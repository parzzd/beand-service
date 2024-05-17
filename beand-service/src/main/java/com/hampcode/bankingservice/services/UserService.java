package com.hampcode.bankingservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hampcode.bankingservice.model.entities.User;
import com.hampcode.bankingservice.repository.UserRepository;
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository=userRepository;
    }
    public List<User> findUsers(Long userId) {
        return userRepository.findUsers(userId);
    }
}
