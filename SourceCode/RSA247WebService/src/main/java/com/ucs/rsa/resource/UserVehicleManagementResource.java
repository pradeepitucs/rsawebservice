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

import com.ucs.rsa.common.dto.UserVehicleDTO;
import com.ucs.rsa.common.dto.UserVehiclesDTO;
import com.ucs.rsa.common.dto.VehicleBodyTypeDTO;
import com.ucs.rsa.common.dto.VehicleBodyTypesDTO;
import com.ucs.rsa.common.dto.VehicleDTO;
import com.ucs.rsa.common.dto.VehicleFuelTypeDTO;
import com.ucs.rsa.common.dto.VehicleFuelTypesDTO;
import com.ucs.rsa.common.dto.VehicleInformationModelDTO;
import com.ucs.rsa.common.dto.VehicleInformationModelsDTO;
import com.ucs.rsa.common.dto.VehicleManufacturerDTO;
import com.ucs.rsa.common.dto.VehicleManufacturersDTO;
import com.ucs.rsa.common.dto.VehicleTypeDTO;
import com.ucs.rsa.common.dto.VehicleTypesDTO;
import com.ucs.rsa.common.dto.VehiclesDTO;
import com.ucs.rsa.model.UserVehicleModel;
import com.ucs.rsa.model.VehicleBodyTypeModel;
import com.ucs.rsa.model.VehicleFuelTypeModel;
import com.ucs.rsa.model.VehicleInformationModel;
import com.ucs.rsa.model.VehicleManufacturerModel;
import com.ucs.rsa.model.VehicleModel;
import com.ucs.rsa.model.VehicleTypeModel;
import com.ucs.rsa.service.UserVehicleService;


/**
 * @author Gururaj A M
 * @version 1.0
 * 
 *          The Class UserVehicleManagementResource.
 */
@Controller
@RequestMapping("/uservehicle")
public class UserVehicleManagementResource
{

	/** The user vehicle service. */
	@Autowired
	private UserVehicleService userVehicleService;

	/**
	 * Gets the user vehicle service.
	 *
	 * @return the user vehicle service
	 */
	public UserVehicleService getUserVehicleService()
	{
		return userVehicleService;
	}

	/**
	 * Sets the user vehicle service.
	 *
	 * @param userVehicleService
	 *           the new user vehicle service
	 */
	public void setUserVehicleService(UserVehicleService userVehicleService)
	{
		this.userVehicleService = userVehicleService;
	}

	/**
	 * Update user vehicle.
	 *
	 * @param iVehicleId
	 *           the i vehicle id
	 * @param isEnabled
	 *           the is enabled
	 * @param iYear
	 *           the i year
	 * @param iUserId
	 *           the i user id
	 * @param iVehicleRegNo
	 *           the i vehicle reg no
	 * @param iVehicleFuelTypeId
	 *           the i vehicle fuel type id
	 * @param iVehicleModelId
	 *           the i vehicle model id
	 * @param iManufacturerId
	 *           the i manufacturer id
	 * @param iVehicleTypeId
	 *           the i vehicle type id
	 * @return the model and view
	 */
	@RequestMapping(value = "/updateuservehicle", method =
	{ RequestMethod.POST })
	public ModelAndView updateUserVehicle(@RequestParam(value = "vehicleid", defaultValue = "0") final int iVehicleId,
			@RequestParam(value = "isenabled") final boolean isEnabled, @RequestParam(value = "year") final int iYear,
			@RequestParam(value = "userid", required = true) final int iUserId,
			@RequestParam(value = "vehicleregno", required = true) final String iVehicleRegNo,
			@RequestParam(value = "vehiclefueltypeid", required = true) final int iVehicleFuelTypeId,
			@RequestParam(value = "vehicleModelId", required = true) final int iVehicleModelId,
			@RequestParam(value = "manufacturerId", required = true) final int iManufacturerId,
			@RequestParam(value = "vehicletypeid", required = true) final int iVehicleTypeId)
	{

		UserVehicleModel userVehicleModel = new UserVehicleModel();
		userVehicleModel.setIsEnabled(isEnabled);
		userVehicleModel.setUserId(iUserId);
		userVehicleModel.setVehicleId(iVehicleId);
		userVehicleModel.setVehicleRegNo(iVehicleRegNo);
		userVehicleModel.setYear(iYear);

		VehicleManufacturerModel vehicleManufacturerModel = new VehicleManufacturerModel();
		vehicleManufacturerModel.setManufacturerId(iManufacturerId);

		VehicleModel vehicleModel = new VehicleModel();
		vehicleModel.setVehicleModelId(iVehicleModelId);
		vehicleModel.setVehicleManufacturerModel(vehicleManufacturerModel);

		VehicleFuelTypeModel vehicleFuelTypeModel = new VehicleFuelTypeModel();
		vehicleFuelTypeModel.setVehicleFuelTypeId(iVehicleFuelTypeId);

		VehicleTypeModel vehicleTypeModel = new VehicleTypeModel();
		vehicleTypeModel.setVehicleTypeId(iVehicleTypeId);

		VehicleInformationModel vehicleInformationModel = new VehicleInformationModel();
		userVehicleModel.setVehicleInformationModel(vehicleInformationModel);

		UserVehicleModel userVehicleModel1 = getUserVehicleService().updateUserVehicle(userVehicleModel, vehicleModel,
				vehicleFuelTypeModel, vehicleTypeModel);

		UserVehicleDTO userVehicleDTO = new UserVehicleDTO();

		userVehicleDTO.setIsEnabled(userVehicleModel1.getIsEnabled());
		userVehicleDTO.setUserId(userVehicleModel1.getUserId());
		userVehicleDTO.setVehicleId(userVehicleModel1.getVehicleId());
		userVehicleDTO.setVehicleRegNo(userVehicleModel1.getVehicleRegNo());

		return new ModelAndView("xml", "userVehicle", userVehicleDTO);
	}

