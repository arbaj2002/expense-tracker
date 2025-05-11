package com.epam.expense_tracker.config;

import com.epam.expense_tracker.entity.Users;
import com.epam.expense_tracker.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Users> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new RuntimeException("User not found with email: " + email);
        }

        // Create a UserDetails object using the retrieved user information
//        return User.withUsername(user.get().getEmail())
//                .password(user.get().getPassword())
//                .roles("USER") // Assign appropriate roles based on your requirements
//                .build();

        return new UserPrincipal(user.get());
    }
}
