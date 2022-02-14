package com.musala.drone.domain.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.musala.drone.enums.DroneState;
import com.musala.drone.validation.EnumValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateDroneRequest {

    @NotEmpty(message = "kindly provide a serialNumber")
    @Size(max = 100, message = "Exceeded maximum number of character allowed")
    String serialNumber;

    @NotNull
    @Max(value = 100, message = "Exceed the maximum allowed value")
    Integer batteryCapacity;

    @NotEmpty(message = "kindly provide the drone state")
    @EnumValidation(enumClass = DroneState.class, message = "invalid Drone state, kindly provide a valid state")
    String state;


}
