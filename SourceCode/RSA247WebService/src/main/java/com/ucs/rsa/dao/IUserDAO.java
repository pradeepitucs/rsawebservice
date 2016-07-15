package com.ucs.rsa.dao;

import com.ucs.rsa.common.dto.UserDTO;

public interface IUserDAO  {

	public UserDTO updateUser(int iUserId, String iUserFirstName,
			String iUserLastName, int iMobieNo, boolean isEnabled,
			boolean isCreate);
	
	public UserDTO updateUser(UserDTO iUserDTO, boolean isCreate);
	
}
