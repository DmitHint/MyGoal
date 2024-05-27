package org.mygoal.fitnessapp.backend.mappers;

import org.mygoal.fitnessapp.backend.dto.SignUpDto;
import org.mygoal.fitnessapp.backend.dto.UserDto;
import org.mygoal.fitnessapp.backend.model.User;
import org.springframework.stereotype.Component;

/**
 * Implementation of the {@link UserMapper} interface.
 * <p>
 * This implementation provides concrete methods for converting between {@link User} entities and their corresponding DTOs, {@link UserDto} and {@link SignUpDto}.
 */
@Component
public class UserMapperImpl implements UserMapper {

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDto toUserDto(User user) {
        if (user == null) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.id(user.getId());
        userDto.firstName(user.getFirstName());
        userDto.lastName(user.getLastName());
        userDto.login(user.getLogin());

        userDto.email(user.getEmail());
        userDto.height(user.getHeight());
        userDto.weight(user.getWeight());
        userDto.fat(user.getFat());
        userDto.shoulderWidth(user.getShoulderWidth());
        userDto.shoulderCircumference(user.getShoulderCircumference());
        userDto.chestCircumference(user.getChestCircumference());
        userDto.waistCircumference(user.getWaistCircumference());
        userDto.hipCircumference(user.getHipCircumference());
        userDto.calfCircumference(user.getCalfCircumference());

        return userDto.build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User signUpToUser(SignUpDto signUpDto) {
        if (signUpDto == null) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.firstName(signUpDto.getFirstName());
        user.lastName(signUpDto.getLastName());
        user.login(signUpDto.getLogin());

        return user.build();
    }
}
