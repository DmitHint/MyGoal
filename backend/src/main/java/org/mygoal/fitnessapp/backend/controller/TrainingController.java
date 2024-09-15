package org.mygoal.fitnessapp.backend.controller;

import lombok.RequiredArgsConstructor;
import org.mygoal.fitnessapp.backend.model.Training;
import org.mygoal.fitnessapp.backend.model.User;
import org.mygoal.fitnessapp.backend.service.TrainingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * REST API controller for managing Training data in the FitnessApp backend.
 * <p>
 * This controller provides endpoints to manage training sessions, including fetching all sessions,
 * applying filters, enrolling users, and canceling training sessions.
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/training")
@Tag(name = "Training", description = "Endpoints for managing training sessions in the FitnessApp")
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
    @Operation(summary = "Get all trainings", description = "Fetch a list of all training sessions in the system.")
    @GetMapping("")
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
    @Operation(summary = "Get trainings with filters", description = "Fetch a list of training sessions with optional filters.")
    @GetMapping(value = "/filter")
    public ResponseEntity<List<Training>> getTrainingsWithFilter(
            @Parameter(description = "Filter by the user ID") @RequestParam(required = false) Long userId,
            @Parameter(description = "Filter by the coach ID") @RequestParam(required = false) Long couchId,
            @Parameter(description = "Filter by the training date") @RequestParam(required = false) LocalDateTime date) {
        return ResponseEntity.ok(trainingService.getTrainingsWithFilter(userId, couchId, date));
    }

    /**
     * POST endpoint to enroll a user in a training session.
     *
     * @param userId     The ID of the user to enroll.
     * @param trainingId The ID of the training session to enroll in.
     * @return A ResponseEntity object containing the updated User object and an HTTP 200 (OK) status code.
     */
    @Operation(summary = "Enroll in training", description = "Enroll a user in a training session.")
    @PostMapping("/enroll/{userId}/{trainingId}")
    public ResponseEntity<User> bookTraining(
            @Parameter(description = "The ID of the user to enroll") @PathVariable Long userId,
            @Parameter(description = "The ID of the training session") @PathVariable Long trainingId) {
        User user = trainingService.enrollUserInTraining(userId, trainingId);
        return ResponseEntity.ok(user);
    }

    /**
     * POST endpoint to cancel a training session for a user.
     *
     * @param trainingId The ID of the training session to cancel.
     * @return A ResponseEntity object containing a success message and an HTTP 200 (OK) status code.
     */
    @Operation(summary = "Cancel training", description = "Cancel a training session for a user.")
    @PostMapping("/cancel/{trainingId}")
    public ResponseEntity<String> cancelTraining(
            @Parameter(description = "The ID of the training session to cancel") @PathVariable Long trainingId) {
        trainingService.cancelUserInTraining(trainingId);
        return ResponseEntity.ok("Cancel training successful");
    }
}
