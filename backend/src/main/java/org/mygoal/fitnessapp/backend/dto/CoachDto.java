package org.mygoal.fitnessapp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoachDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String rating;
}
