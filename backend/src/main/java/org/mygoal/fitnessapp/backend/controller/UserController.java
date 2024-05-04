package org.mygoal.fitnessapp.backend.controller;

import lombok.RequiredArgsConstructor;
import org.mygoal.fitnessapp.backend.dto.UserDto;
import org.mygoal.fitnessapp.backend.dto.UserParameters;
import org.mygoal.fitnessapp.backend.service.EmailService;
import org.mygoal.fitnessapp.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;
    private final EmailService emailService;

    @GetMapping("/profile")
    public ResponseEntity<UserDto> getUserById(@RequestParam Long id) {
        UserDto user = userService.getUserDtoById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/profile/email")
    public ResponseEntity<UserDto> changeUserEmail(@RequestParam Long id, String email) {
        UserDto user = userService.changeUserEmail(id, email);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/profile/params")
    public ResponseEntity<UserDto> changeUserParams(@RequestParam Long id, @RequestBody UserParameters parameters) {
        UserDto user = userService.changeUserParams(id, parameters);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/profile/sendParams")
    public ResponseEntity<Void> sendEmailParams(@RequestParam Long id) {
        emailService.sendEmailParams(userService.getUserById(id));
        return ResponseEntity.ok().build();
    }
}
