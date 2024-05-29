package org.mygoal.fitnessapp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data transfer object for Coach entity.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoachDto {
    /**
     * Coach's ID.
     */
    private Long id;

    /**
     * Coach's first name.
     */
    private String firstName;

    /**
     * Coach's last name.
     */
    private String lastName;

    /**
     * Coach's rating.
     */
    private String rating;
}
