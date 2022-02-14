package com.musala.drone.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DroneMedicationResponse {
    DroneResponse drone;
    String name;
    Double weight;
    String code;
    String image;
}
