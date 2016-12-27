/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
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


/**
 * The Class ServiceProviderServiceMatchingModel.
 */
@Entity
@Table(name="service_provider_service_matching_t")
@NamedQuery(name="ServiceProviderServiceMatchingModel.findAll", query="SELECT u FROM ServiceProviderServiceMatchingModel u")
public class ServiceProviderServiceMatchingModel implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The service provider matching id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="service_provider_service_matching_id")
	private int serviceProviderMatchingId;
	
	/** The service type model. */
	@ManyToOne
	@JoinColumn(name="service_type_id")
	private ServiceTypeModel serviceTypeModel;
	
	/** The service provider model. */
	@ManyToOne
	@JoinColumn(name="service_provider_id")
	private ServiceProviderModel serviceProviderModel;

	/**
	 * Gets the service provider matching id.
	 *
	 * @return the service provider matching id
	 */
	public int getServiceProviderMatchingId() {
		return serviceProviderMatchingId;
	}

	/**
	 * Sets the service provider matching id.
	 *
	 * @param serviceProviderMatchingId the new service provider matching id
	 */
	public void setServiceProviderMatchingId(int serviceProviderMatchingId) {
		this.serviceProviderMatchingId = serviceProviderMatchingId;
	}

	/**
	 * Gets the service type model.
	 *
	 * @return the service type model
	 */
	public ServiceTypeModel getServiceTypeModel() {
		return serviceTypeModel;
	}

	/**
	 * Sets the service type model.
	 *
	 * @param serviceTypeModel the new service type model
	 */
	public void setServiceTypeModel(ServiceTypeModel serviceTypeModel) {
		this.serviceTypeModel = serviceTypeModel;
	}

	/**
	 * Gets the service provider model.
	 *
	 * @return the service provider model
	 */
	public ServiceProviderModel getServiceProviderModel() {
		return serviceProviderModel;
	}

	/**
	 * Sets the service provider model.
	 *
	 * @param serviceProviderModel the new service provider model
	 */
	public void setServiceProviderModel(ServiceProviderModel serviceProviderModel) {
		this.serviceProviderModel = serviceProviderModel;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ServiceProviderServiceMatchingModel [ serviceProviderMatchingId=" + serviceProviderMatchingId + ", serviceTypeModel=" + serviceTypeModel
				 + ", serviceProviderModel="
				+ serviceProviderModel  + "]" + super.toString();
	}

}
