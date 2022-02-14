package com.musala.drone.exception;

public class BadRequestException extends RuntimeException  {

    private static final long serialVersionUID = -167207076249088181L;

    public BadRequestException(String message) {
        super(message);
    }
}
