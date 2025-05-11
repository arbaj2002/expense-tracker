package com.epam.expense_tracker.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "expenses")
public class Expense {
    @Id
    private String id;
    private String description;
    private double amount;
    private Date date;
    private Category category;

    public Expense( String description, double amount, Date date, Category category) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }


    public Category getCategory() {
        return category;
    }


    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }


    public double getAmount() {
        return amount;
    }


    public Date getDate() {
        return date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", category=" + category +
                '}';
    }
}
