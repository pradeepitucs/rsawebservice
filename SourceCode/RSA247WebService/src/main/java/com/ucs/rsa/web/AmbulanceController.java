package com.ucs.rsa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ucs.rsa.common.dto.AmbulanceRequestDTO;
import com.ucs.rsa.common.dto.CustomerRequestDTO;
import com.ucs.rsa.service.ICityService;
import com.ucs.rsa.service.ICustomerRequestService;

@Controller
@RequestMapping("/ambulance")
public class AmbulanceController {
	
	@Autowired
	private ICustomerRequestService customerRequestService;
	
	@RequestMapping(value = "/update", method = { RequestMethod.POST , RequestMethod.GET})
	private ModelAndView updateUser(@RequestParam("issueId") final int issueId,
			@RequestParam("issueType") final String issueType,
			@RequestParam("customerLatitude") final double customerLatitude,
			@RequestParam("customerLongitude") final double customerLongitude,
			@RequestParam("userId") final int userId,
			@RequestParam("issueStatus") final String issueStatus,
			@RequestParam("amount") final long amount,
			@RequestParam("employeeId") final int employeeId) {
		
		AmbulanceRequestDTO ambulanceRequest =  new AmbulanceRequestDTO();
		ambulanceRequest.setAmount(amount);
		ambulanceRequest.setCustomerLatitude(customerLatitude);
		ambulanceRequest.setCustomerLongitude(customerLongitude);
		ambulanceRequest.setEmployeeId(employeeId);
		ambulanceRequest.setIssueId(issueId);
		ambulanceRequest.setIssueStatus(issueStatus);
		ambulanceRequest.setIssueType(issueType);
		ambulanceRequest.setUserId(userId);
		
		CustomerRequestDTO customerRequest = customerRequestService.updateCustomerRequest(ambulanceRequest, true);
		System.out.println("CustomerRequestDTO " + customerRequest);
		
		return new ModelAndView("xml", "customerRequestDTO", customerRequest);
		
	}

}
