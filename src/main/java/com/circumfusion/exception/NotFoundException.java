package com.circumfusion.exception;

public abstract class NotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract String getEntityName();
	
}
