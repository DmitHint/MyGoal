package org.mygoal.fitnessapp.backend.service;

import lombok.RequiredArgsConstructor;
import org.mygoal.fitnessapp.backend.model.Coach;
import org.mygoal.fitnessapp.backend.repository.CoachRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CoachService {

    private final CoachRepository coachRepository;

    public List<Coach> getCoachesList() {
        return coachRepository.findAll();
    }

}