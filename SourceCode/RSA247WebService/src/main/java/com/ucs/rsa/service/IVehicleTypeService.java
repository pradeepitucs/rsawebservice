package com.ucs.rsa.service;

import java.util.List;

import com.ucs.rsa.common.dto.VehicleTypeDTO;
import com.ucs.rsa.common.dto.VehicleTypesDTO;

public interface IVehicleTypeService {

	List<VehicleTypeDTO> getVehicleTypes();
	
	VehicleTypesDTO getVehicleTypes(int iVehicleTypesId);

}
