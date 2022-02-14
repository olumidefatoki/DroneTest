package com.musala.drone.repo;

import com.musala.drone.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicationRepo extends JpaRepository<Medication, Long> {

    List<Medication> findByDroneId(long id);
}