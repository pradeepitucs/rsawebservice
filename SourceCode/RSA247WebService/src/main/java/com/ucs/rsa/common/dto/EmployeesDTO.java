/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author Gururaj A M
 * @version 1.0
 * 
 *          The Class EmployeesDTO.
 */
@XmlRootElement(name = "employee", namespace = "com.ucs.rsa.dto")
public class EmployeesDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The employee DTO. */
	private List<EmployeeDTO> employeeDTO;

	/**
	 * Gets the employee DTO.
	 *
	 * @return the employee DTO
	 */
	@XmlElement(name = "employee")
	public List<EmployeeDTO> getEmployeeDTO()
	{
		return employeeDTO;
	}

	/**
	 * Sets the employee DTO.
	 *
	 * @param employeeDTO
	 *           the new employee DTO
	 */
	public void setEmployeeDTO(List<EmployeeDTO> employeeDTO)
	{
		this.employeeDTO = employeeDTO;
	}

}
