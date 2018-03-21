package com.circumfusion.exception;

public abstract class NotFoundException extends RuntimeException {

	public abstract String getEntityName();
	
}
