package com.ucs.rsa.common.exception;

import java.util.Locale;

import com.ucs.rsa.common.constants.RSAErrorConstants.ErrorCode;

public class RSAException extends RuntimeException {

	private static final long serialVersionUID = -1238436298527570673L;

	private Locale locale;
	private String localizedErrorMessage;

	private ErrorCode error;

	public RSAException() {
		
	}
	
	public RSAException(ErrorCode iErrorCode) {
		this.error = iErrorCode;
	}

	public RSAException(ErrorCode iErrorCode, Locale iLocale) {
		this.error = iErrorCode;
		this.locale = iLocale;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getLocalizedErrorMessage() {
		return localizedErrorMessage;
	}

	public void setLocalizedErrorMessage(String localizedErrorMessage) {
		this.localizedErrorMessage = localizedErrorMessage;
	}

	public ErrorCode getError() {
		return error;
	}

	public void setError(ErrorCode error) {
		this.error = error;
	}

}
