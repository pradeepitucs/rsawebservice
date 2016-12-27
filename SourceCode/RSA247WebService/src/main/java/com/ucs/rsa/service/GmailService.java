/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.service;


/**
 * The Interface GmailService.
 */
public interface GmailService {

	/**
	 * Ready to send email.
	 *
	 * @param from the from
	 * @param to the to
	 * @param subject the subject
	 * @param msg the msg
	 */
	public void readyToSendEmail(String from, String to, String subject, String msg);
	
}
