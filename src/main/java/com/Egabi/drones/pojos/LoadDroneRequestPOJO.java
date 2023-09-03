package com.Egabi.drones.pojos;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoadDroneRequestPOJO {
    @NotNull
    private Long droneId;
    private List<Long> medicationIds;
}
