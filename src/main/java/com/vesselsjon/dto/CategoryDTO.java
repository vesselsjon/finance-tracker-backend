package com.vesselsjon.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CategoryDTO {
    @NotBlank
    private String name;

    @NotNull
    @PositiveOrZero
    private BigDecimal budgetLimit;

    private String description;
}
