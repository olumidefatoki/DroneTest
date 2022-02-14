package com.musala.drone.repo;

import com.musala.drone.model.HistoryLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryLogRepo extends JpaRepository<HistoryLog, Long> {
}
