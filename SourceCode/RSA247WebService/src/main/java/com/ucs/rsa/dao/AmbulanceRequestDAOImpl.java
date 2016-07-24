package com.ucs.rsa.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.dto.AmbulanceRequestDTO;
import com.ucs.rsa.common.dto.CustomerRequestDTO;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.domain.AmbulanceRequest;

@Component
public class AmbulanceRequestDAOImpl extends BaseRepository implements ICustomerRequestDAO {

	@Override
	public CustomerRequestDTO updateUser(CustomerRequestDTO iCustomerRequestDTO, boolean isCreate) {
		AmbulanceRequestDTO ambulanceRequestDTO = (AmbulanceRequestDTO) iCustomerRequestDTO;
		Session theSession = null;
		try {
			theSession = currentSession();
			AmbulanceRequest ambulanceRequest = null;
			ambulanceRequest = new AmbulanceRequest();
			ambulanceRequest.setAmount(ambulanceRequestDTO.getAmount());
			ambulanceRequest.setUserId(ambulanceRequestDTO.getUserId());
			ambulanceRequest.setCustomerLatitude(ambulanceRequestDTO.getCustomerLatitude());
			ambulanceRequest.setCustomerLongitude(ambulanceRequestDTO.getCustomerLongitude());
			ambulanceRequest.setEmployeeId(ambulanceRequestDTO.getEmployeeId());
			ambulanceRequest.setIssueId(ambulanceRequestDTO.getIssueId());
			ambulanceRequest.setIssueStatus(ambulanceRequestDTO.getIssueStatus());
			ambulanceRequest.setIssueType(ambulanceRequestDTO.getIssueType());

			System.out.println("Before Save");
			theSession.save(ambulanceRequest);
			System.out.println("After Save");
			if (ambulanceRequest != null) {
				ambulanceRequestDTO.setUserId(ambulanceRequest.getUserId());
				ambulanceRequestDTO.setAmount(ambulanceRequest.getAmount());
				ambulanceRequestDTO.setCustomerLatitude(ambulanceRequest.getCustomerLatitude());
				ambulanceRequestDTO.setCustomerLongitude(ambulanceRequest.getCustomerLongitude());
				ambulanceRequestDTO.setEmployeeId(ambulanceRequest.getEmployeeId());
				ambulanceRequestDTO.setIssueId(ambulanceRequest.getIssueId());
				ambulanceRequestDTO.setIssueStatus(ambulanceRequest.getIssueStatus());
				ambulanceRequestDTO.setIssueType(ambulanceRequest.getIssueType());
				System.out.println("userDTO " + ambulanceRequestDTO);

			}
		} catch (RSAException rsaException) {
			System.out.println(rsaException.getStackTrace());
			throw rsaException;
		} catch (RuntimeException runtimeException) {
			runtimeException.getStackTrace();
			System.out.println(runtimeException.getStackTrace());
			RSAException rsaException = new RSAException();
			rsaException.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaException;
		}
		CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();
		return customerRequestDTO;
	}

}
