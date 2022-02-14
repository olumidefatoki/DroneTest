package com.musala.drone.scheduler;

import com.musala.drone.model.HistoryLog;
import com.musala.drone.repo.DroneRepo;
import com.musala.drone.repo.HistoryLogRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EventScheduler {
    @Autowired
    DroneRepo droneRepo;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    HistoryLogRepo historyLogRepo;

    @Scheduled(fixedRate = 60000 * 30)
    public void beginAudit() {
        droneRepo.findAll().stream().forEach(
           drone -> {
               HistoryLog log = modelMapper.map(drone, HistoryLog.class);
               historyLogRepo.save(log);
           }
        );
    }
}
