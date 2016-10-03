package com.ucs.rsa.daos;


import java.util.List;

import com.ucs.rsa.model.EmployeeModel;

public interface EmployeeDashboardRequestDAO extends BaseDAO {
	
	public int getCompletedOrRejectedCount(String status, int employeeId);
	
	public double getEmployeeRating(int employeeId);
	
	public List<Integer> getEmployeeFromServiceProviderId(int serviceProviderId);
	
	public int getCompletedOrRejectedCountForServiceProvider(String status,List<Integer> employees);

}
