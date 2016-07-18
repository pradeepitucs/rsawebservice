package com.ucs.rsa.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.dto.UserDTO;
import com.ucs.rsa.common.dto.UserRolesDTO;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.dao.IUserDAO;

@Component
public class UserServiceImpl implements IUserService {

	private IUserDAO userDAO;

	@Transactional
	public UserDTO updateUser(int iUserId, String iUserFirstName,
			String iUserLastName, int iMobieNo, boolean isEnabled,
			boolean isCreate) {

		UserDTO userDTO = null;

		if (!"".equals(iMobieNo)) {
			userDTO = userDAO.updateUser(iUserId, iUserFirstName,
					iUserLastName, iMobieNo, isEnabled, isCreate);
		} else {
			RSAException rsaException = new RSAException();
			rsaException
					.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaException;
		}
		return userDTO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public UserDTO updateUser(UserDTO iUserDTO, boolean isCreate) {
		UserDTO userDTO = null;

		if (!"".equals(iUserDTO.getMobileNo())) {
			userDTO = userDAO.updateUser(iUserDTO,isCreate);
		} else {
			RSAException rsaException = new RSAException();
			rsaException
					.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaException;
		}
		return userDTO;
	}

	@Override
	@Transactional
	public UserRolesDTO getUserRoles() {
		UserRolesDTO userRolesDTO = userDAO.getUserRoles();
		return userRolesDTO;
	}

}
