package org.mygoal.fitnessapp.backend.config;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

/**
 * This class adapts a role to the GrantedAuthority interface, which is required by Spring Security for authorization.
 */
@AllArgsConstructor
public class RolesGrantedAuthorityAdapter implements GrantedAuthority {

    /**
     * Authority of the role
     */
    private String authority;

    /**
     * Returns the authority of the role.
     *
     * @return the authority of the role
     */
    @Override
    public String getAuthority() {
        return this.authority;
    }
}

