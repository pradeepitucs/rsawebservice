/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author Gururaj A M
 * @version 1.0
 * 
 *          The Class ServiceProviderDTO.
 */
@XmlRootElement(name = "service_provider", namespace = "com.ucs.rsa.dto")
public class ServiceProviderDTO
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The service provider name. */
	private String serviceProviderName;

	/** The service provider website. */
	private String serviceProviderWebsite;

	/** The service providertiming. */
	private String serviceProvidertiming;

	/** The is enabled. */
	private boolean isEnabled;

	/** The serviceprovider experties. */
	private String serviceproviderExperties;

	/** The service providerother services. */
	private String serviceProviderotherServices;

	/** The service provider comments. */
	private String serviceProviderComments;

	/** The service provider city. */
	private String serviceProviderCity;

	/** The service provider night operation. */
	private boolean serviceProviderNightOperation;

	/** The service provider premium. */
	private String serviceProviderPremium;

	/** The service provider latitude. */
	private double serviceProviderLatitude;

	/** The service provider longitude. */
	private double serviceProviderLongitude;

	/** The service provider max distance to operate. */
	private int serviceProviderMaxDistanceToOperate;

	/** The image folder name. */
	private String imageFolderName;

	/** The rating. */
	private double rating;

	/** The service provider timestamp. */
	private Timestamp serviceProviderTimestamp;

	/** The four wheeler. */
	private boolean fourWheeler;

	/** The two wheeler. */
	private boolean twoWheeler;

	/** The older service provider id. */
	private int olderServiceProviderId;

	/** The electrical type. */
	private boolean electricalType;

	/** The mechanical type. */
	private boolean mechanicalType;

	/** The body repair. */
	private boolean bodyRepair;

	/** The mobile no. */
	private long mobileNo;

	/** The user id. */
	private int userId;

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
	 * @return true, if is four wheeler
	 */
	public boolean isFourWheeler()
	{
		return fourWheeler;
	}

	/**
	 * Sets the four wheeler.
	 *
	 * @param fourWheeler
	 *           the new four wheeler
	 */
	public void setFourWheeler(boolean fourWheeler)
	{
		this.fourWheeler = fourWheeler;
	}

	/**
	 * Checks if is two wheeler.
	 *
	 * @return true, if is two wheeler
	 */
	public boolean isTwoWheeler()
	{
		return twoWheeler;
	}

	/**
	 * Sets the two wheeler.
	 *
	 * @param twoWheeler
	 *           the new two wheeler
	 */
	public void setTwoWheeler(boolean twoWheeler)
	{
		this.twoWheeler = twoWheeler;
	}

	/**
	 * Gets the older service provider id.
	 *
	 * @return the older service provider id
	 */
	public int getOlderServiceProviderId()
	{
		return olderServiceProviderId;
	}

	/**
	 * Sets the older service provider id.
	 *
	 * @param olderServiceProviderId
	 *           the new older service provider id
	 */
	public void setOlderServiceProviderId(int olderServiceProviderId)
	{
		this.olderServiceProviderId = olderServiceProviderId;
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
				+ ", serviceProviderWebsite=" + serviceProviderWebsite + ", twoWheeler=" + twoWheeler + ", bodyRepair =" + bodyRepair
				+ ", serviceProviderNightOperation =" + serviceProviderNightOperation + ", electricalType =" + electricalType
				+ ", mechanicalType =" + mechanicalType + ", isEnabled =" + isEnabled + "]" + super.toString();
	}

	/**
	 * Gets the mobile no.
	 *
	 * @return the mobile no
	 */
	public long getMobileNo()
	{
		return mobileNo;
	}

	/**
	 * Sets the mobile no.
	 *
	 * @param mobileNo
	 *           the new mobile no
	 */
	public void setMobileNo(long mobileNo)
	{
		this.mobileNo = mobileNo;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public int getUserId()
	{
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId
	 *           the new user id
	 */
	public void setUserId(int userId)
	{
		this.userId = userId;
	}

}
