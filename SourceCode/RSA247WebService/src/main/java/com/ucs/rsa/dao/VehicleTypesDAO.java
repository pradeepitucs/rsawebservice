package com.ucs.rsa.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.dto.VehicleTypeDTO;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.domain.VehicleType;

@Component
public class VehicleTypesDAO extends BaseRepository implements IVehicleTypesDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<VehicleTypeDTO> getVehicleTypes(int iVehicleTypesId) {
		List<VehicleType> theVehicleTypesList = null;
		List<VehicleTypeDTO> vehicleTypesDTOs = new ArrayList<>();
		Session theSession = null;
		try {
			theSession = currentSession();
			final Criteria theCriteria = theSession.createCriteria(VehicleType.class, "vehicleType")
					.add(Restrictions.eq("vehicleType", iVehicleTypesId));
			theVehicleTypesList = (List<VehicleType>) theCriteria.list();

			if (!theVehicleTypesList.isEmpty()) {
				for (VehicleType vehicleTypes : theVehicleTypesList) {
					VehicleTypeDTO vehicleTypeDTO = new VehicleTypeDTO();
					vehicleTypeDTO.setVehicleType(vehicleTypes.getVehicleType());
					vehicleTypeDTO.setFuelType(vehicleTypes.getFuelType());
					vehicleTypeDTO.setVehicleTypeName(vehicleTypes.getVehicleTypeName());
					vehicleTypesDTOs.add(vehicleTypeDTO);
				}
			}
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return vehicleTypesDTOs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VehicleTypeDTO> getVehicleTypes() {
		List<VehicleType> theVehicleTypesList = null;
		List<VehicleTypeDTO> vehicleTypeDTOs = new ArrayList<>();
		Session theSession = null;
		try {
			theSession = currentSession();
			final Criteria theCriteria = theSession.createCriteria(VehicleType.class, "vehicleType");
			theVehicleTypesList = (List<VehicleType>) theCriteria.list();

			if (!theVehicleTypesList.isEmpty()) {
				for (VehicleType vehicleTypes : theVehicleTypesList) {
					VehicleTypeDTO vehicleTypeDTO = new VehicleTypeDTO();
					vehicleTypeDTO.setVehicleType(vehicleTypes.getVehicleType());
					vehicleTypeDTO.setFuelType(vehicleTypes.getFuelType());
					vehicleTypeDTO.setVehicleTypeName(vehicleTypes.getVehicleTypeName());
					vehicleTypeDTOs.add(vehicleTypeDTO);
				}
			}
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return vehicleTypeDTOs;
	}

}
