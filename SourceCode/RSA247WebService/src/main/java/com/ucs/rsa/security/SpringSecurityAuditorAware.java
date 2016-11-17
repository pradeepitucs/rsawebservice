package com.ucs.rsa.security;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


/**
 * @author GururajAM
 * @version 1.0
 */
@Component
public class SpringSecurityAuditorAware implements AuditorAware<String>
{

	@Override
	public String getCurrentAuditor()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null || !authentication.isAuthenticated())
		{
			return null;
		}

		return ((UserDetails) authentication.getPrincipal()).getUsername();
	}

}
