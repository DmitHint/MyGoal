package org.mygoal.fitnessapp.backend.service;

import lombok.RequiredArgsConstructor;
import org.mygoal.fitnessapp.backend.model.Training;
import org.mygoal.fitnessapp.backend.model.User;
import org.mygoal.fitnessapp.backend.repository.TrainingRepository;
import org.mygoal.fitnessapp.backend.repository.UserRepository;
import org.mygoal.fitnessapp.backend.service.util.TrainingSpecifications;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TrainingService {

    private final TrainingRepository trainingRepository;
    private final UserRepository userRepository;

    public List<Training> getTrainings() {
        return trainingRepository.findAll();
    }


    public List<Training> getTrainingsWithFilter(Long userId, Long coachId, LocalDateTime date) {
//        Sort sortByTrainingDateTimeAsc = Sort.by(Sort.Direction.ASC, "trainingDateTime");
        Sort sortByTrainingDateTimeAsc = Sort.by(Sort.Direction.DESC, "trainingDateTime");

        return trainingRepository.findAll(TrainingSpecifications.filter(userId, coachId, date), sortByTrainingDateTimeAsc);
    }

    public void enrollUserInTraining(Long userId, Long trainingId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        Training training = trainingRepository.findById(trainingId)
                .orElseThrow(() -> new RuntimeException("Training not found with ID: " + trainingId));

        training.setUser(user);

        trainingRepository.save(training);
    }

    public void cancelUserInTraining(Long trainingId) {
        Training training = trainingRepository.findById(trainingId)
                .orElseThrow(() -> new RuntimeException("Training not found with ID: " + trainingId));

        training.setUser(null);

        trainingRepository.save(training);
    }

}
