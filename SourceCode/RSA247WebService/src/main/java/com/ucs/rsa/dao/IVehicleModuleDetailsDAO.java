package com.ucs.rsa.dao;

import java.util.List;

import com.ucs.rsa.common.dto.VehicleModuleDetailDTO;

public interface IVehicleModuleDetailsDAO {

	List<VehicleModuleDetailDTO> getVehicleModuleDetails(String iVehicleModuleDetailsId);

	List<VehicleModuleDetailDTO> getVehicleModuleDetails();

}

