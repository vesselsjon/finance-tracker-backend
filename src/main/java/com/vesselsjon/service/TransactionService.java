package com.vesselsjon.service;

import com.vesselsjon.dto.TransactionDTO;
import com.vesselsjon.entity.Category;
import com.vesselsjon.entity.Transaction;
import com.vesselsjon.entity.TransactionType;
import com.vesselsjon.repository.CategoryRepository;
import com.vesselsjon.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction addTransaction(TransactionDTO dto) {
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Transaction transaction = Transaction.builder()
                .description(dto.getDescription())
                .amount(dto.getAmount())
                .type(TransactionType.valueOf(dto.getType().toUpperCase()))
                .category(category)
                .date(dto.getDate())
                .autoScanned(false)
                .build();

        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    public Transaction updateTransaction(Long id, TransactionDTO dto) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        transaction.setDescription(dto.getDescription());
        transaction.setAmount(dto.getAmount());
        transaction.setType(TransactionType.valueOf(dto.getType().toUpperCase()));
        transaction.setCategory(category);
        transaction.setDate(dto.getDate());

        return transactionRepository.save(transaction);
    }

    public Page<Transaction> getFilteredTransactions(Long categoryId, LocalDate start, LocalDate end, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("date").descending());
        return transactionRepository.findFiltered(categoryId, start, end, pageable);
    }
}
