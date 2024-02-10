package com.insurance.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class UserExceptionHandler {
	@ExceptionHandler(value = { UserNotFoundException.class })
	
	public ResponseEntity<Object> handleUser(UserNotFoundException userNotFoundException) {
		UserException customerException = new UserException(userNotFoundException.getMessage(),
				userNotFoundException.getCause(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(customerException, HttpStatus.NOT_FOUND);
	}

}
