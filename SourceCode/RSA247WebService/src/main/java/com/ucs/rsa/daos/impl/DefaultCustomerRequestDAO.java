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
import com.ucs.rsa.model.CustomerRequestModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.ServiceProviderModel;

@Repository(value = "customerRequestDAO")
public class DefaultCustomerRequestDAO extends DefaultBaseDAO implements CustomerRequestDAO {

	@Override
	public CustomerRequestModel updateCustomerRequest(CustomerRequestModel iCustomerRequestModel) {
		CustomerRequestModel customerRequestModel = iCustomerRequestModel;
		Session theSession = null;
		try {
			theSession = currentSession();
			theSession.saveOrUpdate(customerRequestModel);
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return customerRequestModel;
	}
	
	@SuppressWarnings("null")
	@Override
	public ArrayList<Integer> getServiceProviderIDS(ArrayList<Double> ratingAndLocation, String serviceType) {
		Session theSession = null;
		List<Integer> serviceProviderIDList =new  ArrayList<Integer>();
		try {
			theSession = currentSession();
			
			Criteria cr =  (Criteria) theSession.createCriteria(ServiceProviderModel.class, "customerModel")
			.add(Restrictions.between("serviceProviderLatitude", ratingAndLocation.get(2),ratingAndLocation.get(3)))
			.add(Restrictions.between("serviceProviderLongitude", ratingAndLocation.get(4), ratingAndLocation.get(5)))
			.add(Restrictions.between("rating", ratingAndLocation.get(0), ratingAndLocation.get(1)))
			.add(Restrictions.like("serviceproviderExperties", "%"+serviceType+"%"))
			.add(Restrictions.like("serviceProviderotherServices", "%"+serviceType+"%"))
			.setProjection(Projections.projectionList().add(Projections.property("userId"), "userId")).
			setResultTransformer(Transformers.aliasToBean(ServiceProviderModel.class));
			@SuppressWarnings("unchecked")
			List<ServiceProviderModel> serviceProviderList = cr.list();
			for(int i=0;i<serviceProviderList.size();i++) {
				serviceProviderIDList.add(serviceProviderList.get(i).getUserId());
			}
			 System.out.println(serviceProviderList);
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return (ArrayList<Integer>) serviceProviderIDList;
	}
	
	@SuppressWarnings("null")
	@Override
	public ArrayList<String> getDeviceIDSFromServiceProviderIDS(ArrayList<Integer> serviceProviderIDs) {
		Session theSession = null;
		List<String> deviceIDList = new ArrayList<String>();
		try {
			theSession = currentSession();
			
			Criteria cr =  (Criteria) theSession.createCriteria(EmployeeModel.class, "customerModel")
			.add(Restrictions.in("serviceProviderID", serviceProviderIDs))
			.setProjection(Projections.projectionList().add(Projections.property("gcmId"), "gcmId")).
			setResultTransformer(Transformers.aliasToBean(EmployeeModel.class));
			@SuppressWarnings("unchecked")
			List<EmployeeModel> employeeList = cr.list();
			for(int i=0;i<employeeList.size();i++){
				deviceIDList.add(employeeList.get(i).getGcmId());
			}
			 System.out.println(deviceIDList);
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return  (ArrayList<String>) deviceIDList;
	}

	@Override
	public String getIssueStatus(int issueID) {
		Session theSession = null;
		String issueStatus = null;
		try {
			theSession = currentSession();
			CustomerRequestModel ambulanceRequest =  (CustomerRequestModel) theSession.createCriteria(CustomerRequestModel.class, "customerModel")
			.add(Restrictions.eq("issueId", issueID))
			.setProjection(Projections.projectionList().add(Projections.property("issueStatus"), "issueStatus")).
			setResultTransformer(Transformers.aliasToBean(CustomerRequestModel.class));
			issueStatus = ambulanceRequest.getIssueStatus();
			 System.out.println(issueStatus);
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return  issueStatus;
	}

}
