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
	 *//*
	@RequestMapping(value = "/citruspayresponse", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public ModelAndView redirectURL(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println(" HttpServletRequest " + request + " HttpServletResponse " + response);

		Hashtable<String, String> hashTable = redirectURLResource.redirectURL(request, response);
		PaymentDTO paymentDTO = new PaymentDTO();
		if (!hashTable.isEmpty())
		{
			paymentDTO.setHashTable(hashTable);
		}
		else
		{
			RSAException rsaException = new RSAException();
			rsaException.setError(RSAErrorConstants.ErrorCode.TRANSACTION_FAILED_ERROR);
			throw rsaException;
		}
		return new ModelAndView("redirectURL", "paymentDTO", paymentDTO);
	}
	
	*//**
	 * Redirect URL.
	 *
	 * @param request
	 *           the request
	 * @param response
	 *           the response
	 *//*
	@RequestMapping(value = "/citruspayresponse", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public ModelAndView redirectURL(@RequestParam(value = "userresponse") final String iUserId )
	{
		System.out.println(iUserId);
		
		//System.out.println(" HttpServletRequest " + request + " HttpServletResponse " + response);

		Hashtable<String, String> hashTable = redirectURLResource.redirectURL(request, response);
		PaymentDTO paymentDTO = new PaymentDTO();
		if (!hashTable.isEmpty())
		{
			paymentDTO.setHashTable(hashTable);
		}
		else
		{
			RSAException rsaException = new RSAException();
			rsaException.setError(RSAErrorConstants.ErrorCode.TRANSACTION_FAILED_ERROR);
			throw rsaException;
		}
		return new ModelAndView("redirectURL", "paymentDTO", "");
	}*/
	
	public void returnUrlResponse(Hashtable<String, String> reqValMap){
		try {
		if(reqValMap!=null) {
		redirectURLResource.paymentResponse(reqValMap);
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(reqValMap);
	}


}
