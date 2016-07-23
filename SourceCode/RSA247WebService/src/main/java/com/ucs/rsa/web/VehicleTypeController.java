package com.ucs.rsa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ucs.rsa.common.dto.VehicleTypeDTO;
import com.ucs.rsa.common.dto.VehicleTypesDTO;
import com.ucs.rsa.service.IVehicleTypeService;

@Controller
@RequestMapping("/vehicleType")
public class VehicleTypeController {

	@Autowired
	private IVehicleTypeService vehicleTypeService;

	@RequestMapping(value = "/all", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView getAllVehicleTypeDetails() {
		List<VehicleTypeDTO> vehicleTypeDTOs = null;
		vehicleTypeDTOs = vehicleTypeService.getVehicleTypes();
		VehicleTypesDTO vehicleTypeDTO = new VehicleTypesDTO();
		vehicleTypeDTO.setVehicleTypeDTO(vehicleTypeDTOs);
		return new ModelAndView("xml", "vehicleTypesDTO", vehicleTypeDTO);

	}

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public ModelAndView getTypeDetails(@RequestParam("moduleTypeId") final int iVehicleTypesId) {
		VehicleTypesDTO vehicleTypesDTO = null;
		vehicleTypesDTO = vehicleTypeService.getVehicleTypes(iVehicleTypesId);
		List<VehicleTypeDTO> vehicleTypeDTOs = vehicleTypesDTO.getVehicleTypeDTO();
		VehicleTypeDTO aVehicleTypeDTO = null;
		if (!vehicleTypeDTOs.isEmpty()) {
			aVehicleTypeDTO = vehicleTypeDTOs.get(0);
		} else {
			aVehicleTypeDTO = new VehicleTypeDTO();
		}
		return new ModelAndView("xml", "vehicleTypeDTO", aVehicleTypeDTO);
	}

}
