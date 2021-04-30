package com.cflox.number_converter.exception;

public class NumberOutOfRangeException extends RuntimeException{


	private static final long serialVersionUID = 1L;
	private String message;

	public NumberOutOfRangeException() {
	}

	public NumberOutOfRangeException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
