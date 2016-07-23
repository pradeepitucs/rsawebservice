package com.ucs.rsa.dao;

import java.util.List;

import com.ucs.rsa.common.dto.VehicleTypeDTO;

public interface IVehicleTypesDAO {

	List<VehicleTypeDTO> getVehicleTypes(int iVehicleTypesId);

	List<VehicleTypeDTO> getVehicleTypes();

}

