package com.circumfusion.exception;

import org.springframework.http.HttpStatus;

import com.circumfusion.infrastructure.AppException;

public abstract class AlreadyExistException extends AppException {
	
	public abstract String getEntityName();
	
	@Override
	public abstract String getErrorCode();
	
	@Override
	public String getErrorMessage() {
		return getEntityName() + " already exists";
	}
	
	@Override
	public HttpStatus getStatus() {
		return HttpStatus.CONFLICT;
	}

}
