package com.vesselsjon.service;

import com.vesselsjon.dto.TransactionDTO;
import com.vesselsjon.entity.Transaction;
import com.vesselsjon.entity.TransactionType;
import com.vesselsjon.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction addTransaction(TransactionDTO dto) {
        Transaction transaction = Transaction.builder()
                .description(dto.getDescription())
                .amount(dto.getAmount())
                .type(TransactionType.valueOf(dto.getType().toUpperCase()))
                .category(dto.getCategory())
                .date(dto.getDate())
                .autoScanned(false)
                .build();

        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
