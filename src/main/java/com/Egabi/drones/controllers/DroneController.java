package com.Egabi.drones.controllers;

import com.Egabi.drones.pojos.DronePOJO;
import com.Egabi.drones.pojos.LoadDroneRequestPOJO;
import com.Egabi.drones.services.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drone")
public class DroneController {
    @Autowired
    DroneService droneService;
    @RequestMapping(method = RequestMethod.POST)
    public DronePOJO registerDrone(@RequestBody DronePOJO dronePOJO){
        return droneService.registerDrone(dronePOJO);
    }

    @RequestMapping(value = "/load", method = RequestMethod.POST)
    public DronePOJO loadDrone(@RequestBody LoadDroneRequestPOJO loadDroneRequestPOJO){
        return droneService.loadMedicationToDrone(loadDroneRequestPOJO);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public DronePOJO getDroneById(@PathVariable Long id){
        return droneService.getDroneById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/deliver/{id}")
    public void deliverDrone(@PathVariable Long id){
        droneService.deliverDrone(id);
    }
}
