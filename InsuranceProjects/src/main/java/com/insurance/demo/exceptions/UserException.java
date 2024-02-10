package com.insurance.demo.exceptions;

import org.springframework.http.HttpStatus;

public class UserException {
	private final String message;
	private final Throwable throwable;
	private final HttpStatus status;
	
	public UserException(String message, Throwable throwable, HttpStatus status) {
		super();
		this.message = message;
		this.throwable = throwable;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public HttpStatus getStatus() {
		return status;
	}
	
	
}
