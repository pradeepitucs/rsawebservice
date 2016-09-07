package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employeeDashboard", namespace = "com.ucs.rsa.common.dto")
public class EmployeeDashboard implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int rejectedIssue;
	
	private int completedIssue;
	
	private double completedIssueInPercentage;
	
	public double getCompletedIssueInPercentage() {
		return completedIssueInPercentage;
	}

	public void setCompletedIssueInPercentage(double completedIssueInPercentage) {
		this.completedIssueInPercentage = completedIssueInPercentage;
	}

	private double rating;
	
	private double earning;

	public int getRejectedIssue() {
		return rejectedIssue;
	}

	public void setRejectedIssue(int rejectedIssue) {
		this.rejectedIssue = rejectedIssue;
	}

	public int getCompletedIssue() {
		return completedIssue;
	}

	public void setCompletedIssue(int completedIssue) {
		this.completedIssue = completedIssue;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getEarning() {
		return earning;
	}

	public void setEarning(double earning) {
		this.earning = earning;
	}

}
