package com.ucs.rsa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ambulance_t")
@PrimaryKeyJoinColumn(name = "issue_id")
@NamedQuery(name = "AmbulanceRequest.findAll", query = "SELECT c FROM AmbulanceRequest c")
public class AmbulanceRequest extends CustomerRequest implements Serializable{

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

	public AmbulanceRequest() {
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "AmbulanceRequest [amount=" + amount + "employeeId=" + employeeId + "]"
				+ super.toString();
	}

}
