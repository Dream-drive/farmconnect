package com.facon.farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facon.farm.model.CustomerOrder;  // Updated entity class name

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {  // Updated repository name
    // You can add custom queries if needed
}
