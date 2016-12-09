/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


// TODO: Auto-generated Javadoc
/**
 * The Class CitiesDTO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@XmlRootElement(name = "issuepayments", namespace = "com.ucs.rsa.common.dto")

public class IssuePaymentsDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The issue payment DT os. */
	private List<IssuePaymentDTO> issuePaymentDTOs;

	/**
	 * Gets the issue payment DT os.
	 *
	 * @return the issue payment DT os
	 */
	public List<IssuePaymentDTO> getIssuePaymentDTOs()
	{
		return issuePaymentDTOs;
	}

	/**
	 * Sets the issue payment DT os.
	 *
	 * @param issuePaymentDTOs
	 *           the new issue payment DT os
	 */
	public void setIssuePaymentDTOs(List<IssuePaymentDTO> issuePaymentDTOs)
	{
		this.issuePaymentDTOs = issuePaymentDTOs;
	}

}
