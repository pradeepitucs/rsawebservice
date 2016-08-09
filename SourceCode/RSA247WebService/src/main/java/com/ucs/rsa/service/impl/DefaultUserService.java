package com.ucs.rsa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.daos.UserDAO;
import org.springframework.util.StringUtils;
import com.ucs.rsa.model.CustomerModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.ServiceProviderModel;
import com.ucs.rsa.service.UserService;

@Service
public class DefaultUserService extends DefaultBaseService implements UserService {

	@Autowired
	@Qualifier("defaultUserDAO")
	UserDAO userDAO;

	@Override
	public CustomerModel updateCustomer(CustomerModel iCustomerModel) {
		CustomerModel customerModel = null;
		if (!"".equals(iCustomerModel.getRoleModel().getRoleId()) && !"".equals(iCustomerModel.getEmailId())
				&& !"".equals(iCustomerModel.getGcmId())
				&& !"".equals(iCustomerModel.getMobileNo())) {
			customerModel = userDAO.updateCustomer(iCustomerModel);
		} else {
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		return customerModel;
	}

	@Override
	public ServiceProviderModel updateServiceProvider(ServiceProviderModel iCustomerModel) {
		ServiceProviderModel customerModel = null;
		if (!"".equals(iCustomerModel.getRoleModel().getRoleId())
				&& !"".equals(iCustomerModel.getMobileNo())) {
			customerModel = userDAO.updateServiceProvider(iCustomerModel);
		} else {
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		return customerModel;
	}
	

	@Override
	public String login(String iMobileNo, String iGcmId) {
		String result;
		if (validateLoginInputs(iMobileNo, iGcmId)) {
			result = userDAO.login(Integer.valueOf(iMobileNo), iGcmId);
		} else {
			RSAException upcEx = new RSAException();
			upcEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw upcEx;
		}
		return result;
	}
	
	private boolean validateLoginInputs(String iMobileNo, String iGcmId) {
		boolean isValid = Boolean.FALSE;
		if (!StringUtils.isEmpty(iMobileNo) && !StringUtils.isEmpty(iGcmId)) {
			isValid = Boolean.TRUE;
			try {
				Integer.parseInt(iMobileNo);
			} catch (RuntimeException e) {
				RSAException upcEx = new RSAException();
				upcEx.setError(RSAErrorConstants.ErrorCode.INVALID_INPUT_PARAM_ERROR);
				throw upcEx;
			}
		}
		return isValid;
	}
	
	@Override
	public EmployeeModel updateEmployee(EmployeeModel iCustomerModel) {
		EmployeeModel customerModel = null;
		if (!"".equals(iCustomerModel.getRoleModel().getRoleId())
				&& !"".equals(iCustomerModel.getMobileNo())) {
			customerModel = userDAO.updateEmployee(iCustomerModel);
		} else {
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		return customerModel;
	}
	
}
