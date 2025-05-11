package com.epam.expense_tracker.service;

import com.epam.expense_tracker.dto.UserRequestDTO;
import com.epam.expense_tracker.dto.UserResponseDTO;
import com.epam.expense_tracker.entity.Users;

import java.util.List;

public interface UserService {

    UserResponseDTO registerUser(UserRequestDTO userRequestDTO);

    UserResponseDTO loginUser(UserRequestDTO userRequestDTO);

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO getUserByEmail(String id);
    String verify(UserRequestDTO user);
}
