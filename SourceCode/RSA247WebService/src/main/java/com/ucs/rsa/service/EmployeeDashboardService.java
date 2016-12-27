/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.service;

import java.util.List;



/**
 * The Interface EmployeeDashboardService.
 */
public interface EmployeeDashboardService extends BaseService
{

	/**
	 * Gets the completed or rejected count.
	 *
	 * @param status
	 *           the status
	 * @param employeeId
	 *           the employee id
	 * @return the completed or rejected count
	 */
	public int getCompletedOrRejectedCount(String status, int employeeId);

	/**
	 * Gets the employee rating.
	 *
	 * @param employeeId
	 *           the employee id
	 * @return the employee rating
	 */
	public double getEmployeeRating(int employeeId);

	/**
	 * Gets the employee from service provider id.
	 *
	 * @param serviceProviderId
	 *           the service provider id
	 * @return the employee from service provider id
	 */
	public List<Integer> getEmployeeFromServiceProviderId(int serviceProviderId);

	/**
	 * Gets the completed or rejected count for service provider.
	 *
	 * @param status
	 *           the status
	 * @param employees
	 *           the employees
	 * @return the completed or rejected count for service provider
	 */
	public int getCompletedOrRejectedCountForServiceProvider(String status, List<Integer> employees);
	
	/**
	 * Gets the service provider earning.
	 *
	 * @param employees the employees
	 * @return the service provider earning
	 */
	public double getServiceProviderEarning(List<Integer> employees);
	
	/**
	 * Gets the employee earning.
	 *
	 * @param employeeId the employee id
	 * @return the employee earning
	 */
	public double getEmployeeEarning(int employeeId);

}
