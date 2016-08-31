package com.ucs.rsa.service;

public interface GmailService {

	public void readyToSendEmail(String from, String to, String subject, String msg);
	
}
