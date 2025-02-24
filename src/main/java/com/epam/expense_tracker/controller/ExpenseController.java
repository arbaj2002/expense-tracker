package com.epam.expense_tracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/expense-tracker")
public class ExpenseController {
    @GetMapping
    public ResponseEntity<String> getMessage(){
        return ResponseEntity.ok("Hello from expensecontroller");
    }
}
