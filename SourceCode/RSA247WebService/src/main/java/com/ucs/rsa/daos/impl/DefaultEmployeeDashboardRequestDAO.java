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
import com.ucs.rsa.model.ServiceProviderModel;

@Repository(value="defaultEmployeeDashboardDAO")
public class DefaultEmployeeDashboardRequestDAO extends DefaultBaseDAO implements EmployeeDashboardRequestDAO{

	@Override
	public int getCompletedOrRejectedCount(String status, int employeeId) {
		int count =0;
		Session theSession = null;
		try {
			theSession = currentSession();
			EmployeeModel employee =  new EmployeeModel();
			employee.setUserId(employeeId);
				Criteria theCriteria = (Criteria) theSession.createCriteria(CustomerRequestModel.class, "customerRequestModel")
						.add(Restrictions.eq("employeeID", employee))
						.add(Restrictions.eq("issueStatus", status));
				if (theCriteria != null) {
					List<CustomerRequestModel> listOfCustomerRequest = theCriteria.list();
					count = listOfCustomerRequest.size();
				}
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return count;
	}

	@Override
	public double getEmployeeRating(int employeeId) {
		double rating =0;
		Session theSession = null;
		try {
			theSession = currentSession();
			EmployeeModel employee =  new EmployeeModel();
			employee.setUserId(employeeId);
				Criteria theCriteria = (Criteria) theSession.createCriteria(CustomerReviewModel.class, "customerRequestModel")
						.add(Restrictions.eq("employeeID", employee));
				if (theCriteria != null) {
					List<CustomerReviewModel> listOfCustomerReview = theCriteria.list();
					int size = listOfCustomerReview.size();
					double totalRating = 0.0;
					for (CustomerReviewModel customerReviewModel : listOfCustomerReview) {
						totalRating = totalRating + customerReviewModel.getRating();
					}
					rating = totalRating/size;
				}
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return rating;
	}

	@Override
	public List<EmployeeModel> getEmployeeFromServiceProviderId(int serviceProviderId) {
		List<EmployeeModel> employees =null;
		Session theSession = null;
		try {
			theSession = currentSession();
				Criteria theCriteria = (Criteria) theSession.createCriteria(EmployeeModel.class, "employeeModel")
						.add(Restrictions.eq("serviceProviderID", serviceProviderId))
				.setProjection(Projections.projectionList().add(Projections.property("userId"),
						"userId"))
				.setResultTransformer(Transformers.aliasToBean(EmployeeModel.class));
				if (theCriteria != null) {
					employees = theCriteria.list();
				}
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return employees;
	}

	@Override
	public int getCompletedOrRejectedCountForServiceProvider(String status, List<EmployeeModel> employees) {
		int count =0;
		Session theSession = null;
		try {
			theSession = currentSession();
				Criteria theCriteria = (Criteria) theSession.createCriteria(CustomerRequestModel.class, "customerRequestModel")
						.add(Restrictions.in("employeeID", employees))
						.add(Restrictions.eq("issueStatus", status));
						
				if (theCriteria != null) {
					List<CustomerRequestModel> listOfCustomerRequest = theCriteria.list();
					count = listOfCustomerRequest.size();
				}
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return count;
	}

}
