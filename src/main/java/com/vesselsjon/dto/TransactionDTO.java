package com.vesselsjon.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TransactionDTO {
    private String description;
    private BigDecimal amount;
    private String type;
    private Long categoryId;
    private LocalDate date;
}
