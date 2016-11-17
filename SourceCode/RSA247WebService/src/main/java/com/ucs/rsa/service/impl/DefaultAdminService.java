package com.ucs.rsa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.daos.AdminDAO;
import com.ucs.rsa.model.AdminModel;
import com.ucs.rsa.service.AdminService;


/**
 * @author
 * @version 1.0
 */
@Service
public class DefaultAdminService extends DefaultBaseService implements AdminService
{

	@Autowired
	@Qualifier("defaultAdminDAO")
	AdminDAO adminDao;


	@Override
	public AdminModel adminRegistration(AdminModel adminModel)
	{

		AdminModel adminModel2 = null;
		if (!"".equals(adminModel.getUsername()) && !"".equals(adminModel.getMobileNo()) && !"".equals(adminModel.getAdminName())
				&& !"".equals(adminModel.getPassword()))
		{
			adminModel2 = adminDao.adminRegistration(adminModel);
		}
		else
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		return adminModel2;

	}

}
