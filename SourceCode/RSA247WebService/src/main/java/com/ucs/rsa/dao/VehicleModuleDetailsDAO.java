package com.ucs.rsa.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.dto.VehicleModuleDetailDTO;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.domain.VehicleModuleDetails;

@Component
public class VehicleModuleDetailsDAO extends BaseRepository implements IVehicleModuleDetailsDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<VehicleModuleDetailDTO> getVehicleModuleDetails(String iVehicleModuleDetailsId) {
		List<VehicleModuleDetails> theVehicleModuleDetailsList = null;
		List<VehicleModuleDetailDTO> vehicleModuleDetailsDTOs = new ArrayList<>();
		Session theSession = null;
		try {
			theSession = currentSession();
			final Criteria theCriteria = theSession.createCriteria(VehicleModuleDetails.class, "vehicleModuleDetails")
					.add(Restrictions.eq("moduleDetailsID", iVehicleModuleDetailsId));
			theVehicleModuleDetailsList = (List<VehicleModuleDetails>) theCriteria.list();

			if (!theVehicleModuleDetailsList.isEmpty()) {
				for (VehicleModuleDetails vehicleModuleDetails : theVehicleModuleDetailsList) {
					VehicleModuleDetailDTO vehicleVehicleModuleDetailDTO = new VehicleModuleDetailDTO();
					vehicleVehicleModuleDetailDTO.setEnabled(vehicleModuleDetails.isEnabled());
					vehicleVehicleModuleDetailDTO.setManufacturer(vehicleModuleDetails.getManufacturer());
					vehicleVehicleModuleDetailDTO.setModuleDetailsID(vehicleModuleDetails.getModuleDetailsID());
					vehicleVehicleModuleDetailDTO.setModuleName(vehicleModuleDetails.getModuleName());
					vehicleVehicleModuleDetailDTO.setModuleYear(vehicleModuleDetails.getModuleYear());
					vehicleVehicleModuleDetailDTO.setVehicleCategory(vehicleModuleDetails.getVehicleCategory());
					vehicleVehicleModuleDetailDTO.setVehicleClass(vehicleModuleDetails.getVehicleClass());
					vehicleVehicleModuleDetailDTO.setVehicleTypeID(vehicleModuleDetails.getVehicleTypeID());
					vehicleModuleDetailsDTOs.add(vehicleVehicleModuleDetailDTO);
				}
			}
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return vehicleModuleDetailsDTOs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VehicleModuleDetailDTO> getVehicleModuleDetails() {
		List<VehicleModuleDetails> theVehicleModuleDetailsList = null;
		List<VehicleModuleDetailDTO> vehicleModuleDetailsDTOs = new ArrayList<>();
		Session theSession = null;
		try {
			theSession = currentSession();
			final Criteria theCriteria = theSession.createCriteria(VehicleModuleDetails.class, "vehicleModuleDetails");
			theVehicleModuleDetailsList = (List<VehicleModuleDetails>) theCriteria.list();

			if (!theVehicleModuleDetailsList.isEmpty()) {
				for (VehicleModuleDetails vehicleModuleDetails : theVehicleModuleDetailsList) {
					VehicleModuleDetailDTO vehicleVehicleModuleDetailDTO = new VehicleModuleDetailDTO();
					vehicleVehicleModuleDetailDTO.setEnabled(vehicleModuleDetails.isEnabled());
					vehicleVehicleModuleDetailDTO.setManufacturer(vehicleModuleDetails.getManufacturer());
					vehicleVehicleModuleDetailDTO.setModuleDetailsID(vehicleModuleDetails.getModuleDetailsID());
					vehicleVehicleModuleDetailDTO.setModuleName(vehicleModuleDetails.getModuleName());
					vehicleVehicleModuleDetailDTO.setModuleYear(vehicleModuleDetails.getModuleYear());
					vehicleVehicleModuleDetailDTO.setVehicleCategory(vehicleModuleDetails.getVehicleCategory());
					vehicleVehicleModuleDetailDTO.setVehicleClass(vehicleModuleDetails.getVehicleClass());
					vehicleVehicleModuleDetailDTO.setVehicleTypeID(vehicleModuleDetails.getVehicleTypeID());
					vehicleModuleDetailsDTOs.add(vehicleVehicleModuleDetailDTO);
				}
			}
		} catch (RuntimeException ex) {
			RSAException rsaEx = new RSAException();
			rsaEx.setRootCause(ex);
			rsaEx.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaEx;
		}
		return vehicleModuleDetailsDTOs;
	}

}
