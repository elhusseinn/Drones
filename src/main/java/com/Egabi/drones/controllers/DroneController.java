package com.Egabi.drones.controllers;

import com.Egabi.drones.pojos.DronePOJO;
import com.Egabi.drones.services.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drone")
public class DroneController {
    @Autowired
    DroneService droneService;
    @RequestMapping(method = RequestMethod.POST)
    public DronePOJO registerDrone(@RequestBody DronePOJO dronePOJO){
        return droneService.registerDrone(dronePOJO);
    }
}
