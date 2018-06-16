package com.cars.exceptions;

public class UsersException extends Exception{

    private static final long serialVersionUID = 1L;

    public UsersException(String message) {
        super(message);
    }

    public UsersException(String message, Exception e) {
        super(message, e);
    }
}
