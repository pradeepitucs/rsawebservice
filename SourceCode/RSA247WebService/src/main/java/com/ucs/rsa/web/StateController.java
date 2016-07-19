package com.ucs.rsa.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ucs.rsa.common.dto.StateDTO;
import com.ucs.rsa.common.dto.StatesDTO;
import com.ucs.rsa.service.IStateService;

@Controller
@RequestMapping("/state")
public class StateController {

	@Autowired
	private IStateService stateService;

	@RequestMapping(value = "/all", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView getAllState() {
		List<StateDTO> stateDTOsList = new ArrayList<>();
		stateDTOsList = stateService.getStates();
		StatesDTO statesDTO = new StatesDTO();
		statesDTO.setStates(stateDTOsList);
		return new ModelAndView("xml", "states", statesDTO);
	}

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public ModelAndView getStateDetails(@RequestParam("stateid") final String iStateId) {
		StatesDTO statesDTO = new StatesDTO();
		statesDTO = stateService.getStates(iStateId);
		List<StateDTO> stateDTOsList = statesDTO.getStates();
		StateDTO aStateDTO = null;
		if (!stateDTOsList.isEmpty()) {
			aStateDTO = stateDTOsList.get(0);
		} else {
			aStateDTO = new StateDTO();
		}
		return new ModelAndView("xml", "states", aStateDTO);
	}

}
