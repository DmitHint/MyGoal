package org.mygoal.fitnessapp.backend.model;

/**
 * Enum representing the possible statuses of a {@link Training}.
 */
public class Status {

    /**
     * The training has been completed.
     */
    public static final String FINISHED = "finished";

    /**
     * The training is currently in progress.
     */
    public static final String ONGOING = "ongoing";

    /**
     * The training has not yet started.
     */
    public static final String NOT_STARTED = "not started";
}