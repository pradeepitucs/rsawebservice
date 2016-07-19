package com.ucs.rsa.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ucs.rsa.common.dto.CitiesDTO;
import com.ucs.rsa.common.dto.CityDTO;
import com.ucs.rsa.service.ICityService;

@Controller
@RequestMapping("/city")
public class CityController {

	@Autowired
	private ICityService cityService;

	@RequestMapping(value = "/all", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView getAllCity() {
		List<CityDTO> cityDTOs = new ArrayList<>();
		cityDTOs = cityService.getCities();
		CitiesDTO citiesDTO = new CitiesDTO();
		citiesDTO.setCities(cityDTOs);
		return new ModelAndView("xml", "cities", citiesDTO);
	}

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public ModelAndView getCityDetails(@RequestParam("cityid") final String iCityId) {
		CitiesDTO citiesDTO = new CitiesDTO();
		citiesDTO = cityService.getCities(iCityId);
		List<CityDTO> cityDTOs = citiesDTO.getCities();
		CityDTO cityDTO = null;
		if (!cityDTOs.isEmpty()) {
			cityDTO = cityDTOs.get(0);
		} else {
			cityDTO = new CityDTO();
		}
		return new ModelAndView("xml", "cities", cityDTO);
	}

}
