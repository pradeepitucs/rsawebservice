/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.daos.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.daos.CustomerRequestDAO;
import com.ucs.rsa.model.CustomerModel;
import com.ucs.rsa.model.CustomerRequestModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.ServiceProviderModel;


/**
 * The Class DefaultCustomerRequestDAO.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@Repository(value = "customerRequestDAO")
public class DefaultCustomerRequestDAO extends DefaultBaseDAO implements CustomerRequestDAO
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.CustomerRequestDAO#updateCustomerRequest(com.ucs.rsa.model.CustomerRequestModel)
	 */
	@Override
	public CustomerRequestModel updateCustomerRequest(CustomerRequestModel iCustomerRequestModel)
	{
		CustomerRequestModel customerRequestModel = iCustomerRequestModel;
		Session theSession = null;
		try
		{
			theSession = currentSession();
			theSession.saveOrUpdate(customerRequestModel);
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
		return customerRequestModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.CustomerRequestDAO#updateCustomerRequestByEmployee(com.ucs.rsa.model.CustomerRequestModel)
	 */
	@Override
	public ArrayList<String> updateCustomerRequestByEmployee(CustomerRequestModel iCustomerRequestModel)
	{
		ArrayList<String> customerRequestResponse = new ArrayList<String>();
		Session theSession = null;
		try
		{
			theSession = currentSession();
			CustomerRequestModel customerRequestList = (CustomerRequestModel) theSession
					.createCriteria(CustomerRequestModel.class, "customerRequestModel")
					.add(Restrictions.eq("issueId", iCustomerRequestModel.getIssueId())).uniqueResult();
			//CustomerRequestModel customerRequestList = cr.list();
			int customer_id = customerRequestList.getCustomerModel().getUserId();
			customerRequestResponse.add(String.valueOf(customerRequestList.getCustomerModel().getUserId()));
			if (customerRequestList.getIssueStatus() == null || customerRequestList.getIssueStatus().isEmpty())
			{
				customerRequestList.setIssueStartTime(iCustomerRequestModel.getIssueStartTime());
				customerRequestList.setIssueStatus(iCustomerRequestModel.getIssueStatus());
				customerRequestList.setEmployeeModel(iCustomerRequestModel.getEmployeeModel());
				theSession.saveOrUpdate(customerRequestList);
				customerRequestResponse.add("Accepted");
			}
			else
			{
				customerRequestResponse.add("Accepted by other Person");
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
		return customerRequestResponse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.CustomerRequestDAO#getServiceProviderIDS(java.util.ArrayList, java.lang.String)
	 */
	@SuppressWarnings("null")
	@Override
	public ArrayList<Integer> getServiceProviderIDS(ArrayList<Double> ratingAndLocation, String serviceType)
	{
		Session theSession = null;
		List<Integer> serviceProviderIDList = new ArrayList<Integer>();
		try
		{
			theSession = currentSession();

			Criteria cr = (Criteria) theSession.createCriteria(ServiceProviderModel.class, "customerModel")
					.add(Restrictions.between("serviceProviderLatitude", ratingAndLocation.get(2), ratingAndLocation.get(3)))
					.add(Restrictions.between("serviceProviderLongitude", ratingAndLocation.get(4), ratingAndLocation.get(5)))
					.add(Restrictions.between("rating", ratingAndLocation.get(0), ratingAndLocation.get(1)))
					.add(Restrictions.like("serviceproviderExperties", "%" + serviceType + "%"))
					.add(Restrictions.like("serviceProviderotherServices", "%" + serviceType + "%"))
					.setProjection(Projections.projectionList().add(Projections.property("serviceProviderId"), "serviceProviderId"))
					.setResultTransformer(Transformers.aliasToBean(ServiceProviderModel.class));
			@SuppressWarnings("unchecked")
			List<ServiceProviderModel> serviceProviderList = cr.list();
			for (int i = 0; i < serviceProviderList.size(); i++)
			{
				serviceProviderIDList.add(serviceProviderList.get(i).getServiceProviderId());
			}
			System.out.println(serviceProviderList);
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
		return (ArrayList<Integer>) serviceProviderIDList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.CustomerRequestDAO#getDeviceIDSFromServiceProviderIDS(java.util.ArrayList)
	 */
	@SuppressWarnings("null")
	@Override
	public ArrayList<String> getDeviceIDSFromServiceProviderIDS(ArrayList<Integer> serviceProviderIDs)
	{
		Session theSession = null;
		List<String> deviceIDList = new ArrayList<String>();
		try
		{
			theSession = currentSession();

			Criteria cr = (Criteria) theSession.createCriteria(EmployeeModel.class, "customerModel")
					.add(Restrictions.in("serviceProviderID", serviceProviderIDs))
					.setProjection(Projections.projectionList().add(Projections.property("gcmId"), "gcmId"))
					.setResultTransformer(Transformers.aliasToBean(EmployeeModel.class));
			@SuppressWarnings("unchecked")
			List<EmployeeModel> employeeList = cr.list();
			for (int i = 0; i < employeeList.size(); i++)
			{
				deviceIDList.add(employeeList.get(i).getGcmId());
			}
			System.out.println(deviceIDList);
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
		return (ArrayList<String>) deviceIDList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.CustomerRequestDAO#getIssueStatus(int)
	 */
	@Override
	public String getIssueStatus(int issueID)
	{
		Session theSession = null;
		String issueStatus = null;
		try
		{
			theSession = currentSession();
			CustomerRequestModel ambulanceRequest = (CustomerRequestModel) theSession
					.createCriteria(CustomerRequestModel.class, "customerModel").add(Restrictions.eq("issueId", issueID))
					.setProjection(Projections.projectionList().add(Projections.property("issueStatus"), "issueStatus"))
					.setResultTransformer(Transformers.aliasToBean(CustomerRequestModel.class)).uniqueResult();
			issueStatus = ambulanceRequest.getIssueStatus();
			System.out.println(issueStatus);
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
		return issueStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.CustomerRequestDAO#getGCMIDFromCustomerID(int)
	 */
	@Override
	public String getGCMIDFromCustomerID(int customerId)
	{
		Session theSession = null;
		String gcmID = null;
		try
		{
			theSession = currentSession();
			CustomerModel customerModel = (CustomerModel) theSession.createCriteria(CustomerModel.class, "customerModel")
					.add(Restrictions.eq("userId", customerId))
					.setProjection(Projections.projectionList().add(Projections.property("gcmId"), "gcmId"))
					.setResultTransformer(Transformers.aliasToBean(CustomerModel.class)).uniqueResult();
			gcmID = customerModel.getGcmId();
			System.out.println(gcmID);
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
		return gcmID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.CustomerRequestDAO#getServiceProviderIDFromEmployeeID(int)
	 */
	@Override
	public int getServiceProviderIDFromEmployeeID(int employeeID)
	{
		Session theSession = null;
		int serviceProviderID = 0;
		try
		{
			theSession = currentSession();
			EmployeeModel employeeModel = (EmployeeModel) theSession.createCriteria(EmployeeModel.class, "customerModel")
					.add(Restrictions.eq("userId", employeeID))
					.setProjection(Projections.projectionList().add(Projections.property("serviceProviderID"), "serviceProviderID"))
					.setResultTransformer(Transformers.aliasToBean(EmployeeModel.class)).uniqueResult();
			serviceProviderID = employeeModel.getServiceProviderID();
			System.out.println(serviceProviderID);
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
		return serviceProviderID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.CustomerRequestDAO#getServiceProviderLocationFromServiceProviderId(int)
	 */
	@Override
	public ArrayList<Double> getServiceProviderLocationFromServiceProviderId(int serviceProviderID)
	{
		Session theSession = null;
		ArrayList<Double> location = new ArrayList<Double>();
		try
		{
			theSession = currentSession();
			ServiceProviderModel serviceProviderModel = (ServiceProviderModel) theSession
					.createCriteria(ServiceProviderModel.class, "customerModel")
					.add(Restrictions.eq("serviceProviderId", serviceProviderID))
					.setProjection(
							Projections.projectionList().add(Projections.property("serviceProviderLatitude"), "serviceProviderLatitude")
									.add(Projections.property("serviceProviderLongitude"), "serviceProviderLongitude"))
					.setResultTransformer(Transformers.aliasToBean(ServiceProviderModel.class)).uniqueResult();
			location.add(serviceProviderModel.getServiceProviderLatitude());
			location.add(serviceProviderModel.getServiceProviderLongitude());
			System.out.println(serviceProviderID);
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
		return location;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.CustomerRequestDAO#getEmployeeDataFromEmployeeID(int)
	 */
	@Override
	public EmployeeModel getEmployeeDataFromEmployeeID(int employeeID)
	{
		Session theSession = null;
		EmployeeModel employeeModel = null;
		try
		{
			theSession = currentSession();
			employeeModel = (EmployeeModel) theSession.createCriteria(EmployeeModel.class, "customerModel")
					.add(Restrictions.eq("userId", employeeID)).uniqueResult();
			System.out.println(employeeModel);
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



}
