package org.mygoal.fitnessapp.backend.service.util;

import jakarta.persistence.criteria.Predicate;
import org.mygoal.fitnessapp.backend.model.Training;
import org.springframework.data.jpa.domain.Specification;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class TrainingSpecifications {
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


//
//public class TrainingSpecifications {
//    public static Specification<Training> filter(Long userId, Long coachId, LocalDateTime date) {
//        return (root, query, criteriaBuilder) -> {
//            CriteriaQuery<Training> criteriaQuery = criteriaBuilder.createQuery(Training.class);
//            Root<Training> rootEntity = criteriaQuery.from(Training.class);
//            Predicate predicate = criteriaBuilder.conjunction();
//
//            if (userId != null) {
//                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(rootEntity.get("user").get("id"), userId));
//            }
//
//            if (coachId != null) {
//                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(rootEntity.get("coach").get("id"), coachId));
//            }
//
//            if (date != null) {
//                predicate = criteriaBuilder.and(predicate, criteriaBuilder.;
//            }
//
//            return predicate;
//        };
//    }
//}
