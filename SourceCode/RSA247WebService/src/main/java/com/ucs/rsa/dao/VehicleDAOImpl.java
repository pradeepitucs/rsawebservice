package com.ucs.rsa.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.dto.VehicleDTO;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.domain.Vehicle;

@Component
public class VehicleDAOImpl extends BaseRepository implements IVehicleDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<VehicleDTO> getVehicles() {
		List<Vehicle> theVehicleList = null;
		List<VehicleDTO> vehicleDTOs = new ArrayList<>();
		Session theSession = null;
		try {
			theSession = currentSession();
			final Criteria theCriteria = theSession.createCriteria(Vehicle.class, "vehicle");
			theVehicleList = (List<Vehicle>) theCriteria.list();

			if (!theVehicleList.isEmpty()) {
				for (Vehicle vehicle : theVehicleList) {
					VehicleDTO vehicleDTO = new VehicleDTO();
					vehicleDTO.setEnabled(vehicle.isEnabled());
					vehicleDTO.setUserId(vehicle.getUserId());
					vehicleDTO.setVehicleID(vehicle.getVehicleID());
					vehicleDTO.setVehicleModuleID(vehicle.getVehicleModuleID());
					vehicleDTO.setVehicleNo(vehicle.getVehicleNo());
					vehicleDTOs.add(vehicleDTO);
				}
			}

		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return vehicleDTOs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VehicleDTO> getVehicles(int iVehicleId) {
		List<Vehicle> theVehicleList = null;
		List<VehicleDTO> vehicleDTOs = new ArrayList<>();
		Session theSession = null;
		try {
			theSession = currentSession();
			final Criteria theCriteria = theSession.createCriteria(Vehicle.class, "vehicle")
					.add(Restrictions.eq("vehicleID", Integer.valueOf(iVehicleId) ));
			theVehicleList = (List<Vehicle>) theCriteria.list();

			if (!theVehicleList.isEmpty()) {
				for (Vehicle vehicle : theVehicleList) {
					VehicleDTO vehicleDTO = new VehicleDTO();
					vehicleDTO.setEnabled(vehicle.isEnabled());
					vehicleDTO.setUserId(vehicle.getUserId());
					vehicleDTO.setVehicleID(vehicle.getVehicleID());
					vehicleDTO.setVehicleModuleID(vehicle.getVehicleModuleID());
					vehicleDTO.setVehicleNo(vehicle.getVehicleNo());
					vehicleDTOs.add(vehicleDTO);
				}
			}

		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return vehicleDTOs;
	}

	@Override
	public VehicleDTO updateVehicle(VehicleDTO iVehicleDTO, boolean isCreated) {
		VehicleDTO vehicleDTO = (VehicleDTO) iVehicleDTO;
		Session theSession = null;

		try {

			theSession = currentSession();
			Vehicle vehicle = null;

//			vehicle = (Vehicle) theSession.createCriteria(Vehicle.class, "vehicle").uniqueResult();
//			if (vehicle != null) {
//				System.out.println("rsaException");
//				RSAException rsaException = new RSAException();
//				System.out.println("rsaException" + rsaException);
//				rsaException.setError(RSAErrorConstants.ErrorCode.USERNAME_ALREADY_EXISTS_ERROR);
//				throw rsaException;
//			}
			vehicle = new Vehicle();
			vehicle.setEnabled(iVehicleDTO.isEnabled());
			vehicle.setUserId(iVehicleDTO.getUserId());
			vehicle.setVehicleModuleID(iVehicleDTO.getVehicleModuleID());
			vehicle.setVehicleNo(iVehicleDTO.getVehicleNo());
			vehicle.setVehicleID(iVehicleDTO.getVehicleID());

			
			theSession.saveOrUpdate("vehicle", vehicle);
			
			vehicle = (Vehicle) theSession.createCriteria(Vehicle.class, "vehicle").add(Restrictions.eq("vehicleNo", vehicle.getVehicleNo())).uniqueResult();

			System.out.println(vehicle);
			if (vehicle != null) {
				vehicleDTO.setEnabled(vehicle.isEnabled());
				vehicleDTO.setUserId(vehicle.getUserId());
				vehicleDTO.setVehicleID(vehicle.getVehicleID());
				vehicleDTO.setVehicleModuleID(vehicle.getVehicleModuleID());
				vehicleDTO.setVehicleNo(vehicle.getVehicleNo());
			}
			System.out.println("userDTO " + vehicleDTO);

		} catch (RSAException rsaException) {
			System.out.println(rsaException.getStackTrace());
			throw rsaException;
		} catch (RuntimeException runtimeException) {
			runtimeException.getStackTrace();
			System.out.println(runtimeException.getStackTrace());
			RSAException rsaException = new RSAException();
			rsaException.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaException;
		}
		return vehicleDTO;

	}

}
