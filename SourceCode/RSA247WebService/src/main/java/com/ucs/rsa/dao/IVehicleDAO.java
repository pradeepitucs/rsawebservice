package com.ucs.rsa.dao;

import java.util.List;

import com.ucs.rsa.common.dto.VehicleDTO;

public interface IVehicleDAO {

	List<VehicleDTO> getVehicles();

	List<VehicleDTO> getVehicles(int iVehicleId);

	VehicleDTO updateVehicle(VehicleDTO iVehicleDTO, boolean isCreated);

}
