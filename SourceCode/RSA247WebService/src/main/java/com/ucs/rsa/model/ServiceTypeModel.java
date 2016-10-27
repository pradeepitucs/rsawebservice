/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceTypeModel.
 */
@Entity
@Table(name = "service_type_t")
@NamedQuery(name = "ServiceTypeModel.findAll", query = "SELECT v FROM ServiceTypeModel v")
public class ServiceTypeModel implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The service type id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_type_id")
	private int serviceTypeId;

	/** The service type. */
	@Column(name = "service_type")
	private String serviceType;

	/** The non member price. */
	@Column(name = "non_member_price")
	private String nonMemberPrice;
	
	/** The member price. */
	@Column(name = "member_price")
	private String memberPrice;

	/**
	 * Gets the service type id.
	 *
	 * @return the service type id
	 */
	public int getServiceTypeId() {
		return serviceTypeId;
	}

	/**
	 * Sets the service type id.
	 *
	 * @param serviceTypeId the new service type id
	 */
	public void setServiceTypeId(int serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

	/**
	 * Gets the service type.
	 *
	 * @return the service type
	 */
	public String getServiceType() {
		return serviceType;
	}

	/**
	 * Sets the service type.
	 *
	 * @param serviceType the new service type
	 */
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	/**
	 * Gets the non member price.
	 *
	 * @return the non member price
	 */
	public String getNonMemberPrice() {
		return nonMemberPrice;
	}

	/**
	 * Sets the non member price.
	 *
	 * @param nonMemberPrice the new non member price
	 */
	public void setNonMemberPrice(String nonMemberPrice) {
		this.nonMemberPrice = nonMemberPrice;
	}

	/**
	 * Gets the member price.
	 *
	 * @return the member price
	 */
	public String getMemberPrice() {
		return memberPrice;
	}

	/**
	 * Sets the member price.
	 *
	 * @param memberPrice the new member price
	 */
	public void setMemberPrice(String memberPrice) {
		this.memberPrice = memberPrice;
	}

	/** The customer sub issue model. */
	@OneToMany(mappedBy = "serviceTypeModel", fetch = FetchType.LAZY)
	private List<CustomerSubIssueModel> customerSubIssueModel;
	
	/**
	 * Gets the customer sub issue model.
	 *
	 * @return the customer sub issue model
	 */
	public List<CustomerSubIssueModel> getCustomerSubIssueModel() {
		return customerSubIssueModel;
	}

	/**
	 * Sets the customer sub issue model.
	 *
	 * @param customerSubIssueModel the new customer sub issue model
	 */
	public void setCustomerSubIssueModel(List<CustomerSubIssueModel> customerSubIssueModel) {
		this.customerSubIssueModel = customerSubIssueModel;
	}
	
	/** The service provider service matching model. */
	@OneToMany(mappedBy = "serviceTypeModel", fetch = FetchType.LAZY)
	private List<ServiceProviderServiceMatchingModel> serviceProviderServiceMatchingModel;
	
	/** The service provider model. */
	@OneToMany(mappedBy = "serviceTypeModel", fetch = FetchType.LAZY)
	private List<ServiceProviderModel> serviceProviderModel;

	/**
	 * Gets the service provider model.
	 *
	 * @return the service provider model
	 */
	public List<ServiceProviderModel> getServiceProviderModel() {
		return serviceProviderModel;
	}

	/**
	 * Sets the service provider model.
	 *
	 * @param serviceProviderModel the new service provider model
	 */
	public void setServiceProviderModel(List<ServiceProviderModel> serviceProviderModel) {
		this.serviceProviderModel = serviceProviderModel;
	}

	/**
	 * Gets the service provider service matching model.
	 *
	 * @return the service provider service matching model
	 */
	public List<ServiceProviderServiceMatchingModel> getServiceProviderServiceMatchingModel() {
		return serviceProviderServiceMatchingModel;
	}

	/**
	 * Sets the service provider service matching model.
	 *
	 * @param serviceProviderServiceMatchingModel the new service provider service matching model
	 */
	public void setServiceProviderServiceMatchingModel(
			List<ServiceProviderServiceMatchingModel> serviceProviderServiceMatchingModel) {
		this.serviceProviderServiceMatchingModel = serviceProviderServiceMatchingModel;
	}

	/**
	 * Adds the update customer issue model.
	 *
	 * @param customerSubIssueModel the customer sub issue model
	 * @return the customer sub issue model
	 */
	public CustomerSubIssueModel addUpdateCustomerIssueModel(CustomerSubIssueModel customerSubIssueModel) {
		getCustomerSubIssueModel().add(customerSubIssueModel);
		customerSubIssueModel.setServiceTypeModel(this);
		return customerSubIssueModel;
	}

	/**
	 * Removes the customer review model.
	 *
	 * @param customerSubIssueModel the customer sub issue model
	 * @return the customer sub issue model
	 */
	public CustomerSubIssueModel removeCustomerReviewModel(CustomerSubIssueModel customerSubIssueModel) {
		getCustomerSubIssueModel().remove(customerSubIssueModel);
		customerSubIssueModel.setServiceTypeModel(null);
		return customerSubIssueModel;
	}
	
	/**
	 * Adds the update customer issue model.
	 *
	 * @param serviceProviderModel the service provider model
	 * @return the service provider model
	 */
	public ServiceProviderModel addUpdateCustomerIssueModel(ServiceProviderModel serviceProviderModel) {
		getServiceProviderModel().add(serviceProviderModel);
		serviceProviderModel.setServiceTypeModel(this);
		return serviceProviderModel;
	}

	/**
	 * Removes the customer review model.
	 *
	 * @param serviceProviderModel the service provider model
	 * @return the service provider model
	 */
	public ServiceProviderModel removeCustomerReviewModel(ServiceProviderModel serviceProviderModel) {
		getServiceProviderModel().remove(serviceProviderModel);
		serviceProviderModel.setServiceTypeModel(null);
		return serviceProviderModel;
	}
	
	/**
	 * Adds the update customer issue model.
	 *
	 * @param serviceProviderServiceMatchingModel the service provider service matching model
	 * @return the service provider service matching model
	 */
	public ServiceProviderServiceMatchingModel addUpdateCustomerIssueModel(ServiceProviderServiceMatchingModel serviceProviderServiceMatchingModel) {
		getServiceProviderServiceMatchingModel().add(serviceProviderServiceMatchingModel);
		serviceProviderServiceMatchingModel.setServiceTypeModel(this);
		return serviceProviderServiceMatchingModel;
	}

	/**
	 * Removes the customer review model.
	 *
	 * @param serviceProviderServiceMatchingModel the service provider service matching model
	 * @return the service provider service matching model
	 */
	public ServiceProviderServiceMatchingModel removeCustomerReviewModel(ServiceProviderServiceMatchingModel serviceProviderServiceMatchingModel) {
		getServiceProviderServiceMatchingModel().remove(serviceProviderServiceMatchingModel);
		serviceProviderServiceMatchingModel.setServiceTypeModel(null);
		return serviceProviderServiceMatchingModel;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ServiceTypeModel [serviceTypeId=" + serviceTypeId
				+ ",serviceType=" + serviceType + ",nonMemberPrice="
				+ nonMemberPrice  + ",memberPrice="
						+ memberPrice + "]";
	}

}
