/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.service.impl;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.ucs.rsa.service.RedirectURLService;


/**
 * The Class DefaultRedirectURLService.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
@Service
public class DefaultRedirectURLService extends DefaultBaseService implements RedirectURLService
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ucs.rsa.service.RedirectURLService#redirectURL(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void redirectURL(final HttpServletRequest request, HttpServletResponse response)
	{

		try
		{

			String secretKey = "MERCHANT_SECRET_KEY";

			Hashtable<String, String> reqValMap = new Hashtable<String, String>()
			{
				public synchronized String toString()
				{
					Enumeration<String> keys = keys();
					StringBuffer buff = new StringBuffer("{");
					while (keys.hasMoreElements())
					{
						String key = keys.nextElement();
						String value = get(key);

						buff.append("'").append(key).append("'").append(":").append("'").append(value).append("'").append(',');
					}
					buff = new StringBuffer(buff.toString().substring(0, buff.toString().length() - 1));
					buff.append("}");
					return buff.toString();
				}
			};

			Enumeration<String> parameterList = request.getParameterNames();

			while (parameterList.hasMoreElements())
			{
				String paramName = parameterList.nextElement();
				String paramValue = request.getParameter(paramName);
				reqValMap.put(paramName, paramValue);
			}

			String dataString = new StringBuilder().append(request.getParameter("TxId")).append(request.getParameter("TxStatus"))
					.append(request.getParameter("amount")).append(request.getParameter("pgTxnNo"))
					.append(request.getParameter("issuerRefNo")).append(request.getParameter("authIdCode"))
					.append(request.getParameter("firstName")).append(request.getParameter("lastName"))
					.append(request.getParameter("pgRespCode")).append(request.getParameter("addressZip")).toString();
			SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA1");
			Mac mac;

			mac = Mac.getInstance("HmacSHA1");
			mac.init(secretKeySpec);

			byte[] hmacArr = mac.doFinal(dataString.getBytes());
			StringBuilder build = new StringBuilder();
			for (byte b : hmacArr)
			{
				build.append(String.format("%02x", b));
			}
			String hmac = build.toString();

			String reqSignature = request.getParameter("signature");
			System.out.println("txn ID : " + request.getParameter("TxId"));


			//			 if(hmac.equals(reqSignature)) {
			//			 CitrusResponse.pgResponse(reqValMap);
			//			 } else {
			//			 String responseObj = {
			//			 "Error" : "Transaction Failed",
			//			 "Reason" : "Signature Verfication Failed"
			//			 };
			//			 CitrusResponse.pgResponse(responseObj);
			//			 }

		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		catch (InvalidKeyException e)
		{
			e.printStackTrace();
		}

	}

}
