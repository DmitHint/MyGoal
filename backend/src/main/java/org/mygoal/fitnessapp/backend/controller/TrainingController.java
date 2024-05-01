package org.mygoal.fitnessapp.backend.controller;

import lombok.RequiredArgsConstructor;
import org.mygoal.fitnessapp.backend.model.Training;
import org.mygoal.fitnessapp.backend.service.TrainingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class TrainingController {

    private final TrainingService trainingService;

    @GetMapping("/training")
    public ResponseEntity<List<Training>> getTrainings() {
        return ResponseEntity.ok(trainingService.getTrainings());
    }

    @GetMapping(value = "/training/filter")
    public ResponseEntity<List<Training>> getTrainingsWithFilter(
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Long couchId,
            @RequestParam(required = false) LocalDateTime date) {
        return ResponseEntity.ok(trainingService.getTrainingsWithFilter(userId, couchId, date));
    }

    @PostMapping("/training/enroll/{userId}/{trainingId}")
    public ResponseEntity<String> bookTraining(@PathVariable Long userId, @PathVariable Long trainingId) {
        trainingService.enrollUserInTraining(userId, trainingId);
        return ResponseEntity.ok("Booking successful");
    }

    @PostMapping("/training/cancel/{trainingId}")
    public ResponseEntity<String> cancelTraining(@PathVariable Long trainingId) {
        trainingService.cancelUserInTraining(trainingId);
        return ResponseEntity.ok("Cancel training successful");
    }


}
