package com.Egabi.drones.services;

import com.Egabi.drones.mappers.MedicationMapper;
import com.Egabi.drones.models.Medication;
import com.Egabi.drones.pojos.MedicationPOJO;
import com.Egabi.drones.repositories.MedicationRepo;
import com.Egabi.drones.utils.BasicHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicationService {
    @Autowired
    private MedicationRepo medicationRepo;
    @Autowired
    private MedicationMapper medicationMapper;
    public MedicationPOJO addMedication(MedicationPOJO medicationPOJO){
        Medication medication = medicationMapper.toMedication(medicationPOJO);
        Medication createdMedication= medicationRepo.save(medication);
        return medicationMapper.toMedicationPOJO(createdMedication);
    }

    public List<MedicationPOJO> getAllMedications(){
        List<MedicationPOJO> medicationPOJOS = new ArrayList<>();
        List<Medication> medications = medicationRepo.findAll();
        for(Medication med:medications){
            medicationPOJOS.add(medicationMapper.toMedicationPOJO(med));
        }
        return medicationPOJOS;
    }

    public MedicationPOJO updateMedication(Long id, MedicationPOJO medicationPOJO){ //TODO:8yr al khara da
        Medication medication = medicationRepo.findById(id).orElseThrow(()->new EntityNotFoundException("medication with Id "+id+" doesn't exist"));

        if(medicationPOJO.getCode()!=null) medication.setCode(medicationPOJO.getCode());
        if(medicationPOJO.getName()!=null) medication.setName(medicationPOJO.getName());
        if(medicationPOJO.getImage()!=null) medication.setImage(medicationPOJO.getImage());
        if(medicationPOJO.getWeight()!=null) medication.setWeight(medicationPOJO.getWeight());
//        if(medicationPOJO.getDrone()!=null) medication.setDrone(medicationPOJO.getDrone());
        medicationRepo.save(medication);
        return medicationMapper.toMedicationPOJO(medication);
    }

    public MedicationPOJO updateMedicationNew(Long id, MedicationPOJO medicationPOJO) throws Exception {
        Optional<Medication> oldMedication = medicationRepo.findById(id);
        if(oldMedication.isPresent()){
//            Medication updatedMedication = medicationMapper.toMedication((MedicationPOJO) BasicHelper.updateObject(medicationMapper.toMedicationPOJO(oldMedication.get()), medicationPOJO));
            Medication updatedMedication = oldMedication.get();
            MedicationPOJO updatedMedicationPOJO = medicationMapper.toMedicationPOJO(updatedMedication);
            updatedMedicationPOJO = (MedicationPOJO) BasicHelper.updateObject(updatedMedicationPOJO, medicationPOJO);
            medicationRepo.save(medicationMapper.toMedication(updatedMedicationPOJO));
            return updatedMedicationPOJO;

        }
        return null;
    }


}
