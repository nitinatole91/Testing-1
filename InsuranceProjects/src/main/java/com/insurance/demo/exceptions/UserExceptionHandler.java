package com.insurance.demo.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.UnexpectedTypeException;
@RestControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(value = { UserNotFoundException.class })	
	public ResponseEntity<Object> handleUser(UserNotFoundException userNotFoundException) {
		UserException customerException = new UserException(userNotFoundException.getMessage(),
				userNotFoundException.getCause(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(customerException, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = {MethodArgumentNotValidException.class})
	
	public ResponseEntity<Map<String, String>>  handleUserBeanNotValidException(MethodArgumentNotValidException ex){
		Map<String ,String> resp=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			
			String fieldName=((FieldError)error).getField();
			String message = error.getDefaultMessage();
			resp.put(fieldName, message);
		});
		return new ResponseEntity<Map<String, String>>(resp,HttpStatus.BAD_REQUEST);
	}
	
	
}
