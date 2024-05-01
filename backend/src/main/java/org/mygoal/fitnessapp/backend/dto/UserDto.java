package org.mygoal.fitnessapp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String login;

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


    private String token;
}

