package com.insurance.demo.exceptions;



public class UserNotFoundException extends RuntimeException{
	private String errorMessage;
	
	public UserNotFoundException(String errorMessage) {
		super(errorMessage);
		
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
