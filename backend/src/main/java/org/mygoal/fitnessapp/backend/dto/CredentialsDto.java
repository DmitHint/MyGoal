package org.mygoal.fitnessapp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data transfer object for Credentials entity.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CredentialsDto {

    /**
     * User's login.
     */
    private String login;

    /**
     * User's password.
     */
    private char[] password;

}
