package org.mygoal.fitnessapp.backend.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.mygoal.fitnessapp.backend.dto.UserDto;
import org.mygoal.fitnessapp.backend.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Collections;
import java.util.Date;

/**
 * This class is responsible for creating and validating JWT tokens.
 * It uses the HS256 algorithm and a secret key to sign and verify tokens.
 * The secret key is stored in the application.properties file.
 * The createToken method takes a login as input and returns a JWT token.
 * The validateToken method takes a token as input and returns an Authentication object if the token is valid.
 */
@RequiredArgsConstructor
@Component
public class UserAuthProvider {

    @Value(value = "${security.jwt.token.secret-key}")
    private String secretKey;

    private final UserService userService;

    /**
     * This method is called after the bean is instantiated and initializes the secret key.
     */
    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    /**
     * This method creates a JWT token for the given login.
     *
     * @param login the login of the user
     * @return the JWT token
     */
    public String createToken(String login) {
        Date now = new Date();
//        Date validity = new Date(now.getTime() + 3600000); // 1 hour

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return JWT.create()
                .withSubject(login)
                .withIssuedAt(now)
//                .withExpiresAt(validity)
                .sign(algorithm);
    }

    /**
     * Validates the given JWT token.
     *
     * @param token The JWT token to be validated.
     * @return An Authentication object if the token is valid, containing user information.
     */
    public Authentication validateToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        JWTVerifier verifier = JWT.require(algorithm)
                .build();

        DecodedJWT decoded = verifier.verify(token);

        UserDto user = userService.findByLogin(decoded.getSubject());

        return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
    }

}
