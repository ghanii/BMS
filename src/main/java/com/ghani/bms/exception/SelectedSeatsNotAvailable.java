package com.ghani.bms.exception;

public class SelectedSeatsNotAvailable extends RuntimeException {
    public SelectedSeatsNotAvailable(String message) {
        super(message);
    }
}
