/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.resource;

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
import com.ucs.rsa.model.CityModel;
import com.ucs.rsa.service.CityService;


/**
 * The Class CityResource.
 */
@Controller
@RequestMapping("/city")
public class CityResource
{

	/** The city service. */
	@Autowired
	CityService cityService;

	/**
	 * Search city by id.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/searchCityById", method =
	{ RequestMethod.GET })
	public ModelAndView searchCityById()
	{
		return new ModelAndView();
	}

	/**
	 * Search cities by name.
	 *
	 * @param iPageNo
	 *           the i page no
	 * @param iCityName
	 *           the i city name
	 * @return the model and view
	 */
	@RequestMapping(value = "/searchCityByName", method =
	{ RequestMethod.POST, RequestMethod.GET })
	public ModelAndView searchCitiesByName(@RequestParam(value = "page") final String iPageNo,
			@RequestParam(value = "cityName") final String iCityName)
	{

		int page = 1;
		int recordsPerPage = 10;

		List<CityModel> cityModelList = new ArrayList<>();
		cityModelList = cityService.searchCitiesByName(iCityName);

		CitiesDTO citiesDTO = new CitiesDTO();
		List<CityDTO> cityDTOs = new ArrayList<>();

		for (CityModel cityModel : cityModelList)
		{
			CityDTO cityDTO = new CityDTO();
			cityDTO.setIsEnabled(cityModel.getIsEnabled());
			cityDTO.setCityCode(cityModel.getCityCode());
			cityDTO.setCityName(cityModel.getCityName());
			cityDTO.setCityId(cityModel.getCityId());
			cityDTOs.add(cityDTO);
		}
		citiesDTO.setCityDTOs(cityDTOs);

		int noOfRecords = cityModelList.size();
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

		ModelAndView modelAndView = new ModelAndView("viewcities", "viewcities", citiesDTO);
		modelAndView.addObject("currentPage", page);
		modelAndView.addObject("noOfPages", noOfPages);

		return modelAndView;
	}

	/**
	 * Adds the city.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/addCity", method =
	{ RequestMethod.GET })
	public ModelAndView addCity()
	{
		return new ModelAndView();
	}

	/**
	 * Removes the city by name.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/removeCityByName", method =
	{ RequestMethod.GET })
	public ModelAndView removeCityByName()
	{
		return new ModelAndView();
	}

	/**
	 * Edits the city.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/editCity", method =
	{ RequestMethod.GET })
	public ModelAndView editCity()
	{
		return new ModelAndView();
	}

	/**
	 * Find all cities.
	 *
	 * @param iPageNo
	 *           the i page no
	 * @return the model and view
	 */
	@RequestMapping(value = "/findAllCities", method =
	{ RequestMethod.GET })
	public ModelAndView findAllCities(@RequestParam(value = "page") final String iPageNo)
	{

		int page = 1;
		int recordsPerPage = 10;

		if (iPageNo != null && iPageNo != "")
			page = Integer.parseInt(iPageNo);

		List<CityModel> cityModelList = new ArrayList<>();
		cityModelList = cityService.findAllCities((page - 1) * recordsPerPage, recordsPerPage);

		CitiesDTO citiesDTO = new CitiesDTO();
		List<CityDTO> cityDTOs = new ArrayList<>();

		for (CityModel cityModel : cityModelList)
		{
			CityDTO cityDTO = new CityDTO();
			cityDTO.setIsEnabled(cityModel.getIsEnabled());
			cityDTO.setCityCode(cityModel.getCityCode());
			cityDTO.setCityName(cityModel.getCityName());
			cityDTO.setCityId(cityModel.getCityId());
			cityDTOs.add(cityDTO);
		}
		citiesDTO.setCityDTOs(cityDTOs);

		int noOfRecords = cityService.findNoOfRecords();
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

		ModelAndView modelAndView = new ModelAndView("viewcities", "viewcities", citiesDTO);
		modelAndView.addObject("currentPage", page);
		modelAndView.addObject("noOfPages", noOfPages);

		return modelAndView;
	}

	/**
	 * Gets the city service.
	 *
	 * @return the city service
	 */
	public CityService getCityService()
	{
		return cityService;
	}

	/**
	 * Sets the city service.
	 *
	 * @param cityService
	 *           the new city service
	 */
	public void setCityService(CityService cityService)
	{
		this.cityService = cityService;
	}

}
