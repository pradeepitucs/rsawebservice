package com.ucs.rsa.daos;

import java.util.ArrayList;

import com.ucs.rsa.model.CustomerModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.ServiceProviderModel;
import com.ucs.rsa.model.ServiceProviderServiceMatchingModel;
import com.ucs.rsa.model.UserVehicleModel;

public interface UserDAO extends BaseDAO {

	public CustomerModel updateCustomer(CustomerModel iCustomerModel);
	
	public ServiceProviderModel updateServiceProvider(ServiceProviderModel iCustomerModel);
	
	public EmployeeModel updateEmployee(EmployeeModel iCustomerModel);
	
	public String login(long iMobileNo, String iGcmId);
	
	public String employeeLogin(long iMobileNo, String iGcmId);
	
	public ServiceProviderServiceMatchingModel getServiceProvidermatchingModel(
			ArrayList<ServiceProviderServiceMatchingModel> serviceProviderServiceMatchingModelList);
	
	public EmployeeModel insertEmployeesData(EmployeeModel employees);
	
	public String approveServiceProvider(int serviceProviderId);
	
	public String approveEmployee(int employeeId);
	
	public String acceptTermAndCondition(String imageFolderName,boolean accepttermAndCondition);
	
	public CustomerModel updateMemberShip(int userId, boolean isMembership);
	
	public UserVehicleModel getUservehicleDetail(int userId);
	
	public EmployeeModel getEmployeeFromNumber(long employeeNumber);
		
	public ServiceProviderModel getServiceProviderFromNumber(long serviceProviderNumber);
	
}
