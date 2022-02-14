package com.musala.drone;

import com.musala.drone.domain.request.MedicationRequest;
import com.musala.drone.enums.DroneModel;
import com.musala.drone.enums.DroneState;
import com.musala.drone.model.Drone;
import com.musala.drone.model.Medication;
import com.musala.drone.repo.DroneRepo;
import com.musala.drone.repo.MedicationRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DroneApplication implements CommandLineRunner {

    @Autowired
    DroneRepo droneRepo;

    @Autowired
	MedicationRepo medicationRepo;

    @Autowired
	ModelMapper mapper;


    public static void main(String[] args) {
        SpringApplication.run(DroneApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Drone drone = new Drone();
        drone.setSerialNumber("abc_001");
        drone.setModel(DroneModel.LIGHTWEIGHT.toString());
        drone.setWeight(200);
        drone.setBatteryCapacity(100);
        drone.setState(DroneState.IDLE.toString());
        droneRepo.save(drone);

        drone = new Drone();
        drone.setSerialNumber("abc_002");
        drone.setModel(DroneModel.LIGHTWEIGHT.toString());
        drone.setWeight(200);
        drone.setBatteryCapacity(100);
        drone.setState(DroneState.IDLE.toString());
        droneRepo.save(drone);

		drone  = new Drone();
		drone.setSerialNumber("abd_001");
		drone.setModel(DroneModel.CRUISERWEIGHT.toString());
		drone.setWeight(200);
		drone.setBatteryCapacity(100);
		drone.setState(DroneState.IDLE.toString());
		droneRepo.save(drone);

		drone  = new Drone();
		drone.setSerialNumber("abd_002");
		drone.setModel(DroneModel.CRUISERWEIGHT.toString());
		drone.setWeight(200);
		drone.setBatteryCapacity(100);
		drone.setState(DroneState.IDLE.toString());
		droneRepo.save(drone);

		drone  = new Drone();
		drone.setSerialNumber("abe_001");
		drone.setModel(DroneModel.MIDDLEWEIGHT.toString());
		drone.setWeight(200);
		drone.setBatteryCapacity(100);
		drone.setState(DroneState.IDLE.toString());
		droneRepo.save(drone);

		drone  = new Drone();
		drone.setSerialNumber("abe_002");
		drone.setModel(DroneModel.MIDDLEWEIGHT.toString());
		drone.setWeight(200);
		drone.setBatteryCapacity(100);
		drone.setState(DroneState.IDLE.toString());
		droneRepo.save(drone);

		drone  = new Drone();
		drone.setSerialNumber("abf_001");
		drone.setModel(DroneModel.HEAVYWEIGHT.toString());
		drone.setWeight(200);
		drone.setBatteryCapacity(100);
		drone.setState(DroneState.IDLE.toString());
		droneRepo.save(drone);

		drone  = new Drone();
		drone.setSerialNumber("abf_002");
		drone.setModel(DroneModel.HEAVYWEIGHT.toString());
		drone.setWeight(200);
		drone.setBatteryCapacity(100);
		drone.setState(DroneState.IDLE.toString());
		droneRepo.save(drone);

		MedicationRequest medicationRequest  = new MedicationRequest();
		medicationRequest.setWeight(2.5);
		medicationRequest.setCode("PARA_001");
		medicationRequest.setName("PARACETAMOL");
		Medication medication = mapper.map(medicationRequest, Medication.class);
		medication.setDroneId(1);
		medicationRepo.save(medication);

		medicationRequest  = new MedicationRequest();
		medicationRequest.setWeight(2.0);
		medicationRequest.setCode("CHL_002");
		medicationRequest.setName("chloroquine");
		 medication = mapper.map(medicationRequest, Medication.class);
		medication.setDroneId(1);
		medicationRepo.save(medication);


    }
}
