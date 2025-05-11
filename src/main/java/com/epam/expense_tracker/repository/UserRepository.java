package com.epam.expense_tracker.repository;

import com.epam.expense_tracker.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<Users,String> {
    Optional<Users> findByEmail(String email);
}
