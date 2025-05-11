package com.epam.expense_tracker.dto;

public class UserResponseDTO {
    private String email;
    private String password;

    public UserResponseDTO(String email, String password) {
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
