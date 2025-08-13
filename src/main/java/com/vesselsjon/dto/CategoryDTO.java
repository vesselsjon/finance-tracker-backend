package com.vesselsjon.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CategoryDTO {
    private String name;
    private BigDecimal budgetLimit;
    private String description;
}
