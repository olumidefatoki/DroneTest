package com.musala.drone.domain.response;

import com.musala.drone.enums.DroneModel;
import com.musala.drone.enums.DroneState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DroneResponse {
    long id;

    String serialNumber;

    DroneModel model;

    BigDecimal weight;

    int batteryCapacity;

    DroneState state;

}
