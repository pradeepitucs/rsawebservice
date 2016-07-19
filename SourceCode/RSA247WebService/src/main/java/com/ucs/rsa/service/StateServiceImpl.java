package com.ucs.rsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ucs.rsa.common.dto.StateDTO;
import com.ucs.rsa.common.dto.StatesDTO;
import com.ucs.rsa.dao.IStateDAO;

@Component
public class StateServiceImpl extends BaseManagerImpl implements IStateService {

	@Autowired
	private IStateDAO stateDAOImpl;

	@Override
	@Transactional
	public List<StateDTO> getStates() {
		List<StateDTO> stateDTOs = null;
		stateDTOs = stateDAOImpl.getStates();
		return stateDTOs;
	}

	@Override
	@Transactional
	public StatesDTO getStates(String iStateId) {
		StatesDTO statesDTO = null;
		statesDTO = stateDAOImpl.getStates(iStateId);
		return statesDTO;
	}

}