	/**
	 * Vehicle body types.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/vehiclebodytypes", method =
	{ RequestMethod.GET })
	public ModelAndView vehicleBodyTypes()
	{

		List<VehicleBodyTypeModel> vehicleBodyTypeModelList = new ArrayList<>();
		vehicleBodyTypeModelList = getUserVehicleService().loadAll(VehicleBodyTypeModel.class);

		VehicleBodyTypesDTO bodyTypesDTO = new VehicleBodyTypesDTO();
		List<VehicleBodyTypeDTO> vehicleBodyTypeDTOs = new ArrayList<>();

		for (VehicleBodyTypeModel vehicleBodyTypeModel : vehicleBodyTypeModelList)
		{
			VehicleBodyTypeDTO vehicleBodyTypeDTO = new VehicleBodyTypeDTO();
			vehicleBodyTypeDTO.setIsEnabled(vehicleBodyTypeModel.getIsEnabled());
			vehicleBodyTypeDTO.setVehicleBodyTypeId(vehicleBodyTypeModel.getVehicleBodyTypeId());
			vehicleBodyTypeDTO.setVehicleBodyTypeName(vehicleBodyTypeModel.getVehicleBodyTypeName());
			vehicleBodyTypeDTOs.add(vehicleBodyTypeDTO);
		}
		bodyTypesDTO.setVehicleBodyTypeDTOs(vehicleBodyTypeDTOs);

		return new ModelAndView("xml", "vehiclebodytypes", bodyTypesDTO);
	}

	/**
	 * Vehicle body type.
	 *
	 * @param iVehicleBodyTypeId
	 *           the i vehicle body type id
	 * @return the model and view
	 */
	@RequestMapping(value = "/vehiclebodytype", method =
	{ RequestMethod.POST })
	public ModelAndView vehicleBodyType(@RequestParam("vehiclebodytypeid") final int iVehicleBodyTypeId)
	{
		VehicleBodyTypeModel vehicleBodyTypeModel = new VehicleBodyTypeModel();
		vehicleBodyTypeModel = getUserVehicleService().get(VehicleBodyTypeModel.class, iVehicleBodyTypeId);

		VehicleBodyTypeDTO vehicleBodyTypeDTO = new VehicleBodyTypeDTO();
		if (vehicleBodyTypeModel != null)
		{
			vehicleBodyTypeDTO.setIsEnabled(vehicleBodyTypeModel.getIsEnabled());
			vehicleBodyTypeDTO.setVehicleBodyTypeId(vehicleBodyTypeModel.getVehicleBodyTypeId());
			vehicleBodyTypeDTO.setVehicleBodyTypeName(vehicleBodyTypeModel.getVehicleBodyTypeName());
		}

		return new ModelAndView("xml", "vehiclebodytype", vehicleBodyTypeDTO);
	}

