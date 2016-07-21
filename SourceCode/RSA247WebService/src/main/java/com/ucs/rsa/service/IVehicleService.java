package com.ucs.rsa.service;

import java.util.List;

import com.ucs.rsa.common.dto.VehicleDTO;
import com.ucs.rsa.common.dto.VehiclesDTO;

public interface IVehicleService {

	VehicleDTO updateVehicle(VehicleDTO iVehicleDTO, boolean isCreated);

	List<VehicleDTO> getVehicles();

	VehiclesDTO getVehicles(String iVehicleId);

}
