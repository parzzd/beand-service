package com.hampcode.bankingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hampcode.bankingservice.model.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u from User u WHERE u.id=:userId")
    User findUser(@Param("userId") String userId);

}
