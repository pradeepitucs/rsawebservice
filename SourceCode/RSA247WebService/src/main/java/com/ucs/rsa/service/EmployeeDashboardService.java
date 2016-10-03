package com.ucs.rsa.service;

import java.util.ArrayList;
import java.util.List;

import com.ucs.rsa.model.EmployeeModel;

public interface EmployeeDashboardService extends BaseService {
	
	public int getCompletedOrRejectedCount(String status, int employeeId);
	
	public double getEmployeeRating(int employeeId);
	
	public List<Integer> getEmployeeFromServiceProviderId(int serviceProviderId);
	
	public int getCompletedOrRejectedCountForServiceProvider(String status,List<Integer> employees);

}
