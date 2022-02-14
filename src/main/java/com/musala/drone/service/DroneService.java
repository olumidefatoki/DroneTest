package com.musala.drone.service;

import com.musala.drone.domain.request.CreateDroneRequest;
import com.musala.drone.domain.response.DroneResponse;
import com.musala.drone.model.Drone;
import com.musala.drone.repo.DroneRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DroneService {
    private final ModelMapper mapper;
    private final DroneRepo droneRepo;

    public DroneResponse createDrone(CreateDroneRequest request) {
        Drone drone = mapper.map(request, Drone.class);
        log.info("Request :{}", drone);
        drone = droneRepo.save(drone);
        return mapper.map(drone, DroneResponse.class);
    }
}
