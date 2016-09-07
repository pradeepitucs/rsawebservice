package com.ucs.rsa.daos;

import java.util.ArrayList;
import java.util.List;

import com.ucs.rsa.model.EmployeeModel;

public interface EmployeeDashboardRequestDAO extends BaseDAO {
	
	public int getCompletedOrRejectedCount(String status, int employeeId);
	
	public double getEmployeeRating(int employeeId);
	
	public List<EmployeeModel> getEmployeeFromServiceProviderId(int serviceProviderId);
	
	public int getCompletedOrRejectedCountForServiceProvider(String status,List<EmployeeModel> employees);

}
