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

/**
 * The Class VehicleServiceTypeModel.
 */
@Entity
@Table(name="vehicle_service_type_t")
@NamedQuery(name="VehicleServiceTypeModel.findAll", query="SELECT u FROM VehicleServiceTypeModel u")
public class VehicleServiceTypeModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/** The vehicle service type id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vehicle_service_type_id")
	private int vehicleServiceTypeID;
	
	/** The vehicle service type name. */
	@Column(name="vehicle_service_type_name")
	private String vehicleServiceTypeName;
	
	/**
	 * Gets the vehicle service type id.
	 *
	 * @return the vehicle service type id
	 */
	public int getVehicleServiceTypeID() {
		return vehicleServiceTypeID;
	}

	/**
	 * Sets the vehicle service type id.
	 *
	 * @param vehicleServiceTypeID the new vehicle service type id
	 */
	public void setVehicleServiceTypeID(int vehicleServiceTypeID) {
		this.vehicleServiceTypeID = vehicleServiceTypeID;
	}

	/**
	 * Gets the vehicle service type name.
	 *
	 * @return the vehicle service type name
	 */
	public String getVehicleServiceTypeName() {
		return vehicleServiceTypeName;
	}

	/**
	 * Sets the vehicle service type name.
	 *
	 * @param vehicleServiceTypeName the new vehicle service type name
	 */
	public void setVehicleServiceTypeName(String vehicleServiceTypeName) {
		this.vehicleServiceTypeName = vehicleServiceTypeName;
	}

	/*@OneToMany(mappedBy = "VehicleServiceTypeModel", fetch = FetchType.LAZY)
	private List<CustomerServiceRequestModel> customerServiceRequestModel;

	public List<CustomerServiceRequestModel> getCustomerServiceRequestModel() {
		return customerServiceRequestModel;
	}

	public void setCustomerServiceRequestModel(List<CustomerServiceRequestModel> customerServiceRequestModel) {
		this.customerServiceRequestModel = customerServiceRequestModel;
	}
	
	public CustomerServiceRequestModel addCustomerServiceRequestModel(CustomerServiceRequestModel customerServiceRequestModel) {
		getCustomerServiceRequestModel().add(customerServiceRequestModel);
		customerServiceRequestModel.setVehicleServiceTypeModel(this);
		return customerServiceRequestModel;
	}

	public CustomerServiceRequestModel removeCustomerServiceRequestModel(CustomerServiceRequestModel customerServiceRequestModel) {
		getCustomerServiceRequestModel().remove(customerServiceRequestModel);
		customerServiceRequestModel.setVehicleServiceTypeModel(null);
		return customerServiceRequestModel;
	}*/
	
}
