package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="serviceType",namespace="com.ucs.rsa.common.dto")
public class ServiceTypeDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int serviceTypeId;
	private String serviceType;
	private String nonMemberPrice;
	private String memberPrice;
	
	public String getNonMemberPrice() {
		return nonMemberPrice;
	}
	public void setNonMemberPrice(String nonMemberPrice) {
		this.nonMemberPrice = nonMemberPrice;
	}
	public String getMemberPrice() {
		return memberPrice;
	}
	public void setMemberPrice(String memberPrice) {
		this.memberPrice = memberPrice;
	}
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
}
