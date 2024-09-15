package org.mygoal.fitnessapp.backend.controller;

import lombok.RequiredArgsConstructor;
import org.mygoal.fitnessapp.backend.model.Coach;
import org.mygoal.fitnessapp.backend.service.CoachService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * REST API controller for managing Coach data in the FitnessApp backend.
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/coach")
@Tag(name = "Coach", description = "Endpoints for managing coach data.")
public class CoachController {

    /**
     * The CoachService instance used to interact with the database.
     */
    private final CoachService coachService;

    /**
     * GET endpoint to fetch a list of all registered coaches in the system.
     *
     * @return A ResponseEntity object containing a list of Coach objects and an HTTP 200 (OK) status code.
     */
    @Operation(summary = "Get all coaches", description = "Fetch a list of all registered coaches in the system.")
    @GetMapping("/all")
    public ResponseEntity<List<Coach>> getCoaches() {
        return ResponseEntity.ok(coachService.getCoachesList());
    }
}
