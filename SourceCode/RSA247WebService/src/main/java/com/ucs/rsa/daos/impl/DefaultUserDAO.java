package com.ucs.rsa.daos.impl;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.daos.UserDAO;
import com.ucs.rsa.model.CustomerModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.ServiceProviderModel;

@Repository(value="defaultUserDAO")
public class DefaultUserDAO extends DefaultBaseDAO implements UserDAO {

	@Override
	public CustomerModel updateCustomer(CustomerModel iCustomerModel) {
		CustomerModel customerModel = iCustomerModel;
		Session theSession = null;
		try {
			theSession = currentSession();

			/**** Check for invalid role id ****/
			// TODO : check for customer with given id

			/**** Check for user mobile number exists for new user  ****/
			if(customerModel.getUserId() == 0) {
				CustomerModel theCriteria = (CustomerModel) theSession.createCriteria(CustomerModel.class, "customerModel")
						.add(Restrictions.eq("mobileNo", customerModel.getMobileNo()))
						.add(Restrictions.eq("roleModel.roleId", customerModel.getRoleModel().getRoleId())).uniqueResult();
				if (theCriteria != null) {
					System.out.println("rsaException");
					RSAException rsaException = new RSAException();
					System.out.println("rsaException" + rsaException);
					rsaException.setError(RSAErrorConstants.ErrorCode.USER_ALREADY_EXISTS_ERROR);
					throw rsaException;
				}
			}
			theSession.saveOrUpdate(customerModel);
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return customerModel;
	}

	@Override
	public ServiceProviderModel updateServiceProvider(ServiceProviderModel iUserDTO) {
		ServiceProviderModel serviceProviderModel = iUserDTO;
		Session theSession = null;
		try {

			theSession = currentSession();
			if(serviceProviderModel.getUserId() == 0) {
				ServiceProviderModel theCriteria = (ServiceProviderModel) theSession.createCriteria(ServiceProviderModel.class, "serviceProviderModel")
						.add(Restrictions.eq("mobileNo", serviceProviderModel.getMobileNo())).uniqueResult();
				if (theCriteria != null) {
					System.out.println("rsaException");
					RSAException rsaException = new RSAException();
					System.out.println("rsaException" + rsaException);
					rsaException.setError(RSAErrorConstants.ErrorCode.USER_ALREADY_EXISTS_ERROR);
					throw rsaException;
				}
			}
			theSession.saveOrUpdate(serviceProviderModel);
		} catch (RuntimeException runtimeException) {
			runtimeException.getStackTrace();
			System.out.println(runtimeException.getStackTrace());
			RSAException rsaException = new RSAException();
			rsaException.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaException;
		}
		return serviceProviderModel;
	}
	
	@Override
	public String login(Integer iMobileNo, String iGcmId) {
		long mobileNo = iMobileNo;
		String result = null;
		Session theSession = null;
		try {
			theSession = currentSession();
			CustomerModel customer = null;
			customer = (CustomerModel) theSession.createCriteria(CustomerModel.class, "customerModel")
					.add(Restrictions.eq("mobileNo", mobileNo)).uniqueResult();
			
			if(customer!= null) {			
				if (customer.getGcmId()==iGcmId) {
					result = "no change";
				} else {
					//customer = new Customer();
					customer.setGcmId(iGcmId);
					System.out.println("Before update");
					theSession.update(customer);
					System.out.println("After update");
					result = "updated";
				}
			} else {
				result = "not exist";
			}
		} catch (RuntimeException e) {
			RSAException rsaException = new RSAException();
			rsaException.setRootCause(e);
			rsaException.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaException;
		}
		return result;
	}
	
	@Override
	public EmployeeModel updateEmployee(EmployeeModel iCustomerModel) {
		EmployeeModel customerModel = iCustomerModel;
		Session theSession = null;
		try {
			theSession = currentSession();

			/**** Check for invalid role id ****/
			// TODO : check for customer with given id

			/**** Check for user mobile number exists for new user  ****/
			if(customerModel.getUserId() == 0) {
				EmployeeModel theCriteria = (EmployeeModel) theSession.createCriteria(EmployeeModel.class, "customerModel")
						.add(Restrictions.eq("mobileNo", customerModel.getMobileNo())).uniqueResult();
				if (theCriteria != null) {
					System.out.println("rsaException");
					RSAException rsaException = new RSAException();
					System.out.println("rsaException" + rsaException);
					rsaException.setError(RSAErrorConstants.ErrorCode.USER_ALREADY_EXISTS_ERROR);
					throw rsaException;
				}
			}
			theSession.saveOrUpdate(customerModel);
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return customerModel;
	}

}
