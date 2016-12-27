/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.ucs.rsa.service.GmailService;


/**
 * The Class DefaultGmailService.
 */
@Service
public class DefaultGmailService implements GmailService {

	/** The mail sender. */
	@Autowired
	private MailSender mailSender;
	
	/* (non-Javadoc)
	 * @see com.ucs.rsa.service.GmailService#readyToSendEmail(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void readyToSendEmail(String from, String to, String subject, String msg) {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		mailSender.send(message);
	}

	/**
	 * Gets the mail sender.
	 *
	 * @return the mail sender
	 */
	public MailSender getMailSender() {
		return mailSender;
	}

	/**
	 * Sets the mail sender.
	 *
	 * @param mailSender the new mail sender
	 */
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

}
