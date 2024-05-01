package com.hampcode.bankingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hampcode.bankingservice.model.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByOwnerEmail(String email);
}