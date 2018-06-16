package com.cars.exceptions;

public class CarsException extends Exception{

    private static final long serialVersionUID = 1L;

    public CarsException(String message) {
        super(message);
    }

    public CarsException(String message, Exception e) {
        super(message, e);
    }
}
