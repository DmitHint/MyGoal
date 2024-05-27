package org.mygoal.fitnessapp.backend.repository;

import org.mygoal.fitnessapp.backend.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the {@link Coach} entity.
 */
@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
}
