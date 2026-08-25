package com.spring.expense_tracker_backend.dto;


import com.spring.expense_tracker_backend.enums.ExpenseCategory;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
public class ExpenseResponse {
    // Getters and Setters
    private Long id;
    private String description;
    private BigDecimal amount;
    private ExpenseCategory category;
    private LocalDate date;

    public ExpenseResponse() {}

    public ExpenseResponse(Long id, String description, BigDecimal amount,
                           ExpenseCategory category, LocalDate date) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

}
