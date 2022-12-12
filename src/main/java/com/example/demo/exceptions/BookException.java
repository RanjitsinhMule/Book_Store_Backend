package com.example.demo.exceptions;

public class BookException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	String message;
	String details;

	public BookException() {
	}

	public BookException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
