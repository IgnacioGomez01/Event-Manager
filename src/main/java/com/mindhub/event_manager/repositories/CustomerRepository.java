package com.mindhub.event_manager.repositories;

import com.mindhub.event_manager.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    public Customer findByEmail(String customer);
}