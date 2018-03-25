package com.circumfusion.exception;

import org.springframework.http.HttpStatus;

import com.circumfusion.infrastructure.AppException;

public class InvalidLoginException extends AppException
{
	private static final long serialVersionUID = 1L;

	@Override
	public String getErrorCode() {
		return "ERR_INVALID_LOGIN";
	}
	
	@Override
	public String getErrorMessage() {
		return "Invalid Login";
	}
	
	@Override
	public HttpStatus getStatus() {
		return HttpStatus.UNAUTHORIZED;
	}
}
