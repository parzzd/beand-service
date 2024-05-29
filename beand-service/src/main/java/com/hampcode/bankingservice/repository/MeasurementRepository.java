package com.hampcode.bankingservice.repository;

import com.hampcode.bankingservice.model.entities.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    // Puedes agregar métodos adicionales de consulta si es necesario
}