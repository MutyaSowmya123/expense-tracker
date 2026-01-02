package com.example.expense_tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import com.example.expense_tracker.dto.ChartPoint;


import com.example.expense_tracker.model.Expense;
import com.example.expense_tracker.service.ExpenseService;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // Display all expenses
    @GetMapping("/expenses")
    public String getAllExpenses(Model model) {
        model.addAttribute("expenses", expenseService.getAllExpenses());
        return "expenses";  // This will map to the Thymeleaf template 'expenses.html'
    }

    // Display form to add a new expense
    @GetMapping("/expenses/add")
    public String showAddExpenseForm(Model model) {
        model.addAttribute("expense", new Expense());
        return "add-expense";  // This will map to the Thymeleaf template 'add-expense.html'
    }

    // Add new expense (POST method)
    @PostMapping("/expenses/add")
    public String addExpense(@ModelAttribute Expense expense) {
        expenseService.addExpense(expense);
        return "redirect:/expenses";  // Redirect back to the expense list page
    }

    // Delete an expense
    @GetMapping("/expenses/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses";  // Redirect back to the expense list page
    }
    
    @GetMapping("/api/expenses/summary/category")
    @ResponseBody
    public List<ChartPoint> categorySummary() {
        return expenseService.getCategorySummary();
    }


    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

}
