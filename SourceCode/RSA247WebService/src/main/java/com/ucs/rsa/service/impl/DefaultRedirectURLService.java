/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.service.impl;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.ucs.rsa.common.notification.SendNotification;
import com.ucs.rsa.model.CustomerModel;
import com.ucs.rsa.model.CustomerPaymentModel;
import com.ucs.rsa.model.CustomerRequestModel;
import com.ucs.rsa.model.EmployeeModel;
import com.ucs.rsa.model.IssuePaymentModel;
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
				paymentModel.setPgRespCode(jsonData1.getString("pgRespCode"));
				paymentModel.setSignature(jsonData1.getString("signature"));
				paymentModel.setTxRefNo(jsonData1.getString("txRefNo"));
				paymentModel.setTxMsg(jsonData1.getString("txMsg"));
				paymentModel.setTransactionId(jsonData1.getString("transactionId"));

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
				paymentModel.setPgRespCode(jsonData1.getString("pgRespCode"));
				paymentModel.setSignature(jsonData1.getString("signature"));
				paymentModel.setTxRefNo(jsonData1.getString("txRefNo"));
				paymentModel.setTxMsg(jsonData1.getString("txMsg"));
				paymentModel.setTransactionId(jsonData1.getString("transactionId"));

				save(paymentModel);
				if(jsonData1.getString("TxStatus").equals("SUCCESS")){
				CustomerRequestModel cus = new CustomerRequestModel();
				cus = get(CustomerRequestModel.class, Integer.parseInt(jsonData1.getString("param2")));
				int empId = cus.getEmployeeID();
				EmployeeModel emp = new EmployeeModel();
				emp = get(EmployeeModel.class, empId);
				ArrayList<String> deviceID = new ArrayList<>();
				deviceID.add(emp.getGcmId());
				JSONArray jsonArrayObj = new JSONArray();
				JSONObject js = new JSONObject();
				try {
					js.put("Statua", jsonData1.getString("TxStatus"));
				} catch (JSONException e1) {
					e1.printStackTrace();
				}	
				jsonArrayObj.put(js);
				String msg = jsonArrayObj.toString();
				SendNotification sendNotification = new SendNotification();
				sendNotification.sendNotificationData(deviceID, msg); 
				}
			}
				CustomerModel customer = new CustomerModel();
				customer = get(CustomerModel.class,Integer.parseInt(jsonData1.getString("param1")));
				ArrayList<String> deviceID = new ArrayList<>();
				deviceID.add(customer.getGcmId());
				JSONArray jsonArrayObj = new JSONArray();
				JSONObject js = new JSONObject();
				try {
					js.put("Statua", jsonData1.getString("TxStatus"));
				} catch (JSONException e1) {
					e1.printStackTrace();
				}	
				jsonArrayObj.put(js);
				String msg = jsonArrayObj.toString();
				SendNotification sendNotification = new SendNotification();
				sendNotification.sendNotificationData(deviceID, msg); 
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return "";
	}

}
