package com.ucs.rsa.service;

import java.util.ArrayList;
import java.util.List;

import com.ucs.rsa.model.EmployeeModel;

public interface EmployeeDashboardService extends BaseService {
	
	public int getCompletedOrRejectedCount(String status, int employeeId);
	
	public double getEmployeeRating(int employeeId);
	
	public List<EmployeeModel> getEmployeeFromServiceProviderId(int serviceProviderId);
	
	public int getCompletedOrRejectedCountForServiceProvider(String status,List<EmployeeModel> employees);

}
