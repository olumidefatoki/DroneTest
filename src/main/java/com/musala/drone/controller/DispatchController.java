package com.musala.drone.controller;

import com.musala.drone.domain.request.CreateDroneRequest;
import com.musala.drone.domain.response.ApiResponse;
import com.musala.drone.domain.response.DroneResponse;
import com.musala.drone.service.DroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/dispatch")
public class DispatchController {

    private final DroneService service;

    @PostMapping
    public ResponseEntity<ApiResponse<DroneResponse>> createDrone(@Valid @RequestBody CreateDroneRequest request) {
        DroneResponse drone = service.createDrone(request);
        ApiResponse<DroneResponse> response = ApiResponse.<DroneResponse>builder()
                .message("Drone successfully created")
                .data(drone)
                .status(HttpStatus.OK.value())
                .build();
        return ResponseEntity.ok().body(response);
    }

}
