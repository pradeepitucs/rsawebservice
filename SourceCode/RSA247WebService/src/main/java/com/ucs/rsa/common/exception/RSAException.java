/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.exception;

import java.util.Locale;

import com.ucs.rsa.common.constants.RSAErrorConstants.ErrorCode;


/**
 * The Class RSAException.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
public class RSAException extends RuntimeException
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1238436298527570673L;

	/** The locale. */
	private Locale locale;

	/** The localized error message. */
	private String localizedErrorMessage;

	/** The root cause. */
	private Throwable rootCause;

	/** The error. */
	private ErrorCode error;

	/**
	 * Instantiates a new RSA exception.
	 */
	public RSAException()
	{

	}

	/**
	 * Instantiates a new RSA exception.
	 *
	 * @param iErrorCode
	 *           the i error code
	 */
	public RSAException(ErrorCode iErrorCode)
	{
		this.error = iErrorCode;
	}

	/**
	 * Instantiates a new RSA exception.
	 *
	 * @param iErrorCode
	 *           the i error code
	 * @param iLocale
	 *           the i locale
	 */
	public RSAException(ErrorCode iErrorCode, Locale iLocale)
	{
		this.error = iErrorCode;
		this.locale = iLocale;
	}

	/**
	 * Gets the locale.
	 *
	 * @return the locale
	 */
	public Locale getLocale()
	{
		return locale;
	}

	/**
	 * Sets the locale.
	 *
	 * @param locale
	 *           the new locale
	 */
	public void setLocale(Locale locale)
	{
		this.locale = locale;
	}

	/**
	 * Gets the localized error message.
	 *
	 * @return the localized error message
	 */
	public String getLocalizedErrorMessage()
	{
		return localizedErrorMessage;
	}

	/**
	 * Sets the localized error message.
	 *
	 * @param localizedErrorMessage
	 *           the new localized error message
	 */
	public void setLocalizedErrorMessage(String localizedErrorMessage)
	{
		this.localizedErrorMessage = localizedErrorMessage;
	}

	/**
	 * Gets the error.
	 *
	 * @return the error
	 */
	public ErrorCode getError()
	{
		return error;
	}

	/**
	 * Sets the error.
	 *
	 * @param error
	 *           the new error
	 */
	public void setError(ErrorCode error)
	{
		this.error = error;
	}

	/**
	 * Gets the root cause.
	 *
	 * @return the root cause
	 */
	public Throwable getRootCause()
	{
		return rootCause;
	}

	/**
	 * Sets the root cause.
	 *
	 * @param rootCause
	 *           the new root cause
	 */
	public void setRootCause(Throwable rootCause)
	{
		this.rootCause = rootCause;
	}

}
