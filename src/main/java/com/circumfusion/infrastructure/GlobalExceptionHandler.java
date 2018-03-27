package com.circumfusion.infrastructure;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=AppException.class)
	public ResponseEntity<AppException> handleDuplicate(AppException exception) {
		return new ResponseEntity<AppException>(exception, exception.getStatus());
	}
	
}
