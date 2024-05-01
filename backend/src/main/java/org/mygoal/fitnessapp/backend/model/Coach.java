package org.mygoal.fitnessapp.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String rating;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "coach_trainings",
            joinColumns = @JoinColumn(name = "coach_id"),
            inverseJoinColumns = @JoinColumn(name = "training_id"))
    private List<Training> trainings;
}

