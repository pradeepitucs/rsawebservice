package com.ucs.rsa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ambulance_t")
@PrimaryKeyJoinColumn(name = "id")
public class AmbulanceRequest extends CustomerRequest {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "amount")
	private long amount;
	
	@Column(name = "employee_id")
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
		return "Customer [amount=" + amount +"employeeId=" + employeeId+ "]" + super.toString();
	}

}
