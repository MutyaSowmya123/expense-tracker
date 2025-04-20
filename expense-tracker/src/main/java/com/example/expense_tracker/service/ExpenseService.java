package com.example.expense_tracker.service;

import com.example.expense_tracker.model.Expense;
import com.example.expense_tracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    // Method to add an expense
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // Method to get all expenses
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // Method to delete an expense by ID
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
