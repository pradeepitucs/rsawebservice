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
import com.ucs.rsa.daos.EmployeeDashboardRequestDAO;
import com.ucs.rsa.model.CustomerRequestModel;
import com.ucs.rsa.model.CustomerReviewModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.IssuePaymentModel;



/**
 * The Class DefaultEmployeeDashboardRequestDAO.
 */
@Repository(value = "defaultEmployeeDashboardDAO")
public class DefaultEmployeeDashboardRequestDAO extends DefaultBaseDAO implements EmployeeDashboardRequestDAO
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.EmployeeDashboardRequestDAO#getCompletedOrRejectedCount(java.lang.String, int)
	 */
	@Override
	public int getCompletedOrRejectedCount(String status, int employeeId)
	{
		int count = 0;
		Session theSession = null;
		try
		{
			theSession = currentSession();
			Criteria theCriteria = (Criteria) theSession.createCriteria(CustomerRequestModel.class, "customerRequestModel")
					.add(Restrictions.eq("employeeID", employeeId)).add(Restrictions.eq("issueStatus", status));
			if (theCriteria != null)
			{
				@SuppressWarnings("unchecked")
				List<CustomerRequestModel> listOfCustomerRequest = theCriteria.list();
				count = listOfCustomerRequest.size();
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
		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.EmployeeDashboardRequestDAO#getEmployeeRating(int)
	 */
	@Override
	public double getEmployeeRating(int employeeId)
	{
		double rating = 0;
		Session theSession = null;
		try
		{
			theSession = currentSession();
			EmployeeModel employee = new EmployeeModel();
			employee.setUserId(employeeId);
			Criteria theCriteria = (Criteria) theSession.createCriteria(CustomerReviewModel.class, "customerRequestModel")
					.add(Restrictions.eq("employeeModel", employee));
			if (theCriteria != null)
			{
				@SuppressWarnings("unchecked")
				List<CustomerReviewModel> listOfCustomerReview = theCriteria.list();
				int size = listOfCustomerReview.size();
				double totalRating = 0.0;
				for (CustomerReviewModel customerReviewModel : listOfCustomerReview)
				{
					totalRating = totalRating + customerReviewModel.getRating();
				}
				if (size != 0)
				{
					rating = totalRating / size;
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
		return rating;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.EmployeeDashboardRequestDAO#getEmployeeFromServiceProviderId(int)
	 */
	@SuppressWarnings(
	{ "unchecked" })
	@Override
	public List<Integer> getEmployeeFromServiceProviderId(int serviceProviderId)
	{
		List<Integer> employees = new ArrayList<Integer>();
		List<EmployeeModel> employeesModel = null;
		Session theSession = null;
		try
		{
			theSession = currentSession();
			Criteria theCriteria = (Criteria) theSession.createCriteria(EmployeeModel.class, "employeeModel")
					.add(Restrictions.eq("serviceProviderID", serviceProviderId))
					.setProjection(Projections.projectionList().add(Projections.property("userId"), "userId"))
					.setResultTransformer(Transformers.aliasToBean(EmployeeModel.class));
			if (theCriteria != null)
			{
				employeesModel = theCriteria.list();
				for (EmployeeModel employeeModel : employeesModel)
				{
					employees.add(employeeModel.getUserId());
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
		return employees;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.daos.EmployeeDashboardRequestDAO#getCompletedOrRejectedCountForServiceProvider(java.lang.String,
	 * java.util.List)
	 */
	@Override
	public int getCompletedOrRejectedCountForServiceProvider(String status, List<Integer> employees)
	{
		int count = 0;
		Session theSession = null;
		try
		{
			theSession = currentSession();
			Criteria theCriteria = (Criteria) theSession.createCriteria(CustomerRequestModel.class, "customerRequestModel")
					.add(Restrictions.in("employeeID", employees)).add(Restrictions.eq("issueStatus", status));

			if (theCriteria != null)
			{
				@SuppressWarnings("unchecked")
				List<CustomerRequestModel> listOfCustomerRequest = theCriteria.list();
				count = listOfCustomerRequest.size();
			}
			else
			{
				count = 0;
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
		return count;
	}
	
	/* (non-Javadoc)
	 * @see com.ucs.rsa.daos.EmployeeDashboardRequestDAO#getServiceProviderEarning(java.util.List)
	 */
	@Override
	public double getServiceProviderEarning(List<Integer> employees) {
		double earning = 0.0;
		Session theSession = null;
		try {
			theSession = currentSession();
				Criteria theCriteria = (Criteria) theSession.createCriteria(CustomerRequestModel.class, "customerRequestModel")
						.add(Restrictions.in("employeeID", employees));
						
				if (theCriteria != null) {
					List<CustomerRequestModel> listOfCustomerRequest = theCriteria.list();
					List<CustomerRequestModel> finalCustomerRequestModel = new ArrayList<CustomerRequestModel>();
					for(CustomerRequestModel cusRequest:listOfCustomerRequest) {
						CustomerRequestModel cus = new CustomerRequestModel();
						cus.setIssueId(cusRequest.getIssueId());
						finalCustomerRequestModel.add(cus);
					}
					Criteria criteria = (Criteria) theSession.createCriteria(IssuePaymentModel.class, "issuePaymentModel")
							.add(Restrictions.in("customerRequestModel", finalCustomerRequestModel));
					List<IssuePaymentModel> issuePayment = criteria.list();
					if(criteria != null) {
					for(IssuePaymentModel issuepayments : issuePayment) {
						if(issuepayments.getTxStatus().equals("SUCCESS")) {
						earning = earning + Double.parseDouble( issuepayments.getAmount());
						}
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
		return earning;
	}

	/* (non-Javadoc)
	 * @see com.ucs.rsa.daos.EmployeeDashboardRequestDAO#getEmployeeEarning(int)
	 */
	@Override
	public double getEmployeeEarning(int employeeId) {
		double earning = 0.0;
		Session theSession = null;
		try {
			theSession = currentSession();
				Criteria theCriteria = (Criteria) theSession.createCriteria(CustomerRequestModel.class, "customerRequestModel")
						.add(Restrictions.eq("employeeID", employeeId));
						
				if (theCriteria != null) {
					List<CustomerRequestModel> listOfCustomerRequest = theCriteria.list();
					List<CustomerRequestModel> finalCustomerRequestModel = new ArrayList<CustomerRequestModel>();
					for(CustomerRequestModel cusRequest:listOfCustomerRequest) {
						CustomerRequestModel cus = new CustomerRequestModel();
						cus.setIssueId(cusRequest.getIssueId());
						finalCustomerRequestModel.add(cus);
					}
					Criteria criteria = (Criteria) theSession.createCriteria(IssuePaymentModel.class, "customerRequestModel")
							.add(Restrictions.in("customerRequestModel", finalCustomerRequestModel));
					List<IssuePaymentModel> issuePayment = criteria.list();
					if(criteria!=null) {
					for(IssuePaymentModel issuepayments : issuePayment) {
						if(issuepayments.getTxStatus().equals("SUCCESS")) {
						earning = earning + Double.parseDouble( issuepayments.getAmount());
						}
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
		return earning;
	}

}
