/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
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

// TODO: Auto-generated Javadoc
/**
 * The Class SurveyVerificationModel.
 */
@Entity
@Table(name = "verification_data_t")
@NamedQuery(name = "SurveyVerificationModel.findAll", query = "SELECT c FROM SurveyVerificationModel c")
public class SurveyVerificationModel implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The verificatin id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "verifcation_id")
	private int verificatinId;
	
	/** The organization other services. */
	@Column(name = "organization_other_services")
	private String organizationOtherServices;
	
	/** The organization name. */
	@Column(name = "organization_name")
	private String organizationName;
	
	/** The contact person name. */
	@Column(name = "contact_person_name")
	private String contactPersonName;
	
	/** The organization phone number. */
	@Column(name = "organization_phone_number")
	private long organizationPhoneNumber;
	
	/** The organization website. */
	@Column(name = "organization_website")
	private String organizationWebsite;
	
	/** The contactperson phone number. */
	@Column(name = "contact_person_phone_number")
	private long contactpersonPhoneNumber;
	
	/** The contact person email id. */
	@Column(name = "contact_person_email_id")
	private String contactPersonEmailId;
	
	/** The org timing. */
	@Column(name = "org_timing")
	private String orgTiming;
	
	/** The night operation. */
	@Column(name = "night_operation")
	private boolean nightOperation;
	
	/** The org comment. */
	@Column(name = "org_comment")
	private String orgComment;
	
	/** The service providerimage folder name. */
	@Column(name = "service_provider_image_folder_name")
	private String serviceProviderimageFolderName;
	
	/** The org experties. */
	@Column(name = "org_experties")
	private String orgExperties;
	
	/** The org city. */
	@Column(name = "org_city")
	private String orgCity;
	
	/** The insert time stamp. */
	@Column(name = "time_stamp")
	private Timestamp insertTimeStamp;
	
	/** The org location latitude. */
	@Column(name = "org_location_latitude")
	private double orgLocationLatitude;
	
	/** The org location longitude. */
	@Column(name = "org_location_longitude")
	private double orgLocationLongitude;

	/**
	 * Gets the organization phone number.
	 *
	 * @return the organization phone number
	 */
	public long getOrganizationPhoneNumber() {
		return organizationPhoneNumber;
	}

	/**
	 * Sets the organization phone number.
	 *
	 * @param organizationPhoneNumber the new organization phone number
	 */
	public void setOrganizationPhoneNumber(long organizationPhoneNumber) {
		this.organizationPhoneNumber = organizationPhoneNumber;
	}

	/**
	 * Gets the contactperson phone number.
	 *
	 * @return the contactperson phone number
	 */
	public long getContactpersonPhoneNumber() {
		return contactpersonPhoneNumber;
	}

	/**
	 * Sets the contactperson phone number.
	 *
	 * @param contactpersonPhoneNumber the new contactperson phone number
	 */
	public void setContactpersonPhoneNumber(long contactpersonPhoneNumber) {
		this.contactpersonPhoneNumber = contactpersonPhoneNumber;
	}

	/**
	 * Gets the verificatin id.
	 *
	 * @return the verificatin id
	 */
	public int getVerificatinId() {
		return verificatinId;
	}

	/**
	 * Sets the verificatin id.
	 *
	 * @param verificatinId the new verificatin id
	 */
	public void setVerificatinId(int verificatinId) {
		this.verificatinId = verificatinId;
	}

	/**
	 * Gets the organization other services.
	 *
	 * @return the organization other services
	 */
	public String getOrganizationOtherServices() {
		return organizationOtherServices;
	}

	/**
	 * Sets the organization other services.
	 *
	 * @param organizationOtherServices the new organization other services
	 */
	public void setOrganizationOtherServices(String organizationOtherServices) {
		this.organizationOtherServices = organizationOtherServices;
	}

	/**
	 * Gets the organization name.
	 *
	 * @return the organization name
	 */
	public String getOrganizationName() {
		return organizationName;
	}

	/**
	 * Sets the organization name.
	 *
	 * @param organizationName the new organization name
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	/**
	 * Gets the contact person name.
	 *
	 * @return the contact person name
	 */
	public String getContactPersonName() {
		return contactPersonName;
	}

	/**
	 * Sets the contact person name.
	 *
	 * @param contactPersonName the new contact person name
	 */
	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	/**
	 * Gets the organization website.
	 *
	 * @return the organization website
	 */
	public String getOrganizationWebsite() {
		return organizationWebsite;
	}

	/**
	 * Sets the organization website.
	 *
	 * @param organizationWebsite the new organization website
	 */
	public void setOrganizationWebsite(String organizationWebsite) {
		this.organizationWebsite = organizationWebsite;
	}

	/**
	 * Gets the contact person email id.
	 *
	 * @return the contact person email id
	 */
	public String getContactPersonEmailId() {
		return contactPersonEmailId;
	}

	/**
	 * Sets the contact person email id.
	 *
	 * @param contactPersonEmailId the new contact person email id
	 */
	public void setContactPersonEmailId(String contactPersonEmailId) {
		this.contactPersonEmailId = contactPersonEmailId;
	}

	/**
	 * Gets the org timing.
	 *
	 * @return the org timing
	 */
	public String getOrgTiming() {
		return orgTiming;
	}

	/**
	 * Sets the org timing.
	 *
	 * @param orgTiming the new org timing
	 */
	public void setOrgTiming(String orgTiming) {
		this.orgTiming = orgTiming;
	}

	/**
	 * Checks if is night operation.
	 *
	 * @return true, if is night operation
	 */
	public boolean isNightOperation() {
		return nightOperation;
	}

	/**
	 * Sets the night operation.
	 *
	 * @param nightOperation the new night operation
	 */
	public void setNightOperation(boolean nightOperation) {
		this.nightOperation = nightOperation;
	}

	/**
	 * Gets the org comment.
	 *
	 * @return the org comment
	 */
	public String getOrgComment() {
		return orgComment;
	}

	/**
	 * Sets the org comment.
	 *
	 * @param orgComment the new org comment
	 */
	public void setOrgComment(String orgComment) {
		this.orgComment = orgComment;
	}

	/**
	 * Gets the service providerimage folder name.
	 *
	 * @return the service providerimage folder name
	 */
	public String getServiceProviderimageFolderName() {
		return serviceProviderimageFolderName;
	}

	/**
	 * Sets the service providerimage folder name.
	 *
	 * @param serviceProviderimageFolderName the new service providerimage folder name
	 */
	public void setServiceProviderimageFolderName(String serviceProviderimageFolderName) {
		this.serviceProviderimageFolderName = serviceProviderimageFolderName;
	}

	/**
	 * Gets the org experties.
	 *
	 * @return the org experties
	 */
	public String getOrgExperties() {
		return orgExperties;
	}

	/**
	 * Sets the org experties.
	 *
	 * @param orgExperties the new org experties
	 */
	public void setOrgExperties(String orgExperties) {
		this.orgExperties = orgExperties;
	}

	/**
	 * Gets the org city.
	 *
	 * @return the org city
	 */
	public String getOrgCity() {
		return orgCity;
	}

	/**
	 * Sets the org city.
	 *
	 * @param orgCity the new org city
	 */
	public void setOrgCity(String orgCity) {
		this.orgCity = orgCity;
	}

	/**
	 * Gets the insert time stamp.
	 *
	 * @return the insert time stamp
	 */
	public Timestamp getInsertTimeStamp() {
		return insertTimeStamp;
	}

	/**
	 * Sets the insert time stamp.
	 *
	 * @param insertTimeStamp the new insert time stamp
	 */
	public void setInsertTimeStamp(Timestamp insertTimeStamp) {
		this.insertTimeStamp = insertTimeStamp;
	}

	/**
	 * Gets the org location latitude.
	 *
	 * @return the org location latitude
	 */
	public double getOrgLocationLatitude() {
		return orgLocationLatitude;
	}

	/**
	 * Sets the org location latitude.
	 *
	 * @param orgLocationLatitude the new org location latitude
	 */
	public void setOrgLocationLatitude(double orgLocationLatitude) {
		this.orgLocationLatitude = orgLocationLatitude;
	}

	/**
	 * Gets the org location longitude.
	 *
	 * @return the org location longitude
	 */
	public double getOrgLocationLongitude() {
		return orgLocationLongitude;
	}

	/**
	 * Sets the org location longitude.
	 *
	 * @param orgLocationLongitude the new org location longitude
	 */
	public void setOrgLocationLongitude(double orgLocationLongitude) {
		this.orgLocationLongitude = orgLocationLongitude;
	}
	
}
