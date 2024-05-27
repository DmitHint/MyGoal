package org.mygoal.fitnessapp.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * Entity representing a coach in the fitness application.
 */
@Entity
@Data
public class Coach {

    /**
     * The unique identifier of the coach.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The first name of the coach.
     */
    private String name;

    /**
     * The last name of the coach.
     */
    private String surname;

    /**
     * The rating of the coach.
     */
    private String rating;

    /**
     * The list of trainings that the coach is responsible for.
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "coach_trainings",
            joinColumns = @JoinColumn(name = "coach_id"),
            inverseJoinColumns = @JoinColumn(name = "training_id"))
    private List<Training> trainings;
}
