package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "serviceTypes", namespace = "com.ucs.rsa.common.dto")
public class ServiceTypesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ServiceTypeDTO> serviceTypesDTO;

	@XmlElement(name = "serviceTypes")
	public List<ServiceTypeDTO> getServiceTypesDTO() {
		return serviceTypesDTO;
	}

	public void setServiceTypesDTO(List<ServiceTypeDTO> serviceTypesDTO) {
		this.serviceTypesDTO = serviceTypesDTO;
	}

}
