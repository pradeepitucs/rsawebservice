package com.ucs.rsa.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ucs.rsa.common.constants.RSAErrorConstants;
import com.ucs.rsa.common.dto.StateDTO;
import com.ucs.rsa.common.dto.StatesDTO;
import com.ucs.rsa.common.exception.RSAException;
import com.ucs.rsa.domain.State;

@Component
public class StateDAOImpl extends BaseRepository implements IStateDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<StateDTO> getStates() {
		List<State> stateList = null;
		List<StateDTO> stateDTOsList = new ArrayList<>();
		Session theSession = null;
		try {
			theSession = currentSession();
			Criteria criteria = theSession.createCriteria(State.class, "state");
			stateList = (List<State>) criteria.list();
			// BeanUtils.copyProperties(stateList, stateDTOsList);

			if (!stateList.isEmpty()) {
				for (State state : stateList) {
					StateDTO stateDTO = new StateDTO();
					stateDTO.setEnabled(state.isEnabled());
					stateDTO.setStateID(state.getStateID());
					stateDTO.setStateName(state.getStateName());
					stateDTO.setStateCode(state.getStateCode());
					stateDTOsList.add(stateDTO);
				}
			}

		} catch (RuntimeException e) {
			RSAException rsaException = new RSAException();
			rsaException.setRootCause(e);
			rsaException.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaException;
		}
		return stateDTOsList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public StatesDTO getStates(String iStateId) {
		List<State> stateList = null;
		StatesDTO statesDTO = new StatesDTO();
		Session theSession = null;
		try {
			theSession = currentSession();
			Criteria criteria = theSession.createCriteria(State.class, "state")
					.add(Restrictions.eq("stateID", iStateId));
			stateList = (List<State>) criteria.list();
			BeanUtils.copyProperties(stateList, statesDTO.getStates());

		} catch (RuntimeException e) {
			RSAException rsaException = new RSAException();
			rsaException.setRootCause(e);
			rsaException.setError(RSAErrorConstants.ErrorCode.SYSTEM_ERROR);
			throw rsaException;
		}
		return statesDTO;
	}

}
