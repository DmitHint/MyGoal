package org.mygoal.fitnessapp.backend.service;

import org.mygoal.fitnessapp.backend.dto.CredentialsDto;
import org.mygoal.fitnessapp.backend.dto.SignUpDto;
import org.mygoal.fitnessapp.backend.dto.UserDto;
import org.mygoal.fitnessapp.backend.dto.UserParameters;
import org.mygoal.fitnessapp.backend.exceptions.AppException;
import org.mygoal.fitnessapp.backend.mappers.UserMapper;
import org.mygoal.fitnessapp.backend.model.User;
import org.mygoal.fitnessapp.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.CharBuffer;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    public UserDto login(CredentialsDto credentialsDto) {
        User user = userRepository.findByLogin(credentialsDto.getLogin())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        System.out.println("PASSWORD");
        System.out.println(passwordEncoder
                .matches(CharBuffer.wrap(credentialsDto.getPassword()),
                        user.getPassword()
                )
        );
        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public UserDto register(SignUpDto userDto) {
        Optional<User> optionalUser = userRepository.findByLogin(userDto.getLogin());

        if (optionalUser.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.signUpToUser(userDto);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.getPassword())));

        User savedUser = userRepository.save(user);

        return userMapper.toUserDto(savedUser);
    }

    public UserDto findByLogin(String login) {
        User user = userRepository.findByLogin(login)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }

    public UserDto getUserDtoById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
    }


    public UserDto changeUserEmail(Long id, String email) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        user.setEmail(email);
        userRepository.save(user);

        return userMapper.toUserDto(user);
    }

    public UserDto changeUserParams(Long id, UserParameters parameters) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        user.setHeight(parameters.getHeight());
        user.setWeight(parameters.getWeight());
        user.setFat(parameters.getFat());
        user.setShoulderWidth(parameters.getShoulderWidth());
        user.setShoulderCircumference(parameters.getShoulderCircumference());
        user.setChestCircumference(parameters.getChestCircumference());
        user.setWaistCircumference(parameters.getWaistCircumference());
        user.setHipCircumference(parameters.getHipCircumference());
        user.setCalfCircumference(parameters.getCalfCircumference());

        userRepository.save(user);

        return userMapper.toUserDto(user);
    }


}