	/**
	 * Vehicle fuel types.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/vehiclefueltypes", method =
	{ RequestMethod.GET })
	public ModelAndView vehicleFuelTypes()
	{

		List<VehicleFuelTypeModel> vehicleFuelTypeModelList = new ArrayList<>();
		vehicleFuelTypeModelList = getUserVehicleService().loadAll(VehicleFuelTypeModel.class);

		VehicleFuelTypesDTO fuelTypesDTO = new VehicleFuelTypesDTO();
		List<VehicleFuelTypeDTO> vehicleFuelTypeDTOs = new ArrayList<>();

		for (VehicleFuelTypeModel vehicleFuelTypeModel : vehicleFuelTypeModelList)
		{
			VehicleFuelTypeDTO vehicleFuelTypeDTO = new VehicleFuelTypeDTO();
			vehicleFuelTypeDTO.setIsEnabled(vehicleFuelTypeModel.getIsEnabled());
			vehicleFuelTypeDTO.setVehicleFuelTypeId(vehicleFuelTypeModel.getVehicleFuelTypeId());
			vehicleFuelTypeDTO.setVehicleFuelTypeName(vehicleFuelTypeModel.getVehicleFuelTypeName());
			vehicleFuelTypeDTOs.add(vehicleFuelTypeDTO);
		}
		fuelTypesDTO.setVehicleFuelTypeDTOs(vehicleFuelTypeDTOs);
		return new ModelAndView("xml", "vehiclefueltypes", fuelTypesDTO);
	}

	/**
	 * Vehicle fuel type.
	 *
	 * @param iVehicleFuelTypeId
	 *           the i vehicle fuel type id
	 * @return the model and view
	 */
	@RequestMapping(value = "/vehiclefueltype", method =
	{ RequestMethod.POST })
	public ModelAndView vehicleFuelType(@RequestParam("vehiclefueltypeid") final int iVehicleFuelTypeId)
	{

		VehicleFuelTypeModel vehicleFuelTypeModel = new VehicleFuelTypeModel();
		vehicleFuelTypeModel = getUserVehicleService().get(VehicleFuelTypeModel.class, iVehicleFuelTypeId);

		VehicleFuelTypeDTO vehicleFuelTypeDTO = new VehicleFuelTypeDTO();
		if (vehicleFuelTypeModel != null)
		{
			vehicleFuelTypeDTO.setIsEnabled(vehicleFuelTypeModel.getIsEnabled());
			vehicleFuelTypeDTO.setVehicleFuelTypeId(vehicleFuelTypeModel.getVehicleFuelTypeId());
			vehicleFuelTypeDTO.setVehicleFuelTypeName(vehicleFuelTypeModel.getVehicleFuelTypeName());
		}
		return new ModelAndView("xml", "vehiclefueltype", vehicleFuelTypeDTO);
	}

	/**
	 * Vehicle types.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/vehicletypes", method =
	{ RequestMethod.GET })
	public ModelAndView vehicleTypes()
	{

		List<VehicleTypeModel> vehicleTypeModelList = new ArrayList<>();
		vehicleTypeModelList = getUserVehicleService().loadAll(VehicleTypeModel.class);

		VehicleTypesDTO vehicleTypesDTO = new VehicleTypesDTO();
		List<VehicleTypeDTO> typesDTOs = new ArrayList<>();

		for (VehicleTypeModel vehicleTypeModel : vehicleTypeModelList)
		{
			VehicleTypeDTO vehicleTypeDTO = new VehicleTypeDTO();
			vehicleTypeDTO.setIsEnabled(vehicleTypeModel.getIsEnabled());
			vehicleTypeDTO.setVehicleTypeId(vehicleTypeModel.getVehicleTypeId());
			vehicleTypeDTO.setVehicleTypeName(vehicleTypeModel.getVehicleTypeName());
			typesDTOs.add(vehicleTypeDTO);
		}
		vehicleTypesDTO.setVehicleTypeDTOs(typesDTOs);
		return new ModelAndView("xml", "vehicletypes", vehicleTypesDTO);
	}

	/**
	 * Vehicle type.
	 *
	 * @param iVehicleTypeId
	 *           the i vehicle type id
	 * @return the model and view
	 */
	@RequestMapping(value = "/vehicletype", method =
	{ RequestMethod.POST })
	public ModelAndView vehicleType(@RequestParam("vehicleyypeid") final int iVehicleTypeId)
	{

		VehicleTypeModel vehicleTypeModel = new VehicleTypeModel();
		vehicleTypeModel = getUserVehicleService().get(VehicleTypeModel.class, iVehicleTypeId);

		VehicleTypeDTO vehicleTypeDTO = new VehicleTypeDTO();
		if (vehicleTypeModel != null)
		{
			vehicleTypeDTO.setIsEnabled(vehicleTypeModel.getIsEnabled());
			vehicleTypeDTO.setVehicleTypeId(vehicleTypeModel.getVehicleTypeId());
			vehicleTypeDTO.setVehicleTypeName(vehicleTypeModel.getVehicleTypeName());
		}
		return new ModelAndView("xml", "vehicletype", vehicleTypeDTO);
	}

