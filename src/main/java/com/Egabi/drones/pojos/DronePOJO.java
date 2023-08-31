package com.Egabi.drones.pojos;

import com.Egabi.drones.enums.DroneModelEnum;
import com.Egabi.drones.enums.DroneStateEnum;
import com.Egabi.drones.models.Medication;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DronePOJO {

    @Max(100)
    private Long serialNumber;
    private DroneModelEnum model;
    @Max(500)
    private double weightLimit;
    @Range(min = 0, max = 100)
    private int batteryCapacity;
    private DroneStateEnum state;
    private List<Medication> medications;

}
