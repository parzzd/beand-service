package com.hampcode.bankingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hampcode.bankingservice.model.entities.Resource;

public interface ResourceRepository extends JpaRepository<Resource,Long>{
    @Query("SELECT r from Resource r WHERE r.resourceName = :resourceName")
    Resource findByResourceName(String resourceName);
}
