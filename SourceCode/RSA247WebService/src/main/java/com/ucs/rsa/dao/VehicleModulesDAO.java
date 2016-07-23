package com.ucs.rsa.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.dto.VehicleModuleDTO;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.domain.VehicleModules;

@Component
public class VehicleModulesDAO extends BaseRepository implements IVehicleModulesDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<VehicleModuleDTO> getVehicleModules(String iVehicleModulesId) {
		List<VehicleModules> theVehicleModulesList = null;
		List<VehicleModuleDTO> vehicleModulesDTOs = new ArrayList<>();
		Session theSession = null;
		try {
			theSession = currentSession();
			final Criteria theCriteria = theSession.createCriteria(VehicleModules.class, "vehicleModuleDetails")
					.add(Restrictions.eq("moduleDetailsID", Integer.valueOf(iVehicleModulesId)));
			theVehicleModulesList = (List<VehicleModules>) theCriteria.list();

			if (!theVehicleModulesList.isEmpty()) {
				for (VehicleModules vehicleModules : theVehicleModulesList) {
					VehicleModuleDTO vehicleModuleDTO = new VehicleModuleDTO();
					vehicleModuleDTO.setEnabled(vehicleModules.isEnabled());
					vehicleModuleDTO.setManufacturer(vehicleModules.getManufacturer());
					vehicleModuleDTO.setModuleDetailsID(vehicleModules.getModuleDetailsID());
					vehicleModuleDTO.setModuleName(vehicleModules.getModuleName());
					vehicleModuleDTO.setModuleYear(vehicleModules.getModuleYear());
					vehicleModuleDTO.setVehicleCategory(vehicleModules.getVehicleCategory());
					vehicleModuleDTO.setVehicleClass(vehicleModules.getVehicleClass());
					vehicleModuleDTO.setVehicleTypeID(vehicleModules.getVehicleTypeID());
					vehicleModulesDTOs.add(vehicleModuleDTO);
				}
			}
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return vehicleModulesDTOs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VehicleModuleDTO> getVehicleModules() {
		List<VehicleModules> theVehicleModulesList = null;
		List<VehicleModuleDTO> vehicleModuleDTOs = new ArrayList<>();
		Session theSession = null;
		try {
			theSession = currentSession();
			final Criteria theCriteria = theSession.createCriteria(VehicleModules.class, "vehicleModuleDetails");
			theVehicleModulesList = (List<VehicleModules>) theCriteria.list();

			if (!theVehicleModulesList.isEmpty()) {
				for (VehicleModules vehicleModules : theVehicleModulesList) {
					VehicleModuleDTO vehicleVehicleModuleDTO = new VehicleModuleDTO();
					vehicleVehicleModuleDTO.setEnabled(vehicleModules.isEnabled());
					vehicleVehicleModuleDTO.setManufacturer(vehicleModules.getManufacturer());
					vehicleVehicleModuleDTO.setModuleDetailsID(vehicleModules.getModuleDetailsID());
					vehicleVehicleModuleDTO.setModuleName(vehicleModules.getModuleName());
					vehicleVehicleModuleDTO.setModuleYear(vehicleModules.getModuleYear());
					vehicleVehicleModuleDTO.setVehicleCategory(vehicleModules.getVehicleCategory());
					vehicleVehicleModuleDTO.setVehicleClass(vehicleModules.getVehicleClass());
					vehicleVehicleModuleDTO.setVehicleTypeID(vehicleModules.getVehicleTypeID());
					vehicleModuleDTOs.add(vehicleVehicleModuleDTO);
				}
			}
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return vehicleModuleDTOs;
	}

}
