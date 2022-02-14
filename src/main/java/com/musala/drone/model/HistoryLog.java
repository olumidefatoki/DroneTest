package com.musala.drone.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class HistoryLog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;

    @NotNull
    String serialNumber;

    @NotNull
    int batteryCapacity;

}
