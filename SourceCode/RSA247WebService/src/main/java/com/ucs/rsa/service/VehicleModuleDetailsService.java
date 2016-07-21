package com.ucs.rsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.dto.VehicleModuleDetailDTO;
import com.ucs.rsa.common.dto.VehicleModuleDetailsDTO;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.dao.IVehicleModuleDetailsDAO;

@Component
public class VehicleModuleDetailsService extends BaseManagerImpl implements IVehicleModuleDetailsService {

	@Autowired
	private IVehicleModuleDetailsDAO vehicleModuleDetailsDAO;

	@Override
	public VehicleModuleDetailDTO updateVehicleModuleDetails(VehicleModuleDetailDTO vehicleModuleDetailDTO,
			boolean isCreated) {
		return null;
	}

	@Override
	public List<VehicleModuleDetailDTO> getVehicleModuleDetails() {
		List<VehicleModuleDetailDTO> vehicleModuleDetailDTOs = null;
		vehicleModuleDetailDTOs = vehicleModuleDetailsDAO.getVehicleModuleDetails();
		return vehicleModuleDetailDTOs;
	}

	@Override
	public VehicleModuleDetailsDTO getVehicleModuleDetails(String iVehicleModuleDetailsId) {
		List<VehicleModuleDetailDTO> vehicleModuleDetailsDTOs = null;
		if (validateGetVehicleModuleDetails(iVehicleModuleDetailsId)) {
			vehicleModuleDetailsDTOs = vehicleModuleDetailsDAO.getVehicleModuleDetails(iVehicleModuleDetailsId);
		} else {
			RSAException rsaEx = new RSAException();
			rsaEx.setError(RSAErrorConstants.ErrorCode.MANDATORY_PARAMS_MISSING_ERROR);
			throw rsaEx;
		}
		VehicleModuleDetailsDTO vehicleModuleDetailsDTO = new VehicleModuleDetailsDTO();
		vehicleModuleDetailsDTO.setVehicleModuleDetaislDTO(vehicleModuleDetailsDTOs);
		return vehicleModuleDetailsDTO;
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
