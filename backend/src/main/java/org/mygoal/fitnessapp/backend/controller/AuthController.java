package org.mygoal.fitnessapp.backend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.mygoal.fitnessapp.backend.config.UserAuthProvider;
import org.mygoal.fitnessapp.backend.dto.CredentialsDto;
import org.mygoal.fitnessapp.backend.dto.SignUpDto;
import org.mygoal.fitnessapp.backend.dto.UserDto;
import org.mygoal.fitnessapp.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

/**
 * This class defines the REST controller for authentication.
 * It handles login and registration requests.
 * The login endpoint takes a CredentialsDto object as input and returns a UserDto object with a token.
 * The registration endpoint takes a SignUpDto object as input and returns a UserDto object with a token.
 */
@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api")
public class AuthController {

    private final UserService userService;
    private final UserAuthProvider userAuthProvider;

    /**
     * This method handles login requests. It takes a CredentialsDto object as input and returns a UserDto object with a token.
     *
     * @param credentialsDto the credentials of the user
     * @return the user with a token
     */
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid CredentialsDto credentialsDto) {
        UserDto userDto = userService.login(credentialsDto);
        userDto.setToken(userAuthProvider.createToken(userDto.getLogin()));
        return ResponseEntity.ok(userDto);
    }

    /**
     * This method handles registration requests. It takes a SignUpDto object as input and returns a UserDto object with a token.
     *
     * @param user the user to be registered
     * @return the registered user with a token
     */
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpDto user) {
        UserDto createdUser = userService.register(user);
        createdUser.setToken(userAuthProvider.createToken(user.getLogin()));
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }

}

