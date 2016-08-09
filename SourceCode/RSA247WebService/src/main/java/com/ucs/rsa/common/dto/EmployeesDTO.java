package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee", namespace = "com.ucs.rsa.dto")
public class EmployeesDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<EmployeeDTO> employeeDTO;

	@XmlElement(name = "employee")
	public List<EmployeeDTO> getEmployeeDTO() {
		return employeeDTO;
	}

	public void setEmployeeDTO(List<EmployeeDTO> employeeDTO) {
		this.employeeDTO = employeeDTO;
	}

}
