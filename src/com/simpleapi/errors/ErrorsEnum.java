package com.simpleapi.errors;

public enum ErrorsEnum {

	L001_NULL_NAME("E001", "NUll name", "The name provided is null");
	
	private String code;
	private String errorMessage;
	private String fix;
	
	private ErrorsEnum(String code, String errorMessage, String fix) {
		this.code = code;
		this.errorMessage = errorMessage;
		this.fix = fix;
	}
	
	public ErrorMessage message() {
    	ErrorMessage msg = new ErrorMessage();
    	msg.setCode(code);
    	msg.setErrorMessage(errorMessage);
    	msg.setFix(fix);
    	return msg;
    }

	public String getCode() {
		return code;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getFix() {
		return fix;
	}
}
