/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class EmployeeDashboard.
 */
@XmlRootElement(name = "employeeDashboard", namespace = "com.ucs.rsa.common.dto")
public class EmployeeDashboard implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The rejected issue. */
	private int rejectedIssue;

	/** The completed issue. */
	private int completedIssue;

	/** The completed issue in percentage. */
	private double completedIssueInPercentage;

	/**
	 * Gets the completed issue in percentage.
	 *
	 * @return the completed issue in percentage
	 */
	public double getCompletedIssueInPercentage()
	{
		return completedIssueInPercentage;
	}

	/**
	 * Sets the completed issue in percentage.
	 *
	 * @param completedIssueInPercentage
	 *           the new completed issue in percentage
	 */
	public void setCompletedIssueInPercentage(double completedIssueInPercentage)
	{
		this.completedIssueInPercentage = completedIssueInPercentage;
	}

	/** The rating. */
	private double rating;

	/** The earning. */
	private double earning;

	/**
	 * Gets the rejected issue.
	 *
	 * @return the rejected issue
	 */
	public int getRejectedIssue()
	{
		return rejectedIssue;
	}

	/**
	 * Sets the rejected issue.
	 *
	 * @param rejectedIssue
	 *           the new rejected issue
	 */
	public void setRejectedIssue(int rejectedIssue)
	{
		this.rejectedIssue = rejectedIssue;
	}

	/**
	 * Gets the completed issue.
	 *
	 * @return the completed issue
	 */
	public int getCompletedIssue()
	{
		return completedIssue;
	}

	/**
	 * Sets the completed issue.
	 *
	 * @param completedIssue
	 *           the new completed issue
	 */
	public void setCompletedIssue(int completedIssue)
	{
		this.completedIssue = completedIssue;
	}

	/**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public double getRating()
	{
		return rating;
	}

	/**
	 * Sets the rating.
	 *
	 * @param rating
	 *           the new rating
	 */
	public void setRating(double rating)
	{
		this.rating = rating;
	}

	/**
	 * Gets the earning.
	 *
	 * @return the earning
	 */
	public double getEarning()
	{
		return earning;
	}

	/**
	 * Sets the earning.
	 *
	 * @param earning
	 *           the new earning
	 */
	public void setEarning(double earning)
	{
		this.earning = earning;
	}

}
