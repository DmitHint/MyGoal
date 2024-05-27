package org.mygoal.fitnessapp.backend.controller;

import lombok.RequiredArgsConstructor;
import org.mygoal.fitnessapp.backend.model.Training;
import org.mygoal.fitnessapp.backend.model.User;
import org.mygoal.fitnessapp.backend.service.TrainingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * REST API controller for managing Training data in the FitnessApp backend.
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class TrainingController {

    /**
     * The TrainingService instance used to interact with the database.
     */
    private final TrainingService trainingService;

    /**
     * GET endpoint to fetch a list of all training sessions in the system.
     *
     * @return A ResponseEntity object containing a list of Training objects and an HTTP 200 (OK) status code.
     */
    @GetMapping("/training")
    public ResponseEntity<List<Training>> getTrainings() {
        return ResponseEntity.ok(trainingService.getTrainings());
    }

    /**
     * GET endpoint to fetch a list of training sessions with optional filters applied.
     *
     * @param userId  (optional) Filter by the user ID.
     * @param couchId (optional) Filter by the coach ID.
     * @param date    (optional) Filter by the training date.
     * @return A ResponseEntity object containing a list of Training objects and an HTTP 200 (OK) status code.
     */
    @GetMapping(value = "/training/filter")
    public ResponseEntity<List<Training>> getTrainingsWithFilter(
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Long couchId,
            @RequestParam(required = false) LocalDateTime date) {
        return ResponseEntity.ok(trainingService.getTrainingsWithFilter(userId, couchId, date));
    }

    /**
     * POST endpoint to enroll a user in a training session.
     *
     * @param userId     The ID of the user to enroll.
     * @param trainingId The ID of the training session to enroll in.
     * @return A ResponseEntity object containing the updated User object and an HTTP 200 (OK) status code.
     */
    @PostMapping("/training/enroll/{userId}/{trainingId}")
    public ResponseEntity<User> bookTraining(@PathVariable Long userId, @PathVariable Long trainingId) {
        User user = trainingService.enrollUserInTraining(userId, trainingId);
        return ResponseEntity.ok(user);
    }

    /**
     * POST endpoint to cancel a training session for a user.
     *
     * @param trainingId The ID of the training session to cancel.
     * @return A ResponseEntity object containing a success message and an HTTP 200 (OK) status code.
     */
    @PostMapping("/training/cancel/{trainingId}")
    public ResponseEntity<String> cancelTraining(@PathVariable Long trainingId) {
        trainingService.cancelUserInTraining(trainingId);
        return ResponseEntity.ok("Cancel training successful");
    }


}
