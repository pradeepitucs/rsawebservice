/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * The Interface RedirectURLService.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
public interface RedirectURLService extends BaseService
{

	/**
	 * Redirect URL.
	 *
	 * @param request
	 *           the request
	 * @param response
	 *           the response
	 */
	public void redirectURL(HttpServletRequest request, HttpServletResponse response);

}
