package com.ucs.rsa.service;

import java.util.List;

import com.ucs.rsa.common.dto.StateDTO;
import com.ucs.rsa.common.dto.StatesDTO;

public interface IStateService {

	public List<StateDTO> getStates();
	
	public StatesDTO getStates(String iStateId);
	
}
