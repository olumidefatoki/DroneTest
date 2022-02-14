package com.musala.drone.repo;

import com.musala.drone.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneMedicationRepo extends JpaRepository<Medication, Long> {

}