	/**
	 * Vehicle manufacturers.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/vehiclemanufacturers", method =
	{ RequestMethod.GET })
	public ModelAndView vehicleManufacturers()
	{
		List<VehicleManufacturerModel> vehicleManufacturerModelList = new ArrayList<>();
		vehicleManufacturerModelList = getUserVehicleService().loadAll(VehicleManufacturerModel.class);

		VehicleManufacturersDTO vehicleManufacturersDTO = new VehicleManufacturersDTO();
		List<VehicleManufacturerDTO> vehicleManufacturerDTOs = new ArrayList<>();

		for (VehicleManufacturerModel vehicleManufacturerModel : vehicleManufacturerModelList)
		{
			VehicleManufacturerDTO vehicleManufacturerDTO = new VehicleManufacturerDTO();
			vehicleManufacturerDTO.setIsEnabled(vehicleManufacturerModel.getIsEnabled());
			vehicleManufacturerDTO.setManufacturerId(vehicleManufacturerModel.getManufacturerId());
			vehicleManufacturerDTO.setManufacturerName(vehicleManufacturerModel.getManufacturerName());
			vehicleManufacturerDTOs.add(vehicleManufacturerDTO);
		}
		vehicleManufacturersDTO.setVehicleManufacturerDTOs(vehicleManufacturerDTOs);
		return new ModelAndView("xml", "vehiclemanufacturers", vehicleManufacturersDTO);
	}

	/**
	 * Vehicle manufacturer.
	 *
	 * @param iManufacturerId
	 *           the i manufacturer id
	 * @return the model and view
	 */
	@RequestMapping(value = "/vehiclemanufacturer", method =
	{ RequestMethod.POST })
	public ModelAndView vehicleManufacturer(@RequestParam("manufacturerId") final int iManufacturerId)
	{
		VehicleManufacturerModel vehicleManufacturerModel = new VehicleManufacturerModel();
		vehicleManufacturerModel = getUserVehicleService().get(VehicleManufacturerModel.class, iManufacturerId);

		VehicleManufacturerDTO vehicleManufacturerDTO = new VehicleManufacturerDTO();
		if (vehicleManufacturerModel != null)
		{
			vehicleManufacturerDTO.setIsEnabled(vehicleManufacturerModel.getIsEnabled());
			vehicleManufacturerDTO.setManufacturerId(vehicleManufacturerModel.getManufacturerId());
			vehicleManufacturerDTO.setManufacturerName(vehicleManufacturerModel.getManufacturerName());
		}
		return new ModelAndView("xml", "vehiclemanufacturer", vehicleManufacturerDTO);
	}

	/**
	 * Vehicle models.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/vehiclemodels", method =
	{ RequestMethod.GET })
	public ModelAndView vehicleModels()
	{
		List<VehicleModel> vehicleModelList = new ArrayList<>();
		vehicleModelList = getUserVehicleService().loadAll(VehicleModel.class);

		VehiclesDTO vehiclesDTO = new VehiclesDTO();
		List<VehicleDTO> vehicleDTOs = new ArrayList<>();

		for (VehicleModel vehicleModel : vehicleModelList)
		{
			VehicleDTO vehicleDTO = new VehicleDTO();
			vehicleDTO.setIsEnabled(vehicleModel.getIsEnabled());
			vehicleDTO.setModelName(vehicleModel.getModelName());
			vehicleDTO.setVehicleModelId(vehicleModel.getVehicleModelId());
			vehicleDTOs.add(vehicleDTO);
		}
		vehiclesDTO.setVehicleDTOs(vehicleDTOs);

		return new ModelAndView("xml", "vehicles", vehiclesDTO);
	}

	/**
	 * Vehicle model.
	 *
	 * @param iVehicleModelId
	 *           the i vehicle model id
	 * @return the model and view
	 */
	@RequestMapping(value = "/vehiclemodel", method =
	{ RequestMethod.POST })
	public ModelAndView vehicleModel(@RequestParam("vehiclemodelid") final int iVehicleModelId)
	{
		VehicleModel vehicleModel = new VehicleModel();
		vehicleModel = getUserVehicleService().get(VehicleModel.class, iVehicleModelId);

		VehicleDTO vehicleDTO = new VehicleDTO();
		if (vehicleModel != null)
		{
			vehicleDTO.setIsEnabled(vehicleModel.getIsEnabled());
			vehicleDTO.setModelName(vehicleModel.getModelName());
			vehicleDTO.setVehicleModelId(vehicleModel.getVehicleModelId());
		}
		return new ModelAndView("xml", "vehiclemodel", vehicleDTO);
	}

