package com.epam.expense_tracker.dto;

import com.epam.expense_tracker.entity.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.Date;

public class ExpenseRequestDTO {

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be positive")
    private Double amount;


    @NotNull(message = "Date is required")
    private Date date;

    private Category category;

    public ExpenseRequestDTO(String description, Double amount, Date date, Category category) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }


    public @NotNull(message = "Date is required") Date getDate() {
        return date;
    }


    public Double getAmount(){
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ExpenseRequestDTO{" +
                "description='" + description + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", category=" + category +
                '}';
    }
}
