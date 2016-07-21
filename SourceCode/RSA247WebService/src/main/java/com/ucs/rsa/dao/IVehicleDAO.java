package com.ucs.rsa.dao;

import java.util.List;

import com.ucs.rsa.common.dto.VehicleDTO;

public interface IVehicleDAO {

	List<VehicleDTO> getVehicles();

	List<VehicleDTO> getVehicles(String iVehicleId);

	VehicleDTO updateVehicle(VehicleDTO iVehicleDTO, boolean isCreated);

}
