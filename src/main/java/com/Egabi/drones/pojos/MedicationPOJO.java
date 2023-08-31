package com.Egabi.drones.pojos;

import com.Egabi.drones.models.Drone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicationPOJO {
    @Pattern(regexp = "^[a-zA-Z_-]+$")
    private String name;
    private Double weight;
    @Pattern(regexp = "^[A-Z0-9_]+$")
    private String code;
    private byte[] image;
    private Drone drone;

}
