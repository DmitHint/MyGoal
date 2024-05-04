package org.mygoal.fitnessapp.backend.controller;

import lombok.RequiredArgsConstructor;
import org.mygoal.fitnessapp.backend.model.Coach;
import org.mygoal.fitnessapp.backend.service.CoachService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class CoachController {

    private final CoachService coachService;

    @GetMapping("/coach/all")
    public ResponseEntity<List<Coach>> getCoaches() {
        return ResponseEntity.ok(coachService.getCoachesList());
    }
}
