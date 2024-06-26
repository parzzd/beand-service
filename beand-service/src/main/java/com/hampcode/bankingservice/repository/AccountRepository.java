package com.hampcode.bankingservice.repository;

import com.hampcode.bankingservice.model.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    @Query("SELECT t FROM ")
    Optional<Account> findByAccountNumber(String accountNumber);
}
