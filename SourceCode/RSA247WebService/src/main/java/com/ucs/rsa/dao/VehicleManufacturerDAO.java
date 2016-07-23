package com.ucs.rsa.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.dto.VehicleManufacturerDTO;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.domain.VehicleManufacturer;

@Component
public class VehicleManufacturerDAO extends BaseRepository implements IVehicleManufacturerDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<VehicleManufacturerDTO> getVehicleManufacturers(String iVehicleManufacturerId) {
		List<VehicleManufacturer> theVehicleManufacturersList = null;
		List<VehicleManufacturerDTO> vehicleManufacturersDTOs = new ArrayList<>();
		Session theSession = null;
		try {
			theSession = currentSession();
			final Criteria theCriteria = theSession.createCriteria(VehicleManufacturer.class, "vehicleManufacturer")
					.add(Restrictions.eq("manufacturerID", Integer.valueOf(iVehicleManufacturerId)));
			theVehicleManufacturersList = (List<VehicleManufacturer>) theCriteria.list();

			if (!theVehicleManufacturersList.isEmpty()) {
				for (VehicleManufacturer vehicleManufacturers : theVehicleManufacturersList) {
					VehicleManufacturerDTO vehicleManufacturerDTO = new VehicleManufacturerDTO();
					vehicleManufacturerDTO.setEnabled(vehicleManufacturers.isEnabled());
					vehicleManufacturerDTO.setManufacturerName(vehicleManufacturers.getManufacturerName());
					vehicleManufacturerDTO.setManufacturesrID(vehicleManufacturers.getManufacturerID());
					vehicleManufacturersDTOs.add(vehicleManufacturerDTO);
				}
			}
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return vehicleManufacturersDTOs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VehicleManufacturerDTO> getVehicleManufacturers() {
		List<VehicleManufacturer> theVehicleManufacturersList = null;
		List<VehicleManufacturerDTO> vehicleManufacturerDTOs = new ArrayList<>();
		Session theSession = null;
		try {
			theSession = currentSession();
			final Criteria theCriteria = theSession.createCriteria(VehicleManufacturer.class, "vehicleModuleDetails");
			theVehicleManufacturersList = (List<VehicleManufacturer>) theCriteria.list();

			if (!theVehicleManufacturersList.isEmpty()) {
				for (VehicleManufacturer vehicleManufacturers : theVehicleManufacturersList) {
					VehicleManufacturerDTO vehicleManufacturerDTO = new VehicleManufacturerDTO();
					vehicleManufacturerDTO.setEnabled(vehicleManufacturers.isEnabled());
					vehicleManufacturerDTO.setManufacturerName(vehicleManufacturers.getManufacturerName());
					vehicleManufacturerDTO.setManufacturesrID(vehicleManufacturers.getManufacturerID());
					vehicleManufacturerDTOs.add(vehicleManufacturerDTO);
				}
			}
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return vehicleManufacturerDTOs;
	}

}
