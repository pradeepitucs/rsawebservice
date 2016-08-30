/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.daos.UserVehicleDAO;
import com.ucs.rsa.model.UserVehicleModel;
import com.ucs.rsa.model.VehicleFuelTypeModel;
import com.ucs.rsa.model.VehicleModel;
import com.ucs.rsa.model.VehicleTypeModel;
import com.ucs.rsa.service.UserVehicleService;


/**
 * The Class DefaultUserVehicleService.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@Service
public class DefaultUserVehicleService extends DefaultBaseService implements UserVehicleService
{

	/** The user vehicle DAO. */
	@Autowired
	@Qualifier("defaultUserVehicleDAO")
	UserVehicleDAO userVehicleDAO;

	/**
	 * Gets the user vehicle DAO.
	 *
	 * @return the user vehicle DAO
	 */
	public UserVehicleDAO getUserVehicleDAO()
	{
		return userVehicleDAO;
	}

	/**
	 * Sets the user vehicle DAO.
	 *
	 * @param userVehicleDAO
	 *           the new user vehicle DAO
	 */
	public void setUserVehicleDAO(UserVehicleDAO userVehicleDAO)
	{
		this.userVehicleDAO = userVehicleDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.UserVehicleService#getVehiclesByManufacturer(int)
	 */
	@Override
	public List<VehicleModel> getVehiclesByManufacturer(int manufacturerId)
	{
		List<VehicleModel> vehicleModels = new ArrayList<>();
		if (manufacturerId > 0)
		{
			vehicleModels = userVehicleDAO.getVehiclesByManufacturer(manufacturerId);
		}
		return vehicleModels;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.UserVehicleService#updateUserVehicle(com.ucs.rsa.model.UserVehicleModel,
	 * com.ucs.rsa.model.VehicleModel, com.ucs.rsa.model.VehicleFuelTypeModel, com.ucs.rsa.model.VehicleTypeModel)
	 */
	@Override
	public UserVehicleModel updateUserVehicle(UserVehicleModel iUserVehicleModel, VehicleModel iVehicleModel,
			VehicleFuelTypeModel iVehicleFuelTypeModel, VehicleTypeModel iVehicleTypeModel)
	{
		UserVehicleModel userVehicle = null;
		if (!"".equals(iUserVehicleModel.getUserId()) && !"".equals(iUserVehicleModel.getVehicleRegNo())
				&& !"".equals(iVehicleModel.getVehicleModelId()) && !"".equals(iVehicleFuelTypeModel.getVehicleFuelTypeId())
				&& !"".equals(iVehicleTypeModel.getVehicleTypeId())
				&& !"".equals(iVehicleModel.getVehicleManufacturerModel().getManufacturerId()))
		{
			userVehicle = userVehicleDAO.updateUserVehicle(iUserVehicleModel, iVehicleModel, iVehicleFuelTypeModel,
					iVehicleTypeModel);
		}
		else
		{
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		return userVehicle;
	}

}
