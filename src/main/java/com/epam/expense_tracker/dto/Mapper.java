package com.epam.expense_tracker.dto;

import com.epam.expense_tracker.entity.Expense;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public static Expense mapExpenseRequestToExpense(ExpenseRequestDTO requestDTO) {
        Expense expense = new Expense(requestDTO.getDescription(), requestDTO.getAmount(),requestDTO.getDate(), requestDTO.getCategory());

        return expense;
    }

    public static ExpenseResponseDTO mapExpenseToExpenseResponse(Expense expense) {
        ExpenseResponseDTO expenseResponse = new ExpenseResponseDTO(expense.getId(),expense.getDescription(),expense.getAmount(),expense.getDate(),expense.getCategory());

        return expenseResponse;
    }

    public static List<ExpenseResponseDTO> mapExpenseListToExpenseResponseList(List<Expense> expenseList) {
        List<ExpenseResponseDTO> expenseResponseDTOS = new ArrayList<>();
        for (int i = 0; i < expenseList.size(); i++) {
            expenseResponseDTOS.add(Mapper.mapExpenseToExpenseResponse(expenseList.get(i)));
        }
        return expenseResponseDTOS;
    }

//    public static ExpenseResponseDTO mapExpenseRequestToResponseDTO(ExpenseRequestDTO requestDTO) {
//        ExpenseResponseDTO expenseResponse = new ExpenseResponseDTO(requestDTO.getId(),requestDTO.getDescription(),requestDTO.getAmount(),requestDTO.getDate(),requestDTO.getCategory());
//
//        return expenseResponse;
//    }
}
