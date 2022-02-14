package com.musala.drone.domain.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.musala.drone.enums.DroneModel;
import com.musala.drone.enums.DroneState;
import com.musala.drone.validation.EnumValidation;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateDroneRequest {

    @NotEmpty(message = "kindly provide a serialNumber")
    @Size(max = 100, message = "Exceeded maximum number of character allowed")
    String serialNumber;

    @NotEmpty(message = "kindly provide a model")
    @EnumValidation(enumClass = DroneModel.class, message = "invalid model provide, kindly provide a valid model")
    String model;

    @NotNull
    @Max(value = 500, message = "Exceeded  maximum  weight allowed")
    Double weight;

    @NotNull
    @Max(value = 100, message = "Exceed the maximum allowed value")
    Integer batteryCapacity;

    DroneState state = DroneState.IDLE;

}
