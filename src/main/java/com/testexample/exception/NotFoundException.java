package com.testexample.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String ex) {
        super(ex);
    }

    public NotFoundException() {
    }
}
