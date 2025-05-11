package com.epam.expense_tracker.repository;

import com.epam.expense_tracker.entity.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String> {
    boolean existsById(String id);
}
