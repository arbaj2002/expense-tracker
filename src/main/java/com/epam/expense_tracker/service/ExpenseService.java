package com.epam.expense_tracker.service;

import com.epam.expense_tracker.dto.ExpenseRequestDTO;
import com.epam.expense_tracker.dto.ExpenseResponseDTO;
import com.epam.expense_tracker.entity.Expense;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ExpenseService {

    ExpenseResponseDTO createExpense(ExpenseRequestDTO expense);

    List<ExpenseResponseDTO> getAllExpenses();

    ExpenseResponseDTO getExpenseById(String id);

    ExpenseResponseDTO updateExpense(String id, ExpenseRequestDTO expense);

    String deleteExpense(String id);
}
