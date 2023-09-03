package com.Egabi.drones.models;


import com.Egabi.drones.enums.DroneModelEnum;
import com.Egabi.drones.enums.DroneStateEnum;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="drones")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Drone{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serial_number")
    private Long serialNumber;
    @Enumerated(EnumType.STRING)
    private DroneModelEnum model;
    private Double weightLimit;
    private Integer batteryCapacity;

    @Enumerated(EnumType.STRING)
    private DroneStateEnum state;

    @OneToMany(mappedBy ="drone", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Medication> medications;

}
