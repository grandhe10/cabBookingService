package com.example.demo.exception;

public class InvalidCredentialsException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
    public InvalidCredentialsException(String exception) {
        super(exception);
    }
}