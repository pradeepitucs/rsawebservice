package com.ucs.rsa.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
			@RequestParam("mobileNo") final long iMobileNo,
			@RequestParam("emailId") final String iEmailId,
			@RequestParam("city") final int iCity,
			@RequestParam("roleid") final int iRoleId,
			@RequestParam("enabled") final boolean isEnabled,
			@RequestParam("gcmId") final String gcmId,
			@RequestParam("folderName") final String folderName,
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
		iUserDTO.setCity(iCity);
		iUserDTO.setEmailId(iEmailId);
		iUserDTO.setGcmId(gcmId);
		iUserDTO.setFolderName(folderName);
		
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
	
	/**
	 * Upload org img.
	 *
	 * @param files the files
	 * @param fileName the file name
	 * @return String : It gives the result like data inserted or not .
	 * @throws Exception the exception
	 * @Description This method is for upload the verification form images.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "uploadCustomerImg", headers = "content-type=multipart/form-data")
	public @ResponseBody String uploadOrgImg(@RequestParam("file") MultipartFile[] files,
			@RequestParam("fileName") String fileName) throws Exception {
		String imageInserted = null;
		String rootPath = System.getProperty("catalina.home");
		File theDir = new File(rootPath + "/webapps/CustomerApp/" + fileName);
		// if the directory does not exist, create it
		if (!theDir.exists()) {
			boolean result = false;
			try {
				theDir.mkdir();
				result = true;
			} catch (SecurityException se) {
				// handle it
			}
			if (result) {
				if (files != null && files.length > 0) {
					for (int i = 0; i < files.length; i++) {
						try {
							byte[] bytes = files[i].getBytes();
							BufferedOutputStream stream = new BufferedOutputStream(
									new FileOutputStream(theDir.getPath() + "/" + fileName + i + ".jpg"));
							stream.write(bytes);
							stream.flush();
							stream.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else {
					throw new Exception("File not found ");
				}
				imageInserted = "Inserted Data";
			}
		}
		return imageInserted;
	}

}
