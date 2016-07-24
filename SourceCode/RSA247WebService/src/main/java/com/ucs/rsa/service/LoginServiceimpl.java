package com.ucs.rsa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ucs.rsa.dao.ILoginDAO;
@Component
public class LoginServiceimpl extends BaseManagerImpl implements ILoginService {
	
	@Autowired
	private ILoginDAO loginDAOImpl;

	public void setLoginDAOImpl(ILoginDAO loginDAOImpl) {
		this.loginDAOImpl = loginDAOImpl;
	}

	@Override
	@Transactional
	public String numberExist(long mobileNumber, String gcmId) {
		String result = loginDAOImpl.numberExist(mobileNumber, gcmId);
		return result;
	}

}
