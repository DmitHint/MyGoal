package org.mygoal.fitnessapp.backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mygoal.fitnessapp.backend.dto.SignUpDto;
import org.mygoal.fitnessapp.backend.dto.UserDto;
import org.mygoal.fitnessapp.backend.model.User;

/**
 * Mapper for {@link User} entities and their corresponding DTOs.
 * <p>
 * This mapper is responsible for converting between the {@link User} entity and its DTO representations, {@link UserDto} and {@link SignUpDto}.
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    /**
     * Converts a {@link User} entity to a {@link UserDto}.
     *
     * @param user The {@link User} entity to convert.
     * @return The {@link UserDto} representation of the {@link User} entity.
     */
    UserDto toUserDto(User user);

    /**
     * Converts a {@link SignUpDto} to a {@link User} entity.
     * <p>
     * Note: The password field is ignored during the conversion to prevent it from being exposed.
     *
     * @param signUpDto The {@link SignUpDto} to convert.
     * @return The {@link User} entity representation of the {@link SignUpDto}.
     */
    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

}
