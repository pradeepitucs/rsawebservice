package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "states", namespace = "com.ucs.rsa.common.dto")

public class StatesDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<StateDTO> stateDTOs;

	@XmlElement(name = "state")
	public List<StateDTO> getStateDTOs() {
		return stateDTOs;
	}

	public void setStateDTOs(List<StateDTO> stateDTOs) {
		this.stateDTOs = stateDTOs;
	}

}