/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;
import java.util.List;


// TODO: Auto-generated Javadoc
/**
 * The Class FacetResultDTO.
 */
public class FacetResultDTO
{

	/** The result. */
	private Serializable result;

	/** The facets. */
	private List<FacetDTO> facets;

	/**
	 * Gets the result.
	 *
	 * @return the result
	 */
	public Serializable getResult()
	{
		return result;
	}

	/**
	 * Sets the result.
	 *
	 * @param result
	 *           the new result
	 */
	public void setResult(Serializable result)
	{
		this.result = result;
	}

	/**
	 * Gets the facets.
	 *
	 * @return the facets
	 */
	public List<FacetDTO> getFacets()
	{
		return facets;
	}

	/**
	 * Sets the facets.
	 *
	 * @param facets
	 *           the new facets
	 */
	public void setFacets(List<FacetDTO> facets)
	{
		this.facets = facets;
	}

}

class FacetDTO
{


	private String displayName;
	private String value;

	public FacetDTO(String displayName, String value)
	{
		super();
		this.displayName = displayName;
		this.value = value;
	}


	public String getDisplayName()
	{
		return displayName;
	}

	public void setDisplayName(String displayName)
	{
		this.displayName = displayName;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}
}
