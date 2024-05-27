package org.mygoal.fitnessapp.backend.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Base class for all application exceptions.
 */
public class AppException extends RuntimeException {

    private final HttpStatus status;

    /**
     * AppException constructor with status
     */
    public AppException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    /**
     * Get exception status
     */
    public HttpStatus getStatus() {
        return status;
    }

}
