package com.example.smartcode.exception;

public class NegativeParametersException extends Exception {

    private static final String REASON = "Negative parameters are not allowed: %s";

    public NegativeParametersException(Double parameter) {
        super(String.format(REASON, parameter));
    }
}
