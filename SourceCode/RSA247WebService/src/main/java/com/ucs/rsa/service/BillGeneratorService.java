/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.service;

/**
 * The Interface BillGeneratorService.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
public interface BillGeneratorService extends BaseService
{

	/**
	 * Genert bill.
	 *
	 * @return the string builder
	 */
	public StringBuilder genertBill();

}
