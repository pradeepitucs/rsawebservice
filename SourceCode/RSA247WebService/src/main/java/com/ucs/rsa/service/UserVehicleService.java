/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.service;

import java.util.List;

import com.ucs.rsa.model.UserVehicleModel;
import com.ucs.rsa.model.VehicleFuelTypeModel;
import com.ucs.rsa.model.VehicleModel;
import com.ucs.rsa.model.VehicleTypeModel;



/**
 * The Interface UserVehicleService.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
public interface UserVehicleService extends BaseService
{

	/**
	 * Update user vehicle.
	 *
	 * @param iUserVehicleModel
	 *           the i user vehicle model
	 * @param iVehicleModel
	 *           the i vehicle model
	 * @param iVehicleFuelTypeModel
	 *           the i vehicle fuel type model
	 * @param iVehicleTypeModel
	 *           the i vehicle type model
	 * @return the user vehicle model
	 */
	public UserVehicleModel updateUserVehicle(UserVehicleModel iUserVehicleModel, VehicleModel iVehicleModel,
			VehicleFuelTypeModel iVehicleFuelTypeModel, VehicleTypeModel iVehicleTypeModel);

	/**
	 * Gets the vehicles by manufacturer.
	 *
	 * @param manufacturerId
	 *           the manufacturer id
	 * @return the vehicles by manufacturer
	 */
	public List<VehicleModel> getVehiclesByManufacturer(int manufacturerId);

	/**
	 * Update fuel type.
	 *
	 * @param vehicleFuelTypeModel
	 *           the vehicle fuel type model
	 * @return the vehicle fuel type model
	 */
	public VehicleFuelTypeModel updateFuelType(VehicleFuelTypeModel vehicleFuelTypeModel);


}
