package com.ucs.rsa.daos;

import java.util.ArrayList;

import com.ucs.rsa.model.CustomerServiceRequestModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.ServiceProviderModel;


/**
 * The Interface CustomerServiceRequestDAO.
 */
public interface CustomerServiceRequestDAO {
	
	/**
	 * Update customer service request.
	 *
	 * @param iCustomerRequestModel the i customer request model
	 * @return the customer service request model
	 */
	public CustomerServiceRequestModel updateCustomerServiceRequest(CustomerServiceRequestModel iCustomerRequestModel);
	
	/**
	 * Gets the service providers.
	 *
	 * @param ratingArray the rating array
	 * @param serviceTypeId the service type id
	 * @return the service providers
	 */
	public ArrayList<ServiceProviderModel> getServiceProviders(ArrayList<Double> ratingArray, int serviceTypeId);

	/**
	 * Update vehicle service type.
	 *
	 * @param customerServiceRequestmodel the customer service requestmodel
	 * @return the customer service request model
	 */
	public CustomerServiceRequestModel updateVehicleServiceType(
			CustomerServiceRequestModel customerServiceRequestmodel);

	/**
	 * Gets the employees.
	 *
	 * @param serviceProviderId the service provider id
	 * @return the employees
	 */
	public ArrayList<EmployeeModel> getEmployees(int serviceProviderId);

}
