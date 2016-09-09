/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.service.impl;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

import com.ucs.rsa.service.BillGeneratorService;


/**
 * The Class DefaultBillGeneratorService.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@Service
public class DefaultBillGeneratorService extends DefaultBaseService implements BillGeneratorService
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.BillGeneratorService#genertBill()
	 */
	@Override
	public StringBuilder genertBill(int userID, int issueID,String amount)
	{

		String accessKey = "1YRKT64OZERXQ5NYULQQ";
		String secretKey = "7fd89b14464b38a9292995c4d1b2ae650fdcf21d";

		// Need to Check the redirect URL
		String returnUrl = "http://garage-rsa247.rhcloud.com/RSA247WebService/redirecturl/citruspayresponse";

		String txnID = String.valueOf(System.currentTimeMillis());

		// Need to calculate
		//String amount = "100"; //request.getParameter("amount"); //Make sure the datatype of the value is STRING.
		String issue_id =String.valueOf(issueID);
		String user_id = String.valueOf(userID);

		String dataString = "merchantAccessKey=" + accessKey + "&transactionId=" + txnID + "&amount=" + amount;
		SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA1");
		Mac mac;

		StringBuilder resBuilder = new StringBuilder();
		try
		{
			mac = Mac.getInstance("HmacSHA1");
			mac.init(secretKeySpec);
			byte[] hmacArr = mac.doFinal(dataString.getBytes());
			StringBuilder build = new StringBuilder();
			for (byte b : hmacArr)
			{
				build.append(String.format("%02x", b));
			}
			String hmac = build.toString();
			StringBuilder amountBuilder = new StringBuilder();
			amountBuilder.append("\"value\":\"").append(amount).append("\"").append(",\"currency\":\"INR\"");
			
			StringBuilder customBuilder = new StringBuilder();
			customBuilder.append("\"param1\":\"").append(user_id).append("\"").append(",\"param2\":\"").append(issue_id).append("\"");

			// Need to check the all value
			resBuilder.append("{\"merchantTxnId\"").append(":").append("\"").append(txnID).append("\"").append(",")
					.append("\"requestSignature\"").append(":").append("\"").append(hmac).append("\"").append(",")
					.append("\"merchantAccessKey\"").append(":").append("\"").append(accessKey).append("\"").append(",")
					.append("\"returnUrl\"").append(":").append("\"").append(returnUrl).append("\"").append(",").append("\"amount\"")
					.append(":").append("{").append(amountBuilder).append("}")
					.append("\"").append(",").append("\"customParameters\"")
					.append(":").append("{").append(customBuilder).append("}").append("}");
			System.out.println(resBuilder);
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		catch (InvalidKeyException e)
		{
			e.printStackTrace();
		}
		return resBuilder;
	}

}
