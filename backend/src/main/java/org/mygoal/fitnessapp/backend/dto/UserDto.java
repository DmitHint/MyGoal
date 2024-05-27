package org.mygoal.fitnessapp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data transfer object for User entity.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    /**
     * User's ID.
     */
    private Long id;

    /**
     * User's first name.
     */
    private String firstName;

    /**
     * User's last name.
     */
    private String lastName;

    /**
     * User's login.
     */
    private String login;

    /**
     * User's email.
     */
    private String email;

    /**
     * User's height in centimeters.
     */
    private Double height;

    /**
     * User's weight in kilograms.
     */
    private Double weight;

    /**
     * User's body fat percentage.
     */
    private Double fat;

    /**
     * User's shoulder width in centimeters.
     */
    private Double shoulderWidth;

    /**
     * User's shoulder circumference in centimeters.
     */
    private Double shoulderCircumference;

    /**
     * User's chest circumference in centimeters.
     */
    private Double chestCircumference;

    /**
     * User's waist circumference in centimeters.
     */
    private Double waistCircumference;

    /**
     * User's hip circumference in centimeters.
     */
    private Double hipCircumference;

    /**
     * User's calf circumference in centimeters.
     */
    private Double calfCircumference;

    /**
     * User's JWT token.
     */
    private String token;

}