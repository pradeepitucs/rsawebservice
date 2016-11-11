package com.ucs.rsa.daos;

import com.ucs.rsa.model.AdminModel;

public interface AdminDAO extends BaseDAO
{
	public AdminModel adminRegistration(AdminModel adminModel);
}
