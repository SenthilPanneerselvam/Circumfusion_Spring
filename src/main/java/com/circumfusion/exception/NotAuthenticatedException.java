package com.circumfusion.exception;

import org.springframework.http.HttpStatus;

import com.circumfusion.infrastructure.AppException;

public class NotAuthenticatedException extends AppException
{
	private static final long serialVersionUID = 1L;

	@Override
	public String getErrorCode() {
		return "ERR_NOT_AUTHENTICATED";
	}
	
	@Override
	public String getErrorMessage() {
		return "Not Authenticated";
	}
	
	@Override
	public HttpStatus getStatus() {
		return HttpStatus.UNAUTHORIZED;
	}
}
