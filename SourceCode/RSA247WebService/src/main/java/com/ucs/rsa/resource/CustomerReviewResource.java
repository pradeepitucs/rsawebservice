package com.ucs.rsa.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ucs.rsa.common.dto.CustomerReviewDTO;
import com.ucs.rsa.common.dto.CustomerReviewsDTO;
import com.ucs.rsa.model.CustomerModel;
import com.ucs.rsa.model.CustomerRequestModel;
import com.ucs.rsa.model.CustomerReviewModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.ServiceProviderModel;
import com.ucs.rsa.service.CustomerReviewService;

@Controller
@RequestMapping("/servicereview")
public class CustomerReviewResource {

	@Autowired
	private CustomerReviewService customerReviewService;

	public CustomerReviewService getCustomerReviewService() {
		return customerReviewService;
	}

	public void setCustomerReviewService(CustomerReviewService customerReviewService) {
		this.customerReviewService = customerReviewService;
	}

	@RequestMapping(value = "/updatecustomerreview", method = { RequestMethod.POST })
	private ModelAndView updateCustomerReview(
			@RequestParam("customerReviewId") final int iCustomerReviewId,
			@RequestParam("customerId") final int iCustomerId, 
			@RequestParam("comment") final String iComment,
			@RequestParam("approvalstatus") final int iApprovalStatus, 
			@RequestParam("headline") final String iHeadline,
			@RequestParam("rating") final float iRating, 
			@RequestParam("blocked") final boolean iBlocked,
			@RequestParam("issueid") final int iIssueId,
			@RequestParam("employeeId") final int iEmployeeId) {

		CustomerReviewModel customerReviewModel = new CustomerReviewModel();
		customerReviewModel.setApprovalStatus(iApprovalStatus);
		customerReviewModel.setBlocked(iBlocked);
		customerReviewModel.setComment(iComment);
		customerReviewModel.setCustomerReviewId(iCustomerReviewId);
		customerReviewModel.setHeadline(iHeadline);
		customerReviewModel.setRating(iRating);

		CustomerModel customerModel = new CustomerModel();
		customerModel.setUserId(iCustomerId);
		customerReviewModel.setCustomerModel(customerModel);
		
		CustomerRequestModel customerRequestModel = new CustomerRequestModel();
		customerRequestModel.setIssueId(iIssueId);
		customerReviewModel.setCustomerRequestModel(customerRequestModel);
		
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.setUserId(iEmployeeId);
		customerReviewModel.setEmployeeModel(employeeModel);

		CustomerReviewModel customerReviewModel1 = getCustomerReviewService().updateCustomerReview(customerReviewModel);

		CustomerReviewDTO customerReviewDTO = new CustomerReviewDTO();
		if (customerReviewModel1 != null) {
			customerReviewDTO.setApprovalStatus(customerReviewModel1.getApprovalStatus());
			customerReviewDTO.setBlocked(customerReviewModel1.getBlocked());
			customerReviewDTO.setComment(customerReviewModel1.getComment());
			customerReviewDTO.setCreationTime(customerReviewModel1.getCreationTime());
			customerReviewDTO.setCustomerReviewId(customerReviewModel1.getCustomerReviewId());
			customerReviewDTO.setHeadline(customerReviewModel1.getHeadline());
			customerReviewDTO.setRating(customerReviewModel1.getRating());
			
		}
		return new ModelAndView("xml", "customerReview", customerReviewDTO);

	}

	@RequestMapping(value = "/customerreviews", method = { RequestMethod.GET })
	public ModelAndView getAllCustomerReviews() {

		List<CustomerReviewModel> customerReviewModels = new ArrayList<>();
		customerReviewModels = getCustomerReviewService().loadAll(CustomerReviewModel.class);

		CustomerReviewsDTO customerReviewsDTO = new CustomerReviewsDTO();
		List<CustomerReviewDTO> CustomerReviewDTOs = new ArrayList<>();

		for (CustomerReviewModel customerReviewModel : customerReviewModels) {
			CustomerReviewDTO customerReviewDTO = new CustomerReviewDTO();
			customerReviewDTO.setApprovalStatus(customerReviewModel.getApprovalStatus());
			customerReviewDTO.setBlocked(customerReviewModel.getBlocked());
			customerReviewDTO.setComment(customerReviewModel.getComment());
			customerReviewDTO.setCreationTime(customerReviewModel.getCreationTime());
			customerReviewDTO.setCustomerReviewId(customerReviewModel.getCustomerReviewId());
			customerReviewDTO.setHeadline(customerReviewModel.getHeadline());
			customerReviewDTO.setRating(customerReviewModel.getRating());
			CustomerReviewDTOs.add(customerReviewDTO);
		}
		customerReviewsDTO.setCustomerReviewDTOs(CustomerReviewDTOs);
		return new ModelAndView("xml", "customerreviews", customerReviewsDTO);
	}

	@RequestMapping(value = "/customerreview", method = { RequestMethod.GET })
	public ModelAndView getCustomerReview(@RequestParam("customerrequestid") final int iCustomerReviewId) {

		CustomerReviewModel customerReviewModel = new CustomerReviewModel();
		customerReviewModel = getCustomerReviewService().get(CustomerReviewModel.class, iCustomerReviewId);

		CustomerReviewDTO customerReviewDTO = new CustomerReviewDTO();
		if (customerReviewModel != null) {
			customerReviewDTO.setApprovalStatus(customerReviewModel.getApprovalStatus());
			customerReviewDTO.setBlocked(customerReviewModel.getBlocked());
			customerReviewDTO.setComment(customerReviewModel.getComment());
			customerReviewDTO.setCreationTime(customerReviewModel.getCreationTime());
			customerReviewDTO.setCustomerReviewId(customerReviewModel.getCustomerReviewId());
			customerReviewDTO.setHeadline(customerReviewModel.getHeadline());
			customerReviewDTO.setRating(customerReviewModel.getRating());
		}
		return new ModelAndView("xml", "customerreview", customerReviewDTO);
	}
}
