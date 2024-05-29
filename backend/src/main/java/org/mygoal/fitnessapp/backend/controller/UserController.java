package org.mygoal.fitnessapp.backend.controller;

import lombok.RequiredArgsConstructor;
import org.mygoal.fitnessapp.backend.dto.UserDto;
import org.mygoal.fitnessapp.backend.dto.UserParameters;
import org.mygoal.fitnessapp.backend.service.EmailService;
import org.mygoal.fitnessapp.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST API controller for managing User data in the FitnessApp backend.
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/profile")
public class UserController {

    /**
     * The UserService instance used to interact with the database.
     */
    private final UserService userService;

    /**
     * The EmailService instance used to send emails.
     */
    private final EmailService emailService;

    /**
     * GET endpoint to fetch a user's profile data by their ID.
     *
     * @param id The ID of the user to fetch.
     * @return A ResponseEntity object containing a UserDto object and an HTTP 200 (OK) status code.
     */
    @GetMapping("")
    public ResponseEntity<UserDto> getUserById(@RequestParam Long id) {
        UserDto user = userService.getUserDtoById(id);
        return ResponseEntity.ok(user);
    }

    /**
     * POST endpoint to change a user's email address.
     *
     * @param id    The ID of the user to change the email address for.
     * @param email The new email address.
     * @return A ResponseEntity object containing the updated UserDto object and an HTTP 200 (OK) status code.
     */
    @PostMapping("/email")
    public ResponseEntity<UserDto> changeUserEmail(@RequestParam Long id, String email) {
        UserDto user = userService.changeUserEmail(id, email);
        return ResponseEntity.ok(user);
    }

    /**
     * POST endpoint to change a user's physical parameters.
     *
     * @param id         The ID of the user to change the parameters for.
     * @param parameters The new physical parameters.
     * @return A ResponseEntity object containing the updated UserDto object and an HTTP 200 (OK) status code.
     */
    @PostMapping("/params")
    public ResponseEntity<UserDto> changeUserParams(@RequestParam Long id, @RequestBody UserParameters parameters) {
        UserDto user = userService.changeUserParams(id, parameters);
        return ResponseEntity.ok(user);
    }

    /**
     * POST endpoint to email a user with their current physical parameters.
     *
     * @param id The ID of the user to send the email to.
     * @return A ResponseEntity object with an HTTP 200 (OK) status code.
     */
    @PostMapping("/sendParams")
    public ResponseEntity<Void> sendEmailParams(@RequestParam Long id) {
        emailService.sendEmailParams(userService.getUserById(id));
        return ResponseEntity.ok().build();
    }
}
