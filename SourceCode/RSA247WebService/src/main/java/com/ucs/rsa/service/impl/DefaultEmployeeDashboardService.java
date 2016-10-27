/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ucs.rsa.daos.EmployeeDashboardRequestDAO;
import com.ucs.rsa.service.EmployeeDashboardService;


/**
 * The Class DefaultEmployeeDashboardService.
 */
@Service
public class DefaultEmployeeDashboardService extends DefaultBaseService implements EmployeeDashboardService
{

	/** The employee dashboard request DAO. */
	@Autowired
	@Qualifier("defaultEmployeeDashboardDAO")
	EmployeeDashboardRequestDAO employeeDashboardRequestDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.EmployeeDashboardService#getCompletedOrRejectedCount(java.lang.String, int)
	 */
	@Override
	public int getCompletedOrRejectedCount(String status, int employeeId)
	{
		int count = 0;
		if (status != null && employeeId != 0)
		{
			count = employeeDashboardRequestDAO.getCompletedOrRejectedCount(status, employeeId);
		}
		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.EmployeeDashboardService#getEmployeeRating(int)
	 */
	@Override
	public double getEmployeeRating(int employeeId)
	{
		double rating = 0;
		if (employeeId != 0)
		{
			rating = employeeDashboardRequestDAO.getEmployeeRating(employeeId);
		}
		return rating;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.EmployeeDashboardService#getEmployeeFromServiceProviderId(int)
	 */
	@Override
	public List<Integer> getEmployeeFromServiceProviderId(int serviceProviderId)
	{
		List<Integer> employees = null;
		if (serviceProviderId != 0)
		{
			employees = employeeDashboardRequestDAO.getEmployeeFromServiceProviderId(serviceProviderId);
		}
		return employees;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.EmployeeDashboardService#getCompletedOrRejectedCountForServiceProvider(java.lang.String,
	 * java.util.List)
	 */
	@Override
	public int getCompletedOrRejectedCountForServiceProvider(String status, List<Integer> employees)
	{
		int count = 0;
		if (status != null && employees != null)
		{
			count = employeeDashboardRequestDAO.getCompletedOrRejectedCountForServiceProvider(status, employees);
		}
		return count;
	}
	
	/* (non-Javadoc)
	 * @see com.ucs.rsa.service.EmployeeDashboardService#getServiceProviderEarning(java.util.List)
	 */
	@Override
	public double getServiceProviderEarning(List<Integer> employees) {
		double earning =0;
		if(employees!=null) {
			earning = employeeDashboardRequestDAO.getServiceProviderEarning(employees);
		}
		return earning;
	}

	/* (non-Javadoc)
	 * @see com.ucs.rsa.service.EmployeeDashboardService#getEmployeeEarning(int)
	 */
	@Override
	public double getEmployeeEarning(int employeeId) {
		double earning =0;
		if(employeeId!=0) {
			earning = employeeDashboardRequestDAO.getEmployeeEarning(employeeId);
		}
		return earning;
	}

}
