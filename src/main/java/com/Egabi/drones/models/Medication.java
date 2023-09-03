package com.Egabi.drones.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "medications")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Medication{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double weight;
    private String code;
    private byte[] image;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = {"medications", "hibernateLazyInitializer"})
    @JoinColumn(name = "serial_number")
    private Drone drone;
}
