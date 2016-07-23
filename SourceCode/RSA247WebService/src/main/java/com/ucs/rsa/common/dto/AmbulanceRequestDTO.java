package com.ucs.rsa.common.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ambulance_request", namespace = "com.ucs.rsa.dto")
public class AmbulanceRequestDTO extends CustomerRequestDTO{
	
	private static final long serialVersionUID = 1L;
	
	private long amount;
	
	private int employeeId;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Customer [amount=" + amount+"employeeId=" + employeeId + "]" + super.toString();
	}

}
