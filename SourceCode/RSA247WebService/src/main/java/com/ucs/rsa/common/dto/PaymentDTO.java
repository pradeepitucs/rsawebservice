/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.util.Hashtable;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class PaymentDTO.
 */
@XmlRootElement(name = "payment", namespace = "com.ucs.rsa.common.dto")
public class PaymentDTO
{

	/** The hash table. */
	Hashtable<String, String> hashTable;

	/**
	 * Gets the hash table.
	 *
	 * @return the hash table
	 */
	public Hashtable<String, String> getHashTable()
	{
		return hashTable;
	}

	/**
	 * Sets the hash table.
	 *
	 * @param hashTable
	 *           the hash table
	 */
	public void setHashTable(Hashtable<String, String> hashTable)
	{
		this.hashTable = hashTable;
	}

}
