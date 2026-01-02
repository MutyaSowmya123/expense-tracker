package com.example.expense_tracker.repository;

import com.example.expense_tracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Query("select e.category, sum(e.amount) from Expense e group by e.category order by sum(e.amount) desc")
    List<Object[]> sumByCategory();
}