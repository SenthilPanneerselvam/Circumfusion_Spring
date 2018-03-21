package com.circumfusion.infrastructure;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.circumfusion.exception.AlreadyExistException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=AlreadyExistException.class)
	public ResponseEntity<AppException> handleDuplicate(AlreadyExistException exception) {
		return new ResponseEntity<AppException>(exception, exception.getStatus());
	}

}
