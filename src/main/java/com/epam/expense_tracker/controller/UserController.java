package com.epam.expense_tracker.controller;

import com.epam.expense_tracker.dto.UserRequestDTO;
import com.epam.expense_tracker.dto.UserResponseDTO;
import com.epam.expense_tracker.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("expense-tracker/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO userRequestDTO){
        return new ResponseEntity<>(userService.registerUser(userRequestDTO), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody UserRequestDTO userRequestDTO){
        return  userService.verify(userRequestDTO);
//        return new ResponseEntity<>(userService.loginUser(userRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> allUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable String email){
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }
}
