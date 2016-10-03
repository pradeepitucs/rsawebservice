package com.ucs.rsa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ucs.rsa.daos.EmployeeDashboardRequestDAO;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.service.EmployeeDashboardService;

@Service
public class DefaultEmployeeDashboardService extends DefaultBaseService implements EmployeeDashboardService{

	@Autowired
	@Qualifier("defaultEmployeeDashboardDAO")
	EmployeeDashboardRequestDAO employeeDashboardRequestDAO;
	
	@Override
	public int getCompletedOrRejectedCount(String status, int employeeId) {
		int count =0;
		if(status!=null && employeeId!=0) {
			count = employeeDashboardRequestDAO.getCompletedOrRejectedCount(status, employeeId);
		}
		return count;
	}

	@Override
	public double getEmployeeRating(int employeeId) {
		double rating =0;
		if( employeeId!=0) {
			rating = employeeDashboardRequestDAO.getEmployeeRating(employeeId);
		}
		return rating;
	}

	@Override
	public List<Integer> getEmployeeFromServiceProviderId(int serviceProviderId) {
		List<Integer> employees =null;
		if( serviceProviderId!=0) {
			employees = employeeDashboardRequestDAO.getEmployeeFromServiceProviderId(serviceProviderId);
		}
		return employees;
	}

	@Override
	public int getCompletedOrRejectedCountForServiceProvider(String status, List<Integer> employees) {
		int count =0;
		if(status!=null && employees!=null) {
			count = employeeDashboardRequestDAO.getCompletedOrRejectedCountForServiceProvider(status, employees);
		}
		return count;
	}

}
