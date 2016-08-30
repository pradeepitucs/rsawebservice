/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.resource;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ucs.rsa.common.dto.StringDTO;
import com.ucs.rsa.service.RedirectURLService;


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
	RedirectURLService redirectURLResource;

	/**
	 * Redirect URL.
	 *
	 * @param request
	 *           the request
	 * @param response
	 *           the response
	 */
	@RequestMapping(value = "/citruspayresponse", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public ModelAndView redirectURL(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println(" HttpServletRequest " + request + " HttpServletResponse " + response);

		redirectURLResource.redirectURL(request, response);

		StringDTO stringDTO = new StringDTO();
		stringDTO.setStr(" HttpServletRequest " + request.toString() + "\n HttpServletResponse " + response.toString());
		System.out.println(stringDTO.getStr());
		return new ModelAndView("redirectURL", "stringDTO", stringDTO);
	}


}