	/**
	 * Vehicle information models.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/vehicleinformationmodels", method =
	{ RequestMethod.GET })
	public ModelAndView vehicleInformationModels()
	{
		List<VehicleInformationModel> vehicleInformationModelList = new ArrayList<>();
		vehicleInformationModelList = getUserVehicleService().loadAll(VehicleInformationModel.class);

		VehicleInformationModelsDTO vehicleInformationModelsDTO = new VehicleInformationModelsDTO();
		List<VehicleInformationModelDTO> vehicleInformationModelDTOs = new ArrayList<>();

		for (VehicleInformationModel vehicleInformationModel : vehicleInformationModelList)
		{
			VehicleInformationModelDTO vehicleInformationModelDTO = new VehicleInformationModelDTO();
			vehicleInformationModelDTO.setIsEnabled(vehicleInformationModel.getIsEnabled());
			vehicleInformationModelDTO.setVehicleInformationModelId(vehicleInformationModel.getVehicleInformationModelId());
			// vehicleInformationModelDTO.setVehicleInformationModelName(vehicleInformationModel.getVehicleInformationModelName());
			vehicleInformationModelDTOs.add(vehicleInformationModelDTO);
		}
		vehicleInformationModelsDTO.setVehicleInformationModelDTOs(vehicleInformationModelDTOs);

		return new ModelAndView("xml", "vehicleinformationmodels", vehicleInformationModelsDTO);
	}

	/**
	 * Vehicle information model.
	 *
	 * @param iVehicleInformationModelId
	 *           the i vehicle information model id
	 * @return the model and view
	 */
	@RequestMapping(value = "/vehicleinformationmodel", method =
	{ RequestMethod.POST })
	public ModelAndView vehicleInformationModel(@RequestParam("vehicleinformationmodelid") final int iVehicleInformationModelId)
	{

		VehicleInformationModel vehicleInformationModel = new VehicleInformationModel();
		vehicleInformationModel = getUserVehicleService().get(VehicleInformationModel.class, iVehicleInformationModelId);

		VehicleInformationModelDTO vehicleInformationModelDTO = new VehicleInformationModelDTO();
		if (vehicleInformationModel != null)
		{
			vehicleInformationModelDTO.setIsEnabled(vehicleInformationModel.getIsEnabled());
			vehicleInformationModelDTO.setVehicleInformationModelId(vehicleInformationModel.getVehicleInformationModelId());
			// vehicleInformationModelDTO.setVehicleInformationModelName(vehicleInformationModel.getVehicleInformationModelName());
			// vehicleInformationModelDTO.setVehicleInformationModelYear(vehicleInformationModel.getVehicleInformationModelId());
		}
		return new ModelAndView("xml", "vehicleinformationmodel", vehicleInformationModelDTO);
	}

