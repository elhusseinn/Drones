package com.Egabi.drones.pojos;

import com.Egabi.drones.models.Drone;
import lombok.*;

import javax.validation.constraints.Pattern;
import java.util.Arrays;

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
