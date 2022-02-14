package com.musala.drone.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;

    @NotNull
    //@Column(unique = true)
    String serialNumber;

    @NotNull
    double weight;

    @NotNull
    int batteryCapacity;

    @NotEmpty
    String state;

    @NotEmpty
    String model;
}
