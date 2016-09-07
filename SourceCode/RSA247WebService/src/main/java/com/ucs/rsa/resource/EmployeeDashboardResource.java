package com.ucs.rsa.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ucs.rsa.common.dto.EmployeeDashboard;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.ServiceProviderModel;
import com.ucs.rsa.service.EmployeeDashboardService;

@Controller
@RequestMapping("/dashboard")
public class EmployeeDashboardResource {
	
	@Autowired
	private EmployeeDashboardService employeeDashboardService;
	
	public EmployeeDashboardService getEmployeeDashboardService() {
		return employeeDashboardService;
	}

	public void setEmployeeDashboardService(EmployeeDashboardService employeeDashboardService) {
		this.employeeDashboardService = employeeDashboardService;
	}

	@RequestMapping(value = "/employeeDashboardDetail", method = { RequestMethod.POST })
	private ModelAndView employeeDashboardDetail(@RequestParam("employeeId") final int employeeId){
	EmployeeModel employee = new EmployeeModel();
	employee = getEmployeeDashboardService().get(EmployeeModel.class, employeeId);
	int completedCount = 0;
	int rejectedCount = 0;
	double completedInParcentage = 0.0;
	double rating = 0.0;
	if(employee.isOnwer()){
		List<EmployeeModel> employees = getEmployeeDashboardService().getEmployeeFromServiceProviderId(employee.getServiceProviderID());
		completedCount = getEmployeeDashboardService().getCompletedOrRejectedCountForServiceProvider("Completed",employees);
		rejectedCount = getEmployeeDashboardService().getCompletedOrRejectedCountForServiceProvider("Rejected", employees);
		if(completedCount != 0 || rejectedCount != 0) {
			completedInParcentage = (completedCount*100)/(completedCount + rejectedCount);
		} 
		ServiceProviderModel serviceProviderModel =  new ServiceProviderModel();
		serviceProviderModel= getEmployeeDashboardService().get(ServiceProviderModel.class, employee.getServiceProviderID());
		rating = serviceProviderModel.getRating();
	} else {
		completedCount = getEmployeeDashboardService().getCompletedOrRejectedCount("Completed",employeeId);
		rejectedCount = getEmployeeDashboardService().getCompletedOrRejectedCount("Rejected", employeeId);
		if(completedCount != 0 || rejectedCount != 0) {
			completedInParcentage = (completedCount*100)/(completedCount + rejectedCount);
		} 
		rating = getEmployeeDashboardService().getEmployeeRating(employeeId);
	}
	EmployeeDashboard employeeDashboard = new EmployeeDashboard();
	employeeDashboard.setCompletedIssue(completedCount);
	employeeDashboard.setRejectedIssue(rejectedCount);
	employeeDashboard.setCompletedIssueInPercentage(completedInParcentage);
	employeeDashboard.setRating(rating);
	return new ModelAndView("xml", "employeeDashboard", employeeDashboard);
		
	}


}
