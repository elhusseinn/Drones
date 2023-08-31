package com.Egabi.drones.repositories;

import com.Egabi.drones.models.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneRepo extends JpaRepository<Drone, Long> {
}
