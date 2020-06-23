package com.example.demo.exception;

public class CabNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
    public CabNotFoundException(String exception) {
        super(exception);
    }
}