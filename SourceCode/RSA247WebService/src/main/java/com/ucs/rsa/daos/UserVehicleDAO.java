package com.ucs.rsa.daos;

import java.util.List;

import com.ucs.rsa.model.UserVehicleModel;
import com.ucs.rsa.model.VehicleFuelTypeModel;
import com.ucs.rsa.model.VehicleModel;
import com.ucs.rsa.model.VehicleTypeModel;

public interface UserVehicleDAO extends BaseDAO {

	public UserVehicleModel updateUserVehicle(UserVehicleModel iUserVehicleModel, VehicleModel iVehicleModel,
			VehicleFuelTypeModel iVehicleFuelTypeModel, VehicleTypeModel iVehicleTypeModel);

	public List<VehicleModel> getVehiclesByManufacturer(int manufacturerId);
}
