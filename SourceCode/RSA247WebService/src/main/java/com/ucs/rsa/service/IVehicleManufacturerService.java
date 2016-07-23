package com.ucs.rsa.service;

import java.util.List;

import com.ucs.rsa.common.dto.VehicleManufacturerDTO;
import com.ucs.rsa.common.dto.VehicleManufacturersDTO;

public interface IVehicleManufacturerService {

	VehicleManufacturersDTO getVehicleManufacturers(int iVehicleManufacturerId);

	List<VehicleManufacturerDTO> getVehicleManufacturers();

}

