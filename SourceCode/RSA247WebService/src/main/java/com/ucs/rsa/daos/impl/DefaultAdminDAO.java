package com.ucs.rsa.daos.impl;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.daos.AdminDAO;
import com.ucs.rsa.model.AdminModel;


/**
 * @author
 * @version 1.0
 */
@Repository(value = "defaultAdminDAO")
public class DefaultAdminDAO extends DefaultBaseDAO implements AdminDAO
{

	@Override
	public AdminModel adminRegistration(AdminModel adminModel)
	{
		AdminModel adminModel2 = adminModel;

		Session theSession = null;
		try
		{
			theSession = currentSession();
			// We can add user to createBy and UpdatedBy like this
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (adminModel.getUserId() == 0)
			{
				adminModel2.setCreatedBy(authentication.getName());
				AdminModel theCriteria = (AdminModel) theSession.createCriteria(AdminModel.class, "adminModel")
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
			adminModel2.setUpdatedBy(authentication.getName());
			theSession.saveOrUpdate(adminModel2);
		}
		catch (RSAException e)
		{
			throw e;
		}
		catch (RuntimeException ex)
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return adminModel2;
	}

}
