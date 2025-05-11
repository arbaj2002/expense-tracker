package com.epam.expense_tracker.service;

import com.epam.expense_tracker.config.JWTService;
import com.epam.expense_tracker.dto.Mapper;
import com.epam.expense_tracker.dto.UserMapper;
import com.epam.expense_tracker.dto.UserRequestDTO;
import com.epam.expense_tracker.dto.UserResponseDTO;
import com.epam.expense_tracker.entity.Users;
import com.epam.expense_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService{
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserResponseDTO registerUser(UserRequestDTO userRequestDTO) {
        Users convertedUser = UserMapper.mapUserRequestToUser(userRequestDTO);
        convertedUser.setPassword(bCryptPasswordEncoder.encode(userRequestDTO.getPassword()));
        return UserMapper.mapUserToUserResponse(userRepository.save(convertedUser));
    }

    @Override
    public UserResponseDTO loginUser(UserRequestDTO userRequestDTO) {
        Users convertedUser = UserMapper.mapUserRequestToUser(userRequestDTO);
        return UserMapper.mapUserToUserResponse(userRepository.save(convertedUser));
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<Users> allUsers =  userRepository.findAll();
        return UserMapper.mapUserListToUserResponseList(allUsers);
    }

    @Override
    public UserResponseDTO getUserByEmail(String email) {
        Optional<Users> newUser = userRepository.findByEmail(email);
        if(newUser.isPresent())
            return UserMapper.mapUserToUserResponse(newUser.get());
        else
            throw new RuntimeException("User does not exists");
    }

    @Override
    public String verify(UserRequestDTO user){
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
                );
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user.getEmail());
        }
        throw new RuntimeException("Login Failed");
    }


}
