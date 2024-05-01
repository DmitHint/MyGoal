package org.mygoal.fitnessapp.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    private Double height;
    private Double weight;
    private Double fat;

    private Double shoulderWidth;
    private Double shoulderCircumference;
    private Double chestCircumference;
    private Double waistCircumference;
    private Double hipCircumference;
    private Double calfCircumference;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_trainings",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "training_id"))
    private List<Training> training;
}
