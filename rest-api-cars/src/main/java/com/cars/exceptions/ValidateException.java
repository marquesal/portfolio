package com.cars.exceptions;

public class ValidateException extends Exception {

    private static final long serialVersionUID = 1L;

    public ValidateException(String message) {
        super(message);
    }

    public ValidateException(String message, Exception e) {
        super(message, e);
    }
}
