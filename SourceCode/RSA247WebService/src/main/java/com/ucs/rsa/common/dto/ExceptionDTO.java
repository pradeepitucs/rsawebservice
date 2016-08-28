/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author Gururaj A M
 * @version 1.0
 * 
 *          The Class ExceptionDTO.
 */
@XmlRootElement(name = "error", namespace = "com.ucs.rsa.common.dto")
public class ExceptionDTO
{

	/** The error code. */
	private int errorCode;

	/** The error key. */
	private String errorKey;

	/** The error message. */
	private String errorMessage;

	/** The localized error message. */
	private String localizedErrorMessage;

	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public int getErrorCode()
	{
		return this.errorCode;
	}

	/**
	 * Sets the error code.
	 *
	 * @param iErrorCode
	 *           the new error code
	 */
	public void setErrorCode(final int iErrorCode)
	{
		this.errorCode = iErrorCode;
	}

	/**
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	public String getErrorMessage()
	{
		return this.errorMessage;
	}

	/**
	 * Sets the error message.
	 *
	 * @param iErrorMessage
	 *           the new error message
	 */
	public void setErrorMessage(final String iErrorMessage)
	{
		this.errorMessage = iErrorMessage;
	}

	/**
	 * Gets the localized error message.
	 *
	 * @return the localized error message
	 */
	public String getLocalizedErrorMessage()
	{
		return this.localizedErrorMessage;
	}

	/**
	 * Sets the localized error message.
	 *
	 * @param iLocalizedErrorMessage
	 *           the new localized error message
	 */
	public void setLocalizedErrorMessage(final String iLocalizedErrorMessage)
	{
		this.localizedErrorMessage = iLocalizedErrorMessage;
	}

	/**
	 * Gets the error key.
	 *
	 * @return the error key
	 */
	public String getErrorKey()
	{
		return this.errorKey;
	}

	/**
	 * Sets the error key.
	 *
	 * @param iErrorKey
	 *           the new error key
	 */
	public void setErrorKey(final String iErrorKey)
	{
		this.errorKey = iErrorKey;
	}
}
