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

	@Column(name = "non_member_price")
	private String nonMemberPrice;
	
	@Column(name = "member_price")
	private String memberPrice;

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

	@OneToMany(mappedBy = "serviceTypeModel", fetch = FetchType.LAZY)
	private List<CustomerSubIssueModel> customerSubIssueModel;
	
	public List<CustomerSubIssueModel> getCustomerSubIssueModel() {
		return customerSubIssueModel;
	}

	public void setCustomerSubIssueModel(List<CustomerSubIssueModel> customerSubIssueModel) {
		this.customerSubIssueModel = customerSubIssueModel;
	}
	
	@OneToMany(mappedBy = "serviceTypeModel", fetch = FetchType.LAZY)
	private List<ServiceProviderServiceMatchingModel> serviceProviderServiceMatchingModel;
	
	@OneToMany(mappedBy = "serviceTypeModel", fetch = FetchType.LAZY)
	private List<ServiceProviderModel> serviceProviderModel;

	public List<ServiceProviderModel> getServiceProviderModel() {
		return serviceProviderModel;
	}

	public void setServiceProviderModel(List<ServiceProviderModel> serviceProviderModel) {
		this.serviceProviderModel = serviceProviderModel;
	}

	public List<ServiceProviderServiceMatchingModel> getServiceProviderServiceMatchingModel() {
		return serviceProviderServiceMatchingModel;
	}

	public void setServiceProviderServiceMatchingModel(
			List<ServiceProviderServiceMatchingModel> serviceProviderServiceMatchingModel) {
		this.serviceProviderServiceMatchingModel = serviceProviderServiceMatchingModel;
	}

	public CustomerSubIssueModel addUpdateCustomerIssueModel(CustomerSubIssueModel customerSubIssueModel) {
		getCustomerSubIssueModel().add(customerSubIssueModel);
		customerSubIssueModel.setServiceTypeModel(this);
		return customerSubIssueModel;
	}

	public CustomerSubIssueModel removeCustomerReviewModel(CustomerSubIssueModel customerSubIssueModel) {
		getCustomerSubIssueModel().remove(customerSubIssueModel);
		customerSubIssueModel.setServiceTypeModel(null);
		return customerSubIssueModel;
	}
	
	public ServiceProviderModel addUpdateCustomerIssueModel(ServiceProviderModel serviceProviderModel) {
		getServiceProviderModel().add(serviceProviderModel);
		serviceProviderModel.setServiceTypeModel(this);
		return serviceProviderModel;
	}

	public ServiceProviderModel removeCustomerReviewModel(ServiceProviderModel serviceProviderModel) {
		getServiceProviderModel().remove(serviceProviderModel);
		serviceProviderModel.setServiceTypeModel(null);
		return serviceProviderModel;
	}
	
	public ServiceProviderServiceMatchingModel addUpdateCustomerIssueModel(ServiceProviderServiceMatchingModel serviceProviderServiceMatchingModel) {
		getServiceProviderServiceMatchingModel().add(serviceProviderServiceMatchingModel);
		serviceProviderServiceMatchingModel.setServiceTypeModel(this);
		return serviceProviderServiceMatchingModel;
	}

	public ServiceProviderServiceMatchingModel removeCustomerReviewModel(ServiceProviderServiceMatchingModel serviceProviderServiceMatchingModel) {
		getServiceProviderServiceMatchingModel().remove(serviceProviderServiceMatchingModel);
		serviceProviderServiceMatchingModel.setServiceTypeModel(null);
		return serviceProviderServiceMatchingModel;
	}

	@Override
	public String toString() {
		return "ServiceTypeModel [serviceTypeId=" + serviceTypeId
				+ ",serviceType=" + serviceType + ",nonMemberPrice="
				+ nonMemberPrice  + ",memberPrice="
						+ memberPrice + "]";
	}

}
