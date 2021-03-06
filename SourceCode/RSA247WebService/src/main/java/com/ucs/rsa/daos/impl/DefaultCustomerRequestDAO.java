package com.ucs.rsa.daos.impl;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.ucs.rsa.model.CustomerSubIssueModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.ServiceProviderCommentModel;
import com.ucs.rsa.model.ServiceProviderModel;
import com.ucs.rsa.model.ServiceProviderServiceMatchingModel;
import com.ucs.rsa.model.ServiceTypeModel;
import com.ucs.rsa.model.UserVehicleModel;

@Repository(value = "customerRequestDAO")
public class DefaultCustomerRequestDAO extends DefaultBaseDAO implements CustomerRequestDAO {

	@Override
	public CustomerRequestModel updateCustomerRequest(CustomerRequestModel iCustomerRequestModel) {
		CustomerRequestModel customerRequestModel = iCustomerRequestModel;
		Session theSession = null;
		try {
			theSession = currentSession();
			if(customerRequestModel.getIssueId()==0) {
				CustomerRequestModel customerReq = (CustomerRequestModel) theSession
						.createCriteria(CustomerRequestModel.class, "customerRequestModel")
						.add(Restrictions.eq("issueId", iCustomerRequestModel.getIssueId())).uniqueResult();
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
	public ArrayList<String> updateCustomerRequestByEmployee(CustomerRequestModel iCustomerRequestModel) {
		ArrayList<String> customerRequestResponse = new ArrayList<String>();
		Session theSession = null;
		try {
			theSession = currentSession();
			CustomerRequestModel customerRequestList = (CustomerRequestModel) theSession
					.createCriteria(CustomerRequestModel.class, "customerRequestModel")
					.add(Restrictions.eq("issueId", iCustomerRequestModel.getIssueId())).uniqueResult();
			// CustomerRequestModel customerRequestList = cr.list();
			int customer_id = customerRequestList.getCustomerModel().getUserId();
			customerRequestResponse.add(String.valueOf(customerRequestList.getCustomerModel().getUserId()));
			if (customerRequestList.getIssueStatus().equals("Open" )) {
				customerRequestList.setIssueStartTime(iCustomerRequestModel.getIssueStartTime());
				customerRequestList.setIssueStatus(iCustomerRequestModel.getIssueStatus());
				customerRequestList.setEmployeeID(iCustomerRequestModel.getEmployeeID());
				theSession.saveOrUpdate(customerRequestList);
				customerRequestResponse.add("Accepted");
			} else {
				customerRequestResponse.add("Accepted by other Person");
			}

		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return customerRequestResponse;
	}

	@SuppressWarnings("null")
	@Override
	public ArrayList<Integer> getServiceProviderIDS(ArrayList<Double> ratingAndLocation, int serviceType,String newTimeFormat) {
		Session theSession = null;
		List<Integer> serviceProviderIDList = new ArrayList<Integer>();
		try {
			theSession = currentSession();

			Criteria cr = (Criteria) theSession.createCriteria(ServiceProviderModel.class, "customerModel")
					.add(Restrictions.between("serviceProviderLatitude", ratingAndLocation.get(2),
							ratingAndLocation.get(3)))
					.add(Restrictions.between("serviceProviderLongitude", ratingAndLocation.get(4),
							ratingAndLocation.get(5)))
					.add(Restrictions.between("rating", ratingAndLocation.get(0), ratingAndLocation.get(1)))
					.add(Restrictions.eq("isEnabled", true));
					/*.setProjection(Projections.projectionList().add(Projections.property("serviceProviderId"),
							"serviceProviderId"))
					.setResultTransformer(Transformers.aliasToBean(ServiceProviderModel.class));*/
			@SuppressWarnings("unchecked")
			List<ServiceProviderModel> serviceProviderList = cr.list();
			List<ServiceProviderModel> serviceProviderFinalList = new ArrayList<ServiceProviderModel>();
			for(ServiceProviderModel serviceProviderModel : serviceProviderList){
				String[] times = serviceProviderModel.getServiceProvidertiming().split(",");
				try {
				    String string1 = times[0];
				    Date time1 = new SimpleDateFormat("H:m").parse(string1);
				    Calendar calendar1 = Calendar.getInstance();
				    calendar1.setTime(time1);
				    calendar1.add(Calendar.DATE, 1);

				    String string2 = times[1];
				    Date time2 = new SimpleDateFormat("H:m").parse(string2);
				    Calendar calendar2 = Calendar.getInstance();
				    calendar2.setTime(time2);
				    calendar2.add(Calendar.DATE, 1);

				    String someRandomTime = newTimeFormat;
				    Date d = new SimpleDateFormat("H:m").parse(someRandomTime);
				    Calendar calendar3 = Calendar.getInstance();
				    calendar3.setTime(d);
				    calendar3.add(Calendar.DATE, 1);

				    Date x = calendar3.getTime();
				    Date x1 = calendar2.getTime();
				    if(x1.before(calendar1.getTime()))
				    {
				    	calendar2.add(Calendar.HOUR, 24);
				    	x1 = calendar2.getTime();
				    }
				    if (x.after(calendar1.getTime()) && x.before(x1)) {
				        serviceProviderFinalList.add(serviceProviderModel);
				    }
				} catch (ParseException e) {
				    e.printStackTrace();
				}
			} 
			for (ServiceProviderModel serviceProviderModel : serviceProviderFinalList) {
				if(serviceProviderModel.getServiceTypeModel().getServiceTypeId()==serviceType) {
					serviceProviderIDList.add(serviceProviderModel.getServiceProviderId());
				} else {
					ServiceProviderModel serviceProviderModel2 =  new ServiceProviderModel();
					serviceProviderModel2.setServiceProviderId(serviceProviderModel.getServiceProviderId());
					ServiceTypeModel serviceTypeModel =  new ServiceTypeModel();
					serviceTypeModel.setServiceTypeId(serviceType);
					Criteria crit = (Criteria) theSession.createCriteria(ServiceProviderServiceMatchingModel.class, "customerModel")
							.add(Restrictions.eq("serviceTypeModel", serviceTypeModel))
							.add(Restrictions.eq("serviceProviderModel", serviceProviderModel2));
					List<ServiceProviderServiceMatchingModel> listOfOtherService = crit.list();
					for (ServiceProviderServiceMatchingModel serviceProviderServiceMatchingModel : listOfOtherService) {
						serviceProviderIDList.add(serviceProviderServiceMatchingModel.getServiceProviderModel().getServiceProviderId());
					}
				}
			}
			/*for (int i = 0; i < serviceProviderFinalList.size(); i++) {
				serviceProviderIDList.add(serviceProviderFinalList.get(i).getServiceProviderId());
			}*/
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

			Criteria cr = (Criteria) theSession.createCriteria(EmployeeModel.class, "customerModel")
					.add(Restrictions.in("serviceProviderID", serviceProviderIDs))
					.add(Restrictions.eq("isEnabled", true))
					.setProjection(Projections.projectionList().add(Projections.property("gcmId"), "gcmId"))
					.setResultTransformer(Transformers.aliasToBean(EmployeeModel.class));
			@SuppressWarnings("unchecked")
			List<EmployeeModel> employeeList = cr.list();
			for (int i = 0; i < employeeList.size(); i++) {
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
		return (ArrayList<String>) deviceIDList;
	}

	@Override
	public String getIssueStatus(int issueID) {
		Session theSession = null;
		String issueStatus = null;
		try {
			theSession = currentSession();
			CustomerRequestModel ambulanceRequest = (CustomerRequestModel) theSession
					.createCriteria(CustomerRequestModel.class, "customerModel")
					.add(Restrictions.eq("issueId", issueID))
					.setProjection(Projections.projectionList().add(Projections.property("issueStatus"), "issueStatus"))
					.setResultTransformer(Transformers.aliasToBean(CustomerRequestModel.class)).uniqueResult();
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
		return issueStatus;
	}

	@Override
	public String getGCMIDFromCustomerID(int customerId) {
		Session theSession = null;
		String gcmID = null;
		try {
			theSession = currentSession();
			CustomerModel customerModel = (CustomerModel) theSession
					.createCriteria(CustomerModel.class, "customerModel").add(Restrictions.eq("userId", customerId))
					.setProjection(Projections.projectionList().add(Projections.property("gcmId"), "gcmId"))
					.setResultTransformer(Transformers.aliasToBean(CustomerModel.class)).uniqueResult();
			gcmID = customerModel.getGcmId();
			System.out.println(gcmID);
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return gcmID;
	}

	@Override
	public int getServiceProviderIDFromEmployeeID(int employeeID) {
		Session theSession = null;
		int serviceProviderID = 0;
		try {
			theSession = currentSession();
			EmployeeModel employeeModel = (EmployeeModel) theSession
					.createCriteria(EmployeeModel.class, "customerModel").add(Restrictions.eq("userId", employeeID))
					.setProjection(Projections.projectionList().add(Projections.property("serviceProviderID"),
							"serviceProviderID"))
					.setResultTransformer(Transformers.aliasToBean(EmployeeModel.class)).uniqueResult();
			serviceProviderID = employeeModel.getServiceProviderID();
			System.out.println(serviceProviderID);
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return serviceProviderID;
	}

	@Override
	public ArrayList<Double> getServiceProviderLocationFromServiceProviderId(int serviceProviderID) {
		Session theSession = null;
		ArrayList<Double> location = new ArrayList<Double>();
		try {
			theSession = currentSession();
			ServiceProviderModel serviceProviderModel = (ServiceProviderModel) theSession
					.createCriteria(ServiceProviderModel.class, "customerModel")
					.add(Restrictions.eq("serviceProviderId", serviceProviderID))
					.setProjection(Projections.projectionList()
							.add(Projections.property("serviceProviderLatitude"), "serviceProviderLatitude")
							.add(Projections.property("serviceProviderLongitude"), "serviceProviderLongitude"))
					.setResultTransformer(Transformers.aliasToBean(ServiceProviderModel.class)).uniqueResult();
			location.add(serviceProviderModel.getServiceProviderLatitude());
			location.add(serviceProviderModel.getServiceProviderLongitude());
			System.out.println(serviceProviderID);
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return location;
	}

	@Override
	public EmployeeModel getEmployeeDataFromEmployeeID(int employeeID) {
		Session theSession = null;
		EmployeeModel employeeModel = null;
		try {
			theSession = currentSession();
			employeeModel = (EmployeeModel) theSession.createCriteria(EmployeeModel.class, "customerModel")
					.add(Restrictions.eq("userId", employeeID)).uniqueResult();
			System.out.println(employeeModel);
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
	public CustomerRequestModel updateCustomerIssueAfterAccepting(CustomerRequestModel iCustomerRequestModel) {
		CustomerRequestModel customerRequest = null;
		Session theSession = null;
		try {
			theSession = currentSession();
			customerRequest = (CustomerRequestModel) theSession
					.createCriteria(CustomerRequestModel.class, "customerRequestModel")
					.add(Restrictions.eq("issueId", iCustomerRequestModel.getIssueId())).uniqueResult();
			customerRequest.setIssueStatus(iCustomerRequestModel.getIssueStatus());
			customerRequest.setEmployeeID(iCustomerRequestModel.getEmployeeID());
			theSession.saveOrUpdate(customerRequest);
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return customerRequest;
	}

	@Override
	public UserVehicleModel getUserVehicle(int customerID) {
		UserVehicleModel userVehicleModel = null;
		Session theSession = null;
		try {
			theSession = currentSession();
			Criteria ca = (Criteria) theSession
					.createCriteria(UserVehicleModel.class, "customerRequestModel")
					.add(Restrictions.eq("userId", customerID));
			@SuppressWarnings("unchecked")
			List<UserVehicleModel> listOfUserVehicle = ca.list();
			userVehicleModel = listOfUserVehicle.get(0);
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return userVehicleModel;
	}

	@Override
	public CustomerRequestModel updateCustomerIssueByServiceProvider(CustomerRequestModel customerRequestModel,
			ArrayList<CustomerSubIssueModel> customerSubIssueModelList,
			ServiceProviderCommentModel serviceProviderCommentModel) {
		CustomerRequestModel customerRequestList = null;
		Session theSession = null;
		try {
			theSession = currentSession();
			customerRequestList = (CustomerRequestModel) theSession
					.createCriteria(CustomerRequestModel.class, "customerRequestModel")
					.add(Restrictions.eq("issueId", customerRequestModel.getIssueId())).uniqueResult();
			customerRequestList.setIssueStatus(customerRequestModel.getIssueStatus());
			if(customerRequestList.getCustomerVehicleNumber()!=null && customerRequestList.getCustomerVehicleNumber().equalsIgnoreCase(customerRequestList.getCustomerVehicleNumber())){
				
			} else {
				customerRequestList.setCustomerVehicleNumber(customerRequestModel.getCustomerVehicleNumber());
			}
			theSession.saveOrUpdate(customerRequestList);
			for(int i=0;i<customerSubIssueModelList.size();i++) {
				theSession.saveOrUpdate(customerSubIssueModelList.get(i));
			}
			if(serviceProviderCommentModel.getServiceProviderComment()!=null && !serviceProviderCommentModel.getServiceProviderComment().isEmpty()) {
			theSession.saveOrUpdate(serviceProviderCommentModel);
			}
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return customerRequestList;
	}

	@Override
	public CustomerRequestModel rejectCustomerIssue(CustomerRequestModel customerRequestModel,
			ServiceProviderCommentModel serviceProviderCommentModel) {
		CustomerRequestModel customerRequestList = null;
		Session theSession = null;
		try {
			theSession = currentSession();
			customerRequestList = (CustomerRequestModel) theSession
					.createCriteria(CustomerRequestModel.class, "customerRequestModel")
					.add(Restrictions.eq("issueId", customerRequestModel.getIssueId())).uniqueResult();
			customerRequestList.setIssueStatus(customerRequestModel.getIssueStatus());
			theSession.saveOrUpdate(customerRequestList);
			if(serviceProviderCommentModel.getServiceProviderComment()!=null && !serviceProviderCommentModel.getServiceProviderComment().isEmpty()) {
			theSession.saveOrUpdate(serviceProviderCommentModel);
			}
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return customerRequestList;
	}

	@Override
	public List<ServiceTypeModel> getCompletedService(int issueID,CustomerRequestModel customerRequestModel) {
		CustomerRequestModel customerRequestList = new CustomerRequestModel();
		customerRequestList.setIssueId(issueID);
		List<ServiceTypeModel> listOfServiceType = new ArrayList<>();
		Session theSession = null;
		try {
			theSession = currentSession();
			customerRequestList = (CustomerRequestModel) theSession
					.createCriteria(CustomerRequestModel.class, "customerRequestModel")
					.add(Restrictions.eq("issueId", customerRequestModel.getIssueId())).uniqueResult();
			customerRequestList.setIssueStatus(customerRequestModel.getIssueStatus());
			theSession.saveOrUpdate(customerRequestList);
			Criteria criteria = (Criteria) theSession
					.createCriteria(CustomerSubIssueModel.class, "customerRequestModel")
					.add(Restrictions.eq("customerRequestModel", customerRequestList));
			List<CustomerSubIssueModel> listOfSubIssue = criteria.list();
			boolean status = false;
			for(CustomerSubIssueModel customerSubissue : listOfSubIssue){
			
				ServiceTypeModel serviceType = new ServiceTypeModel();
				serviceType = customerSubissue.getServiceTypeModel();
				if(status==false){
				if(serviceType.getServiceTypeId()==3 || serviceType.getServiceTypeId()==4 ||
						serviceType.getServiceTypeId()==5 || serviceType.getServiceTypeId()==6 ||
								serviceType.getServiceTypeId()==7 || serviceType.getServiceTypeId()==8) {
					
					status = true;
					try {
						String string1 = "08:00:00";
					    Date time1 = new SimpleDateFormat("HH:mm:ss").parse(string1);
					    Calendar calendar1 = Calendar.getInstance();
					    calendar1.setTime(time1);

					    String string2 = "19:00:00";
					    Date time2 = new SimpleDateFormat("HH:mm:ss").parse(string2);
					    Calendar calendar2 = Calendar.getInstance();
					    calendar2.setTime(time2);
					    calendar2.add(Calendar.DATE, 1);
					    
					    java.sql.Time time = customerRequestList.getIssueTime();
					    DateFormat df = new SimpleDateFormat("HH:mm:ss");
					    String someRandomTime = df.format(time);
					    String text = "01:00:00";
					    Date d = new SimpleDateFormat("HH:mm:ss").parse(someRandomTime);
						Calendar calendar3 = Calendar.getInstance();
					    calendar3.setTime(d);
					    calendar3.add(Calendar.DATE, 1);

					    Date x = calendar3.getTime();
					    if (x.after(calendar1.getTime()) && x.before(calendar2.getTime())) {
					        //checkes whether the current time is between 14:49:00 and 20:11:13.
					       
					        	ServiceTypeModel serviceTypeModel = (ServiceTypeModel) theSession
										.createCriteria(ServiceTypeModel.class, "serviceTypeModel")
										.add(Restrictions.eq("serviceTypeId", 9)).uniqueResult();
								 listOfServiceType.add(serviceTypeModel);
					       
					    } else {
					    	ServiceTypeModel serviceTypeModel = (ServiceTypeModel) theSession
									.createCriteria(ServiceTypeModel.class, "serviceTypeModel")
									.add(Restrictions.eq("serviceTypeId", 10)).uniqueResult();
							 listOfServiceType.add(serviceTypeModel);
					    }
					} catch (ParseException e) {
						e.printStackTrace();
					}			    
				}
			}
				ServiceTypeModel serviceTypeModel = (ServiceTypeModel) theSession
						.createCriteria(ServiceTypeModel.class, "serviceTypeModel")
						.add(Restrictions.eq("serviceTypeId", serviceType.getServiceTypeId())).uniqueResult();
				 listOfServiceType.add(serviceTypeModel);
			}
			
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return listOfServiceType;
	}

	@SuppressWarnings("null")
	@Override
	public List<ServiceTypeModel> getPaymentDetail(int issueID) {
		CustomerRequestModel customerRequestList = new CustomerRequestModel();
		customerRequestList.setIssueId(issueID);
		List<ServiceTypeModel> listOfServiceType = new ArrayList<>();
		Session theSession = null;
		try {
			theSession = currentSession();
			CustomerRequestModel customer = new CustomerRequestModel();
			customer.setIssueId(issueID);
			Criteria criteria = (Criteria) theSession
					.createCriteria(CustomerSubIssueModel.class, "customerRequestModel")
					.add(Restrictions.eq("customerRequestModel", customer));
			List<CustomerSubIssueModel> listOfSubIssue = criteria.list();
			boolean status = false;
			for(CustomerSubIssueModel customerSubissue : listOfSubIssue){
				
				ServiceTypeModel serviceType = new ServiceTypeModel();
				serviceType = customerSubissue.getServiceTypeModel();
				if(status == false){
				if(serviceType.getServiceTypeId()==3 || serviceType.getServiceTypeId()==4 ||
						serviceType.getServiceTypeId()==5 || serviceType.getServiceTypeId()==6 ||
								serviceType.getServiceTypeId()==7 || serviceType.getServiceTypeId()==8) {
					status = true;
					
					try {
						String string1 = "08:00:00";
					    Date time1 = new SimpleDateFormat("HH:mm:ss").parse(string1);
					    Calendar calendar1 = Calendar.getInstance();
					    calendar1.setTime(time1);

					    String string2 = "19:00:00";
					    Date time2 = new SimpleDateFormat("HH:mm:ss").parse(string2);
					    Calendar calendar2 = Calendar.getInstance();
					    calendar2.setTime(time2);
					    calendar2.add(Calendar.DATE, 1);
					    
					    CustomerRequestModel customerRequest = (CustomerRequestModel) theSession
								.createCriteria(CustomerRequestModel.class, "serviceTypeModel")
								.add(Restrictions.eq("issueId", issueID)).uniqueResult();
					    java.sql.Time time = customerRequest.getIssueTime();
					    DateFormat df = new SimpleDateFormat("HH:mm:ss");
					    String someRandomTime = df.format(time);
					    Date d = new SimpleDateFormat("HH:mm:ss").parse(someRandomTime);
						Calendar calendar3 = Calendar.getInstance();
					    calendar3.setTime(d);
					    calendar3.add(Calendar.DATE, 1);

					    Date x = calendar3.getTime();
					    if (x.after(calendar1.getTime()) && x.before(calendar2.getTime())) {
					        //checkes whether the current time is between 14:49:00 and 20:11:13.
					       
					        	ServiceTypeModel serviceTypeModel = (ServiceTypeModel) theSession
										.createCriteria(ServiceTypeModel.class, "serviceTypeModel")
										.add(Restrictions.eq("serviceTypeId", 9)).uniqueResult();
								 listOfServiceType.add(serviceTypeModel);
					       
					    } else {
					    	ServiceTypeModel serviceTypeModel = (ServiceTypeModel) theSession
									.createCriteria(ServiceTypeModel.class, "serviceTypeModel")
									.add(Restrictions.eq("serviceTypeId", 10)).uniqueResult();
							 listOfServiceType.add(serviceTypeModel);
					    }
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    
				}
			}
				//serviceTypeId.add(serviceType.getServiceTypeId());
				ServiceTypeModel serviceTypeModel = (ServiceTypeModel) theSession
						.createCriteria(ServiceTypeModel.class, "serviceTypeModel")
						.add(Restrictions.eq("serviceTypeId", serviceType.getServiceTypeId())).uniqueResult();
				 listOfServiceType.add(serviceTypeModel);
			}
			
		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return listOfServiceType;
	}

}
