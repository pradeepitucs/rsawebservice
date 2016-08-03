package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "service_provider", namespace = "com.ucs.rsa.dto")
public class ServiceProvidersDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private List<ServiceProviderDTO> serviceProviderDTO;

	@XmlElement(name = "service_provider")
	public List<ServiceProviderDTO> getServiceProviderDTOs() {
		return serviceProviderDTO;
	}

	public void setServiceProviderDTOs(List<ServiceProviderDTO> serviceProviderDTO) {
		this.serviceProviderDTO = serviceProviderDTO;
	}

}
