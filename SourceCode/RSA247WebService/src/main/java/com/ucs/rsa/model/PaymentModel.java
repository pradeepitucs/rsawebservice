/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


// TODO: Auto-generated Javadoc
/**
 * The persistent class for the payment_t database table.
 * 
 * @author Gururaj A M
 * @version 1.0
 */
@Entity
@Table(name = "payment_t")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "PaymentModel.findAll", query = "SELECT u FROM PaymentModel u")
public class PaymentModel implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The payment id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private String paymentId;

	/** The address zip. *//*
								   * private String addressZip;
								   */

	/** The amount. */
	private String amount;

	/** The auth id code. */
	private String authIdCode;

	/** The first name. */
	/*
	 * private String firstName;
	 * 
	 *//** The info. *//*
							 * @Lob private String info;
							 */

	/** The issuer ref no. */
	private String issuerRefNo;

	/** The last name. *//*
								 * private String lastName;
								 */

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

	/**
	 * Instantiates a new payment model.
	 */
	public PaymentModel()
	{
	}

	/**
	 * Gets the payment id.
	 *
	 * @return the payment id
	 */
	public String getPaymentId()
	{
		return this.paymentId;
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
	 * Gets the address zip.
	 *
	 * @return the address zip
	 */
	/*
	 * public String getAddressZip() { return this.addressZip; }
	 * 
	 *//**
	   * Sets the address zip.
	   *
	   * @param addressZip
	   *           the new address zip
	   *//*
		  * public void setAddressZip(String addressZip) { this.addressZip = addressZip; }
		  */

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public String getAmount()
	{
		return this.amount;
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
		return this.authIdCode;
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
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	/*
	 * public String getFirstName() { return this.firstName; }
	 * 
	 *//**
	   * Sets the first name.
	   *
	   * @param firstName
	   *           the new first name
	   */
	/*
	 * public void setFirstName(String firstName) { this.firstName = firstName; }
	 * 
	 *//**
	   * Gets the info.
	   *
	   * @return the info
	   */
	/*
	 * public String getInfo() { return this.info; }
	 * 
	 *//**
	   * Sets the info.
	   *
	   * @param info
	   *           the new info
	   *//*
		  * public void setInfo(String info) { this.info = info; }
		  */

	/**
	 * Gets the issuer ref no.
	 *
	 * @return the issuer ref no
	 */
	public String getIssuerRefNo()
	{
		return this.issuerRefNo;
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
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	/*
	 * public String getLastName() { return this.lastName; }
	 * 
	 *//**
	   * Sets the last name.
	   *
	   * @param lastName
	   *           the new last name
	   *//*
		  * public void setLastName(String lastName) { this.lastName = lastName; }
		  */

	/**
	 * Gets the pg resp code.
	 *
	 * @return the pg resp code
	 */
	public String getPgRespCode()
	{
		return this.pgRespCode;
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
		return this.pgTxnNo;
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
		return this.signature;
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
		return this.transactionId;
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
		return this.txId;
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
		return this.txMsg;
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
		return this.txRefNo;
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
		return this.txStatus;
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

}
