package com.Egabi.drones.services;

import com.Egabi.drones.mappers.DroneMapper;
import com.Egabi.drones.models.Drone;
import com.Egabi.drones.pojos.DronePOJO;
import com.Egabi.drones.repositories.DroneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DroneService {

    @Autowired
    DroneRepo droneRepo;
    @Autowired
    DroneMapper droneMapper;

    public DronePOJO registerDrone(DronePOJO dronePOJO){
        Drone drone = droneMapper.toDrone(dronePOJO);
        Drone createdDrone = droneRepo.save(drone);
        return droneMapper.toDronePOJO(createdDrone);
    }
}
