package com.ucs.rsa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ucs.rsa.common.dto.VehicleDTO;
import com.ucs.rsa.common.dto.VehiclesDTO;
import com.ucs.rsa.service.IVehicleService;


@Controller
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private IVehicleService vehicleService;
	
	@RequestMapping(value = "/update", method = { RequestMethod.POST , RequestMethod.GET})
	private ModelAndView updateVehicle(@RequestParam("userId") final int iUserId,
			@RequestParam("vehicleModuleID") final String iVehicleModuleID,
			@RequestParam("vehicle_no") final String iVehicleNo,
			@RequestParam("isEnabled") final boolean isEnabled,
			@RequestParam("isCreated") final boolean isCreated) {

		VehicleDTO iVehicleDTO = new VehicleDTO();
		iVehicleDTO.setEnabled(isEnabled);
		iVehicleDTO.setUserId(iUserId);
		iVehicleDTO.setVehicleModuleID(iVehicleModuleID);
		iVehicleDTO.setVehicleNo(iVehicleNo);
		
		VehicleDTO ivehicleDTO = vehicleService.updateVehicle(iVehicleDTO, isCreated);
		
		return new ModelAndView("xml", "vehicleDTO", ivehicleDTO);
	}
	
	@RequestMapping(value = "/all", method = {RequestMethod.GET, RequestMethod.POST })
	public ModelAndView getAllVehicle() {
		List<VehicleDTO> vehicleDTOs = null;
		vehicleDTOs = vehicleService.getVehicles();
		VehiclesDTO vehiclesDTO = new VehiclesDTO();
		vehiclesDTO.setVehiclesDTO(vehicleDTOs);
		return new ModelAndView("xml", "vehiclesDTO", vehiclesDTO);

	}

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public ModelAndView getVehicleDetails(@RequestParam("vehicleid") final int iVehicleId) {

		VehiclesDTO vehiclesDTO = null;
		vehiclesDTO = vehicleService.getVehicles(iVehicleId);
		List<VehicleDTO> theCountryDTOList = vehiclesDTO.getVehiclesDTO();
		VehicleDTO aVehicleDTO = null;
		if (!theCountryDTOList.isEmpty()) {
			aVehicleDTO = theCountryDTOList.get(0);
		} else {
			aVehicleDTO = new VehicleDTO();
		}
		return new ModelAndView("xml", "vehicleDTO", aVehicleDTO);
	}
	
}
