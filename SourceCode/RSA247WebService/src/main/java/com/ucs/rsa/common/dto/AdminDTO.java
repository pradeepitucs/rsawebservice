package com.ucs.rsa.common.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "admin", namespace = "com.ucs.rsa.common.dto")
public class AdminDTO extends UserDTO
{
	private static final long serialVersionUID = 1L;
   private String username;
	private String password;
	private String adminName;
	private String confirmPassword;
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getAdminName()
	{
		return adminName;
	}
	public void setAdminName(String adminName)
	{
		this.adminName = adminName;
	}
	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
	public String getConfirmPassword()
	{
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword)
	{
		this.confirmPassword = confirmPassword;
	}
	 
}
