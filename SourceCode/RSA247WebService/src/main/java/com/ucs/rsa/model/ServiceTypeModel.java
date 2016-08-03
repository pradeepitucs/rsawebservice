package com.ucs.rsa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "service_type_t")
@NamedQuery(name = "ServiceTypeModel.findAll", query = "SELECT v FROM ServiceTypeModel v")
public class ServiceTypeModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_type_id")
	private int serviceTypeId;

	@Column(name = "service_type")
	private String serviceType;

	@Column(name = "service_price")
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

	@Override
	public String toString() {
		return "ServiceTypeModel [serviceTypeId=" + serviceTypeId
				+ ",serviceType=" + serviceType + ",servicePrice="
				+ servicePrice  + "]";
	}

}
