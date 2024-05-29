package org.mygoal.fitnessapp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Data transfer object for error messages.
 */
@AllArgsConstructor
@Data
@Builder
public class ErrorDto {

    /**
     * Error message.
     */
    private String message;
}

