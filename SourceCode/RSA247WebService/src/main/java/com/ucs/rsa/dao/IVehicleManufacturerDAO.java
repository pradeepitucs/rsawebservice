package com.ucs.rsa.dao;

import java.util.List;

import com.ucs.rsa.common.dto.VehicleManufacturerDTO;

public interface IVehicleManufacturerDAO {

	List<VehicleManufacturerDTO> getVehicleManufacturers(String iVehicleManufacturerId);

	List<VehicleManufacturerDTO> getVehicleManufacturers();

}

