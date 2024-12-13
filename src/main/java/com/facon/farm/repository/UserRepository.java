package com.facon.farm.repository;

import com.facon.farm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    // You can define custom queries if needed
}
