package com.ucs.rsa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.ucs.rsa.service.ILoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private ILoginService loginService;
	String result;
	
	@RequestMapping(value = "/mobileNumber/detail", method = RequestMethod.POST)
	public ModelAndView getMobileNumberDetail(@RequestParam("mobileNumber") final long mobileNumber,
			@RequestParam("gcmId") final String gcmId) {
		result = loginService.numberExist(mobileNumber, gcmId);
		System.out.println(result);
		return new ModelAndView("xml", "numberStatus", result);
		
	}
	
}
