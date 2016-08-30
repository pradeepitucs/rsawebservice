/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.web.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.ucs.rsa.common.dto.ExceptionDTO;
import com.ucs.rsa.common.exception.RSAException;


/**
 * The Class RSAExceptionResolver.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
public class RSAExceptionResolver implements HandlerExceptionResolver
{

	/** The order. */
	private int order;

	/**
	 * Gets the order.
	 *
	 * @return the order
	 */
	public int getOrder()
	{
		return order;
	}

	/**
	 * Sets the order.
	 *
	 * @param order
	 *           the new order
	 */
	public void setOrder(int order)
	{
		this.order = order;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	public ModelAndView resolveException(final HttpServletRequest iRequest, final HttpServletResponse iResponse,
			final Object iHandler, final Exception iException)
	{
		iException.printStackTrace();
		final ExceptionDTO anExceptionDTO = new ExceptionDTO();
		if (iException instanceof RSAException)
		{

			anExceptionDTO.setErrorKey(((RSAException) iException).getError().getKey());
			anExceptionDTO.setErrorMessage(((RSAException) iException).getError().getMessage());

		}
		else
		{
			anExceptionDTO.setErrorMessage(iException.getMessage());
		}
		return new ModelAndView("plist", "error", anExceptionDTO);
	}
}
