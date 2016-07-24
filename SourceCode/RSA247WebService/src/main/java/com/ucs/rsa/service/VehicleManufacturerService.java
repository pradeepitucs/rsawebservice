package com.ucs.rsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.dto.VehicleManufacturerDTO;
import com.ucs.rsa.common.dto.VehicleManufacturersDTO;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.dao.IVehicleManufacturerDAO;


@Component
public class VehicleManufacturerService extends BaseManagerImpl implements IVehicleManufacturerService {

	@Autowired
	private IVehicleManufacturerDAO vehicleManufacturerDAO;

	@Override
	public VehicleManufacturersDTO getVehicleManufacturers(int iVehicleManufacturerId) {
		List<VehicleManufacturerDTO> vehicleManufacturerDTOs = null;
		if (validateGetVehicleManufacturers(iVehicleManufacturerId)) {
			vehicleManufacturerDTOs = vehicleManufacturerDAO.getVehicleManufacturers(iVehicleManufacturerId);
		} else {
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		VehicleManufacturersDTO vehicleManufacturersDTO = new VehicleManufacturersDTO();
		vehicleManufacturersDTO.setVehicleManufacturerDTOs(vehicleManufacturerDTOs);
		return vehicleManufacturersDTO;
	}

	@Override
	public List<VehicleManufacturerDTO> getVehicleManufacturers() {
		List<VehicleManufacturerDTO> vehicleManufacturerDTOs = null;
		vehicleManufacturerDTOs = vehicleManufacturerDAO.getVehicleManufacturers();
		return vehicleManufacturerDTOs;
	}

	private boolean validateGetVehicleManufacturers(int iVehicleManufacturerId) {
		boolean isValid = Boolean.FALSE;
		if (0 != iVehicleManufacturerId) {
			isValid = Boolean.TRUE;
		}
		return isValid;
	}

}
