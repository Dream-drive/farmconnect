package com.facon.farm.repository;

import com.facon.farm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom method to find a user by email
    User findByEmail(String email);
}
