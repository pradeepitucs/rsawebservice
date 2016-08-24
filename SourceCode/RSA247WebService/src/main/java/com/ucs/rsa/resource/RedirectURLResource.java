package com.ucs.rsa.resource;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ucs.rsa.service.RedirectURLService;

@Controller
@RequestMapping("/redirecturl")
public class RedirectURLResource extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	RedirectURLService redirectURLResource;

	@RequestMapping(value = "/citruspayresponse", method = { RequestMethod.POST, RequestMethod.GET })
	public void redirectURL(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(" HttpServletRequest " + request + " HttpServletResponse " + response);
		
		redirectURLResource.redirectURL(request, response);
	
	}
	
	
}
