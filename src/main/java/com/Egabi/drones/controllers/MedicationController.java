package com.Egabi.drones.controllers;

import com.Egabi.drones.pojos.MedicationPOJO;
import com.Egabi.drones.services.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/medication")
public class MedicationController {
    @Autowired
    private MedicationService medicationService;

    @RequestMapping(method = RequestMethod.POST)
    public MedicationPOJO addMedication(@Valid @RequestBody MedicationPOJO medicationPOJO){
       return medicationService.addMedication(medicationPOJO);
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<MedicationPOJO> getAllMedications(){
        return medicationService.getAllMedications();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateMedication(@PathVariable Long id ,@Valid @RequestBody MedicationPOJO medicationPOJO){
        medicationService.updateMedication(id, medicationPOJO);
    }
}
