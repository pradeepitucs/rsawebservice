/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class StringBuilderDTO.
 */
@XmlRootElement(name = "stringbuilder", namespace = "com.ucs.rsa.common.dto")
public class StringBuilderDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The str builder. */
	private StringBuilder strBuilder;

	/**
	 * Gets the str builder.
	 *
	 * @return the str builder
	 */
	public StringBuilder getStrBuilder()
	{
		return strBuilder;
	}

	/**
	 * Sets the str builder.
	 *
	 * @param strBuilder
	 *           the new str builder
	 */
	public void setStrBuilder(StringBuilder strBuilder)
	{
		this.strBuilder = strBuilder;
	}

}
