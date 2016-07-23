package com.ucs.rsa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ucs.rsa.common.dto.VehicleModuleDetailDTO;
import com.ucs.rsa.common.dto.VehicleModuleDetailsDTO;
import com.ucs.rsa.service.IVehicleModuleDetailsService;

@Controller
@RequestMapping("/vehicleModule")
public class VehicleModuleDetailsController {

	@Autowired
	private IVehicleModuleDetailsService vehicleModuleDetailsService;

	@RequestMapping(value = "/update", method = { RequestMethod.POST, RequestMethod.GET })
	private ModelAndView updateVehicleModuleDetails(final 
			VehicleModuleDetailDTO vehicleModuleDetailDTO) {

		VehicleModuleDetailDTO ivehicleModuleDetailDTO = vehicleModuleDetailsService
				.updateVehicleModuleDetails(vehicleModuleDetailDTO, false);

		return new ModelAndView("xml", "vehicleModuleDetailDTO", ivehicleModuleDetailDTO);
	}

	@RequestMapping(value = "/all", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView getAllVehicleModuleDetails() {
		List<VehicleModuleDetailDTO> vehicleModuleDetailDTOs = null;
		vehicleModuleDetailDTOs = vehicleModuleDetailsService.getVehicleModuleDetails();
		VehicleModuleDetailsDTO vehicleModuleDetailsDTO = new VehicleModuleDetailsDTO();
		vehicleModuleDetailsDTO.setVehicleModuleDetaislDTO(vehicleModuleDetailDTOs);
		return new ModelAndView("xml", "vehicleModuleDetailsDTO", vehicleModuleDetailsDTO);

	}

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public ModelAndView getModuleDetails(@RequestParam("moduleDetailsId") final String iVehicleModuleDetailsId) {
		VehicleModuleDetailsDTO vehicleModuleDetailsDTO = null;
		vehicleModuleDetailsDTO = vehicleModuleDetailsService.getVehicleModuleDetails(iVehicleModuleDetailsId);
		List<VehicleModuleDetailDTO> vehicleModuleDetailDTOs = vehicleModuleDetailsDTO.getVehicleModuleDetaislDTO();
		VehicleModuleDetailDTO aVehicleModuleDetailDTO = null;
		if (!vehicleModuleDetailDTOs.isEmpty()) {
			aVehicleModuleDetailDTO = vehicleModuleDetailDTOs.get(0);
		} else {
			aVehicleModuleDetailDTO = new VehicleModuleDetailDTO();
		}
		return new ModelAndView("xml", "vehicleModuleDetailDTO", aVehicleModuleDetailDTO);
	}

}
