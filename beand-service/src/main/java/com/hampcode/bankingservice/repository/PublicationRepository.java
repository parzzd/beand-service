package com.hampcode.bankingservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hampcode.bankingservice.model.entities.Publication;

public interface PublicationRepository extends JpaRepository<Publication,Long> {

}