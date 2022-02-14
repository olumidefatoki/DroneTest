package com.musala.drone.repo;

import com.musala.drone.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DroneRepo extends JpaRepository<Drone, Long> {
    Optional<Drone> findBySerialNumber(String serialNumber);

    @Query("SELECT d FROM Drone d WHERE d.batteryCapacity > 25")
    List<Drone> findAllAvailableDrone();
}
