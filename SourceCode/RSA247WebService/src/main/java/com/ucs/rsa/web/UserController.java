package com.ucs.rsa.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ucs.rsa.common.dto.CustomerDTO;
import com.ucs.rsa.common.dto.UserDTO;
import com.ucs.rsa.common.dto.UserRolesDTO;
import com.ucs.rsa.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private IUserService userService;

	@RequestMapping(value = "/display", method = RequestMethod.GET)
	private ModelAndView display() {
		return new ModelAndView("Welcome to RSA247");
	}

	@RequestMapping(value = "/update", method = { RequestMethod.POST , RequestMethod.GET})
	private ModelAndView updateUser(@RequestParam("userId") final int iUserId,
			@RequestParam("userFirstName") final String iUserFirstName,
			@RequestParam("userLastName") final String iUserLastName,
			@RequestParam("mobileNo") final int iMobileNo,
			@RequestParam("roleid") final int iRoleId,
			@RequestParam("enabled") final boolean isEnabled,
			@RequestParam("isCreated") final boolean isCreated) {

		
//		UserDTO userDTO1 = userService.updateUser(iUserId, iUserFirstName,
//				iUserLastName, iMobileNo, isEnabled, isCreated);
		
		CustomerDTO iUserDTO = new CustomerDTO();
		iUserDTO.setMobileNo(iMobileNo);
		iUserDTO.setUserId(iUserId);
		iUserDTO.setEnabled(isEnabled);
		iUserDTO.setRoleId(iRoleId);
		iUserDTO.setUserFirstName(iUserFirstName);
		iUserDTO.setUserLastName(iUserLastName);
		
		System.out.println("CustomerDTO " + iUserDTO);
		
		UserDTO userDTO = userService.updateUser(iUserDTO, isCreated);
		
		System.out.println("UserDTO " + userDTO);
		
		return new ModelAndView("xml", "userDTO", userDTO);
	}

	public void setUserServices(IUserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	private ModelAndView getUserRoles() {
		UserRolesDTO userRolesDTO = userService.getUserRoles();
		return new ModelAndView("xml", "userRolesDTO", userRolesDTO);
	}

}
