package com.ucs.rsa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ucs.rsa.common.dto.VehicleModuleDTO;
import com.ucs.rsa.common.dto.VehicleModulesDTO;
import com.ucs.rsa.service.IVehicleModuleService;

@Controller
@RequestMapping("/vehicleModule")
public class VehicleModuleController {

	@Autowired
	private IVehicleModuleService vehicleModuleService;

	@RequestMapping(value = "/all", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView getAllVehicleModuleDetails() {
		List<VehicleModuleDTO> vehicleModuleDTOs = null;
		vehicleModuleDTOs = vehicleModuleService.getVehicleModules();
		VehicleModulesDTO vehicleModuleDTO = new VehicleModulesDTO();
		vehicleModuleDTO.setVehicleModuleDTO(vehicleModuleDTOs);
		return new ModelAndView("xml", "vehicleModulesDTO", vehicleModuleDTO);

	}

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public ModelAndView getModuleDetails(@RequestParam("moduleDetailsId") final String iVehicleModulesId) {
		VehicleModulesDTO vehicleModulesDTO = null;
		vehicleModulesDTO = vehicleModuleService.getVehicleModules(iVehicleModulesId);
		List<VehicleModuleDTO> vehicleModuleDTOs = vehicleModulesDTO.getVehicleModuleDTO();
		VehicleModuleDTO aVehicleModuleDTO = null;
		if (!vehicleModuleDTOs.isEmpty()) {
			aVehicleModuleDTO = vehicleModuleDTOs.get(0);
		} else {
			aVehicleModuleDTO = new VehicleModuleDTO();
		}
		return new ModelAndView("xml", "vehicleModuleDetailDTO", aVehicleModuleDTO);
	}

}
