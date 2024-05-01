package org.mygoal.fitnessapp.backend.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.mygoal.fitnessapp.backend.model.Status;
import org.mygoal.fitnessapp.backend.model.Training;
import org.mygoal.fitnessapp.backend.repository.TrainingRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingStatusService {

    private final TrainingRepository trainingRepository;

    @Transactional
    @Scheduled(fixedRate = 300000L)
    public void updateTrainingStatuses() {
        LocalDateTime now = LocalDateTime.now();

        List<Training> trainingsToUpdate = trainingRepository.findAll();

        for (Training training : trainingsToUpdate) {
            LocalDateTime startTime = training.getTrainingDateTime();
            Duration duration = Duration.between(startTime, now);

            if (now.isAfter(startTime)) {
                if (duration.toMinutes() >= 60) {
                    training.setStatus(Status.FINISHED);
                } else {
                    training.setStatus(Status.ONGOING);
                }
            } else {
                training.setStatus(Status.NOT_STARTED);
            }
        }

        trainingRepository.saveAll(trainingsToUpdate);
    }

}