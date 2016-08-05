package com.ucs.rsa.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.ucs.rsa.model.AmbulanceRequest;
import com.ucs.rsa.model.ServiceTypeModel;
import com.ucs.rsa.model.UserModel;
import com.ucs.rsa.service.ICustomerRequestService;
@Controller
@RequestMapping("/ambulance")
public class AmbulanceController {

	@Autowired
	private ICustomerRequestService customerRequestService;


	public ICustomerRequestService getCustomerRequestService() {
		return customerRequestService;
	}


	public void setCustomerRequestService(ICustomerRequestService customerRequestService) {
		this.customerRequestService = customerRequestService;
	}


	@RequestMapping(value = "/update", method = { RequestMethod.POST })
	private ModelAndView updateUser(@RequestParam("issueId") final int issueId,
			@RequestParam("issueTypeId") final int issueTypeId,
			@RequestParam("customerLatitude") final double customerLatitude,
			@RequestParam("customerLongitude") final double customerLongitude,
			@RequestParam("userId") final int userId,
			@RequestParam("issueStatus") final String issueStatus,
			@RequestParam("amount") final long amount,
			@RequestParam("employeeId") final int employeeId) {

		System.out.println("ddd");
		AmbulanceRequest ambulanceRequest = new AmbulanceRequest();
		ambulanceRequest.setAmount(amount);
		ambulanceRequest.setCustomerLatitude(customerLatitude);
		ambulanceRequest.setCustomerLongitude(customerLongitude);
		ambulanceRequest.setEmployeeId(employeeId);
		ambulanceRequest.setIssueId(issueId);
		ambulanceRequest.setIssueStatus(issueStatus);
		ServiceTypeModel serverType = new ServiceTypeModel();
		serverType.setServiceTypeId(issueTypeId);
		ambulanceRequest.setServiceTypeModel(serverType);
		UserModel userModel = new UserModel();
		userModel.setUserId(userId);
		ambulanceRequest.setUserModel(userModel);

		AmbulanceRequest ambulanceRequests = getCustomerRequestService()
				.updateAmbulanceRequest(ambulanceRequest, true);
		return new ModelAndView("xml", "customerRequestDTO", ambulanceRequests);

	}

}
