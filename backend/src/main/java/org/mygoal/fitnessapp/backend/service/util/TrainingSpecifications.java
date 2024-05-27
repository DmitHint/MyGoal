package org.mygoal.fitnessapp.backend.service.util;

import jakarta.persistence.criteria.Predicate;
import org.mygoal.fitnessapp.backend.model.Training;
import org.springframework.data.jpa.domain.Specification;
import java.time.LocalDateTime;
import java.time.LocalDate;

/**
 * Class containing specifications for filtering workouts.
 */
public class TrainingSpecifications {

    /**
     * Method for creating a specification that filters workouts by the specified parameters.
     *
     * @param userId   User ID.
     * @param coachId  Coach ID.
     * @param dateTime Workout date and time.
     * @return Specification that can be used to filter workouts.
     */
    public static Specification<Training> filter(Long userId, Long coachId, LocalDateTime dateTime) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (userId != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("user").get("id"), userId));
            }

            if (coachId != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("coach").get("id"), coachId));
            }

            if (dateTime != null) {
                LocalDate currentDate = LocalDate.now();

                LocalDateTime startOfDay = dateTime.toLocalDate().atStartOfDay();
                LocalDateTime endOfDay = dateTime.toLocalDate().atTime(23, 59, 59);

                predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.<LocalDate>get("trainingDateTime"), currentDate));

                predicate = criteriaBuilder.and(
                        predicate,
                        criteriaBuilder.between(root.get("trainingDateTime"), startOfDay, endOfDay)
                );

                if (dateTime.toLocalDate().equals(currentDate)) {
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("trainingDateTime"), dateTime));
                }
            }

            return predicate;
        };
    }
}
