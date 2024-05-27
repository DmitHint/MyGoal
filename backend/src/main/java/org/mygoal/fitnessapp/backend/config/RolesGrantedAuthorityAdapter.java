package org.mygoal.fitnessapp.backend.config;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

/**
 * This class adapts a role to the GrantedAuthority interface, which is required by Spring Security for authorization.
 */
@AllArgsConstructor
public class RolesGrantedAuthorityAdapter implements GrantedAuthority {
    private String authority;

    @Override
    public String getAuthority() {
        return this.authority;
    }
}

