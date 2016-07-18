package com.ucs.rsa.dao;

import com.ucs.rsa.common.dto.UserDTO;
import com.ucs.rsa.common.dto.UserRolesDTO;

public interface IUserDAO  {

	public UserDTO updateUser(int iUserId, String iUserFirstName,
			String iUserLastName, int iMobieNo, boolean isEnabled,
			boolean isCreate);
	
	public UserDTO updateUser(UserDTO iUserDTO, boolean isCreate);
	
	public UserRolesDTO getUserRoles();
	
}
