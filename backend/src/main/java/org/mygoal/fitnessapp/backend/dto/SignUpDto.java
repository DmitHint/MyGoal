package org.mygoal.fitnessapp.backend.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data transfer object for user sign up data.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpDto {

    /**
     * User's first name.
     */
    @NotEmpty
    private String firstName;

    /**
     * User's last name.
     */
    @NotEmpty
    private String lastName;

    /**
     * User's login.
     */
    @NotEmpty
    private String login;

    /**
     * User's password.
     */
    @NotEmpty
    private char[] password;

}

