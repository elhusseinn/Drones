package com.Egabi.drones.services;

import com.Egabi.drones.enums.DroneStateEnum;
import com.Egabi.drones.exceptions.DroneNotAvailableException;
import com.Egabi.drones.mappers.DroneMapper;
import com.Egabi.drones.models.Drone;
import com.Egabi.drones.models.Medication;
import com.Egabi.drones.pojos.DronePOJO;
import com.Egabi.drones.pojos.LoadDroneRequestPOJO;
import com.Egabi.drones.repositories.DroneRepo;
import com.Egabi.drones.repositories.MedicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
public class DroneService {
    @Autowired
    private DroneRepo droneRepo;
    @Autowired
    private MedicationRepo medicationRepo;
    @Autowired
    private DroneMapper droneMapper;

    public DronePOJO registerDrone(DronePOJO dronePOJO){
        Drone drone = droneMapper.toDrone(dronePOJO);
        Drone createdDrone = droneRepo.save(drone);
        return droneMapper.toDronePOJO(createdDrone);
    }
    public DronePOJO getDroneById(Long id){
        return droneMapper.toDronePOJO(droneRepo.findById(id).orElseThrow(()->new EntityNotFoundException("drone with ID "+id+" doesn't exist")));
    }
    public DronePOJO updateDrone(Long id, DronePOJO dronePOJO){
        Drone drone = droneRepo.findById(id).orElseThrow(()->new EntityNotFoundException("drone with ID "+id+" doesn't exist"));
        if(dronePOJO.getModel()!=null) drone.setModel(dronePOJO.getModel());
        if(dronePOJO.getWeightLimit()!=null) drone.setWeightLimit(drone.getWeightLimit());
        if(dronePOJO.getBatteryCapacity()!= null) drone.setBatteryCapacity(dronePOJO.getBatteryCapacity());
        if(dronePOJO.getState()!=null) drone.setState(dronePOJO.getState());
        if(dronePOJO.getMedications()!=null) drone.setMedications(dronePOJO.getMedications());
        droneRepo.save(drone);
        return droneMapper.toDronePOJO(drone);
    }

    public DronePOJO loadMedicationToDrone(LoadDroneRequestPOJO loadDroneRequestPOJO){ // TODO: edit to take list of medicationIds and check if they all exist
        Long droneId = loadDroneRequestPOJO.getDroneId(); List<Long> medicationIds = loadDroneRequestPOJO.getMedicationIds();

        // get the drone and medication and check if they exist? if not throw exception
        Drone drone = droneRepo.findById(droneId).orElseThrow(()->new EntityNotFoundException("drone with ID "+droneId+" doesn't exist"));

        // check drone status if ready to load
        if(drone.getState()!= DroneStateEnum.IDLE && drone.getState() != DroneStateEnum.LOADING){throw new DroneNotAvailableException(droneId);}

        //check for the drone battery percentage > 25? throws DroneNotAvailableException(long id, int batteryPercentage)
        if(drone.getBatteryCapacity() <= 25){throw new DroneNotAvailableException(droneId, drone.getBatteryCapacity());}

        List<Medication> currentMedications = drone.getMedications(); // current medications that already exist in the drone
        Set<Medication> medications = new HashSet<>();

        medicationIds.forEach(medicationId->{
            medications.add(medicationRepo.findById(medicationId).orElseThrow(()->new EntityNotFoundException("medication with ID "+medicationId+" doesn't exist")));
        });

        /**
         * check the drone if it's carrying any medications and add them,
         * check if the total added medications on the medications that already exist would be overweight\
         * throws DroneNotAvailableException(double weightLimit, double weight)
         */

        Double currentLoadedWeight = currentMedications.stream()
                                    .mapToDouble(Medication::getWeight)
                                    .sum();

        Double weightAfterLoading = medications.stream()
                                    .mapToDouble(Medication::getWeight)
                                    .sum();
        weightAfterLoading+=currentLoadedWeight;
        if(weightAfterLoading > drone.getWeightLimit()){throw new DroneNotAvailableException(drone.getWeightLimit(), weightAfterLoading);}

        /**
         * if passes all the checks: change the drone state to LOADING
         * get all the medications and set their drone to drone or the opposite (append to the list of drones)
         */
        drone.setState(DroneStateEnum.LOADING);

        medications.addAll(currentMedications);

        drone.setMedications(new ArrayList<>(medications));

        medications.forEach(medication -> {
            medication.setDrone(drone);
            medicationRepo.save(medication);
        });

        return updateDrone(droneId, droneMapper.toDronePOJO(drone));

    }
}
