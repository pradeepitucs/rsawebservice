package com.ucs.rsa.service.impl;

import java.util.ArrayList;
import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.daos.UserDAO;

import org.springframework.util.StringUtils;

import com.ucs.rsa.model.CustomerModel;
import com.ucs.rsa.model.CustomerPaymentModel;
import com.ucs.rsa.model.CustomerRequestModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.IssuePaymentModel;
import com.ucs.rsa.model.ServiceProviderModel;
import com.ucs.rsa.model.ServiceProviderServiceMatchingModel;
import com.ucs.rsa.model.UserVehicleModel;
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
		if ( !"".equals(iCustomerModel.getServiceProviderPhoneNumber())) {
			customerModel = userDAO.updateServiceProvider(iCustomerModel);
		} else {
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		return customerModel;
	}
	

	@Override
	public String login(long iMobileNo, String iGcmId) {
		String result;
		if (validateLoginInputs(iMobileNo, iGcmId)) {
			result = userDAO.login(Long.valueOf(iMobileNo), iGcmId);
		} else {
			RSAException upcEx = new RSAException();
			upcEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw upcEx;
		}
		return result;
	}
	
	@Override
	public String employeeLogin(long iMobileNo, String iGcmId) {
		String result;
		if (validateLoginInputs(iMobileNo, iGcmId)) {
			result = userDAO.employeeLogin(Long.valueOf(iMobileNo), iGcmId);
		} else {
			RSAException upcEx = new RSAException();
			upcEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw upcEx;
		}
		return result;
	}
	
	private boolean validateLoginInputs(long iMobileNo, String iGcmId) {
		boolean isValid = Boolean.FALSE;
		if (!StringUtils.isEmpty(iMobileNo) && !StringUtils.isEmpty(iGcmId)) {
			isValid = Boolean.TRUE;
			try {
				Integer i =(int) (long) iMobileNo;
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

	@Override
	public ServiceProviderServiceMatchingModel getServiceProvidermatchingModel(
			ArrayList<ServiceProviderServiceMatchingModel> serviceProviderServiceMatchingModelList) {
		ServiceProviderServiceMatchingModel customerModel = null;
		if (serviceProviderServiceMatchingModelList!=null) {
			customerModel = userDAO.getServiceProvidermatchingModel(serviceProviderServiceMatchingModelList);
		} else {
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		return customerModel;
	}

	@Override
	public EmployeeModel insertEmployeesData(EmployeeModel employees) {
		EmployeeModel customerModel = null;
		if (employees!=null) {
			customerModel = userDAO.insertEmployeesData(employees);
		} else {
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		return customerModel;
	}

	@Override
	public String approveServiceProvider(int serviceProviderId) {
		String approvalStatus = null;
		if (serviceProviderId!=0) {
			approvalStatus = userDAO.approveServiceProvider(serviceProviderId);
		} else {
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.INVALID_SERVICE_PROVIDER_ID);
			throw rsaEx;
		}
		return approvalStatus;
	}
	
	@Override
	public String approveEmployee(int employeeId) {
		String approvalStatus = null;
		if (employeeId!=0) {
			approvalStatus = userDAO.approveEmployee(employeeId);
		} else {
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.INVALID_SERVICE_PROVIDER_ID);
			throw rsaEx;
		}
		return approvalStatus;
	}

	@Override
	public String acceptTermAndCondition(String imageFolderName, boolean accepttermAndCondition) {
		String termConditionStatus = null;
		if (imageFolderName!=null) {
			termConditionStatus = userDAO.acceptTermAndCondition(imageFolderName,accepttermAndCondition);
		} else {
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.INVALID_SERVICE_PROVIDER_ID);
			throw rsaEx;
		}
		return termConditionStatus;
	}

	@Override
	public CustomerModel updateMemberShip(int userId, boolean isMembership) {
		CustomerModel customer = null;
		if (userId!=0) {
			customer = userDAO.updateMemberShip(userId,isMembership);
		} else {
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.INVALID_SERVICE_PROVIDER_ID);
			throw rsaEx;
		}
		return customer;

	}

	@Override
	public UserVehicleModel getUservehicleDetail(int userId) {
		UserVehicleModel userVehicle = null;
		if (userId!=0) {
			userVehicle = userDAO.getUservehicleDetail(userId);
		} else {
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.INVALID_INPUT_PARAM_ERROR);
			throw rsaEx;
		}
		return userVehicle;
	}

	@Override
	public EmployeeModel getEmployeeFromNumber(long employeeNumber) {
		EmployeeModel employeeModel = null;
		if (employeeNumber!=0) {
			employeeModel = userDAO.getEmployeeFromNumber(employeeNumber);
		} else {
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.INVALID_INPUT_PARAM_ERROR);
			throw rsaEx;
		}
		return employeeModel;
	}
	
	@Override
	public ServiceProviderModel getServiceProviderFromNumber(long serviceProviderNumber) {
		ServiceProviderModel employeeModel = null;
		if (serviceProviderNumber!=0) {
			employeeModel = userDAO.getServiceProviderFromNumber(serviceProviderNumber);
		} else {
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.INVALID_INPUT_PARAM_ERROR);
			throw rsaEx;
		}
		return employeeModel;
	}
	
