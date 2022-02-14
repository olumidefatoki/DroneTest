package com.musala.drone.controller;

import com.musala.drone.domain.request.CreateDroneRequest;
import com.musala.drone.domain.request.MedicationRequest;
import com.musala.drone.domain.response.ApiResponse;
import com.musala.drone.domain.response.DroneMedicationResponse;
import com.musala.drone.domain.response.DroneResponse;
import com.musala.drone.service.DroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import java.io.IOException;
import java.util.List;

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
                .status(HttpStatus.CREATED.value())
                .build();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<DroneResponse>>> getALlDrone() {
        List<DroneResponse> allDrone = service.findAllDrone();
        ApiResponse<List<DroneResponse>> response = ApiResponse.<List<DroneResponse>>builder()
                .message("successfully")
                .data(allDrone)
                .status(HttpStatus.OK.value())
                .build();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("drone/medication/load")
    @Consumes({MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE})
    public ResponseEntity<ApiResponse<DroneMedicationResponse>> createMedication(@Valid MedicationRequest request) throws IOException {
        DroneMedicationResponse drone = service.createDroneMedication(request);
        ApiResponse<DroneMedicationResponse> response = ApiResponse.<DroneMedicationResponse>builder()
                .message("Drone medication successfully created")
                .data(drone)
                .status(HttpStatus.OK.value())
                .build();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/drone/medication/{serialNumber}")
    public ResponseEntity<ApiResponse<List<DroneMedicationResponse>>> getDroneMedication(@PathVariable String serialNumber) {
        List<DroneMedicationResponse> droneMedication = service.getDroneMedication(serialNumber);
        ApiResponse<List<DroneMedicationResponse>> response = ApiResponse.<List<DroneMedicationResponse>>builder()
                .message("Success")
                .data(droneMedication)
                .status(HttpStatus.OK.value())
                .build();
        return ResponseEntity.ok().body(response);
    }


    @GetMapping("/drone/available")
    public ResponseEntity<ApiResponse<List<DroneResponse>>> availableDrone() {
        List<DroneResponse> allDrone = service.findAvailableDrone();
        ApiResponse<List<DroneResponse>> response = ApiResponse.<List<DroneResponse>>builder()
                .message("successfully")
                .data(allDrone)
                .status(HttpStatus.OK.value())
                .build();
        return ResponseEntity.ok().body(response);
    }

}
