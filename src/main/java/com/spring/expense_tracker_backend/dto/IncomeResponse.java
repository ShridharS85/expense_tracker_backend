package com.spring.expense_tracker_backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
public class IncomeResponse {
    // Getters and Setters
    private Long id;
    private String description;
    private BigDecimal amount;
    private LocalDate date;

    public IncomeResponse() {}

    public IncomeResponse(Long id, String description, BigDecimal amount, LocalDate date) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

}
