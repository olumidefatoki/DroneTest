package com.musala.drone.service;

import com.google.common.base.Enums;
import com.musala.drone.domain.request.CreateDroneRequest;
import com.musala.drone.domain.request.MedicationRequest;
import com.musala.drone.domain.response.DroneMedicationResponse;
import com.musala.drone.domain.response.DroneResponse;
import com.musala.drone.enums.PictureFormat;
import com.musala.drone.exception.BadRequestException;
import com.musala.drone.model.Drone;
import com.musala.drone.model.Medication;
import com.musala.drone.repo.DroneRepo;
import com.musala.drone.repo.MedicationRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class DroneService {
    private final ModelMapper mapper;
    private final DroneRepo droneRepo;
    private final MedicationRepo medicationRepo;

    public DroneResponse createDrone(CreateDroneRequest request) {
        droneRepo.findBySerialNumber(request.getSerialNumber()).ifPresent(
                res -> {
                    throw new BadRequestException("serial number already existed");
                }
        );
        Drone drone = mapper.map(request, Drone.class);
        log.info("Request :{}", drone);
        drone = droneRepo.save(drone);
        return mapper.map(drone, DroneResponse.class);
    }

    public List<DroneResponse> findAllDrone() {
        List<Drone> allDrone = droneRepo.findAll();
        return mapper.map(allDrone, new TypeToken<List<DroneResponse>>() {
        }.getType());
    }

    public DroneMedicationResponse createDroneMedication(MedicationRequest request) throws IOException {
        validateFile(request.getImage());

        Drone drone = droneRepo.findBySerialNumber(request.getSerialNumber())
                .orElseThrow(() -> new BadRequestException("invalid serial number provided"));

        List<Medication> medications = medicationRepo.findByDroneId(drone.getId());

        double totalMedWeight = medications.stream().mapToDouble(Medication::getWeight).sum();

        if ((totalMedWeight + request.getWeight()) > drone.getWeight())
            throw new BadRequestException("Medication total weight exceed Drone Weight");

        Medication medication = mapper.map(request, Medication.class);
        medication.setDroneId(drone.getId());
        medication.setImage(uploadPicture(request.getImage()));
        medicationRepo.save(medication);

        return mapper.map(request, new TypeToken<DroneMedicationResponse>() {
        }.getType());
    }

    public List<DroneMedicationResponse> getDroneMedication(String serialNumber) {
        Drone drone = droneRepo.findBySerialNumber(serialNumber)
                .orElseThrow(() -> new BadRequestException("invalid serial number provided"));

        List<Medication> medications = medicationRepo.findByDroneId(drone.getId());
        if (medications.isEmpty())
            throw new BadRequestException("No Medication FOund");

        return mapper.map(medications, new TypeToken<List<DroneMedicationResponse>>() {
        }.getType());
    }

    private void validateFile(MultipartFile file) {
        if (file == null) {
            throw new BadRequestException("No File was uploaded");
        }
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        if (fileName.contains("..")) {
            throw new BadRequestException("Sorry! Filename contains invalid path sequence " + fileName);
        }
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (!Enums.getIfPresent(PictureFormat.class, fileExtension.toUpperCase(Locale.ROOT)).isPresent()) {
            throw new BadRequestException("Invalid File type uploaded.");
        }
    }

    private String uploadPicture(MultipartFile file) throws IOException {
        String filename = UUID.randomUUID().toString();
        createDirectory("FILE_UPLOAD");
        Path path = Paths.get("FILE_UPLOAD/" + filename + "." + getFileExtension(file));
        Files.write(path, file.getBytes());
        return filename;
    }

    private void createDirectory(String directoryName) {
        File fileFolder = new File(directoryName);
        if (!Files.exists(Paths.get(fileFolder.getName()))) {
            fileFolder.mkdir();
        }
    }

    private String getFileExtension(MultipartFile file) {
        String originalFileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        return originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
    }
}
