package com.ucs.rsa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="service_provider_service_matching_t")
@NamedQuery(name="ServiceProviderServiceMatchingModel.findAll", query="SELECT u FROM ServiceProviderServiceMatchingModel u")
public class ServiceProviderServiceMatchingModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="service_provider_service_matching_id")
	private int serviceProviderMatchingId;
	
	@ManyToOne
	@JoinColumn(name="service_type_id")
	private ServiceTypeModel serviceTypeModel;
	
	@ManyToOne
	@JoinColumn(name="service_provider_id")
	private ServiceProviderModel serviceProviderModel;

	public int getServiceProviderMatchingId() {
		return serviceProviderMatchingId;
	}

	public void setServiceProviderMatchingId(int serviceProviderMatchingId) {
		this.serviceProviderMatchingId = serviceProviderMatchingId;
	}

	public ServiceTypeModel getServiceTypeModel() {
		return serviceTypeModel;
	}

	public void setServiceTypeModel(ServiceTypeModel serviceTypeModel) {
		this.serviceTypeModel = serviceTypeModel;
	}

	public ServiceProviderModel getServiceProviderModel() {
		return serviceProviderModel;
	}

	public void setServiceProviderModel(ServiceProviderModel serviceProviderModel) {
		this.serviceProviderModel = serviceProviderModel;
	}
	
	@Override
	public String toString() {
		return "ServiceProviderServiceMatchingModel [ serviceProviderMatchingId=" + serviceProviderMatchingId + ", serviceTypeModel=" + serviceTypeModel
				 + ", serviceProviderModel="
				+ serviceProviderModel  + "]" + super.toString();
	}

}
