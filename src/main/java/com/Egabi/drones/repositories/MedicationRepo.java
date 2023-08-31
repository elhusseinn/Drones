package com.Egabi.drones.repositories;

import com.Egabi.drones.models.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepo extends JpaRepository<Medication, Long> {
}
