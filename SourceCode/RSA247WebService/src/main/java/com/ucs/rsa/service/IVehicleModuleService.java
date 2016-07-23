package com.ucs.rsa.service;

import java.util.List;

import com.ucs.rsa.common.dto.VehicleModuleDTO;
import com.ucs.rsa.common.dto.VehicleModulesDTO;

public interface IVehicleModuleService {

	List<VehicleModuleDTO> getVehicleModules();
	
	VehicleModulesDTO getVehicleModules(int iVehicleModulesId);

	VehicleModulesDTO getVehicleManufacturers(int iVehicleManufacturersId);

}
