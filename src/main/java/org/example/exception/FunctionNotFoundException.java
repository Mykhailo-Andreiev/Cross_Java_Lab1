package org.example.exception;

public class FunctionNotFoundException extends RuntimeException {

    public FunctionNotFoundException(String message) {
        super(message);
    }
}
