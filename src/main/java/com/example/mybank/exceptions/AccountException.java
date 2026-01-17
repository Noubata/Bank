package com.example.mybank.exceptions;

public class AccountException extends RuntimeException {
    public AccountException(String message) {
        super(message);
    }
}
