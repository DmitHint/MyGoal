package org.mygoal.fitnessapp.backend.repository;

import org.mygoal.fitnessapp.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for working with user data.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Method for finding a user by login.
     *
     * @param login User's login.
     * @return An Optional object containing the user if it was found, or an empty object if the user was not found.
     */
    Optional<User> findByLogin(String login);
}


