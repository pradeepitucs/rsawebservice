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
 * The Class ServiceProviderServicePriceModel.
 */
@Entity
@Table(name="service_provider_service_price_t")
@NamedQuery(name="ServiceProviderServicePriceModel.findAll", query="SELECT u FROM ServiceProviderServicePriceModel u")
public class ServiceProviderServicePriceModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** The service provider services price id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="service_provider_service_price_id")
	private int serviceProviderServicesPriceId;
	
	/** The service provider model. */
	@ManyToOne
	@JoinColumn(name="service_provider_id")
	private ServiceProviderModel serviceProviderModel;
	
	/** The gold price. */
	@Column(name = "gold_price")
	private String goldPrice;
	
	/** The silver price. */
	@Column(name = "silver_price")
	private String silverPrice;
	
	/** The platinum price. */
	@Column(name = "platinum_price")
	private String platinumPrice;

	/**
	 * Gets the service provider services price id.
	 *
	 * @return the service provider services price id
	 */
	public int getServiceProviderServicesPriceId() {
		return serviceProviderServicesPriceId;
	}

	/**
	 * Sets the service provider services price id.
	 *
	 * @param serviceProviderServicesPriceId the new service provider services price id
	 */
	public void setServiceProviderServicesPriceId(int serviceProviderServicesPriceId) {
		this.serviceProviderServicesPriceId = serviceProviderServicesPriceId;
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

	/**
	 * Gets the gold price.
	 *
	 * @return the gold price
	 */
	public String getGoldPrice() {
		return goldPrice;
	}

	/**
	 * Sets the gold price.
	 *
	 * @param goldPrice the new gold price
	 */
	public void setGoldPrice(String goldPrice) {
		this.goldPrice = goldPrice;
	}

	/**
	 * Gets the silver price.
	 *
	 * @return the silver price
	 */
	public String getSilverPrice() {
		return silverPrice;
	}

	/**
	 * Sets the silver price.
	 *
	 * @param silverPrice the new silver price
	 */
	public void setSilverPrice(String silverPrice) {
		this.silverPrice = silverPrice;
	}

	/**
	 * Gets the platinum price.
	 *
	 * @return the platinum price
	 */
	public String getPlatinumPrice() {
		return platinumPrice;
	}

	/**
	 * Sets the platinum price.
	 *
	 * @param platinumPrice the new platinum price
	 */
	public void setPlatinumPrice(String platinumPrice) {
		this.platinumPrice = platinumPrice;
	}

}
