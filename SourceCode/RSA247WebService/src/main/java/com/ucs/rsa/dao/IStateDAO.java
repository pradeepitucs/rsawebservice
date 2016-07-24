package com.ucs.rsa.dao;

import java.util.List;

import com.ucs.rsa.common.dto.StateDTO;
import com.ucs.rsa.common.dto.StatesDTO;

public interface IStateDAO {

public List<StateDTO> getStates();
	
	public StatesDTO getStates(String iStateId);
	
}
