/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.resource;

import java.util.Hashtable;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.dto.PaymentDTO;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.service.RedirectURLService;
import com.ucs.rsa.service.impl.DefaultRedirectURLService;


/**
 * The Class RedirectURLResource.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@Controller
@RequestMapping("/redirecturl")
public class RedirectURLResource extends HttpServlet
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The redirect URL resource. */
	@Autowired
	RedirectURLService redirectURLResource ;
	
	@RequestMapping(value = "/response", method =
		{ RequestMethod.POST, RequestMethod.GET })
	public void returnUrlResponse(@RequestParam(value = "response") final  String reqValMap){
		try {
		if(reqValMap!=null) {
			redirectURLResource.paymentResponse(reqValMap);
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the redirectURLResource
	 */
	public RedirectURLService getRedirectURLResource() {
		return redirectURLResource;
	}

	/**
	 * @param redirectURLResource the redirectURLResource to set
	 */
	public void setRedirectURLResource(RedirectURLService redirectURLResource) {
		this.redirectURLResource = redirectURLResource;
	}


}
