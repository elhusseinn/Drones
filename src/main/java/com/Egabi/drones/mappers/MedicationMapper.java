package com.Egabi.drones.mappers;

import com.Egabi.drones.models.Medication;
import com.Egabi.drones.pojos.MedicationPOJO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MedicationMapper {
    MedicationMapper MEDICATION_MAPPER = Mappers.getMapper(MedicationMapper.class);
    MedicationPOJO toMedicationPOJO (Medication medication);
    Medication toMedication(MedicationPOJO medicationPOJO);
}
