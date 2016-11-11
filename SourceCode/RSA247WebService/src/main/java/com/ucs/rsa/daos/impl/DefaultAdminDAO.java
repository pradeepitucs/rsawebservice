package com.ucs.rsa.daos.impl;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.exception.RSAException;

import com.ucs.rsa.daos.AdminDAO;
import com.ucs.rsa.model.AdminModel;

@Repository(value = "AdminDAO")
public class DefaultAdminDAO extends DefaultBaseDAO implements AdminDAO
{

	@Override
	public AdminModel adminRegistration(AdminModel adminModel)
	{
		AdminModel adminModel2 = adminModel;
		
	 Session theSession = null;
	try {
		theSession = currentSession(); 
		
			if(adminModel.getUserId() == 0)
			{
				AdminModel theCriteria = (AdminModel) theSession.createCriteria(AdminModel.class, "AdminModel")
						.add(Restrictions.eq("mobileNo", adminModel.getMobileNo()))
						.add(Restrictions.eq("roleModel.roleId", adminModel.getRoleModel().getRoleId())).uniqueResult();
				if (theCriteria != null)
				{
					System.out.println("rsaException");
					RSAException rsaException = new RSAException();
					System.out.println("rsaException" + rsaException);
					rsaException.setError(RSAErrorConstants.ErrorCode.USER_ALREADY_EXISTS_ERROR);
					throw rsaException;
				}
			}
		theSession.saveOrUpdate(adminModel2);
	} catch (RSAException e) {
		throw e;
	} catch (RuntimeException ex) {
		RSAException rsaEx = new RSAException();
		rsaEx.setRootCause(ex);
		rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
		throw rsaEx;
	}
	return adminModel2;
	}

}
