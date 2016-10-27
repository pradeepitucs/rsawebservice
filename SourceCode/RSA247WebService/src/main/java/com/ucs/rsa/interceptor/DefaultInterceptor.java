/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ucs.rsa.model.UserModel;


/**
 * This DefaultInterceptor adds the user to the model of every requests managed
 */
public class DefaultInterceptor extends HandlerInterceptorAdapter
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#postHandle(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object,
	 * org.springframework.web.servlet.ModelAndView)
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception
	{

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null && auth.getPrincipal() != null)
		{

			if (UserModel.class.isAssignableFrom(auth.getPrincipal().getClass()))
			{

				UserModel user = (UserModel) auth.getPrincipal();

				modelAndView.getModelMap().addAttribute("user", user);

			}
		}

	}
}
