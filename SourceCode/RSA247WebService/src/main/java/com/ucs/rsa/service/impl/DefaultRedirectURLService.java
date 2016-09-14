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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.ucs.rsa.model.CustomerModel;
import com.ucs.rsa.model.CustomerPaymentModel;
import com.ucs.rsa.model.CustomerRequestModel;
import com.ucs.rsa.model.IssuePaymentModel;
import com.ucs.rsa.model.PaymentModel;
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
	 
	@Override
	public Hashtable<String, String> redirectURL(final HttpServletRequest request, HttpServletResponse response)
	{

		try
		{

			String secretKey = "7fd89b14464b38a9292995c4d1b2ae650fdcf21d";

			Hashtable<String, String> reqValMap = new Hashtable<String, String>()
			{
				private static final long serialVersionUID = 1L;

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
					.append(request.getParameter("pgRespCode")).append(request.getParameter("addressZip"))
					.append(request.getParameter("customParameters")).toString();

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
			if(request.getParameter("issue_id").equals(null)) {
				CustomerPaymentModel paymentModel = new CustomerPaymentModel();
				CustomerModel customerModel = new CustomerModel();
				customerModel.setUserId(Integer.parseInt(request.getParameter("user_d")));
				paymentModel.setCustomerModel(customerModel);
				paymentModel.setTxId(request.getParameter("TxId"));
				paymentModel.setTxStatus(request.getParameter("TxStatus"));
				paymentModel.setAmount(request.getParameter("amount"));
				paymentModel.setPgTxnNo(request.getParameter("pgTxnNo"));
				paymentModel.setIssuerRefNo(request.getParameter("issuerRefNo"));
				paymentModel.setAuthIdCode(request.getParameter("authIdCode"));
				paymentModel.setFirstName(request.getParameter("firstName"));
				paymentModel.setLastName(request.getParameter("lastName"));
				paymentModel.setPgRespCode(request.getParameter("pgRespCode"));
				paymentModel.setAddressZip(request.getParameter("addressZip"));
				paymentModel.setSignature(request.getParameter("signature"));
				paymentModel.setTxRefNo(request.getParameter("txRefNo"));
				paymentModel.setTxMsg(request.getParameter("txMsg"));
				paymentModel.setTransactionId(request.getParameter("transactionId"));
				paymentModel.setInfo(reqValMap.toString());

				save(paymentModel);
			} else {
				
				IssuePaymentModel paymentModel = new IssuePaymentModel();
				CustomerRequestModel customerRequestModel = new CustomerRequestModel();
				customerRequestModel.setIssueId(Integer.parseInt(request.getParameter("issue_id")));
				paymentModel.setCustomerRequestModel(customerRequestModel);
				paymentModel.setTxId(request.getParameter("TxId"));
				paymentModel.setTxStatus(request.getParameter("TxStatus"));
				paymentModel.setAmount(request.getParameter("amount"));
				paymentModel.setPgTxnNo(request.getParameter("pgTxnNo"));
				paymentModel.setIssuerRefNo(request.getParameter("issuerRefNo"));
				paymentModel.setAuthIdCode(request.getParameter("authIdCode"));
				paymentModel.setFirstName(request.getParameter("firstName"));
				paymentModel.setLastName(request.getParameter("lastName"));
				paymentModel.setPgRespCode(request.getParameter("pgRespCode"));
				paymentModel.setAddressZip(request.getParameter("addressZip"));
				paymentModel.setSignature(request.getParameter("signature"));
				paymentModel.setTxRefNo(request.getParameter("txRefNo"));
				paymentModel.setTxMsg(request.getParameter("txMsg"));
				paymentModel.setTransactionId(request.getParameter("transactionId"));
				paymentModel.setInfo(reqValMap.toString());

				save(paymentModel);
			}
			

			if (hmac.equals(reqSignature))
			{
				return reqValMap;
			}

		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		catch (InvalidKeyException e)
		{
			e.printStackTrace();
		}

		return new Hashtable<String, String>();
	}*/
	
	@Override
	public String paymentResponse( String reqValMap) {
		JSONArray jsonData = null;
		try {
			jsonData = new JSONArray(reqValMap);
			for (int i = 0; i < jsonData.length(); i++) {
				JSONObject jsonData1 = jsonData.getJSONObject(i);
			if(jsonData1.getString("param2").equals("0")) {
				CustomerPaymentModel paymentModel = new CustomerPaymentModel();
				CustomerModel customerModel = new CustomerModel();
				customerModel.setUserId(Integer.parseInt(jsonData1.getString("param1")));
				paymentModel.setCustomerModel(customerModel);
				paymentModel.setTxId(jsonData1.getString("TxId"));
				paymentModel.setTxStatus(jsonData1.getString("TxStatus"));
				paymentModel.setAmount(jsonData1.getString("amount"));
				paymentModel.setPgTxnNo(jsonData1.getString("pgTxnNo"));
				paymentModel.setIssuerRefNo(jsonData1.getString("issuerRefNo"));
				paymentModel.setAuthIdCode(jsonData1.getString("authIdCode"));
			//	paymentModel.setFirstName(jsonData1.getString("firstName"));
			//	paymentModel.setLastName(jsonData1.getString("lastName"));
				paymentModel.setPgRespCode(jsonData1.getString("pgRespCode"));
			//	paymentModel.setAddressZip(jsonData1.getString("addressZip"));
				paymentModel.setSignature(jsonData1.getString("signature"));
				paymentModel.setTxRefNo(jsonData1.getString("txRefNo"));
				paymentModel.setTxMsg(jsonData1.getString("txMsg"));
				paymentModel.setTransactionId(jsonData1.getString("transactionId"));
			//	paymentModel.setInfo("");

				save(paymentModel);
			} else {
				
				IssuePaymentModel paymentModel = new IssuePaymentModel();
				CustomerRequestModel customerRequestModel = new CustomerRequestModel();
				customerRequestModel.setIssueId(Integer.parseInt(jsonData1.getString("param2")));
				paymentModel.setCustomerRequestModel(customerRequestModel);
				paymentModel.setTxId(jsonData1.getString("TxId"));
				paymentModel.setTxStatus(jsonData1.getString("TxStatus"));
				paymentModel.setAmount(jsonData1.getString("amount"));
				paymentModel.setPgTxnNo(jsonData1.getString("pgTxnNo"));
				paymentModel.setIssuerRefNo(jsonData1.getString("issuerRefNo"));
				paymentModel.setAuthIdCode(jsonData1.getString("authIdCode"));
			//	paymentModel.setFirstName(jsonData1.getString("firstName"));
			//	paymentModel.setLastName(jsonData1.getString("lastName"));
				paymentModel.setPgRespCode(jsonData1.getString("pgRespCode"));
			//	paymentModel.setAddressZip(jsonData1.getString("addressZip"));
				paymentModel.setSignature(jsonData1.getString("signature"));
				paymentModel.setTxRefNo(jsonData1.getString("txRefNo"));
				paymentModel.setTxMsg(jsonData1.getString("txMsg"));
				paymentModel.setTransactionId(jsonData1.getString("transactionId"));
			//	paymentModel.setInfo("");

				save(paymentModel);
			}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return "";
	}

}
