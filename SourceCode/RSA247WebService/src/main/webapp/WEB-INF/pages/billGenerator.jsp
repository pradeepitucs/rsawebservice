<%@page import="java.text.Format"%>
<%@page import="javax.crypto.Mac"%>
<%@page import="javax.crypto.spec.SecretKeySpec"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	response.setContentType("application/json");
	String accessKey = "1YRKT64OZERXQ5NYULQQ";
	String secretKey = "7fd89b14464b38a9292995c4d1b2ae650fdcf21d";
	String returnUrl = "http://garage-rsa247.rhcloud.com/RSA247WebService/redirecturl/citruspayresponse";
	String txnID = String.valueOf(System.currentTimeMillis());
	String amount = request.getParameter("amount"); //Make sure the datatype of the value is STRING.
	String customParameters = request.getParameter("customParameters");
	String issue_id ="1";
	String user_id = "1";
	String dataString = "merchantAccessKey=" + accessKey + "&transactionId=" + txnID + "&amount=" + amount + "&customParameters=" + customParameters;
	SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA1");
	Mac mac = Mac.getInstance("HmacSHA1");
	mac.init(secretKeySpec);
	byte[] hmacArr = mac.doFinal(dataString.getBytes());
	StringBuilder build = new StringBuilder();
	for (byte b : hmacArr) {
		build.append(String.format("%02x", b));
	}
	String hmac = build.toString();
	StringBuilder amountBuilder = new StringBuilder();
	amountBuilder.append("\"value\":\"").append(amount).append("\"").append(",\"currency\":\"INR\"");
	
	StringBuilder customBuilder = new StringBuilder();
	customBuilder.append("\"param1\":\"").append(user_id).append("\"").append(",\"param2\":\"").append(issue_id).append("\"");
	
	StringBuilder resBuilder = new StringBuilder("{");

	resBuilder.append("\"merchantTxnId\"").append(":").append("\"").append(txnID).append("\"").append(",")
			.append("\"requestSignature\"").append(":").append("\"").append(hmac).append("\"").append(",")
			.append("\"merchantAccessKey\"").append(":").append("\"").append(accessKey).append("\"").append(",")
			.append("\"returnUrl\"").append(":").append("\"").append(returnUrl).append("\"").append(",")
			.append("\"amount\"").append(":").append("{").append(amountBuilder).append("}")
			.append("\"").append(",").append("\"customParameters\"")
			.append(":").append("{").append(customBuilder).append("}").append("}");
	out.print(resBuilder);
%>
