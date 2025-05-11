package com.epam.expense_tracker.service;

import com.epam.expense_tracker.dto.ExpenseRequestDTO;
import com.epam.expense_tracker.dto.ExpenseResponseDTO;
import com.epam.expense_tracker.dto.Mapper;
import com.epam.expense_tracker.entity.Expense;
import com.epam.expense_tracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    private ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public ExpenseResponseDTO createExpense(ExpenseRequestDTO expense) {
        System.out.println(expense);
        Expense convertedExpense = Mapper.mapExpenseRequestToExpense(expense);
        System.out.println("Converted Expense: " + convertedExpense);
        Expense savedExpense = expenseRepository.save(convertedExpense);

        return Mapper.mapExpenseToExpenseResponse(savedExpense);
    }

    @Override
    public List<ExpenseResponseDTO> getAllExpenses() {
        List<Expense> expenseList = expenseRepository.findAll();
        return Mapper.mapExpenseListToExpenseResponseList(expenseList);
    }

    @Override
    public ExpenseResponseDTO getExpenseById(String id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        if (expense.isPresent()) {
            return Mapper.mapExpenseToExpenseResponse(expense.get());
        } else {
            throw new RuntimeException("Expense Not Found");
        }

    }

    @Override
    public ExpenseResponseDTO updateExpense(String id, ExpenseRequestDTO expenseRequest) {
        if (expenseRepository.existsById(id)) {
            Expense convertedExpense = expenseRepository.findById(id).get();

            convertedExpense.setDescription(expenseRequest.getDescription());
            convertedExpense.setAmount(expenseRequest.getAmount());
            convertedExpense.setDate(expenseRequest.getDate());
            convertedExpense.setCategory(expenseRequest.getCategory());

            Expense savedExpense = expenseRepository.save(convertedExpense);
            return Mapper.mapExpenseToExpenseResponse(savedExpense);
        } else {
            throw new RuntimeException("Cannot update, expense does not exists");
        }
    }

    @Override
    public String deleteExpense(String id) {
        if (!expenseRepository.existsById(id)) {
            throw new RuntimeException("No expense found");
        } else {
            expenseRepository.deleteById(id);
            return "Expense is deleted";
        }
    }
}
