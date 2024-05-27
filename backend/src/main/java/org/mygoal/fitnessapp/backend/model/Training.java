package org.mygoal.fitnessapp.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * Represents a training session in a fitness application.
 */
@Entity
@Data
public class Training {

    /**
     * The unique identifier of the training session.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The current status of the training session (e.g., "Planned", "In Progress", "Completed").
     */
    private String status;

    /**
     * The scheduled or actual date and time of the training session.
     */
    private LocalDateTime trainingDateTime;

    /**
     * The user who is participating in the training session.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    /**
     * The coach who is leading the training session.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private Coach coach;

}
