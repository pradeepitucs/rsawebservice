/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.daos.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.daos.UserDAO;
import com.ucs.rsa.model.AdminModel;
import com.ucs.rsa.model.CustomerModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.ServiceProviderModel;
import com.ucs.rsa.model.ServiceProviderServiceMatchingModel;
import com.ucs.rsa.model.ServiceProviderServicePriceModel;
import com.ucs.rsa.model.SurveyVerificationModel;
import com.ucs.rsa.model.UserModel;
import com.ucs.rsa.model.UserVehicleModel;



/**
 * The Class DefaultUserDAO.
 */
@Repository(value = "defaultUserDAO")
public class DefaultUserDAO extends DefaultBaseDAO implements UserDAO
{

	/** The no of records. */
	private int noOfRecords;

	/** The service provider models. */
	List<ServiceProviderModel> serviceProviderModels = new ArrayList<>();

	/** The employee models. */
	List<EmployeeModel> employeeModels = new ArrayList<>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.UserDAO#updateCustomer(com.ucs.rsa.model.CustomerModel)
	 */
	@Override
	public CustomerModel updateCustomer(CustomerModel iCustomerModel)
	{
		CustomerModel customerModel = iCustomerModel;
		Session theSession = null;
		try
		{
			theSession = currentSession();
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

			/**** Check for invalid role id ****/
			// TODO : check for customer with given id

			/**** Check for user mobile number exists for new user ****/
			if (customerModel.getUserId() == 0)
			{
				iCustomerModel.setCreatedBy(authentication.getName());
				CustomerModel theCriteria = (CustomerModel) theSession.createCriteria(CustomerModel.class, "customerModel")
						.add(Restrictions.eq("mobileNo", customerModel.getMobileNo()))
						.add(Restrictions.eq("roleModel.roleId", customerModel.getRoleModel().getRoleId())).uniqueResult();
				if (theCriteria != null)
				{
					System.out.println("rsaException");
					RSAException rsaException = new RSAException();
					System.out.println("rsaException" + rsaException);
					rsaException.setError(RSAErrorConstants.ErrorCode.USER_ALREADY_EXISTS_ERROR);
					throw rsaException;
				}
			}
			else
			{
				iCustomerModel.setUpdatedBy(authentication.getName());
			}
			theSession.saveOrUpdate(customerModel);
		}
		catch (RSAException e)
		{
			e.printStackTrace();
			throw e;
		}
		catch (RuntimeException ex)
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return customerModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.UserDAO#updateServiceProvider(com.ucs.rsa.model.ServiceProviderModel)
	 */
	@Override
	public ServiceProviderModel updateServiceProvider(ServiceProviderModel iUserDTO)
	{
		ServiceProviderModel serviceProviderModel = iUserDTO;
		Session theSession = null;
		try
		{

			theSession = currentSession();
			if (serviceProviderModel.getServiceProviderId() == 0)
			{
				ServiceProviderModel theCriteria = (ServiceProviderModel) theSession
						.createCriteria(ServiceProviderModel.class, "serviceProviderModel")
						.add(Restrictions.eq("serviceProviderPhoneNumber", serviceProviderModel.getServiceProviderPhoneNumber()))
						.uniqueResult();
				if (theCriteria != null)
				{
					System.out.println("rsaException");
					RSAException rsaException = new RSAException();
					System.out.println("rsaException" + rsaException);
					rsaException.setError(RSAErrorConstants.ErrorCode.SERVICE_PROVIDER_ALREADY_EXISTS_ERROR);
					throw rsaException;
				}
				theSession.saveOrUpdate(serviceProviderModel);
			} else {
				ServiceProviderModel theCriteria = (ServiceProviderModel) theSession.createCriteria(ServiceProviderModel.class, "serviceProviderModel")
						.add(Restrictions.eq("serviceProviderId", serviceProviderModel.getServiceProviderId())).uniqueResult();
				if (theCriteria != null) {
					theCriteria.setBodyRepair(serviceProviderModel.isBodyRepair());
					theCriteria.setElectricalType(serviceProviderModel.isElectricalType());
					theCriteria.setFourWheeler(serviceProviderModel.isFourWheeler());
					theCriteria.setImageFolderName(serviceProviderModel.getImageFolderName());
					theCriteria.setMechanicalType(serviceProviderModel.isMechanicalType());
					theCriteria.setServiceProviderCity(serviceProviderModel.getServiceProviderCity());
					theCriteria.setServiceProviderLatitude(serviceProviderModel.getServiceProviderLatitude());
					theCriteria.setServiceProviderLongitude(serviceProviderModel.getServiceProviderLongitude());
					theCriteria.setServiceProviderName(serviceProviderModel.getServiceProviderName());
					theCriteria.setServiceProviderPremium(serviceProviderModel.getServiceProviderPremium());
					theCriteria.setServiceProviderTimestamp(serviceProviderModel.getServiceProviderTimestamp());
					theCriteria.setServiceProvidertiming(serviceProviderModel.getServiceProvidertiming());
					theCriteria.setTwoWheeler(serviceProviderModel.getTwoWheeler());
					theSession.saveOrUpdate(theCriteria);
				}
			}
			
		}
		catch (RSAException e)
		{
			throw e;
		}
		catch (RuntimeException runtimeException)
		{
			runtimeException.getStackTrace();
			System.out.println(runtimeException.getStackTrace());
			RSAException rsaException = new RSAException();
			rsaException.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaException;
		}
		return serviceProviderModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.UserDAO#login(long, java.lang.String)
	 */
	@Override
	public String login(long iMobileNo, String iGcmId)
	{
		long mobileNo = iMobileNo;
		String result = null;
		Session theSession = null;
		try
		{
			theSession = currentSession();
			CustomerModel customer = null;
			customer = (CustomerModel) theSession.createCriteria(CustomerModel.class, "customerModel")
					.add(Restrictions.eq("mobileNo", mobileNo)).uniqueResult();

			if (customer != null)
			{
				if (customer.getGcmId() == iGcmId)
				{
					result = "no change," + "userId:" + customer.getUserId();
				}
				else
				{
					//customer = new Customer();
					customer.setGcmId(iGcmId);
					System.out.println("Before update");
					theSession.update(customer);
					System.out.println("After update");
					result = "updated," + "userId:" + customer.getUserId();
				}
			}
			else
			{
				result = "not exist";
			}
		}
		catch (RuntimeException e)
		{
			RSAException rsaException = new RSAException();
			rsaException.setRootCause(e);
			rsaException.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaException;
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.UserDAO#employeeLogin(long, java.lang.String)
	 */
	@Override
	public String employeeLogin(long iMobileNo, String iGcmId)
	{
		long mobileNo = iMobileNo;
		String result = null;
		Session theSession = null;
		try
		{
			theSession = currentSession();
			EmployeeModel employee = null;
			employee = (EmployeeModel) theSession.createCriteria(EmployeeModel.class, "employeeModel")
					.add(Restrictions.eq("mobileNo", mobileNo)).uniqueResult();
			SurveyVerificationModel surveyVerification = null;
			surveyVerification = (SurveyVerificationModel) theSession
					.createCriteria(SurveyVerificationModel.class, "surveyVerificationModel")
					.add(Restrictions.eq("contactpersonPhoneNumber", mobileNo)).uniqueResult();
			if (employee != null)
			{
				if (employee.getIsEnabled())
				{
					if (employee.getGcmId() == iGcmId)
					{
						result = "approval_status:no change,employeeId:" + employee.getUserId() + ",serviceproviderId:"
								+ employee.getServiceProviderID() + ",owner:" + employee.isOnwer();
					}
					else
					{
						employee.setGcmId(iGcmId);
						System.out.println("Before update");
						theSession.update(employee);
						System.out.println("After update");
						result = "approval_status:updated,employeeId:" + employee.getUserId() + ",serviceproviderId:"
								+ employee.getServiceProviderID() + ",owner:" + employee.isOnwer();
					}
				}
				else
				{
					if (employee.getGcmId() == null)
					{
						if (employee.getEmployeeName() != null)
						{
							result = "employeeName:-" + employee.getEmployeeName() + ",serviceProviderId:-"
									+ employee.getServiceProviderID() + ",userID:-" + employee.getUserId();
						}
						else
						{
							result = "userID:-"+employee.getUserId()+",serviceProviderId:-"+employee.getServiceProviderID();
						}
					}
					else
					{
						result = "Approval Pending";
					}
				}
			}
			else if (surveyVerification != null)
			{
				result = new Gson().toJson(surveyVerification);

			}
			else
			{
				result = "not exist";
			}
		}
		catch (RuntimeException e)
		{
			RSAException rsaException = new RSAException();
			rsaException.setRootCause(e);
			rsaException.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaException;
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.UserDAO#updateEmployee(com.ucs.rsa.model.EmployeeModel)
	 */
	@Override
	public EmployeeModel updateEmployee(EmployeeModel iCustomerModel)
	{
		EmployeeModel customerModel = iCustomerModel;
		Session theSession = null;
		try
		{
			theSession = currentSession();

			/**** Check for invalid role id ****/
			// TODO : check for customer with given id

			/**** Check for user mobile number exists for new user ****/
			if (customerModel.getUserId() == 0)
			{
				EmployeeModel theCriteria = (EmployeeModel) theSession.createCriteria(EmployeeModel.class, "customerModel")
						.add(Restrictions.eq("mobileNo", customerModel.getMobileNo()))
						.add(Restrictions.eq("roleModel.roleId", customerModel.getRoleModel().getRoleId())).uniqueResult();
				if (theCriteria != null)
				{
					System.out.println("rsaException");
					RSAException rsaException = new RSAException();
					System.out.println("rsaException" + rsaException);
					rsaException.setError(RSAErrorConstants.ErrorCode.USER_ALREADY_EXISTS_ERROR);
					throw rsaException;
				}
			}
			theSession.saveOrUpdate(customerModel);
		}
		catch (RSAException e)
		{
			throw e;
		}
		catch (RuntimeException ex)
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return customerModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.UserDAO#getServiceProvidermatchingModel(java.util.ArrayList)
	 */
	@Override
	public ServiceProviderServiceMatchingModel getServiceProvidermatchingModel(
			ArrayList<ServiceProviderServiceMatchingModel> serviceProviderServiceMatchingModelList)
	{
		ServiceProviderServiceMatchingModel serviceProviderServiceMatchingModel = null;
		Session theSession = null;
		try
		{
			theSession = currentSession();
			for (ServiceProviderServiceMatchingModel serviceProviderServiceMatchingModel2 : serviceProviderServiceMatchingModelList)
			{
				theSession.saveOrUpdate(serviceProviderServiceMatchingModel2);
				serviceProviderServiceMatchingModel = serviceProviderServiceMatchingModel2;
			}
		}
		catch (RSAException e)
		{
			throw e;
		}
		catch (RuntimeException ex)
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return serviceProviderServiceMatchingModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.UserDAO#insertEmployeesData(com.ucs.rsa.model.EmployeeModel)
	 */
	@Override
	public EmployeeModel insertEmployeesData(EmployeeModel employees)
	{
		EmployeeModel employeeModel = null;
		Session theSession = null;
		try
		{
			theSession = currentSession();
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			//for (EmployeeModel employeeModel2 : employees) {
			if (employees.getUserId() == 0)
			{
				employees.setCreatedBy(authentication.getName());
				EmployeeModel theCriteria = (EmployeeModel) theSession.createCriteria(EmployeeModel.class, "employeeModel")
						.add(Restrictions.eq("mobileNo", employees.getMobileNo()))
						.add(Restrictions.eq("roleModel.roleId", employees.getRoleModel().getRoleId())).uniqueResult();
				if (theCriteria != null)
				{
					System.out.println("rsaException");
					RSAException rsaException = new RSAException();
					System.out.println("rsaException" + rsaException);
					rsaException.setError(RSAErrorConstants.ErrorCode.USER_ALREADY_EXISTS_ERROR);
					throw rsaException;
				}
				theSession.saveOrUpdate(employees);
				employeeModel = employees;
			} else {
				employeeModel = (EmployeeModel) theSession.createCriteria(EmployeeModel.class, "employeeModel")
						.add(Restrictions.eq("mobileNo", employees.getMobileNo()))
						.add(Restrictions.eq("roleModel.roleId", employees.getRoleModel().getRoleId())).uniqueResult();
				if(employeeModel!=null){
					employeeModel.setEmployeeEmail(employees.getEmployeeEmail());
					employeeModel.setEmployeeName(employees.getEmployeeName());
					employeeModel.setGcmId(employees.getGcmId());
					employeeModel.setOnwer(employees.isOnwer());
					employeeModel.setServiceProviderID(employees.getServiceProviderID());
				}
				
			}
			
		//}
	}
		catch (RSAException e)
		{
			throw e;
		}
		catch (RuntimeException ex)
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return employeeModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.UserDAO#approveServiceProvider(int)
	 */
	@Override
	public String approveServiceProvider(int serviceProviderId)
	{
		String approvalStatus = null;
		Session theSession = null;
		try
		{
			theSession = currentSession();
			ServiceProviderModel serviceproviderModel = (ServiceProviderModel) theSession
					.createCriteria(ServiceProviderModel.class, "employeeModel")
					.add(Restrictions.eq("serviceProviderId", serviceProviderId)).uniqueResult();
			if (serviceproviderModel != null)
			{
				if (serviceproviderModel.isAcceptTermCondition() == true)
				{
					serviceproviderModel.setEnabled(true);
					theSession.saveOrUpdate(serviceproviderModel);
					approvalStatus = "Approved";
				}
				else
				{
					approvalStatus = "Terms And Condition not accepted";
				}
			}
		}
		catch (RSAException e)
		{
			throw e;
		}
		catch (RuntimeException ex)
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return approvalStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.UserDAO#approveEmployee(int)
	 */
	@Override
	public String approveEmployee(int employeeId)
	{
		String approvalStatus = null;
		Session theSession = null;
		try
		{
			theSession = currentSession();
			EmployeeModel employeeModel = (EmployeeModel) theSession.createCriteria(EmployeeModel.class, "employeeModel")
					.add(Restrictions.eq("userId", employeeId)).uniqueResult();
			if (employeeModel != null)
			{
				int serviceProviderId = employeeModel.getServiceProviderID();
				ServiceProviderModel serviceproviderModel = (ServiceProviderModel) theSession
						.createCriteria(ServiceProviderModel.class, "employeeModel")
						.add(Restrictions.eq("serviceProviderId", serviceProviderId)).uniqueResult();
				if (serviceproviderModel != null)
				{
					if (serviceproviderModel.isEnabled() == true)
					{
						employeeModel.setIsEnabled(true);
						theSession.saveOrUpdate(employeeModel);
						approvalStatus = "Approved";
					}
					else
					{
						approvalStatus = "ServicePrvoder not yet approved";
					}
				}

			}
		}
		catch (RSAException e)
		{
			throw e;
		}
		catch (RuntimeException ex)
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return approvalStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.UserDAO#acceptTermAndCondition(java.lang.String, boolean)
	 */
	@Override
	public String acceptTermAndCondition(String imageFolderName, boolean accepttermAndCondition)
	{
		String termAndConditionStatus = null;
		Session theSession = null;
		try
		{
			theSession = currentSession();
			ServiceProviderModel serviceproviderModel = (ServiceProviderModel) theSession
					.createCriteria(ServiceProviderModel.class, "employeeModel")
					.add(Restrictions.eq("imageFolderName", imageFolderName)).uniqueResult();
			if (serviceproviderModel != null)
			{
				serviceproviderModel.setAcceptTermCondition(accepttermAndCondition);
				theSession.saveOrUpdate(serviceproviderModel);
				termAndConditionStatus = "Approval Pending";
			}
			else
			{
				termAndConditionStatus = "Service provider Not exist";
			}
		}
		catch (RSAException e)
		{
			throw e;
		}
		catch (RuntimeException ex)
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return termAndConditionStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.UserDAO#updateMemberShip(int, boolean)
	 */
	@Override
	public CustomerModel updateMemberShip(int userId, boolean isMembership)
	{
		CustomerModel customerModel = null;
		Session theSession = null;
		try
		{
			theSession = currentSession();
			customerModel = (CustomerModel) theSession.createCriteria(CustomerModel.class, "customerModel")
					.add(Restrictions.eq("userId", userId)).uniqueResult();
			if (customerModel != null)
			{
				customerModel.setMember(isMembership);
				theSession.saveOrUpdate(customerModel);
			}


		}
		catch (RSAException e)
		{
			throw e;
		}
		catch (RuntimeException ex)
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return customerModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.UserDAO#getUservehicleDetail(int)
	 */
	@Override
	public UserVehicleModel getUservehicleDetail(int userId)
	{
		UserVehicleModel userVehicle = null;
		Session theSession = null;
		try
		{
			theSession = currentSession();
			userVehicle = (UserVehicleModel) theSession.createCriteria(UserVehicleModel.class, "userVehicleModel")
					.add(Restrictions.eq("userId", userId)).uniqueResult();
			System.out.println(userVehicle);
		}
		catch (RSAException e)
		{
			throw e;
		}
		catch (RuntimeException ex)
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return userVehicle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.UserDAO#getEmployeeFromNumber(long)
	 */
	@Override
	public EmployeeModel getEmployeeFromNumber(long employeeNumber)
	{
		EmployeeModel employeeModel = null;
		Session theSession = null;
		try
		{
			theSession = currentSession();

			/**** Check for invalid role id ****/
			// TODO : check for customer with given id

			/**** Check for user mobile number exists for new user ****/
			employeeModel = (EmployeeModel) theSession.createCriteria(EmployeeModel.class, "customerModel")
					.add(Restrictions.eq("mobileNo", employeeNumber)).add(Restrictions.eq("roleModel.roleId", 3)).uniqueResult();
		}
		catch (RSAException e)
		{
			throw e;
		}
		catch (RuntimeException ex)
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return employeeModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.UserDAO#getServiceProviderFromNumber(long)
	 */
	@Override
	public ServiceProviderModel getServiceProviderFromNumber(long serviceProviderNumber)
	{
		ServiceProviderModel employeeModel = null;
		Session theSession = null;
		try
		{
			theSession = currentSession();

			/**** Check for invalid role id ****/
			// TODO : check for customer with given id

			/**** Check for user mobile number exists for new user ****/
			employeeModel = (ServiceProviderModel) theSession.createCriteria(ServiceProviderModel.class, "customerModel")
					.add(Restrictions.eq("serviceProviderPhoneNumber", serviceProviderNumber)).uniqueResult();
		}
		catch (RSAException e)
		{
			throw e;
		}
		catch (RuntimeException ex)
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return employeeModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.UserDAO#getUserByUsername(java.lang.String)
	 */
	@Override
	public UserModel getUserByUsername(String username)
	{

		AdminModel adminModel = new AdminModel();
		Session theSession = null;
		try
		{
			theSession = currentSession();

			adminModel = (AdminModel) theSession.createCriteria(AdminModel.class, "adminModel")
					.add(Restrictions.eq("username", username)).uniqueResult();

			if (adminModel != null)
			{
				return adminModel;
			}

		}
		catch (RuntimeException ex)
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.UserDAO#findAllServiceProviders(int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ServiceProviderModel> findAllServiceProviders(int iPageNo, int iRecordsPerPage)
	{
		Session theSession = null;
		try
		{
			theSession = currentSession();

			if (iPageNo >= -1 && iRecordsPerPage >= -1)
			{
				Criteria theCriteria = theSession.createCriteria(ServiceProviderModel.class, "serviceProviderModel")
						.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).setFirstResult(iPageNo).setMaxResults(iRecordsPerPage);
				serviceProviderModels = (List<ServiceProviderModel>) theCriteria.list();

				this.noOfRecords = theSession.createCriteria(ServiceProviderModel.class, "serviceProviderModel").list().size();
			}

		}
		catch (RSAException e)
		{
			e.getStackTrace();
			throw e;
		}
		catch (RuntimeException ex)
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.getStackTrace();
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return serviceProviderModels;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.UserDAO#findNoOfRecords()
	 */
	@Override
	public int findNoOfRecords()
	{
		return noOfRecords;
	}

	/**
	 * Gets the no of records.
	 *
	 * @return the no of records
	 */
	public int getNoOfRecords()
	{
		return noOfRecords;
	}

	/**
	 * Sets the no of records.
	 *
	 * @param noOfRecords
	 *           the new no of records
	 */
	public void setNoOfRecords(int noOfRecords)
	{
		this.noOfRecords = noOfRecords;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.UserDAO#findAllEmployees(int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeModel> findAllEmployees(int iPageNo, int iRecordsPerPage)
	{
		Session theSession = null;
		try
		{
			theSession = currentSession();

			if (iPageNo >= -1 && iRecordsPerPage >= -1)
			{
				Criteria theCriteria = theSession.createCriteria(EmployeeModel.class, "employeeModel")
						.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).setFirstResult(iPageNo).setMaxResults(iRecordsPerPage);
				employeeModels = (List<EmployeeModel>) theCriteria.list();

				this.noOfRecords = theSession.createCriteria(EmployeeModel.class).list().size();
			}

		}
		catch (RSAException e)
		{
			throw e;
		}
		catch (RuntimeException ex)
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return employeeModels;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.UserDAO#findAllCities()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Set<String> findAllCities()
	{
		Set<String> cities = new HashSet<>();
		Session theSession = null;
		try
		{
			theSession = currentSession();
			Criteria theCriteria = (Criteria) theSession.createCriteria(ServiceProviderModel.class, "serviceProviderModel")
					.setProjection(Projections.property("serviceProviderCity"));
			cities = new HashSet<>(theCriteria.list());
		}
		catch (RSAException e)
		{
			throw e;
		}
		catch (RuntimeException ex)
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}

		return cities;
	}
	
	@Override
	public ServiceProviderServicePriceModel updateServiceProviderServicePriceModel(
			ServiceProviderServicePriceModel serviceProviderServicePriceModel) {
		ServiceProviderServicePriceModel serviceProviderServicePrice = null;
		Session theSession = null;
		try {
			theSession = currentSession();
			theSession.saveOrUpdate(serviceProviderServicePriceModel);
			serviceProviderServicePrice = serviceProviderServicePriceModel;
			
		}catch (RSAException e) {
			throw e;
		} catch (RuntimeException runtimeException) {
			runtimeException.getStackTrace();
			System.out.println(runtimeException.getStackTrace());
			RSAException rsaException = new RSAException();
			rsaException.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaException;
		}
		return serviceProviderServicePrice;
	}
}
