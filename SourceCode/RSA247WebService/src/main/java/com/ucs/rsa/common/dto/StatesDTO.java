package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "states", namespace = "com.ucs.rsa.common.dto")
public class StatesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<StateDTO> states;

	public List<StateDTO> getStates() {
		return states;
	}

	public void setStates(List<StateDTO> states) {
		this.states = states;
	}

	@Override
	public String toString() {
		return "StatesDTO [state=" + states + "]";
	}

}
