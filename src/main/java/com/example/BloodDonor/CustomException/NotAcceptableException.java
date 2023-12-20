package com.example.BloodDonor.CustomException;

import java.io.IOException;

public class NotAcceptableException extends IOException {
    public NotAcceptableException(String message) {
        super(message);
    }

    public NotAcceptableException(String message, Throwable cause) {
        super(message, cause);
    }
}
