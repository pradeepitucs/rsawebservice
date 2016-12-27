package com.ucs.rsa.daos.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.daos.CustomerServiceRequestDAO;
import com.ucs.rsa.model.CustomerServiceRequestModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.ServiceProviderModel;
import com.ucs.rsa.model.ServiceProviderServiceMatchingModel;
import com.ucs.rsa.model.ServiceTypeModel;

/**
 * The Class DefaultCustomerServiceRequestDAO.
 */
@Repository(value = "customerServiceRequestDAO")
public class DefaultCustomerServiceRequestDAO extends DefaultBaseDAO implements CustomerServiceRequestDAO{

	@Override
	public CustomerServiceRequestModel updateCustomerServiceRequest(CustomerServiceRequestModel iCustomerRequestModel) {
		CustomerServiceRequestModel customerRequestModel = iCustomerRequestModel;
		Session theSession = null;
		try {
			theSession = currentSession();
			if(customerRequestModel.getCustomerServiceRequestID()==0) {
				CustomerServiceRequestModel customerReq = (CustomerServiceRequestModel) theSession
						.createCriteria(CustomerServiceRequestModel.class, "customerServiceRequestModel")
						.add(Restrictions.eq("customerServiceRequestID", iCustomerRequestModel.getCustomerServiceRequestID())).uniqueResult();
				if(customerReq!=null){
					System.out.println("rsaException");
					RSAException rsaException = new RSAException();
					System.out.println("rsaException" + rsaException);
					rsaException.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
					throw rsaException;
				}
			}
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
	
	@Override
	public ArrayList<ServiceProviderModel> getServiceProviders(ArrayList<Double> ratingArray, int serviceTypeId) {
		Session theSession = null;
		List<ServiceProviderModel> serviceProviderIDList = new ArrayList<ServiceProviderModel>();
		try {
			theSession = currentSession();

			Criteria cr = (Criteria) theSession.createCriteria(ServiceProviderModel.class, "customerModel")
					.add(Restrictions.between("serviceProviderLatitude", ratingArray.get(2),
							ratingArray.get(3)))
					.add(Restrictions.between("serviceProviderLongitude", ratingArray.get(4),
							ratingArray.get(5)))
					.add(Restrictions.between("rating", ratingArray.get(0), ratingArray.get(1)))
					.add(Restrictions.eq("isEnabled", true));
			@SuppressWarnings("unchecked")
			List<ServiceProviderModel> serviceProviderList = cr.list();
			
			for (ServiceProviderModel serviceProviderModel : serviceProviderList) {
					ServiceProviderModel serviceProviderModel2 =  new ServiceProviderModel();
					serviceProviderModel2.setServiceProviderId(serviceProviderModel.getServiceProviderId());
					ServiceTypeModel serviceTypeModel =  new ServiceTypeModel();
					serviceTypeModel.setServiceTypeId(serviceTypeId);
					Criteria crit = (Criteria) theSession.createCriteria(ServiceProviderServiceMatchingModel.class, "customerModel")
							.add(Restrictions.eq("serviceTypeModel", serviceTypeModel))
							.add(Restrictions.eq("serviceProviderModel", serviceProviderModel2));
					List<ServiceProviderServiceMatchingModel> listOfOtherService = crit.list();
					for (ServiceProviderServiceMatchingModel serviceProviderServiceMatchingModel : listOfOtherService) {
						serviceProviderIDList.add(serviceProviderServiceMatchingModel.getServiceProviderModel());
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
		return (ArrayList<ServiceProviderModel>) serviceProviderIDList;
	}

	@Override
	public CustomerServiceRequestModel updateVehicleServiceType(
			CustomerServiceRequestModel customerServiceRequestmodel) {
		CustomerServiceRequestModel customerReq ;
		Session theSession = null;
		try {
			theSession = currentSession();
				 customerReq = (CustomerServiceRequestModel) theSession
						.createCriteria(CustomerServiceRequestModel.class, "customerServiceRequestModel")
						.add(Restrictions.eq("customerServiceRequestID", customerServiceRequestmodel.getCustomerServiceRequestID())).uniqueResult();
				if(customerReq!=null){
					customerReq.setVehicleServiceTypeID(customerServiceRequestmodel.getVehicleServiceTypeID());
					theSession.saveOrUpdate(customerReq);
				}
			
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return customerReq;
	}

	@Override
	public ArrayList<EmployeeModel> getEmployees(int serviceProviderId) {
		ArrayList<EmployeeModel> employees = null;
		Session theSession = null;
		try {
			theSession = currentSession();
			Criteria employee = (Criteria) theSession
					.createCriteria(EmployeeModel.class, "employeeModel")
					.add(Restrictions.eq("serviceProviderID", serviceProviderId));
			if(employee!=null){
				employees = (ArrayList<EmployeeModel>) employee.list();
			}
		}catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return employees;
	}

}
