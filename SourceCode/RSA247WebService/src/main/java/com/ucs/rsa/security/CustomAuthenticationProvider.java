/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ucs.rsa.model.AdminModel;
import com.ucs.rsa.service.impl.DefaultUserService;


/**
 * The Class CustomAuthenticationProvider.
 * 
 * @author Gururaj A M
 * @version 1.0
 */
public class CustomAuthenticationProvider implements UserDetailsService
{

	/** The user service. */
	@Autowired
	private DefaultUserService userService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		AdminModel user = (AdminModel) userService.getUserByUsername(username);

		if (user == null)
		{
			throw new UsernameNotFoundException("unable to find the user");
		}

		// just a temporany workaround, the authorities will be load from the db together with the user
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

		user.setAuthorities(grantedAuthorities);

		return user;
	}

	

}
