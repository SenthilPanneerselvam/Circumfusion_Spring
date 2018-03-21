package com.circumfusion.exception;

public class UserAlreadyExistsException extends AlreadyExistException {
	
	private static final String TYPE = "User";

	@Override
	public String getEntityName() {
		return TYPE;
	}

	@Override
	public String getErrorCode() {
		return "ERR_USR_EXST";
	}

}
