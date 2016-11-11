package com.ucs.rsa.service;

import com.ucs.rsa.model.AdminModel;

public interface AdminService extends BaseService
{
	public AdminModel adminRegistration(AdminModel adminModel);
}