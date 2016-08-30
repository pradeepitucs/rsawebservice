/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class StringDTO.
 */
@XmlRootElement(name = "string", namespace = "com.ucs.rsa.common.dto")
public class StringDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The str. */
	private String str;

	/**
	 * Gets the str.
	 *
	 * @return the str
	 */
	public String getStr()
	{
		return str;
	}

	/**
	 * Sets the str.
	 *
	 * @param str
	 *           the new str
	 */
	public void setStr(String str)
	{
		this.str = str;
	}

}
