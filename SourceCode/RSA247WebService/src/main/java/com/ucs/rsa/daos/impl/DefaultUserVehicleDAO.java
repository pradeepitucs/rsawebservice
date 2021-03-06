package com.ucs.rsa.daos.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.daos.UserVehicleDAO;
import com.ucs.rsa.model.UserModel;
import com.ucs.rsa.model.UserVehicleModel;
import com.ucs.rsa.model.VehicleFuelTypeModel;
import com.ucs.rsa.model.VehicleInformationModel;
import com.ucs.rsa.model.VehicleManufacturerModel;
import com.ucs.rsa.model.VehicleModel;
import com.ucs.rsa.model.VehicleTypeModel;

@Repository(value = "defaultUserVehicleDAO")
public class DefaultUserVehicleDAO extends DefaultBaseDAO implements UserVehicleDAO {

	@Override
	public List<VehicleModel> getVehiclesByManufacturer(int manufacturerId) {
		List<VehicleModel> vehicleModels = new ArrayList<>();
		Session theSession = null;
		try {
			theSession = currentSession();

			/**** Check for invalid manufacturer id ****/
			VehicleManufacturerModel vehicleManufacturerModel = (VehicleManufacturerModel) theSession
					.createCriteria(VehicleManufacturerModel.class, "vehicleManufacturerModel")
					.add(Restrictions.eq("manufacturerId", manufacturerId)).uniqueResult();
			if (vehicleManufacturerModel != null) {
				Criteria theCriteria = theSession.createCriteria(VehicleModel.class, "vehicleModel").add(Restrictions
						.eq("vehicleManufacturerModel.manufacturerId", vehicleManufacturerModel.getManufacturerId()));
				vehicleModels = (List<VehicleModel>) theCriteria.list();
			}

		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return vehicleModels;
	}

	@Override
	public UserVehicleModel updateUserVehicle(UserVehicleModel iUserVehicleModel, VehicleModel iVehicleModel,
			VehicleFuelTypeModel iVehicleFuelTypeModel, VehicleTypeModel iVehicleTypeModel) {
		UserVehicleModel userVehicleModel1 = iUserVehicleModel;
		Session theSession = null;
		try {
			theSession = currentSession();

			/**** Check for invalid user id ****/
			// TODO : check for customer with given id

			/**** Check for invalid vehicle model id ****/
			VehicleModel theVehicleModel = (VehicleModel) theSession.createCriteria(VehicleModel.class, "vehicleModel")
					.add(Restrictions.eq("vehicleModelId", iVehicleModel.getVehicleModelId())).uniqueResult();
			if (theVehicleModel == null) {
				RSAException rsaEx = new RSAException();
				rsaEx.setError(RSAErrorConstants.ErrorCode.INVALID_VEHICLE_MODEL_ID_ERROR);
				throw rsaEx;
			}

			/**** Check for invalid vehicle model id ****/
			VehicleFuelTypeModel theVehicleFuelTypeModel = (VehicleFuelTypeModel) theSession
					.createCriteria(VehicleFuelTypeModel.class, "vehicleFuelTypeModel")
					.add(Restrictions.eq("vehicleFuelTypeId", iVehicleFuelTypeModel.getVehicleFuelTypeId()))
					.uniqueResult();
			if (theVehicleFuelTypeModel == null) {
				RSAException rsaEx = new RSAException();
				rsaEx.setError(RSAErrorConstants.ErrorCode.INVALID_VEHICLE_FUEL_TYPE_MODEL_ID_ERROR);
				throw rsaEx;
			}

			/**** Check for invalid vehicle model id ****/
			VehicleTypeModel theVehicleTypeModel = (VehicleTypeModel) theSession
					.createCriteria(VehicleTypeModel.class, "vehicleTypeModel")
					.add(Restrictions.eq("vehicleTypeId", iVehicleTypeModel.getVehicleTypeId())).uniqueResult();
			if (theVehicleTypeModel == null) {
				RSAException rsaEx = new RSAException();
				rsaEx.setError(RSAErrorConstants.ErrorCode.INVALID_VEHICLE_TYPE_MODEL_ID_ERROR);
				throw rsaEx;
			}

			/**** Check for invalid vehicle model id ****/
			VehicleManufacturerModel theVehicleManufacturerModel = (VehicleManufacturerModel) theSession
					.createCriteria(VehicleManufacturerModel.class, "vehicleManufacturerModel").add(Restrictions
							.eq("manufacturerId", iVehicleModel.getVehicleManufacturerModel().getManufacturerId()))
					.uniqueResult();
			if (theVehicleManufacturerModel == null) {
				RSAException rsaEx = new RSAException();
				rsaEx.setError(RSAErrorConstants.ErrorCode.INVALID_VEHICLE_MANUFACTURER_MODEL_ID_ERROR);
				throw rsaEx;
			}

			/**** Check for invalid vehicle model id ****/
			UserModel theUserModel = (UserModel) theSession.createCriteria(UserModel.class, "userModel")
					.add(Restrictions.eq("userId", iUserVehicleModel.getUserId())).uniqueResult();
			if (theUserModel == null) {
				RSAException rsaEx = new RSAException();
				rsaEx.setError(RSAErrorConstants.ErrorCode.USER_NOT_FOUND_ERROR);
				throw rsaEx;
			}

			/**** Check for invalid vehicle information model id ****/
			VehicleInformationModel vehicleInformationModel = (VehicleInformationModel) theSession
					.createCriteria(VehicleInformationModel.class, "vehicleInformationModel")
					.createAlias("vehicleModel.vehicleManufacturerModel", "vehicleManufacturerModel")
					.add(Restrictions.eq("vehicleFuelTypeModel.vehicleFuelTypeId",
							iVehicleTypeModel.getVehicleTypeId()))
					.add(Restrictions.eq("vehicleModel.vehicleModelId", iVehicleModel.getVehicleModelId()))
					.add(Restrictions.eq("vehicleTypeModel.vehicleTypeId", iVehicleTypeModel.getVehicleTypeId()))
					/*.add(Restrictions.eq("vehicleManufacturerModel.manufacturerId",
							iVehicleModel.getVehicleManufacturerModel().getManufacturerId()))*/
					.uniqueResult();

			/**** Check for user reg the vehicle ****/
			UserVehicleModel vehicleModel = (UserVehicleModel) theSession
					.createCriteria(UserVehicleModel.class, "userVehicleModel")
					.add(Restrictions.eq("userId", userVehicleModel1.getUserId()))
					.add(Restrictions.eq("vehicleRegNo", userVehicleModel1.getVehicleRegNo())).uniqueResult();

			if (vehicleInformationModel != null) {
				userVehicleModel1.setVehicleInformationModel(vehicleInformationModel);
				
				if(userVehicleModel1.getVehicleId() == 0) {
					if(vehicleModel != null) {
						RSAException rsaEx = new RSAException();
						rsaEx.setError(RSAErrorConstants.ErrorCode.VEHICLE_INFORMATION_ALREADY_EXISTS_FOR_THIS_USER_ERROR);
						throw rsaEx;
					}
				}
				
				theSession.saveOrUpdate(userVehicleModel1);
			} else {
				RSAException rsaEx = new RSAException();
				rsaEx.setError(RSAErrorConstants.ErrorCode.INVALID_VEHICLE_INFORMATION_MODEL_ID_ERROR);
				throw rsaEx;
			}

		} catch (RSAException e) {
			throw e;
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return userVehicleModel1;
	}

}
