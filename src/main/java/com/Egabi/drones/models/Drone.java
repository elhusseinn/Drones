package com.Egabi.drones.models;


import com.Egabi.drones.enums.DroneModelEnum;
import com.Egabi.drones.enums.DroneStateEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="drones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drone{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serial_number")
    private Long serialNumber;
    @Enumerated(EnumType.STRING)
    private DroneModelEnum model;
    private double weightLimit;
    private int batteryCapacity;

    @Enumerated(EnumType.STRING)
    private DroneStateEnum state;

    @OneToMany(mappedBy ="drone", fetch = FetchType.EAGER)
    private List<Medication> medications;


}
