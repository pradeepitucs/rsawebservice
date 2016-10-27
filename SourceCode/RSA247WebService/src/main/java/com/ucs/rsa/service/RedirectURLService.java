/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.service;

// TODO: Auto-generated Javadoc
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
	 * @param reqValMap
	 *           the req val map
	 * @return the string
	 */
	//public Hashtable<String, String> redirectURL(HttpServletRequest request, HttpServletResponse response);

	public String paymentResponse(String reqValMap);

}
