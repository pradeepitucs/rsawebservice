/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.resource;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ucs.rsa.service.RedirectURLService;


// TODO: Auto-generated Javadoc
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
	 * Gets the redirect URL resource.
	 *
	 * @return the redirectURLResource
	 */
	public RedirectURLService getRedirectURLResource()
	{
		return redirectURLResource;
	}

	/**
	 * Return url response.
	 *
	 * @param reqValMap the req val map
	 */
	@RequestMapping(value = "/response", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public void returnUrlResponse(@RequestParam(value = "response") final String reqValMap)
	{
		try
		{
			if (reqValMap != null)
			{
				redirectURLResource.paymentResponse(reqValMap);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Sets the redirect URL resource.
	 *
	 * @param redirectURLResource           the redirectURLResource to set
	 */
	public void setRedirectURLResource(RedirectURLService redirectURLResource)
	{
		this.redirectURLResource = redirectURLResource;
	}


}
