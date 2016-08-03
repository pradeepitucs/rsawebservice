package com.ucs.rsa.service;

import java.util.List;

import com.ucs.rsa.model.UserVehicleModel;
import com.ucs.rsa.model.VehicleFuelTypeModel;
import com.ucs.rsa.model.VehicleModel;
import com.ucs.rsa.model.VehicleTypeModel;

public interface UserVehicleService extends BaseService {

	public UserVehicleModel updateUserVehicle(UserVehicleModel iUserVehicleModel, VehicleModel iVehicleModel, VehicleFuelTypeModel iVehicleFuelTypeModel, VehicleTypeModel iVehicleTypeModel);
	
	public List<VehicleModel> getVehiclesByManufacturer(int manufacturerId);
	
}
