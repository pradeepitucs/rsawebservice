/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author Gururaj A M
 * @version 1.0
 * 
 *          The Interface RedirectURLService.
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
