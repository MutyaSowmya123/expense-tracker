package com.example.expense_tracker.Controller;

import com.example.expense_tracker.model.Expense;
import com.example.expense_tracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
}
