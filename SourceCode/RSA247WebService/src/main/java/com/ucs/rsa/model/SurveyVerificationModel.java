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
@Table(name = "verification_data_t")
@NamedQuery(name = "SurveyVerificationModel.findAll", query = "SELECT c FROM SurveyVerificationModel c")
public class SurveyVerificationModel implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "verifcation_id")
	private int verificatinId;
	
	@Column(name = "organization_other_services")
	private String organizationOtherServices;
	
	@Column(name = "organization_name")
	private String organizationName;
	
	@Column(name = "contact_person_name")
	private String contactPersonName;
	
	@Column(name = "organization_phone_number")
	private long organizationPhoneNumber;
	
	@Column(name = "organization_website")
	private String organizationWebsite;
	
	@Column(name = "contact_person_phone_number")
	private long contactpersonPhoneNumber;
	
	@Column(name = "contact_person_email_id")
	private String contactPersonEmailId;
	
	@Column(name = "org_timing")
	private String orgTiming;
	
	@Column(name = "night_operation")
	private boolean nightOperation;
	
	@Column(name = "org_comment")
	private String orgComment;
	
	@Column(name = "service_provider_image_folder_name")
	private String serviceProviderimageFolderName;
	
	@Column(name = "org_experties")
	private String orgExperties;
	
	@Column(name = "org_city")
	private String orgCity;
	
	@Column(name = "time_stamp")
	private Timestamp insertTimeStamp;
	
	@Column(name = "org_location_latitude")
	private double orgLocationLatitude;
	
	@Column(name = "org_location_longitude")
	private double orgLocationLongitude;

	public long getOrganizationPhoneNumber() {
		return organizationPhoneNumber;
	}

	public void setOrganizationPhoneNumber(long organizationPhoneNumber) {
		this.organizationPhoneNumber = organizationPhoneNumber;
	}

	public long getContactpersonPhoneNumber() {
		return contactpersonPhoneNumber;
	}

	public void setContactpersonPhoneNumber(long contactpersonPhoneNumber) {
		this.contactpersonPhoneNumber = contactpersonPhoneNumber;
	}

	public int getVerificatinId() {
		return verificatinId;
	}

	public void setVerificatinId(int verificatinId) {
		this.verificatinId = verificatinId;
	}

	public String getOrganizationOtherServices() {
		return organizationOtherServices;
	}

	public void setOrganizationOtherServices(String organizationOtherServices) {
		this.organizationOtherServices = organizationOtherServices;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getOrganizationWebsite() {
		return organizationWebsite;
	}

	public void setOrganizationWebsite(String organizationWebsite) {
		this.organizationWebsite = organizationWebsite;
	}

	public String getContactPersonEmailId() {
		return contactPersonEmailId;
	}

	public void setContactPersonEmailId(String contactPersonEmailId) {
		this.contactPersonEmailId = contactPersonEmailId;
	}

	public String getOrgTiming() {
		return orgTiming;
	}

	public void setOrgTiming(String orgTiming) {
		this.orgTiming = orgTiming;
	}

	public boolean isNightOperation() {
		return nightOperation;
	}

	public void setNightOperation(boolean nightOperation) {
		this.nightOperation = nightOperation;
	}

	public String getOrgComment() {
		return orgComment;
	}

	public void setOrgComment(String orgComment) {
		this.orgComment = orgComment;
	}

	public String getServiceProviderimageFolderName() {
		return serviceProviderimageFolderName;
	}

	public void setServiceProviderimageFolderName(String serviceProviderimageFolderName) {
		this.serviceProviderimageFolderName = serviceProviderimageFolderName;
	}

	public String getOrgExperties() {
		return orgExperties;
	}

	public void setOrgExperties(String orgExperties) {
		this.orgExperties = orgExperties;
	}

	public String getOrgCity() {
		return orgCity;
	}

	public void setOrgCity(String orgCity) {
		this.orgCity = orgCity;
	}

	public Timestamp getInsertTimeStamp() {
		return insertTimeStamp;
	}

	public void setInsertTimeStamp(Timestamp insertTimeStamp) {
		this.insertTimeStamp = insertTimeStamp;
	}

	public double getOrgLocationLatitude() {
		return orgLocationLatitude;
	}

	public void setOrgLocationLatitude(double orgLocationLatitude) {
		this.orgLocationLatitude = orgLocationLatitude;
	}

	public double getOrgLocationLongitude() {
		return orgLocationLongitude;
	}

	public void setOrgLocationLongitude(double orgLocationLongitude) {
		this.orgLocationLongitude = orgLocationLongitude;
	}
	
}
