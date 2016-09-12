package com.ucs.rsa.daos.impl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.daos.UserDAO;
import com.ucs.rsa.model.CustomerModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.ServiceProviderModel;
import com.ucs.rsa.model.ServiceProviderServiceMatchingModel;
import com.ucs.rsa.model.UserVehicleModel;

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
			if(serviceProviderModel.getServiceProviderId() == 0) {
				ServiceProviderModel theCriteria = (ServiceProviderModel) theSession.createCriteria(ServiceProviderModel.class, "serviceProviderModel")
						.add(Restrictions.eq("serviceProviderPhoneNumber", serviceProviderModel.getServiceProviderPhoneNumber())).uniqueResult();
				if (theCriteria != null) {
					System.out.println("rsaException");
					RSAException rsaException = new RSAException();
					System.out.println("rsaException" + rsaException);
					rsaException.setError(RSAErrorConstants.ErrorCode.SERVICE_PROVIDER_ALREADY_EXISTS_ERROR);
					throw rsaException;
				}
			}
			theSession.saveOrUpdate(serviceProviderModel);
		}catch (RSAException e) {
			throw e;
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
	public String login(long iMobileNo, String iGcmId) {
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
					result = "no change," +"userId:" +customer.getUserId() ;
				} else {
					//customer = new Customer();
					customer.setGcmId(iGcmId);
					System.out.println("Before update");
					theSession.update(customer);
					System.out.println("After update");
					result = "updated," +"userId:" +customer.getUserId();
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
	public String employeeLogin(long iMobileNo, String iGcmId) {
		long mobileNo = iMobileNo;
		String result = null;
		Session theSession = null;
		try {
			theSession = currentSession();
			EmployeeModel employee = null;
			employee = (EmployeeModel) theSession.createCriteria(EmployeeModel.class, "employeeModel")
					.add(Restrictions.eq("mobileNo", mobileNo)).uniqueResult();
			
			if(employee!= null) {	
				if(employee.getIsEnabled()){
					if (employee.getGcmId()==iGcmId) {
						result = "no change,employeeId:"+ employee.getUserId();
					} else {
						employee.setGcmId(iGcmId);
						System.out.println("Before update");
						theSession.update(employee);
						System.out.println("After update");
						result = "updated,employeeId:"+ employee.getUserId();
					}
				} else {
					if(employee.getGcmId()==null) {
						if(employee.getEmployeeName()!=null) {
						result = "employeeName:-"+employee.getEmployeeName()+",serviceProviderId:-"+employee.getServiceProviderID()+",userID:-"+employee.getUserId();
						} else {
							result = "employeeName:-"+",serviceProviderId:-"+employee.getServiceProviderID()+",userID:-"+employee.getUserId();
						}
					} else {
						result = "Approval Pending";
					}
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
	public ServiceProviderServiceMatchingModel getServiceProvidermatchingModel(
			ArrayList<ServiceProviderServiceMatchingModel> serviceProviderServiceMatchingModelList) {
		ServiceProviderServiceMatchingModel serviceProviderServiceMatchingModel = null;
		Session theSession = null;
		try {
			theSession = currentSession();
			for (ServiceProviderServiceMatchingModel serviceProviderServiceMatchingModel2 : serviceProviderServiceMatchingModelList) {
				theSession.saveOrUpdate(serviceProviderServiceMatchingModel2);
				serviceProviderServiceMatchingModel= serviceProviderServiceMatchingModel2;
			}
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return serviceProviderServiceMatchingModel;
	}

	@Override
	public EmployeeModel insertEmployeesData(EmployeeModel employees) {
		EmployeeModel employeeModel = null;
		Session theSession = null;
		try {
			theSession = currentSession();
			//for (EmployeeModel employeeModel2 : employees) {
				if(employees.getUserId() == 0) {
					EmployeeModel theCriteria = (EmployeeModel) theSession.createCriteria(EmployeeModel.class, "employeeModel")
							.add(Restrictions.eq("mobileNo", employees.getMobileNo()))
							.add(Restrictions.eq("roleModel.roleId", employees.getRoleModel().getRoleId())).uniqueResult();
					if (theCriteria != null) {
						System.out.println("rsaException");
						RSAException rsaException = new RSAException();
						System.out.println("rsaException" + rsaException);
						rsaException.setError(RSAErrorConstants.ErrorCode.USER_ALREADY_EXISTS_ERROR);
						throw rsaException;
					}
				}
				theSession.saveOrUpdate(employees);
				employeeModel = employees;
			//}
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return employeeModel;
	}

	@Override
	public String approveServiceProvider(int serviceProviderId) {
		String approvalStatus = null;
		Session theSession = null;
		try {
			theSession = currentSession();
			ServiceProviderModel serviceproviderModel = (ServiceProviderModel) theSession.createCriteria(ServiceProviderModel.class, "employeeModel")
					.add(Restrictions.eq("serviceProviderId", serviceProviderId)).uniqueResult();
			if(serviceproviderModel!=null) {
				if(serviceproviderModel.isAcceptTermCondition()==true) {
				serviceproviderModel.setEnabled(true);
				theSession.saveOrUpdate(serviceproviderModel);
				approvalStatus= "Approvad";
				} else {
					approvalStatus= "Terms And Condition not accepted";
				}
			}
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return approvalStatus;
	}
	
	@Override
	public String approveEmployee(int employeeId) {
		String approvalStatus = null;
		Session theSession = null;
		try {
			theSession = currentSession();
			EmployeeModel employeeModel = (EmployeeModel) theSession.createCriteria(EmployeeModel.class, "employeeModel")
					.add(Restrictions.eq("userId", employeeId)).uniqueResult();
			if(employeeModel!=null) {
				int serviceProviderId = employeeModel.getServiceProviderID();
				ServiceProviderModel serviceproviderModel = (ServiceProviderModel) theSession.createCriteria(ServiceProviderModel.class, "employeeModel")
						.add(Restrictions.eq("serviceProviderId", serviceProviderId)).uniqueResult();
				if(serviceproviderModel!=null){
				if(serviceproviderModel.isEnabled()==true) {
					employeeModel.setIsEnabled(true);
				theSession.saveOrUpdate(employeeModel);
				approvalStatus= "Approved";
				} else {
					approvalStatus= "Terms And Condition not accepted";
				} 
				}
				
			}
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return approvalStatus;
	}

	@Override
	public String acceptTermAndCondition(String imageFolderName, boolean accepttermAndCondition) {
		String termAndConditionStatus = null;
		Session theSession = null;
		try {
			theSession = currentSession();
			ServiceProviderModel serviceproviderModel = (ServiceProviderModel) theSession.createCriteria(ServiceProviderModel.class, "employeeModel")
					.add(Restrictions.eq("imageFolderName", imageFolderName)).uniqueResult();
			if(serviceproviderModel!=null) {
				serviceproviderModel.setAcceptTermCondition(accepttermAndCondition);
				theSession.saveOrUpdate(serviceproviderModel);
				termAndConditionStatus= "Approval Pending";
			} else {
				termAndConditionStatus = "Service provider Not exist";
			}
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return termAndConditionStatus;
	}

	@Override
	public CustomerModel updateMemberShip(int userId, boolean isMembership) {
		CustomerModel customerModel = null;
		Session theSession = null;
		try {
			theSession = currentSession();
				 customerModel = (CustomerModel) theSession.createCriteria(CustomerModel.class, "customerModel")
						.add(Restrictions.eq("userId", userId)).uniqueResult();
				if (customerModel != null) {
					customerModel.setMember(isMembership);
					theSession.saveOrUpdate(customerModel);
				}
			
			
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
	public UserVehicleModel getUservehicleDetail(int userId) {
		UserVehicleModel userVehicle = null;
		Session theSession = null;
		try {
			theSession = currentSession();
				 userVehicle = (UserVehicleModel) theSession.createCriteria(UserVehicleModel.class, "userVehicleModel")
						.add(Restrictions.eq("userId", userId)).uniqueResult();
			System.out.println(userVehicle);
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return userVehicle;
	}

	@Override
	public EmployeeModel getEmployeeFromNumber(long employeeNumber) {
		EmployeeModel employeeModel = null;
		Session theSession = null;
		try {
			theSession = currentSession();

			/**** Check for invalid role id ****/
			// TODO : check for customer with given id

			/**** Check for user mobile number exists for new user  ****/
			employeeModel = (EmployeeModel) theSession.createCriteria(EmployeeModel.class, "customerModel")
						.add(Restrictions.eq("mobileNo", employeeNumber))
						.add(Restrictions.eq("roleModel.roleId", 3)).uniqueResult();
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return employeeModel;
	}
	
	@Override
	public ServiceProviderModel getServiceProviderFromNumber(long serviceProviderNumber) {
		ServiceProviderModel employeeModel = null;
		Session theSession = null;
		try {
			theSession = currentSession();

			/**** Check for invalid role id ****/
			// TODO : check for customer with given id

			/**** Check for user mobile number exists for new user  ****/
			employeeModel = (ServiceProviderModel) theSession.createCriteria(ServiceProviderModel.class, "customerModel")
						.add(Restrictions.eq("serviceProviderPhoneNumber", serviceProviderNumber)).uniqueResult();
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return employeeModel;
	}

}
