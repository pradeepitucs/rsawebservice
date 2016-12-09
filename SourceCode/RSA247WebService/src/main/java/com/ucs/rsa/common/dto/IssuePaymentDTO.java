/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


// TODO: Auto-generated Javadoc
/**
 * The Class IssuePaymentDTO.
 *
 * @author GururajAM
 * @version 1.0
 */
@XmlRootElement(name = "issuePayment", namespace = "com.ucs.rsa.common.dto")
public class IssuePaymentDTO implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The payment id. */
	private String paymentId;

	/** The amount. */
	private String amount;

	/** The auth id code. */
	private String authIdCode;

	/** The issuer ref no. */
	private String issuerRefNo;

	/** The pg resp code. */
	private String pgRespCode;

	/** The pg txn no. */
	private String pgTxnNo;

	/** The signature. */
	private String signature;

	/** The transaction id. */
	private String transactionId;

	/** The tx id. */
	private String txId;

	/** The tx msg. */
	private String txMsg;

	/** The tx ref no. */
	private String txRefNo;

	/** The tx status. */
	private String txStatus;

	/** The issue ID. */
	private int issueID;

	/**
	 * Gets the payment id.
	 *
	 * @return the payment id
	 */
	public String getPaymentId()
	{
		return paymentId;
	}

	/**
	 * Sets the payment id.
	 *
	 * @param paymentId
	 *           the new payment id
	 */
	public void setPaymentId(String paymentId)
	{
		this.paymentId = paymentId;
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public String getAmount()
	{
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount
	 *           the new amount
	 */
	public void setAmount(String amount)
	{
		this.amount = amount;
	}

	/**
	 * Gets the auth id code.
	 *
	 * @return the auth id code
	 */
	public String getAuthIdCode()
	{
		return authIdCode;
	}

	/**
	 * Sets the auth id code.
	 *
	 * @param authIdCode
	 *           the new auth id code
	 */
	public void setAuthIdCode(String authIdCode)
	{
		this.authIdCode = authIdCode;
	}

	/**
	 * Gets the issuer ref no.
	 *
	 * @return the issuer ref no
	 */
	public String getIssuerRefNo()
	{
		return issuerRefNo;
	}

	/**
	 * Sets the issuer ref no.
	 *
	 * @param issuerRefNo
	 *           the new issuer ref no
	 */
	public void setIssuerRefNo(String issuerRefNo)
	{
		this.issuerRefNo = issuerRefNo;
	}

	/**
	 * Gets the pg resp code.
	 *
	 * @return the pg resp code
	 */
	public String getPgRespCode()
	{
		return pgRespCode;
	}

	/**
	 * Sets the pg resp code.
	 *
	 * @param pgRespCode
	 *           the new pg resp code
	 */
	public void setPgRespCode(String pgRespCode)
	{
		this.pgRespCode = pgRespCode;
	}

	/**
	 * Gets the pg txn no.
	 *
	 * @return the pg txn no
	 */
	public String getPgTxnNo()
	{
		return pgTxnNo;
	}

	/**
	 * Sets the pg txn no.
	 *
	 * @param pgTxnNo
	 *           the new pg txn no
	 */
	public void setPgTxnNo(String pgTxnNo)
	{
		this.pgTxnNo = pgTxnNo;
	}

	/**
	 * Gets the signature.
	 *
	 * @return the signature
	 */
	public String getSignature()
	{
		return signature;
	}

	/**
	 * Sets the signature.
	 *
	 * @param signature
	 *           the new signature
	 */
	public void setSignature(String signature)
	{
		this.signature = signature;
	}

	/**
	 * Gets the transaction id.
	 *
	 * @return the transaction id
	 */
	public String getTransactionId()
	{
		return transactionId;
	}

	/**
	 * Sets the transaction id.
	 *
	 * @param transactionId
	 *           the new transaction id
	 */
	public void setTransactionId(String transactionId)
	{
		this.transactionId = transactionId;
	}

	/**
	 * Gets the tx id.
	 *
	 * @return the tx id
	 */
	public String getTxId()
	{
		return txId;
	}

	/**
	 * Sets the tx id.
	 *
	 * @param txId
	 *           the new tx id
	 */
	public void setTxId(String txId)
	{
		this.txId = txId;
	}

	/**
	 * Gets the tx msg.
	 *
	 * @return the tx msg
	 */
	public String getTxMsg()
	{
		return txMsg;
	}

	/**
	 * Sets the tx msg.
	 *
	 * @param txMsg
	 *           the new tx msg
	 */
	public void setTxMsg(String txMsg)
	{
		this.txMsg = txMsg;
	}

	/**
	 * Gets the tx ref no.
	 *
	 * @return the tx ref no
	 */
	public String getTxRefNo()
	{
		return txRefNo;
	}

	/**
	 * Sets the tx ref no.
	 *
	 * @param txRefNo
	 *           the new tx ref no
	 */
	public void setTxRefNo(String txRefNo)
	{
		this.txRefNo = txRefNo;
	}

	/**
	 * Gets the tx status.
	 *
	 * @return the tx status
	 */
	public String getTxStatus()
	{
		return txStatus;
	}

	/**
	 * Sets the tx status.
	 *
	 * @param txStatus
	 *           the new tx status
	 */
	public void setTxStatus(String txStatus)
	{
		this.txStatus = txStatus;
	}

	/**
	 * Gets the issue ID.
	 *
	 * @return the issue ID
	 */
	public int getIssueID()
	{
		return issueID;
	}

	/**
	 * Sets the issue ID.
	 *
	 * @param issueID
	 *           the new issue ID
	 */
	public void setIssueID(int issueID)
	{
		this.issueID = issueID;
	}



}