	/**
	 * Vehicles.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/vehicles", method =
	{ RequestMethod.GET })
	public ModelAndView vehicles()
	{

		List<UserVehicleModel> userVehicleModelList = new ArrayList<>();
		userVehicleModelList = getUserVehicleService().loadAll(UserVehicleModel.class);

		UserVehiclesDTO userVehiclesDTO = new UserVehiclesDTO();
		List<UserVehicleDTO> userVehicleDTOs = new ArrayList<>();

		for (UserVehicleModel userVehicleModel : userVehicleModelList)
		{
			UserVehicleDTO userVehicleDTO = new UserVehicleDTO();
			userVehicleDTO.setIsEnabled(userVehicleModel.getIsEnabled());
			userVehicleDTO.setUserId(userVehicleModel.getUserId());
			userVehicleDTO.setVehicleId(userVehicleModel.getVehicleId());
			userVehicleDTO.setVehicleRegNo(userVehicleModel.getVehicleRegNo());
			userVehicleDTOs.add(userVehicleDTO);
		}
		userVehiclesDTO.setUserVehicleDTOs(userVehicleDTOs);
		return new ModelAndView("xml", "vehicles", userVehiclesDTO);
	}

	/**
	 * Vehicle.
	 *
	 * @param iVehicleId
	 *           the i vehicle id
	 * @return the model and view
	 */
	@RequestMapping(value = "/vehicle", method =
	{ RequestMethod.GET })
	public ModelAndView vehicle(@RequestParam("vehicleid") final int iVehicleId)
	{
		UserVehicleModel userVehicleModel = new UserVehicleModel();
		userVehicleModel = getUserVehicleService().get(UserVehicleModel.class, iVehicleId);

		UserVehicleDTO userVehicleDTO = new UserVehicleDTO();
		if (userVehicleModel != null)
		{
			userVehicleDTO.setIsEnabled(userVehicleModel.getIsEnabled());
			userVehicleDTO.setUserId(userVehicleModel.getUserId());
			userVehicleDTO.setVehicleId(userVehicleModel.getVehicleId());
			userVehicleDTO.setVehicleRegNo(userVehicleModel.getVehicleRegNo());
		}
		return new ModelAndView("xml", "vehicle", userVehicleDTO);
	}

	/**
	 * Gets the vehicle models by manufacturer.
	 *
	 * @param iVehicleModelId
	 *           the i vehicle model id
	 * @return the vehicle models by manufacturer
	 */
	@RequestMapping(value = "/vehiclemodelsdetailsbymanufacturer", method =
	{ RequestMethod.POST })
	public ModelAndView getVehicleModelsByManufacturer(@RequestParam("manufacturerid") final int iVehicleModelId)
	{
		List<VehicleModel> vehicleModels = new ArrayList<>();
		vehicleModels = getUserVehicleService().getVehiclesByManufacturer(iVehicleModelId);

		VehiclesDTO vehiclesDTO = new VehiclesDTO();
		List<VehicleDTO> vehicleDTOs = new ArrayList<>();

		for (VehicleModel vehicleModel : vehicleModels)
		{
			VehicleDTO vehicleDTO = new VehicleDTO();
			vehicleDTO.setIsEnabled(vehicleModel.getIsEnabled());
			vehicleDTO.setModelName(vehicleModel.getModelName());
			vehicleDTO.setVehicleModelId(vehicleModel.getVehicleModelId());
			vehicleDTOs.add(vehicleDTO);
		}
		vehiclesDTO.setVehicleDTOs(vehicleDTOs);
		return new ModelAndView("xml", "vehiclemodels", vehiclesDTO);
	}

	/**
	 * Vehicle information model dep vehicle model.
	 *
	 * @param iVehicleInformationModelId
	 *           the i vehicle information model id
	 * @return the model and view
	 */
	@RequestMapping(value = "/vehicleinformationmobyvehiclemodel", method =
	{ RequestMethod.POST })
	public ModelAndView vehicleInformationModelDepVehicleModel(
			@RequestParam("vehicleinformationmodelid") final int iVehicleInformationModelId)
	{

		VehicleInformationModel vehicleInformationModel = new VehicleInformationModel();
		vehicleInformationModel = getUserVehicleService().get(VehicleInformationModel.class, iVehicleInformationModelId);

		VehicleInformationModelDTO vehicleInformationModelDTO = new VehicleInformationModelDTO();
		if (vehicleInformationModel != null)
		{
			vehicleInformationModelDTO.setIsEnabled(vehicleInformationModel.getIsEnabled());
			vehicleInformationModelDTO.setVehicleInformationModelId(vehicleInformationModel.getVehicleInformationModelId());
			// vehicleInformationModelDTO.setVehicleInformationModelName(vehicleInformationModel.getVehicleInformationModelName());
			// vehicleInformationModelDTO.setVehicleInformationModelYear(vehicleInformationModel.getVehicleInformationModelId());
		}
		return new ModelAndView("xml", "vehicleinformationmodel", vehicleInformationModelDTO);
	}

}
