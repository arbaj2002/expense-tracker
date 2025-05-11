package com.epam.expense_tracker.dto;

public class UserRequestDTO {
    private String email;
    private String password;

    public UserRequestDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
