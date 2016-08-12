package com.ucs.rsa.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "service_provider_t")
@NamedQuery(name = "ServiceProviderModel.findAll", query = "SELECT u FROM ServiceProviderModel u")
public class ServiceProviderModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "service_provider_name")
	private String serviceProviderName;

	@Column(name = "service_provider_website")
	private String serviceProviderWebsite;

	@Column(name = "service_provider_timing")
	private String serviceProvidertiming;

	@Column(name = "service_provider_experties")
	private String serviceproviderExperties;

	@Column(name = "service_provider_otherservices")
	private String serviceProviderotherServices;

	@Column(name = "service_provider_comments")
	private String serviceProviderComments;

	@Column(name = "service_provider_city")
	private String serviceProviderCity;

	@Column(name = "night_operation")
	private boolean serviceProviderNightOperation;

	@Column(name = "premium_service_provider")
	private String serviceProviderPremium;

	@Column(name = "service_provider_location_latitude")
	private double serviceProviderLatitude;

	@Column(name = "service_provider_location_longitude")
	private double serviceProviderLongitude;

	@Column(name = "max_distance_to_operate")
	private int serviceProviderMaxDistanceToOperate;

	@Column(name = "service_provider_image_folder_name")
	private String imageFolderName;

	@Column(name = "service_provider_rating")
	private double rating;

	@Column(name = "electrical_type")
	private boolean electricalType;

	@Column(name = "mechanical_type")
	private boolean mechanicalType;

	@Column(name = "body_repair")
	private boolean bodyRepair;

	@Column(name = "service_provider_timestamp")
	private Timestamp serviceProviderTimestamp;

	@Column(name = "four_wheeler")
	private Boolean fourWheeler;

	@Column(name = "two_wheeler")
	private Boolean twoWheeler;

	@Column(name = "older_service_provider_id")
	private Integer olderServiceProviderId;

	@Column(name = "is_enabled")
	private boolean isEnabled;

	@Column(name = "service_provider_phone_number")
	private long serviceProviderPhoneNumber;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_provider_id", unique = true, insertable = true, updatable = false)
	private int serviceProviderId;

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public long getServiceProviderPhoneNumber() {
		return serviceProviderPhoneNumber;
	}

	public void setServiceProviderPhoneNumber(long serviceProviderPhoneNumber) {
		this.serviceProviderPhoneNumber = serviceProviderPhoneNumber;
	}

	public int getServiceProviderId() {
		return serviceProviderId;
	}

	public void setServiceProviderId(int serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}

	public Boolean getFourWheeler() {
		return fourWheeler;
	}

	public Boolean getTwoWheeler() {
		return twoWheeler;
	}

	public Integer getOlderServiceProviderId() {
		return olderServiceProviderId;
	}

	public void setOlderServiceProviderId(Integer olderServiceProviderId) {
		this.olderServiceProviderId = olderServiceProviderId;
	}

	public Timestamp getServiceProviderTimestamp() {
		return serviceProviderTimestamp;
	}

	public void setServiceProviderTimestamp(Timestamp serviceProviderTimestamp) {
		this.serviceProviderTimestamp = serviceProviderTimestamp;
	}

	public Boolean isFourWheeler() {
		return fourWheeler;
	}

	public void setFourWheeler(Boolean fourWheeler) {
		this.fourWheeler = fourWheeler;
	}

	public Boolean isTwoWheeler() {
		return twoWheeler;
	}

	public void setTwoWheeler(Boolean twoWheeler) {
		this.twoWheeler = twoWheeler;
	}

	public ServiceProviderModel() {
	}

	public String getServiceProviderName() {
		return serviceProviderName;
	}

	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
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
		return "ServiceProvider [ serviceProviderName=" + serviceProviderName + ", imageFolderName=" + imageFolderName
				+ ", rating=" + rating + ", serviceProviderCity=" + serviceProviderCity + ", serviceProviderComments ="
				+ serviceProviderComments + ", serviceproviderExperties=" + serviceproviderExperties
				+ ", serviceProviderLatitude=" + serviceProviderLatitude + ", serviceProviderLongitude="
				+ serviceProviderLongitude + ", serviceProviderMaxDistanceToOperate="
				+ serviceProviderMaxDistanceToOperate + ", serviceProviderotherServices ="
				+ serviceProviderotherServices + ", serviceProviderPremium=" + serviceProviderPremium
				+ ", serviceProvidertiming=" + serviceProvidertiming + ", serviceProviderWebsite="
				+ serviceProviderWebsite + ", bodyRepair =" + bodyRepair + ", serviceProviderNightOperation ="
				+ serviceProviderNightOperation + ", electricalType =" + electricalType + ", mechanicalType ="
				+ mechanicalType + ", twoWheeler =" + twoWheeler + ", fourWheeler =" + fourWheeler
				+ ", olderServiceProviderId =" + olderServiceProviderId + ", serviceProviderTimestamp ="
				+ serviceProviderTimestamp + ", serviceProviderId =" + serviceProviderId
				+ ", isEnabled =" + isEnabled + ", serviceProviderPhoneNumber ="
				+ serviceProviderPhoneNumber + "]" + super.toString();
	}
}
