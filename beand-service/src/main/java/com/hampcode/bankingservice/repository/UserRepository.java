package com.hampcode.bankingservice.repository;

import com.hampcode.bankingservice.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
