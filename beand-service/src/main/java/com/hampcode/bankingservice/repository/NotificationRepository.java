package com.hampcode.bankingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hampcode.bankingservice.model.entities.Notification;


public interface NotificationRepository extends JpaRepository<Notification,Long> {

}