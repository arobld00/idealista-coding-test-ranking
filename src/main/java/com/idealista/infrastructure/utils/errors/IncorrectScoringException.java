package com.idealista.infrastructure.utils.errors;

public class IncorrectScoringException extends RuntimeException {

    public IncorrectScoringException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

}
