/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


// TODO: Auto-generated Javadoc
/**
 * The Class AdminModel.
 * 
 * @author Gururaj A M
 * @version 1.0
 */
@Entity
@Table(name = "admin_t")
@PrimaryKeyJoinColumn(name = "user_id")
@NamedQuery(name = "AdminModel.findAll", query = "SELECT c FROM AdminModel c")
public class AdminModel extends UserModel implements Serializable, UserDetails
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The username. */
	@Column(name = "username", nullable = false, length = 16, unique = true)
	private String username;

	/** The password. */
	@Column(name = "password", nullable = false, length = 64)
	private String password;

	/** The authorities. */
	@Transient
	private Collection<? extends GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return authorities;
	}

	/**
	 * Sets the authorities.
	 *
	 * @param authorities
	 *           the new authorities
	 */
	public void setAuthorities(Collection<GrantedAuthority> authorities)
	{
		this.authorities = authorities;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
	 */
	@Override
	public boolean isAccountNonExpired()
	{
		return Boolean.TRUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
	 */
	@Override
	public boolean isAccountNonLocked()
	{
		return Boolean.TRUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
	 */
	@Override
	public boolean isCredentialsNonExpired()
	{
		return Boolean.TRUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
	 */
	@Override
	public boolean isEnabled()
	{
		return Boolean.TRUE;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername()
	{
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username
	 *           the username to set
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *           the password to set
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	// this method is called by the authentication-provider and it is used in
	// the password encoder to
	/**
	 * Gets the salt.
	 *
	 * @return the salt
	 */
	// salt the form-input user password
	public String getSalt()
	{

		StringBuilder sb = new StringBuilder();
		sb.append(username);
		sb.reverse();
		sb.append("X");
		sb.append(username);

		String salt = sb.toString();

		return salt;
	}
}
