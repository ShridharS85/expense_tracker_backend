package com.spring.expense_tracker_backend.service;

import com.spring.expense_tracker_backend.dto.DashboardResponse;
import com.spring.expense_tracker_backend.entity.User;
import com.spring.expense_tracker_backend.repository.ExpenseRepository;
import com.spring.expense_tracker_backend.repository.IncomeRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DashboardService {

    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;

    public DashboardService(IncomeRepository incomeRepository, ExpenseRepository expenseRepository) {
        this.incomeRepository = incomeRepository;
        this.expenseRepository = expenseRepository;
    }

    public DashboardResponse getDashboard(User user) {
        BigDecimal totalIncome = incomeRepository.getTotalByUserId(user.getId());
        BigDecimal totalExpenses = expenseRepository.getTotalByUserId(user.getId());
        BigDecimal balance = totalIncome.subtract(totalExpenses);

        return new DashboardResponse(totalIncome, totalExpenses, balance);
    }
}
