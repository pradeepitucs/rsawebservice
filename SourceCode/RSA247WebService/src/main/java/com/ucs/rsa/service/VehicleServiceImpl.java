package com.ucs.rsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.dto.UserDTO;
import com.ucs.rsa.common.dto.VehicleDTO;
import com.ucs.rsa.common.dto.VehiclesDTO;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.dao.IVehicleDAO;

@Component
public class VehicleServiceImpl extends BaseManagerImpl implements IVehicleService {
	
	@Autowired
	private IVehicleDAO vehicleDAO;

	@Override
	public VehicleDTO updateVehicle(VehicleDTO iVehicleDTO, boolean isCreated) {
		VehicleDTO vehicleDTO = null;

		if (!"".equals(iVehicleDTO.getVehicleModuleID()) && !"".equals(iVehicleDTO.getUserId()) ) {
			vehicleDTO = vehicleDAO.updateVehicle(iVehicleDTO,isCreated);
		} else {
			RSAException rsaException = new RSAException();
			rsaException
					.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaException;
		}
		return vehicleDTO;
	}

	@Override
	public List<VehicleDTO> getVehicles() {
		List<VehicleDTO> vehicleDTOs = null;
		vehicleDTOs = vehicleDAO.getVehicles();
		return vehicleDTOs;
	}

	@Override
	public VehiclesDTO getVehicles(String iVehicleId) {
		List<VehicleDTO> vehicleDTOs = null;
		if(validateGetVehicles(iVehicleId)) {
			vehicleDTOs = vehicleDAO.getVehicles(iVehicleId);
		} else {
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		VehiclesDTO vehiclesDTO = new VehiclesDTO();
		vehiclesDTO.setVehiclesDTO(vehicleDTOs);
		return vehiclesDTO;
	}

	private boolean validateGetVehicles(String iVehicleId) {
		boolean isValid = Boolean.FALSE;
		if(null != iVehicleId && "" != iVehicleId) {
			isValid = Boolean.TRUE;
			try {
				Integer.valueOf(iVehicleId);
			} catch (RuntimeException e) {
				RSAException rsaEx = new RSAException();
				rsaEx.setError(RSAErrorConstants.ErrorCode.INVALID_INPUT_PARAM_ERROR);
				throw rsaEx;
			}
		}
		return isValid;
	}
}
