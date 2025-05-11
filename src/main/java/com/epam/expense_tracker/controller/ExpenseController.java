package com.epam.expense_tracker.controller;

import com.epam.expense_tracker.dto.ExpenseRequestDTO;
import com.epam.expense_tracker.dto.ExpenseResponseDTO;
import com.epam.expense_tracker.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/expense-tracker/expense")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

//    @GetMapping
//    public ResponseEntity<String> getMessage(){
//        return ResponseEntity.ok("Hello from expense controller");
//    }

    @PostMapping
    public ResponseEntity<ExpenseResponseDTO> createExpense(@RequestBody ExpenseRequestDTO expense) {
        return new ResponseEntity<>(expenseService.createExpense(expense), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseResponseDTO>>  getAllExpenses() {
        return new ResponseEntity<>(expenseService.getAllExpenses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseResponseDTO> getExpenseById(@PathVariable String id) {
        return new ResponseEntity<>(expenseService.getExpenseById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseResponseDTO>  updateExpense(@PathVariable String id, @RequestBody ExpenseRequestDTO expense) {
        return new ResponseEntity<>(expenseService.updateExpense(id, expense), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable String id) {
        String message = expenseService.deleteExpense(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
