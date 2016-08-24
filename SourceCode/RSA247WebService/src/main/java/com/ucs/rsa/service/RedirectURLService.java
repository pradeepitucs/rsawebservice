package com.ucs.rsa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface RedirectURLService extends BaseService {

	public void redirectURL(HttpServletRequest request, HttpServletResponse response);
	
}
