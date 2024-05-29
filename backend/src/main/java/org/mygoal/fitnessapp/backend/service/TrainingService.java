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

/**
 * The service is responsible for working with {@link Training} model objects.
 * Provides methods for getting all {@link Training} objects, filtering them by various parameters, as well as enrolling and canceling {@link User}s in {@link Training}s.
 */
@RequiredArgsConstructor
@Service
public class TrainingService {

    /**
     * Repository for working with {@link Training} objects.
     */
    private final TrainingRepository trainingRepository;

    /**
     * Repository for working with {@link User} objects.
     */
    private final UserRepository userRepository;

    /**
     * This method returns a list of all {@link Training} objects.
     *
     * @return list of all {@link Training} objects
     */
    public List<Training> getTrainings() {
        return trainingRepository.findAll();
    }


    /**
     * This method returns a list of {@link Training} objects filtered by various parameters.
     *
     * @param userId    the ID of the user who created the training
     * @param coachId   the ID of the coach who created the training
     * @param date      the date of the training
     * @return list of filtered {@link Training} objects
     */
    public List<Training> getTrainingsWithFilter(Long userId, Long coachId, LocalDateTime date) {
//        Sort sortByTrainingDateTimeAsc = Sort.by(Sort.Direction.ASC, "trainingDateTime");
        Sort sortByTrainingDateTimeAsc = Sort.by(Sort.Direction.DESC, "trainingDateTime");

        return trainingRepository.findAll(TrainingSpecifications.filter(userId, coachId, date), sortByTrainingDateTimeAsc);
    }

    /**
     * This method enrolls a user in a training.
     *
     * @param userId     the ID of the user who wants to enroll in the training
     * @param trainingId the ID of the training
     * @return the user who enrolled in the training
     */
    public User enrollUserInTraining(Long userId, Long trainingId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        Training training = trainingRepository.findById(trainingId)
                .orElseThrow(() -> new RuntimeException("Training not found with ID: " + trainingId));

        training.setUser(user);

        trainingRepository.save(training);

        return user;
    }

    /**
     * This method cancels a user's enrollment in a training.
     *
     * @param trainingId the ID of the training
     */
    public void cancelUserInTraining(Long trainingId) {
        Training training = trainingRepository.findById(trainingId)
                .orElseThrow(() -> new RuntimeException("Training not found with ID: " + trainingId));

        training.setUser(null);

        trainingRepository.save(training);
    }

}
