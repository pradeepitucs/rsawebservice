package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="serviceType",namespace="com.ucs.rsa.common.dto")
public class ServiceTypeDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int serviceTypeId;
	private String serviceType;
	private int servicePrice;
	
	public int getServiceTypeId() {
		return serviceTypeId;
	}
	public void setServiceTypeId(int serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public int getServicePrice() {
		return servicePrice;
	}
	public void setServicePrice(int servicePrice) {
		this.servicePrice = servicePrice;
	}
}
