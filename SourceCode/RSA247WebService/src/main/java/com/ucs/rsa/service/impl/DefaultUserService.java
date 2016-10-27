/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.daos.UserDAO;
import com.ucs.rsa.model.CustomerModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.ServiceProviderModel;
import com.ucs.rsa.model.ServiceProviderServiceMatchingModel;
import com.ucs.rsa.model.UserModel;
import com.ucs.rsa.model.UserVehicleModel;
import com.ucs.rsa.service.UserService;


/**
 * The Class DefaultUserService.
 */
@Service
public class DefaultUserService extends DefaultBaseService implements UserService
{

	/** The user DAO. */
	@Autowired
	@Qualifier("defaultUserDAO")
	UserDAO userDAO;

	/** The employee list. */
	List<EmployeeModel> employeeList = new ArrayList<>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.UserService#updateCustomer(com.ucs.rsa.model.CustomerModel)
	 */
	@Override
	public CustomerModel updateCustomer(CustomerModel iCustomerModel)
	{
		CustomerModel customerModel = null;
		if (!"".equals(iCustomerModel.getRoleModel().getRoleId()) && !"".equals(iCustomerModel.getEmailId())
				&& !"".equals(iCustomerModel.getGcmId()) && !"".equals(iCustomerModel.getMobileNo()))
		{
			customerModel = userDAO.updateCustomer(iCustomerModel);
		}
		else
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		return customerModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.UserService#updateServiceProvider(com.ucs.rsa.model.ServiceProviderModel)
	 */
	@Override
	public ServiceProviderModel updateServiceProvider(ServiceProviderModel iCustomerModel)
	{
		ServiceProviderModel customerModel = null;
		if (!"".equals(iCustomerModel.getServiceProviderPhoneNumber()))
		{
			customerModel = userDAO.updateServiceProvider(iCustomerModel);
		}
		else
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		return customerModel;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.UserService#login(long, java.lang.String)
	 */
	@Override
	public String login(long iMobileNo, String iGcmId)
	{
		String result;
		if (validateLoginInputs(iMobileNo, iGcmId))
		{
			result = userDAO.login(Long.valueOf(iMobileNo), iGcmId);
		}
		else
		{
			RSAException upcEx = new RSAException();
			upcEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw upcEx;
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.UserService#employeeLogin(long, java.lang.String)
	 */
	@Override
	public String employeeLogin(long iMobileNo, String iGcmId)
	{
		String result;
		if (validateLoginInputs(iMobileNo, iGcmId))
		{
			result = userDAO.employeeLogin(Long.valueOf(iMobileNo), iGcmId);
		}
		else
		{
			RSAException upcEx = new RSAException();
			upcEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw upcEx;
		}
		return result;
	}

	/**
	 * Validate login inputs.
	 *
	 * @param iMobileNo
	 *           the i mobile no
	 * @param iGcmId
	 *           the i gcm id
	 * @return true, if successful
	 */
	private boolean validateLoginInputs(long iMobileNo, String iGcmId)
	{
		boolean isValid = Boolean.FALSE;
		if (!StringUtils.isEmpty(iMobileNo) && !StringUtils.isEmpty(iGcmId))
		{
			isValid = Boolean.TRUE;
			try
			{
				@SuppressWarnings("unused")
				Integer i = (int) (long) iMobileNo;
			}
			catch (RuntimeException e)
			{
				RSAException upcEx = new RSAException();
				upcEx.setError(RSAErrorConstants.ErrorCode.INVALID_INPUT_PARAM_ERROR);
				throw upcEx;
			}
		}
		return isValid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.UserService#updateEmployee(com.ucs.rsa.model.EmployeeModel)
	 */
	@Override
	public EmployeeModel updateEmployee(EmployeeModel iCustomerModel)
	{
		EmployeeModel customerModel = null;
		if (!"".equals(iCustomerModel.getRoleModel().getRoleId()) && !"".equals(iCustomerModel.getMobileNo()))
		{
			customerModel = userDAO.updateEmployee(iCustomerModel);
		}
		else
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		return customerModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.UserService#getServiceProvidermatchingModel(java.util.ArrayList)
	 */
	@Override
	public ServiceProviderServiceMatchingModel getServiceProvidermatchingModel(
			ArrayList<ServiceProviderServiceMatchingModel> serviceProviderServiceMatchingModelList)
	{
		ServiceProviderServiceMatchingModel customerModel = null;
		if (serviceProviderServiceMatchingModelList != null)
		{
			customerModel = userDAO.getServiceProvidermatchingModel(serviceProviderServiceMatchingModelList);
		}
		else
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		return customerModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.UserService#insertEmployeesData(com.ucs.rsa.model.EmployeeModel)
	 */
	@Override
	public EmployeeModel insertEmployeesData(EmployeeModel employees)
	{
		EmployeeModel customerModel = null;
		if (employees != null)
		{
			customerModel = userDAO.insertEmployeesData(employees);
		}
		else
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		return customerModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.UserService#approveServiceProvider(int)
	 */
	@Override
	public String approveServiceProvider(int serviceProviderId)
	{
		String approvalStatus = null;
		if (serviceProviderId != 0)
		{
			approvalStatus = userDAO.approveServiceProvider(serviceProviderId);
		}
		else
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.INVALID_SERVICE_PROVIDER_ID);
			throw rsaEx;
		}
		return approvalStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.UserService#approveEmployee(int)
	 */
	@Override
	public String approveEmployee(int employeeId)
	{
		String approvalStatus = null;
		if (employeeId != 0)
		{
			approvalStatus = userDAO.approveEmployee(employeeId);
		}
		else
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.INVALID_SERVICE_PROVIDER_ID);
			throw rsaEx;
		}
		return approvalStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.UserService#acceptTermAndCondition(java.lang.String, boolean)
	 */
	@Override
	public String acceptTermAndCondition(String imageFolderName, boolean accepttermAndCondition)
	{
		String termConditionStatus = null;
		if (imageFolderName != null)
		{
			termConditionStatus = userDAO.acceptTermAndCondition(imageFolderName, accepttermAndCondition);
		}
		else
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.INVALID_SERVICE_PROVIDER_ID);
			throw rsaEx;
		}
		return termConditionStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.UserService#updateMemberShip(int, boolean)
	 */
	@Override
	public CustomerModel updateMemberShip(int userId, boolean isMembership)
	{
		CustomerModel customer = null;
		if (userId != 0)
		{
			customer = userDAO.updateMemberShip(userId, isMembership);
		}
		else
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.INVALID_SERVICE_PROVIDER_ID);
			throw rsaEx;
		}
		return customer;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.UserService#getUservehicleDetail(int)
	 */
	@Override
	public UserVehicleModel getUservehicleDetail(int userId)
	{
		UserVehicleModel userVehicle = null;
		if (userId != 0)
		{
			userVehicle = userDAO.getUservehicleDetail(userId);
		}
		else
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.INVALID_INPUT_PARAM_ERROR);
			throw rsaEx;
		}
		return userVehicle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.UserService#getEmployeeFromNumber(long)
	 */
	@Override
	public EmployeeModel getEmployeeFromNumber(long employeeNumber)
	{
		EmployeeModel employeeModel = null;
		if (employeeNumber != 0)
		{
			employeeModel = userDAO.getEmployeeFromNumber(employeeNumber);
		}
		else
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.INVALID_INPUT_PARAM_ERROR);
			throw rsaEx;
		}
		return employeeModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.UserService#getServiceProviderFromNumber(long)
	 */
	@Override
	public ServiceProviderModel getServiceProviderFromNumber(long serviceProviderNumber)
	{
		ServiceProviderModel employeeModel = null;
		if (serviceProviderNumber != 0)
		{
			employeeModel = userDAO.getServiceProviderFromNumber(serviceProviderNumber);
		}
		else
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.INVALID_INPUT_PARAM_ERROR);
			throw rsaEx;
		}
		return employeeModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.UserService#getUserByUsername(java.lang.String)
	 */
	public UserModel getUserByUsername(String username)
	{
		return userDAO.getUserByUsername(username);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.UserService#findAllServiceProviders(int, int)
	 */
	@Override
	public List<ServiceProviderModel> findAllServiceProviders(int iPageNo, int iRecordsPerPage)
	{
		List<ServiceProviderModel> serviceProviderModels = new ArrayList<>();
		if (iPageNo >= -1 && iRecordsPerPage >= -1)
			serviceProviderModels = userDAO.findAllServiceProviders(iPageNo, iRecordsPerPage);
		return serviceProviderModels;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.UserService#findNoOfRecords()
	 */
	@Override
	public int findNoOfRecords()
	{
		int noOfRecords = userDAO.findNoOfRecords();
		return noOfRecords;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.UserService#findAllEmployees(int, int)
	 */
	@Override
	public List<EmployeeModel> findAllEmployees(int iPageNo, int iRecordsPerPage)
	{
		List<EmployeeModel> employeeModels = new ArrayList<>();
		if (iPageNo >= -1 && iRecordsPerPage >= -1)
			employeeModels = userDAO.findAllEmployees(iPageNo, iRecordsPerPage);
		return employeeModels;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.UserService#searchEmployeesByMobileNo(java.lang.String)
	 */
	@Override
	public List<EmployeeModel> searchEmployeesByMobileNo(String iMobileNo)
	{

		Comparator<EmployeeModel> groupByComparator = Comparator.comparing(EmployeeModel::getEmployeeName);

		List<EmployeeModel> result = getEmployeeList().stream()
				.filter(e -> Long.valueOf(e.getMobileNo()).toString().contains(iMobileNo)).sorted(groupByComparator)
				.collect(Collectors.toList());

		return result;
	}

	/**
	 * Gets the employee list.
	 *
	 * @return the employee list
	 */
	public List<EmployeeModel> getEmployeeList()
	{
		if (this.employeeList.isEmpty())
			this.employeeList = loadAll(EmployeeModel.class);
		return employeeList;
	}

	/**
	 * Sets the employee list.
	 *
	 * @param employeeList
	 *           the new employee list
	 */
	public void setEmployeeList(List<EmployeeModel> employeeList)
	{
		this.employeeList = employeeList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.UserService#findAllCities()
	 */
	@Override
	public Set<String> findAllCities()
	{
		Set<String> cities = new HashSet<>();
		cities = userDAO.findAllCities();
		return cities;
	}


}
