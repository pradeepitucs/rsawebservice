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

@Service
public class DefaultUserVehicleService extends DefaultBaseService implements UserVehicleService {

	@Autowired
	@Qualifier("defaultUserVehicleDAO")
	UserVehicleDAO userVehicleDAO;

	public UserVehicleDAO getUserVehicleDAO() {
		return userVehicleDAO;
	}

	public void setUserVehicleDAO(UserVehicleDAO userVehicleDAO) {
		this.userVehicleDAO = userVehicleDAO;
	}

	@Override
	public List<VehicleModel> getVehiclesByManufacturer(int manufacturerId) {
		List<VehicleModel> vehicleModels = new ArrayList<>();
		if (manufacturerId > 0) {
			vehicleModels = userVehicleDAO.getVehiclesByManufacturer(manufacturerId);
		}
		return vehicleModels;
	}

	@Override
	public UserVehicleModel updateUserVehicle(UserVehicleModel iUserVehicleModel, VehicleModel iVehicleModel,
			VehicleFuelTypeModel iVehicleFuelTypeModel, VehicleTypeModel iVehicleTypeModel) {
		UserVehicleModel userVehicle = null;
		if (!"".equals(iUserVehicleModel.getUserId()) && !"".equals(iUserVehicleModel.getVehicleRegNo())
				&& !"".equals(iVehicleModel.getVehicleModelId())
				&& !"".equals(iVehicleFuelTypeModel.getVehicleFuelTypeId())
				&& !"".equals(iVehicleTypeModel.getVehicleTypeId())
				&& !"".equals(iVehicleModel.getVehicleManufacturerModel().getManufacturerId())) {
			userVehicle = userVehicleDAO.updateUserVehicle(iUserVehicleModel, iVehicleModel, iVehicleFuelTypeModel, iVehicleTypeModel);
		} else {
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		return userVehicle;
	}

}
