package com.ucs.rsa.common.dto;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "error", namespace = "com.ucs.rsa.common.dto")
public class ExceptionDTO {

	private int errorCode;
	private String errorKey;
	private String errorMessage;
	private String localizedErrorMessage;

	public int getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(final int iErrorCode) {
		this.errorCode = iErrorCode;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}

	public void setErrorMessage(final String iErrorMessage) {
		this.errorMessage = iErrorMessage;
	}

	public String getLocalizedErrorMessage() {
		return this.localizedErrorMessage;
	}

	public void setLocalizedErrorMessage(final String iLocalizedErrorMessage) {
		this.localizedErrorMessage = iLocalizedErrorMessage;
	}

	public String getErrorKey() {
		return this.errorKey;
	}

	public void setErrorKey(final String iErrorKey) {
		this.errorKey = iErrorKey;
	}
}
