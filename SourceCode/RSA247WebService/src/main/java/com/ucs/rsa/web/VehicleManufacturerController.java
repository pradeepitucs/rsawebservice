package com.ucs.rsa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ucs.rsa.common.dto.VehicleManufacturerDTO;
import com.ucs.rsa.common.dto.VehicleManufacturersDTO;
import com.ucs.rsa.service.IVehicleManufacturerService;

@Controller
@RequestMapping("/vehicleManufacture")
public class VehicleManufacturerController {

	@Autowired
	private IVehicleManufacturerService vehicleManufacturerService;

	@RequestMapping(value = "/all", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView getAllVehicleModuleDetails() {
		List<VehicleManufacturerDTO> vehicleManufacturerDTOs = null;
		vehicleManufacturerDTOs = vehicleManufacturerService.getVehicleManufacturers();
		VehicleManufacturersDTO vehicleManufacturerDTO = new VehicleManufacturersDTO();
		vehicleManufacturerDTO.setVehicleManufacturerDTOs(vehicleManufacturerDTOs);
		return new ModelAndView("xml", "vehicleModulesDTO", vehicleManufacturerDTO);

	}

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public ModelAndView getModuleDetails(@RequestParam("manufacturerId") final int iVehicleManufacturerId) {
		VehicleManufacturersDTO vehicleManufacturersDTO = null;
		vehicleManufacturersDTO = vehicleManufacturerService.getVehicleManufacturers(iVehicleManufacturerId);
		List<VehicleManufacturerDTO> vehicleManufacturerDTOs = vehicleManufacturersDTO.getVehicleManufacturerDTOs();
		VehicleManufacturerDTO aVehicleManufacturerDTO = null;
		if (!vehicleManufacturerDTOs.isEmpty()) {
			aVehicleManufacturerDTO = vehicleManufacturerDTOs.get(0);
		} else {
			aVehicleManufacturerDTO = new VehicleManufacturerDTO();
		}
		return new ModelAndView("xml", "vehicleModuleDetailDTO", aVehicleManufacturerDTO);
	}

}
