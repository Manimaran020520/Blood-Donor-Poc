package com.example.BloodDonor.CustomException;

import java.io.IOException;

public class AlreadyExistsException extends IOException {
    public AlreadyExistsException(String message) {
        super(message);
    }

    public AlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
