/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class StatesDTO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@XmlRootElement(name = "states", namespace = "com.ucs.rsa.common.dto")

public class StatesDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The state DT os. */
	private List<StateDTO> stateDTOs;

	/**
	 * Gets the state DT os.
	 *
	 * @return the state DT os
	 */
	@XmlElement(name = "state")
	public List<StateDTO> getStateDTOs()
	{
		return stateDTOs;
	}

	/**
	 * Sets the state DT os.
	 *
	 * @param stateDTOs
	 *           the new state DT os
	 */
	public void setStateDTOs(List<StateDTO> stateDTOs)
	{
		this.stateDTOs = stateDTOs;
	}

}
