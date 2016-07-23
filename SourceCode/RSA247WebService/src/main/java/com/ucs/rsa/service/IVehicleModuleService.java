package com.ucs.rsa.service;

import java.util.List;

import com.ucs.rsa.common.dto.VehicleModuleDetailDTO;
import com.ucs.rsa.common.dto.VehicleModuleDetailsDTO;

public interface IVehicleModuleDetailsService {

	VehicleModuleDetailDTO updateVehicleModuleDetails(VehicleModuleDetailDTO vehicleModuleDetailDTO, boolean isCreated);

	List<VehicleModuleDetailDTO> getVehicleModuleDetails();

	VehicleModuleDetailsDTO getVehicleModuleDetails(String iVehicleModuleDetailsId);

}
