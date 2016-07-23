package com.ucs.rsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.dto.VehicleModuleDTO;
import com.ucs.rsa.common.dto.VehicleModulesDTO;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.dao.IVehicleModulesDAO;

@Component
public class VehicleModuleService extends BaseManagerImpl implements IVehicleModuleService {

	@Autowired
	private IVehicleModulesDAO vehicleModuleDetailsDAO;

	@Override
	public List<VehicleModuleDTO> getVehicleModules() {
		List<VehicleModuleDTO> vehicleModuleDetailDTOs = null;
		vehicleModuleDetailDTOs = vehicleModuleDetailsDAO.getVehicleModules();
		return vehicleModuleDetailDTOs;
	}

	@Override
	public VehicleModulesDTO getVehicleModules(int iVehicleModuleDetailsId) {
		List<VehicleModuleDTO> vehicleModulesDTOs = null;
		if (validateGetVehicleModuleDetails(iVehicleModuleDetailsId)) {
			vehicleModulesDTOs = vehicleModuleDetailsDAO.getVehicleModules(iVehicleModuleDetailsId);
		} else {
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		VehicleModulesDTO vehicleModulesDTO = new VehicleModulesDTO();
		vehicleModulesDTO.setVehicleModuleDTO(vehicleModulesDTOs);
		return vehicleModulesDTO;
	}

	private boolean validateGetVehicleModuleDetails(int iVehicleModuleDetailsId) {
		boolean isValid = Boolean.FALSE;
		if (0 != iVehicleModuleDetailsId) {
			isValid = Boolean.TRUE;
		}
		return isValid;
	}

	@Override
	public VehicleModulesDTO getVehicleManufacturers(int iVehicleManufacturersId) {
		List<VehicleModuleDTO> vehicleModulesDTOs = null;
		if (validateGetVehicleModuleDetails(iVehicleManufacturersId)) {
			vehicleModulesDTOs = vehicleModuleDetailsDAO.getVehicleManufacturers(iVehicleManufacturersId);
		} else {
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		VehicleModulesDTO vehicleModulesDTO = new VehicleModulesDTO();
		vehicleModulesDTO.setVehicleModuleDTO(vehicleModulesDTOs);
		return vehicleModulesDTO;
	}

}
