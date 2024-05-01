package org.mygoal.fitnessapp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserParameters {
    private Double height;
    private Double weight;
    private Double fat;

    private Double shoulderWidth;
    private Double shoulderCircumference;
    private Double chestCircumference;
    private Double waistCircumference;
    private Double hipCircumference;
    private Double calfCircumference;
}
