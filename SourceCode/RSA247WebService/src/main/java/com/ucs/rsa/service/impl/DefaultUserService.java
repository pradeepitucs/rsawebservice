/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.service.impl;

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
import com.ucs.rsa.service.UserService;


/**
 * The Class DefaultUserService.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@Service
public class DefaultUserService extends DefaultBaseService implements UserService
{

	/** The user DAO. */
	@Autowired
	@Qualifier("defaultUserDAO")
	UserDAO userDAO;

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
	 * @see com.ucs.rsa.service.UserService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public String login(String iMobileNo, String iGcmId)
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

	/**
	 * Validate login inputs.
	 *
	 * @param iMobileNo
	 *           the i mobile no
	 * @param iGcmId
	 *           the i gcm id
	 * @return true, if successful
	 */
	private boolean validateLoginInputs(String iMobileNo, String iGcmId)
	{
		boolean isValid = Boolean.FALSE;
		if (!StringUtils.isEmpty(iMobileNo) && !StringUtils.isEmpty(iGcmId))
		{
			isValid = Boolean.TRUE;
			try
			{
				Long.parseLong(iMobileNo);
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

}
