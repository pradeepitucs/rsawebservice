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


/**
 * The Class ServiceProviderModel.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@Entity
@Table(name = "service_provider_t")
@NamedQuery(name = "ServiceProviderModel.findAll", query = "SELECT u FROM ServiceProviderModel u")
public class ServiceProviderModel implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The service provider name. */
	@Column(name = "service_provider_name")
	private String serviceProviderName;

	/** The service provider website. */
	@Column(name = "service_provider_website")
	private String serviceProviderWebsite;

	/** The service providertiming. */
	@Column(name = "service_provider_timing")
	private String serviceProvidertiming;

	/** The serviceprovider experties. */
	@Column(name = "service_provider_experties")
	private String serviceproviderExperties;

	/** The service providerother services. */
	@Column(name = "service_provider_otherservices")
	private String serviceProviderotherServices;

	/** The service provider comments. */
	@Column(name = "service_provider_comments")
	private String serviceProviderComments;

	/** The service provider city. */
	@Column(name = "service_provider_city")
	private String serviceProviderCity;

	/** The service provider night operation. */
	@Column(name = "night_operation")
	private boolean serviceProviderNightOperation;

	/** The service provider premium. */
	@Column(name = "premium_service_provider")
	private String serviceProviderPremium;

	/** The service provider latitude. */
	@Column(name = "service_provider_location_latitude")
	private double serviceProviderLatitude;

	/** The service provider longitude. */
	@Column(name = "service_provider_location_longitude")
	private double serviceProviderLongitude;

	/** The service provider max distance to operate. */
	@Column(name = "max_distance_to_operate")
	private int serviceProviderMaxDistanceToOperate;

	/** The image folder name. */
	@Column(name = "service_provider_image_folder_name")
	private String imageFolderName;

	/** The rating. */
	@Column(name = "service_provider_rating")
	private double rating;

	/** The electrical type. */
	@Column(name = "electrical_type")
	private boolean electricalType;

	/** The mechanical type. */
	@Column(name = "mechanical_type")
	private boolean mechanicalType;

	/** The body repair. */
	@Column(name = "body_repair")
	private boolean bodyRepair;

	/** The service provider timestamp. */
	@Column(name = "service_provider_timestamp")
	private Timestamp serviceProviderTimestamp;

	/** The four wheeler. */
	@Column(name = "four_wheeler")
	private Boolean fourWheeler;

	/** The two wheeler. */
	@Column(name = "two_wheeler")
	private Boolean twoWheeler;

	/** The older service provider id. */
	@Column(name = "older_service_provider_id")
	private Integer olderServiceProviderId;

	/** The is enabled. */
	@Column(name = "is_enabled")
	private boolean isEnabled;

	/** The service provider phone number. */
	@Column(name = "service_provider_phone_number")
	private long serviceProviderPhoneNumber;

	/** The service provider id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_provider_id", unique = true, insertable = true, updatable = false)
	private int serviceProviderId;

	/**
	 * Checks if is enabled.
	 *
	 * @return true, if is enabled
	 */
	public boolean isEnabled()
	{
		return isEnabled;
	}

	/**
	 * Sets the enabled.
	 *
	 * @param isEnabled
	 *           the new enabled
	 */
	public void setEnabled(boolean isEnabled)
	{
		this.isEnabled = isEnabled;
	}

	/**
	 * Gets the service provider phone number.
	 *
	 * @return the service provider phone number
	 */
	public long getServiceProviderPhoneNumber()
	{
		return serviceProviderPhoneNumber;
	}

	/**
	 * Sets the service provider phone number.
	 *
	 * @param serviceProviderPhoneNumber
	 *           the new service provider phone number
	 */
	public void setServiceProviderPhoneNumber(long serviceProviderPhoneNumber)
	{
		this.serviceProviderPhoneNumber = serviceProviderPhoneNumber;
	}

	/**
	 * Gets the service provider id.
	 *
	 * @return the service provider id
	 */
	public int getServiceProviderId()
	{
		return serviceProviderId;
	}

	/**
	 * Sets the service provider id.
	 *
	 * @param serviceProviderId
	 *           the new service provider id
	 */
	public void setServiceProviderId(int serviceProviderId)
	{
		this.serviceProviderId = serviceProviderId;
	}

	/**
	 * Gets the four wheeler.
	 *
	 * @return the four wheeler
	 */
	public Boolean getFourWheeler()
	{
		return fourWheeler;
	}

	/**
	 * Gets the two wheeler.
	 *
	 * @return the two wheeler
	 */
	public Boolean getTwoWheeler()
	{
		return twoWheeler;
	}

	/**
	 * Gets the older service provider id.
	 *
	 * @return the older service provider id
	 */
	public Integer getOlderServiceProviderId()
	{
		return olderServiceProviderId;
	}

	/**
	 * Sets the older service provider id.
	 *
	 * @param olderServiceProviderId
	 *           the new older service provider id
	 */
	public void setOlderServiceProviderId(Integer olderServiceProviderId)
	{
		this.olderServiceProviderId = olderServiceProviderId;
	}

	/**
	 * Gets the service provider timestamp.
	 *
	 * @return the service provider timestamp
	 */
	public Timestamp getServiceProviderTimestamp()
	{
		return serviceProviderTimestamp;
	}

	/**
	 * Sets the service provider timestamp.
	 *
	 * @param serviceProviderTimestamp
	 *           the new service provider timestamp
	 */
	public void setServiceProviderTimestamp(Timestamp serviceProviderTimestamp)
	{
		this.serviceProviderTimestamp = serviceProviderTimestamp;
	}

	/**
	 * Checks if is four wheeler.
	 *
	 * @return the boolean
	 */
	public Boolean isFourWheeler()
	{
		return fourWheeler;
	}

	/**
	 * Sets the four wheeler.
	 *
	 * @param fourWheeler
	 *           the new four wheeler
	 */
	public void setFourWheeler(Boolean fourWheeler)
	{
		this.fourWheeler = fourWheeler;
	}

	/**
	 * Checks if is two wheeler.
	 *
	 * @return the boolean
	 */
	public Boolean isTwoWheeler()
	{
		return twoWheeler;
	}

	/**
	 * Sets the two wheeler.
	 *
	 * @param twoWheeler
	 *           the new two wheeler
	 */
	public void setTwoWheeler(Boolean twoWheeler)
	{
		this.twoWheeler = twoWheeler;
	}

	/**
	 * Instantiates a new service provider model.
	 */
	public ServiceProviderModel()
	{
	}

	/**
	 * Gets the service provider name.
	 *
	 * @return the service provider name
	 */
	public String getServiceProviderName()
	{
		return serviceProviderName;
	}

	/**
	 * Sets the service provider name.
	 *
	 * @param serviceProviderName
	 *           the new service provider name
	 */
	public void setServiceProviderName(String serviceProviderName)
	{
		this.serviceProviderName = serviceProviderName;
	}

	/**
	 * Gets the image folder name.
	 *
	 * @return the image folder name
	 */
	public String getImageFolderName()
	{
		return imageFolderName;
	}

	/**
	 * Sets the image folder name.
	 *
	 * @param imageFolderName
	 *           the new image folder name
	 */
	public void setImageFolderName(String imageFolderName)
	{
		this.imageFolderName = imageFolderName;
	}

	/**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public double getRating()
	{
		return rating;
	}

	/**
	 * Sets the rating.
	 *
	 * @param rating
	 *           the new rating
	 */
	public void setRating(double rating)
	{
		this.rating = rating;
	}

	/**
	 * Checks if is electrical type.
	 *
	 * @return true, if is electrical type
	 */
	public boolean isElectricalType()
	{
		return electricalType;
	}

	/**
	 * Sets the electrical type.
	 *
	 * @param electricalType
	 *           the new electrical type
	 */
	public void setElectricalType(boolean electricalType)
	{
		this.electricalType = electricalType;
	}

	/**
	 * Checks if is mechanical type.
	 *
	 * @return true, if is mechanical type
	 */
	public boolean isMechanicalType()
	{
		return mechanicalType;
	}

	/**
	 * Sets the mechanical type.
	 *
	 * @param mechanicalType
	 *           the new mechanical type
	 */
	public void setMechanicalType(boolean mechanicalType)
	{
		this.mechanicalType = mechanicalType;
	}

	/**
	 * Checks if is body repair.
	 *
	 * @return true, if is body repair
	 */
	public boolean isBodyRepair()
	{
		return bodyRepair;
	}

	/**
	 * Sets the body repair.
	 *
	 * @param bodyRepair
	 *           the new body repair
	 */
	public void setBodyRepair(boolean bodyRepair)
	{
		this.bodyRepair = bodyRepair;
	}

	/**
	 * Gets the service provider website.
	 *
	 * @return the service provider website
	 */
	public String getServiceProviderWebsite()
	{
		return serviceProviderWebsite;
	}

	/**
	 * Sets the service provider website.
	 *
	 * @param serviceProviderWebsite
	 *           the new service provider website
	 */
	public void setServiceProviderWebsite(String serviceProviderWebsite)
	{
		this.serviceProviderWebsite = serviceProviderWebsite;
	}

	/**
	 * Gets the service providertiming.
	 *
	 * @return the service providertiming
	 */
	public String getServiceProvidertiming()
	{
		return serviceProvidertiming;
	}

	/**
	 * Sets the service providertiming.
	 *
	 * @param serviceProvidertiming
	 *           the new service providertiming
	 */
	public void setServiceProvidertiming(String serviceProvidertiming)
	{
		this.serviceProvidertiming = serviceProvidertiming;
	}

	/**
	 * Gets the serviceprovider experties.
	 *
	 * @return the serviceprovider experties
	 */
	public String getServiceproviderExperties()
	{
		return serviceproviderExperties;
	}

	/**
	 * Sets the serviceprovider experties.
	 *
	 * @param serviceproviderExperties
	 *           the new serviceprovider experties
	 */
	public void setServiceproviderExperties(String serviceproviderExperties)
	{
		this.serviceproviderExperties = serviceproviderExperties;
	}

	/**
	 * Gets the service providerother services.
	 *
	 * @return the service providerother services
	 */
	public String getServiceProviderotherServices()
	{
		return serviceProviderotherServices;
	}

	/**
	 * Sets the service providerother services.
	 *
	 * @param serviceProviderotherServices
	 *           the new service providerother services
	 */
	public void setServiceProviderotherServices(String serviceProviderotherServices)
	{
		this.serviceProviderotherServices = serviceProviderotherServices;
	}

	/**
	 * Gets the service provider comments.
	 *
	 * @return the service provider comments
	 */
	public String getServiceProviderComments()
	{
		return serviceProviderComments;
	}

	/**
	 * Sets the service provider comments.
	 *
	 * @param serviceProviderComments
	 *           the new service provider comments
	 */
	public void setServiceProviderComments(String serviceProviderComments)
	{
		this.serviceProviderComments = serviceProviderComments;
	}

	/**
	 * Gets the service provider city.
	 *
	 * @return the service provider city
	 */
	public String getServiceProviderCity()
	{
		return serviceProviderCity;
	}

	/**
	 * Sets the service provider city.
	 *
	 * @param serviceProviderCity
	 *           the new service provider city
	 */
	public void setServiceProviderCity(String serviceProviderCity)
	{
		this.serviceProviderCity = serviceProviderCity;
	}

	/**
	 * Checks if is service provider night operation.
	 *
	 * @return true, if is service provider night operation
	 */
	public boolean isServiceProviderNightOperation()
	{
		return serviceProviderNightOperation;
	}

	/**
	 * Sets the service provider night operation.
	 *
	 * @param serviceProviderNightOperation
	 *           the new service provider night operation
	 */
	public void setServiceProviderNightOperation(boolean serviceProviderNightOperation)
	{
		this.serviceProviderNightOperation = serviceProviderNightOperation;
	}

	/**
	 * Gets the service provider premium.
	 *
	 * @return the service provider premium
	 */
	public String getServiceProviderPremium()
	{
		return serviceProviderPremium;
	}

	/**
	 * Sets the service provider premium.
	 *
	 * @param serviceProviderPremium
	 *           the new service provider premium
	 */
	public void setServiceProviderPremium(String serviceProviderPremium)
	{
		this.serviceProviderPremium = serviceProviderPremium;
	}

	/**
	 * Gets the service provider latitude.
	 *
	 * @return the service provider latitude
	 */
	public double getServiceProviderLatitude()
	{
		return serviceProviderLatitude;
	}

	/**
	 * Sets the service provider latitude.
	 *
	 * @param serviceProviderLatitude
	 *           the new service provider latitude
	 */
	public void setServiceProviderLatitude(double serviceProviderLatitude)
	{
		this.serviceProviderLatitude = serviceProviderLatitude;
	}

	/**
	 * Gets the service provider longitude.
	 *
	 * @return the service provider longitude
	 */
	public double getServiceProviderLongitude()
	{
		return serviceProviderLongitude;
	}

	/**
	 * Sets the service provider longitude.
	 *
	 * @param serviceProviderLongitude
	 *           the new service provider longitude
	 */
	public void setServiceProviderLongitude(double serviceProviderLongitude)
	{
		this.serviceProviderLongitude = serviceProviderLongitude;
	}

	/**
	 * Gets the service provider max distance to operate.
	 *
	 * @return the service provider max distance to operate
	 */
	public int getServiceProviderMaxDistanceToOperate()
	{
		return serviceProviderMaxDistanceToOperate;
	}

	/**
	 * Sets the service provider max distance to operate.
	 *
	 * @param serviceProviderMaxDistanceToOperate
	 *           the new service provider max distance to operate
	 */
	public void setServiceProviderMaxDistanceToOperate(int serviceProviderMaxDistanceToOperate)
	{
		this.serviceProviderMaxDistanceToOperate = serviceProviderMaxDistanceToOperate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ServiceProvider [ serviceProviderName=" + serviceProviderName + ", imageFolderName=" + imageFolderName + ", rating="
				+ rating + ", serviceProviderCity=" + serviceProviderCity + ", serviceProviderComments =" + serviceProviderComments
				+ ", serviceproviderExperties=" + serviceproviderExperties + ", serviceProviderLatitude=" + serviceProviderLatitude
				+ ", serviceProviderLongitude=" + serviceProviderLongitude + ", serviceProviderMaxDistanceToOperate="
				+ serviceProviderMaxDistanceToOperate + ", serviceProviderotherServices =" + serviceProviderotherServices
				+ ", serviceProviderPremium=" + serviceProviderPremium + ", serviceProvidertiming=" + serviceProvidertiming
				+ ", serviceProviderWebsite=" + serviceProviderWebsite + ", bodyRepair =" + bodyRepair
				+ ", serviceProviderNightOperation =" + serviceProviderNightOperation + ", electricalType =" + electricalType
				+ ", mechanicalType =" + mechanicalType + ", twoWheeler =" + twoWheeler + ", fourWheeler =" + fourWheeler
				+ ", olderServiceProviderId =" + olderServiceProviderId + ", serviceProviderTimestamp =" + serviceProviderTimestamp
				+ ", serviceProviderId =" + serviceProviderId + ", isEnabled =" + isEnabled + ", serviceProviderPhoneNumber ="
				+ serviceProviderPhoneNumber + "]" + super.toString();
	}
}
