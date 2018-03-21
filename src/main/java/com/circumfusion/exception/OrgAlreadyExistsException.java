package com.circumfusion.exception;

public class OrgAlreadyExistsException extends AlreadyExistException {
	
	private static final String TYPE = "Organization";

	@Override
	public String getEntityName() {
		return TYPE;
	}

	@Override
	public String getErrorCode() {
		return "ERR_ORG_EXST";
	}

}
