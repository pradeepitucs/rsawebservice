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
	public VehicleModulesDTO getVehicleModules(String iVehicleModuleDetailsId) {
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

	private boolean validateGetVehicleModuleDetails(String iVehicleModuleDetailsId) {
		boolean isValid = Boolean.FALSE;
		if (null != iVehicleModuleDetailsId && "" != iVehicleModuleDetailsId) {
			isValid = Boolean.TRUE;
			try {
				Integer.valueOf(iVehicleModuleDetailsId);
			} catch (RuntimeException e) {
				RSAException rsaEx = new RSAException();
				rsaEx.setError(RSAErrorConstants.ErrorCode.INVALID_INPUT_PARAM_ERROR);
				throw rsaEx;
			}
		}
		return isValid;
	}

}
