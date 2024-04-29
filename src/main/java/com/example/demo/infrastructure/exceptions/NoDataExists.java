package com.example.demo.infrastructure.exceptions;

public class NoDataExists extends RuntimeException{
    public NoDataExists(String message) {
        super(message);
    }
}
