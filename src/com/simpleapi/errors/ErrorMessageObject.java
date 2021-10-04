package com.simpleapi.errors;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessageObject {

	@XmlElement
	public String code;

	@XmlElement
	public String errorMessage;

	@XmlElement
	public String fix;

	public ErrorMessageObject(ErrorsEnum erro) {
		this.code = erro.getCode();
		this.errorMessage = erro.getErrorMessage();
		this.fix = erro.getFix();
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

	public void setCode(String code) {
		this.code = code;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setFix(String fix) {
		this.fix = fix;
	}

}
