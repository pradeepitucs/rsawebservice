package com.ucs.rsa.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ucs.rsa.common.dto.CustomerRequestDTO;
import com.ucs.rsa.common.dto.CustomerRequestsDTO;
import com.ucs.rsa.model.CustomerModel;
import com.ucs.rsa.model.CustomerRequestModel;
import com.ucs.rsa.model.ServiceProviderModel;
import com.ucs.rsa.model.ServiceTypeModel;
import com.ucs.rsa.service.CustomerRequestService;

@Controller
@RequestMapping("/servicerequest")
public class CustomerRequestResource {

	@Autowired
	private CustomerRequestService customerRequestService;

	public CustomerRequestService getCustomerRequestService() {
		return customerRequestService;
	}

	public void setCustomerRequestService(CustomerRequestService customerRequestService) {
		this.customerRequestService = customerRequestService;
	}

	@RequestMapping(value = "/updatecustomerrequest", method = { RequestMethod.POST })
	private ModelAndView updateCustomerRequest(@RequestParam("issueId") final int issueId,
			@RequestParam("issueTypeId") final int issueTypeId,
			@RequestParam("customerLatitude") final double customerLatitude,
			@RequestParam("customerLongitude") final double customerLongitude,
			@RequestParam("customerId") final int customerId, @RequestParam("issueStatus") final String issueStatus,
			@RequestParam("amount") final long amount, @RequestParam("employeeId") final int employeeId) {

		CustomerRequestModel customerRequestModel = new CustomerRequestModel();
		customerRequestModel.setCustomerLatitude(customerLatitude);
		customerRequestModel.setCustomerLongitude(customerLongitude);
		customerRequestModel.setIssueId(issueId);
		customerRequestModel.setIssueStatus(issueStatus);

		ServiceTypeModel serverType = new ServiceTypeModel();
		serverType.setServiceTypeId(issueTypeId);
		customerRequestModel.setServiceTypeModel(serverType);

		CustomerModel customerModel = new CustomerModel();
		customerModel.setUserId(customerId);
		customerRequestModel.setCustomerModel(customerModel);
		
		ServiceProviderModel serviceProviderModel = new ServiceProviderModel();
		serviceProviderModel.setUserId(employeeId);
		customerRequestModel.setServiceProviderModel(serviceProviderModel);
		
		CustomerRequestModel customerRequestModel1 = getCustomerRequestService()
				.updateCustomerRequest(customerRequestModel);

		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();
		customerRequestDTO.setCustomerLatitude(customerRequestModel1.getCustomerLatitude());
		customerRequestDTO.setCustomerLongitude(customerRequestModel1.getCustomerLongitude());
		customerRequestDTO.setIssueId(customerRequestModel1.getIssueId());
		customerRequestDTO.setIssueStatus(customerRequestModel1.getIssueStatus());

		return new ModelAndView("xml", "customerRequest", customerRequestDTO);

	}

	@RequestMapping(value = "/customerrequests", method = { RequestMethod.GET })
	public ModelAndView getAllCustomerRequests() {

		List<CustomerRequestModel> customerRequestModels = new ArrayList<>();
		customerRequestModels = getCustomerRequestService().loadAll(CustomerRequestModel.class);

		CustomerRequestsDTO customerRequestsDTO = new CustomerRequestsDTO();
		List<CustomerRequestDTO> CustomerRequestDTOs = new ArrayList<>();

		for (CustomerRequestModel customerRequestModel : customerRequestModels) {
			CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();
			customerRequestDTO.setCustomerLatitude(customerRequestModel.getCustomerLatitude());
			customerRequestDTO.setCustomerLongitude(customerRequestModel.getCustomerLongitude());
			customerRequestDTO.setIssueId(customerRequestModel.getIssueId());
			customerRequestDTO.setIssueStatus(customerRequestModel.getIssueStatus());
			CustomerRequestDTOs.add(customerRequestDTO);
		}
		customerRequestsDTO.setCustomerRequests(CustomerRequestDTOs);
		return new ModelAndView("xml", "customers", customerRequestsDTO);
	}

	@RequestMapping(value = "/customerrequest", method = { RequestMethod.GET })
	public ModelAndView getCustomerRequest(@RequestParam("customerrequestid") final int iCustomerRequestId) {

		CustomerRequestModel customerRequestModel = new CustomerRequestModel();
		customerRequestModel = getCustomerRequestService().get(CustomerRequestModel.class, iCustomerRequestId);

		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();
		if (customerRequestModel != null) {
			customerRequestDTO.setCustomerLatitude(customerRequestModel.getCustomerLatitude());
			customerRequestDTO.setCustomerLongitude(customerRequestModel.getCustomerLongitude());
			customerRequestDTO.setIssueId(customerRequestModel.getIssueId());
			customerRequestDTO.setIssueStatus(customerRequestModel.getIssueStatus());
		}
		return new ModelAndView("xml", "customerrequest", customerRequestDTO);
	}
}
