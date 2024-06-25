package com.hampcode.bankingservice.repository;

import com.hampcode.bankingservice.model.entities.ProgressReport;
import com.hampcode.bankingservice.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgressReportRepository extends JpaRepository<ProgressReport, Long> {
    List<ProgressReport> findByUser(User user);
}