/*	@Override
	public String paymentResponse(Hashtable<String, String> reqValMap) {
		
		if(reqValMap.get("param2").equals("0")) {
			CustomerPaymentModel paymentModel = new CustomerPaymentModel();
			CustomerModel customerModel = new CustomerModel();
			customerModel.setUserId(Integer.parseInt(reqValMap.get("param1")));
			paymentModel.setCustomerModel(customerModel);
			paymentModel.setTxId(reqValMap.get("TxId"));
			paymentModel.setTxStatus(reqValMap.get("TxStatus"));
			paymentModel.setAmount(reqValMap.get("amount"));
			paymentModel.setPgTxnNo(reqValMap.get("pgTxnNo"));
			paymentModel.setIssuerRefNo(reqValMap.get("issuerRefNo"));
			paymentModel.setAuthIdCode(reqValMap.get("authIdCode"));
			paymentModel.setFirstName(reqValMap.get("firstName"));
			paymentModel.setLastName(reqValMap.get("lastName"));
			paymentModel.setPgRespCode(reqValMap.get("pgRespCode"));
			paymentModel.setAddressZip(reqValMap.get("addressZip"));
			paymentModel.setSignature(reqValMap.get("signature"));
			paymentModel.setTxRefNo(reqValMap.get("txRefNo"));
			paymentModel.setTxMsg(reqValMap.get("txMsg"));
			paymentModel.setTransactionId(reqValMap.get("transactionId"));
			paymentModel.setInfo(reqValMap.toString());

			save(paymentModel);
		} else {
			
			IssuePaymentModel paymentModel = new IssuePaymentModel();
			CustomerRequestModel customerRequestModel = new CustomerRequestModel();
			customerRequestModel.setIssueId(Integer.parseInt(reqValMap.get("param2")));
			paymentModel.setCustomerRequestModel(customerRequestModel);
			paymentModel.setTxId(reqValMap.get("TxId"));
			paymentModel.setTxStatus(reqValMap.get("TxStatus"));
			paymentModel.setAmount(reqValMap.get("amount"));
			paymentModel.setPgTxnNo(reqValMap.get("pgTxnNo"));
			paymentModel.setIssuerRefNo(reqValMap.get("issuerRefNo"));
			paymentModel.setAuthIdCode(reqValMap.get("authIdCode"));
			paymentModel.setFirstName(reqValMap.get("firstName"));
			paymentModel.setLastName(reqValMap.get("lastName"));
			paymentModel.setPgRespCode(reqValMap.get("pgRespCode"));
			paymentModel.setAddressZip(reqValMap.get("addressZip"));
			paymentModel.setSignature(reqValMap.get("signature"));
			paymentModel.setTxRefNo(reqValMap.get("txRefNo"));
			paymentModel.setTxMsg(reqValMap.get("txMsg"));
			paymentModel.setTransactionId(reqValMap.get("transactionId"));
			paymentModel.setInfo(reqValMap.toString());

			save(paymentModel);
		}
		return "";
	}*/
	
}
