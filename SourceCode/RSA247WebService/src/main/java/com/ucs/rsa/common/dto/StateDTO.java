package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "state", namespace = "com.ucs.rsa.common.dto")
public class StateDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int stateID;
	private String stateName;
	private String stateCode;
	private boolean isEnabled;

	public int getStateID() {
		return stateID;
	}

	public void setStateID(int stateID) {
		this.stateID = stateID;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Override
	public String toString() {
		return "StateDTO [stateID=" + stateID + ", stateName=" + stateName + ", stateCode=" + stateCode + ", isEnabled="
				+ isEnabled + "]";
	}

}
