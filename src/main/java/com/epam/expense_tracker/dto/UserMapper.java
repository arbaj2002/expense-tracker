package com.epam.expense_tracker.dto;

import com.epam.expense_tracker.entity.Users;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    // Map UserRequestDTO to Users entity
    public static Users mapUserRequestToUser(UserRequestDTO requestDTO) {

        Users user = new Users(requestDTO.getEmail(), requestDTO.getPassword());
        return user;
    }

    // Map Users entity to UserResponseDTO
    public static UserResponseDTO mapUserToUserResponse(Users user) {
        UserResponseDTO responseDTO = new UserResponseDTO(user.getEmail(), user.getPassword());
        return responseDTO;
    }

    // Map a list of Users entities to a list of UserResponseDTO
    public static List<UserResponseDTO> mapUserListToUserResponseList(List<Users> userList) {
        List<UserResponseDTO> userResponseDTOS = new ArrayList<>();
        for (Users user : userList) {
            userResponseDTOS.add(mapUserToUserResponse(user));
        }
        return userResponseDTOS;
    }

    // Map UserRequestDTO to UserResponseDTO (used in some cases like in controller)
    public static UserResponseDTO mapUserRequestToResponseDTO(UserRequestDTO requestDTO) {
        UserResponseDTO responseDTO = new UserResponseDTO(requestDTO.getEmail(), requestDTO.getPassword());
        return responseDTO;
    }
}
