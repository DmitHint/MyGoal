package org.mygoal.fitnessapp.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents a user in a fitness application.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    /**
     * The unique identifier of the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The login username of the user.
     */
    private String login;

    /**
     * The first name of the user.
     */
    private String firstName;

    /**
     * The last name of the user.
     */
    private String lastName;

    /**
     * The password of the user.
     */
    private String password;

    /**
     * The email address of the user.
     */
    private String email;

    /**
     * The height of the user in centimeters.
     */
    private Double height;

    /**
     * The weight of the user in kilograms.
     */
    private Double weight;

    /**
     * The body fat percentage of the user.
     */
    private Double fat;

    /**
     * The width of the user's shoulders in centimeters.
     */
    private Double shoulderWidth;

    /**
     * The circumference of the user's shoulders in centimeters.
     */
    private Double shoulderCircumference;

    /**
     * The circumference of the user's chest in centimeters.
     */
    private Double chestCircumference;

    /**
     * The circumference of the user's waist in centimeters.
     */
    private Double waistCircumference;

    /**
     * The circumference of the user's hips in centimeters.
     */
    private Double hipCircumference;

    /**
     * The circumference of the user's calves in centimeters.
     */
    private Double calfCircumference;

    /**
     * The list of training sessions associated with the user.
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_trainings",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "training_id"))
    private List<Training> training;

}
