package com.ucs.rsa.common.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "service_provider", namespace = "com.ucs.rsa.dto")
public class ServiceProviderDTO extends UserDTO {
	
	private static final long serialVersionUID = 1L;

	private String serviceProviderName;

	private String serviceProviderWebsite;

	private String serviceProvidertiming;

	private boolean isEnabled;

	private String serviceproviderExperties;

	private String serviceProviderotherServices;

	private String serviceProviderComments;

	private String serviceProviderCity;

	private boolean serviceProviderNightOperation;

	private String serviceProviderPremium;

	private double serviceProviderLatitude;

	private double serviceProviderLongitude;

	private int serviceProviderMaxDistanceToOperate;

	private String imageFolderName;

	private double rating;

	private int vehicleTypeId;

	private boolean electricalType;

	private boolean mechanicalType;

	private boolean bodyRepair;

	public String getServiceProviderName() {
		return serviceProviderName;
	}

	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getImageFolderName() {
		return imageFolderName;
	}

	public void setImageFolderName(String imageFolderName) {
		this.imageFolderName = imageFolderName;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getVehicleTypeId() {
		return vehicleTypeId;
	}

	public void setVehicleTypeId(int vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}

	public boolean isElectricalType() {
		return electricalType;
	}

	public void setElectricalType(boolean electricalType) {
		this.electricalType = electricalType;
	}

	public boolean isMechanicalType() {
		return mechanicalType;
	}

	public void setMechanicalType(boolean mechanicalType) {
		this.mechanicalType = mechanicalType;
	}

	public boolean isBodyRepair() {
		return bodyRepair;
	}

	public void setBodyRepair(boolean bodyRepair) {
		this.bodyRepair = bodyRepair;
	}

	public String getServiceProviderWebsite() {
		return serviceProviderWebsite;
	}

	public void setServiceProviderWebsite(String serviceProviderWebsite) {
		this.serviceProviderWebsite = serviceProviderWebsite;
	}

	public String getServiceProvidertiming() {
		return serviceProvidertiming;
	}

	public void setServiceProvidertiming(String serviceProvidertiming) {
		this.serviceProvidertiming = serviceProvidertiming;
	}

	public String getServiceproviderExperties() {
		return serviceproviderExperties;
	}

	public void setServiceproviderExperties(String serviceproviderExperties) {
		this.serviceproviderExperties = serviceproviderExperties;
	}

	public String getServiceProviderotherServices() {
		return serviceProviderotherServices;
	}

	public void setServiceProviderotherServices(String serviceProviderotherServices) {
		this.serviceProviderotherServices = serviceProviderotherServices;
	}

	public String getServiceProviderComments() {
		return serviceProviderComments;
	}

	public void setServiceProviderComments(String serviceProviderComments) {
		this.serviceProviderComments = serviceProviderComments;
	}

	public String getServiceProviderCity() {
		return serviceProviderCity;
	}

	public void setServiceProviderCity(String serviceProviderCity) {
		this.serviceProviderCity = serviceProviderCity;
	}

	public boolean isServiceProviderNightOperation() {
		return serviceProviderNightOperation;
	}

	public void setServiceProviderNightOperation(boolean serviceProviderNightOperation) {
		this.serviceProviderNightOperation = serviceProviderNightOperation;
	}

	public String getServiceProviderPremium() {
		return serviceProviderPremium;
	}

	public void setServiceProviderPremium(String serviceProviderPremium) {
		this.serviceProviderPremium = serviceProviderPremium;
	}

	public double getServiceProviderLatitude() {
		return serviceProviderLatitude;
	}

	public void setServiceProviderLatitude(double serviceProviderLatitude) {
		this.serviceProviderLatitude = serviceProviderLatitude;
	}

	public double getServiceProviderLongitude() {
		return serviceProviderLongitude;
	}

	public void setServiceProviderLongitude(double serviceProviderLongitude) {
		this.serviceProviderLongitude = serviceProviderLongitude;
	}

	public int getServiceProviderMaxDistanceToOperate() {
		return serviceProviderMaxDistanceToOperate;
	}

	public void setServiceProviderMaxDistanceToOperate(int serviceProviderMaxDistanceToOperate) {
		this.serviceProviderMaxDistanceToOperate = serviceProviderMaxDistanceToOperate;
	}

	@Override
	public String toString() {
		return "ServiceProvider [ serviceProviderName="
				+ serviceProviderName + ", imageFolderName=" + imageFolderName + ", rating=" + rating
				+ ", serviceProviderCity=" + serviceProviderCity + ", serviceProviderComments ="
				+ serviceProviderComments + ", serviceproviderExperties=" + serviceproviderExperties
				+ ", serviceProviderLatitude=" + serviceProviderLatitude + ", serviceProviderLongitude="
				+ serviceProviderLongitude + ", serviceProviderMaxDistanceToOperate="
				+ serviceProviderMaxDistanceToOperate + ", serviceProviderotherServices ="
				+ serviceProviderotherServices + ", serviceProviderPremium=" + serviceProviderPremium
				+ ", serviceProvidertiming=" + serviceProvidertiming + ", serviceProviderWebsite="
				+ serviceProviderWebsite + ", vehicleTypeId=" + vehicleTypeId + ", bodyRepair =" + bodyRepair
				+ ", serviceProviderNightOperation =" + serviceProviderNightOperation + ", electricalType ="
				+ electricalType + ", mechanicalType =" + mechanicalType + ", isEnabled =" + isEnabled + "]"
				+ super.toString();
	}

}
