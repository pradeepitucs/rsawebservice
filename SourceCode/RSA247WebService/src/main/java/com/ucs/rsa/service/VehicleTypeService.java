package com.ucs.rsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.dto.VehicleTypeDTO;
import com.ucs.rsa.common.dto.VehicleTypesDTO;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.dao.IVehicleTypesDAO;

@Component
public class VehicleTypeService extends BaseManagerImpl implements IVehicleTypeService {

	@Autowired
	private IVehicleTypesDAO vehicleTypeDetailsDAO;

	@Override
	public List<VehicleTypeDTO> getVehicleTypes() {
		List<VehicleTypeDTO> vehicleTypeDetailDTOs = null;
		vehicleTypeDetailDTOs = vehicleTypeDetailsDAO.getVehicleTypes();
		return vehicleTypeDetailDTOs;
	}

	@Override
	public VehicleTypesDTO getVehicleTypes(int iVehicleTypeDetailsId) {
		List<VehicleTypeDTO> vehicleTypesDTOs = null;
		if (validateGetVehicleTypeDetails(iVehicleTypeDetailsId)) {
			vehicleTypesDTOs = vehicleTypeDetailsDAO.getVehicleTypes(iVehicleTypeDetailsId);
		} else {
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		VehicleTypesDTO vehicleTypesDTO = new VehicleTypesDTO();
		vehicleTypesDTO.setVehicleTypeDTO(vehicleTypesDTOs);
		return vehicleTypesDTO;
	}

	private boolean validateGetVehicleTypeDetails(int iVehicleTypeDetailsId) {
		boolean isValid = Boolean.FALSE;
		if (0 != iVehicleTypeDetailsId) {
			isValid = Boolean.TRUE;
		}
		return isValid;
	}

}
