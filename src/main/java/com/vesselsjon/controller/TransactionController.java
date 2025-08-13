package com.vesselsjon.controller;

import com.vesselsjon.dto.TransactionDTO;
import com.vesselsjon.entity.Transaction;
import com.vesselsjon.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping
    public List<Transaction> getTransaction() {
        return transactionService.getAllTransactions();
    }

    @PostMapping
    public Transaction addTransaction(@RequestBody TransactionDTO dto) {
        return transactionService.addTransaction(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
    }
}
