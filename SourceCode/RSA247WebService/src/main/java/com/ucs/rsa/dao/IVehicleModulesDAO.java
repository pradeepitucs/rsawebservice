package com.ucs.rsa.dao;

import java.util.List;

import com.ucs.rsa.common.dto.VehicleModuleDTO;

public interface IVehicleModulesDAO {

	List<VehicleModuleDTO> getVehicleModules(String iVehicleModulesId);

	List<VehicleModuleDTO> getVehicleModules();

}

