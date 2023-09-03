package com.Egabi.drones.mappers;

import com.Egabi.drones.models.Medication;
import com.Egabi.drones.pojos.MedicationPOJO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MedicationMapper {
    MedicationMapper MEDICATION_MAPPER = Mappers.getMapper(MedicationMapper.class);
    @Mapping(target = "drone", ignore = true)
    MedicationPOJO toMedicationPOJO (Medication medication);
    @Mapping(target = "drone", ignore = true)
    Medication toMedication(MedicationPOJO medicationPOJO);
}
