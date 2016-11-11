package com.ucs.rsa.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ucs.rsa.common.dto.AdminDTO;
import com.ucs.rsa.model.AdminModel;
import com.ucs.rsa.model.RoleModel;
import com.ucs.rsa.security.EncriptionAndDecription;
import com.ucs.rsa.service.AdminService;



@Controller
@RequestMapping("/admin")
public class AdminManagementResource
{
	
	public static final int adminRole = 1;
	
/*	@Autowired
	EncriptionAndDecription encriptionAndDecription;
*/	 
	@Autowired
	AdminService admintService;

	@RequestMapping(value = "/register", method ={ RequestMethod.GET })
		public ModelAndView registerPage()
		{
			ModelAndView modelAndView = new ModelAndView("register");
			
			return modelAndView;
		}

	@RequestMapping(value = "/adminregistration", method = { RequestMethod.POST })
	private ModelAndView adminRegistration(@RequestParam("username") final String username,
			@RequestParam("mobileNo") final long mobileNo,
			@RequestParam("adminName") final String adminName,
			@RequestParam("password") final String password,
			@RequestParam("confirmpwd") final String confirmpwd) throws Exception 
	{
		
		AdminModel adminModel2=null;
		AdminDTO adminDTO=new AdminDTO();
		AdminModel adminModel=new AdminModel();
		//String password1=EncriptionAndDecription.encrypt(password);
		//String confirmpwd1=EncriptionAndDecription.encrypt(confirmpwd);
		adminModel.setUsername(username);
		adminModel.setMobileNo(mobileNo);
		adminModel.setAdminName(adminName);
		RoleModel roleModel = new RoleModel();
		roleModel.setRoleId(adminRole);
		adminModel.setRoleModel(roleModel);
		
		ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder(512);
	    String encodedPassword = passwordEncoder.encodePassword(password, adminModel.getSalt());
	    String encodedConfirmPassword = passwordEncoder.encodePassword(confirmpwd, adminModel.getSalt());
		adminModel.setPassword(encodedPassword);
		if(adminModel.getPassword().equals(encodedConfirmPassword))
		{
			adminModel2=admintService.adminRegistration(adminModel);
			 adminDTO.setMobileNo(adminModel2.getMobileNo());
			 adminDTO.setAdminName(adminModel2.getAdminName());
			 adminDTO.setPassword(adminModel2.getPassword());
		}
		
		return new ModelAndView("home", "admin", adminDTO);
	}



}
