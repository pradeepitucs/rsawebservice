   <%@ page import="java.text.Format" %>  
   <%@ page import="java.text.Format" %>  
   <%@ page import="javax.crypto.Mac" %>   
   <%@ page import="javax.crypto.spec.SecretKeySpec" %>   
   <%@ page import="java.util.Random" %>  
   <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>   
   <%  
   //response.setContentType("application/json"); 
   
    		
   // String accessKey = "G25RXEWGGVXZ50VWAI1E";  //my test keys   
   // String secretKey = "fb440cfff9b6f245b119a4ee1aee35739d8255a6";  
    
		
    String accessKey = "1YRKT64OZERXQ5NYULQQ";
    String secretKey = "7fd89b14464b38a9292995c4d1b2ae650fdcf21d";
    
   
    String returnUrl = "http://45.124.51.6:8080/CounterWebApp/returncode.jsp";  
    String txnID = String.valueOf(System.currentTimeMillis());     
    String amount = request.getParameter("amount");  
    
    //custom parameter dob hardcoded
    String param1=  request.getParameter("param1"); 
    String param2=  request.getParameter("param2");
    
    // String operation = request.getParameter("dpopeartion");
    String dataString = "merchantAccessKey=" + accessKey + "&transactionId=" + txnID + "&amount=" + amount;    
    SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA1");    
    Mac mac = Mac.getInstance("HmacSHA1");     
    mac.init(secretKeySpec);     
    byte []hmacArr = mac.doFinal(dataString.getBytes());    
    StringBuilder build = new StringBuilder();     
         for (byte b : hmacArr) {         
             build.append(String.format("%02x", b));     
          }   
    String hmac = build.toString();     
    StringBuilder amountBuilder = new StringBuilder();  
   // StringBuilder mydob = new StringBuilder();
    
  
    
    //custom parameter dob added
  //  mydob.append("\"dob\":\"").append(dob).append("\"");
    StringBuilder customBuilder = new StringBuilder();
			customBuilder.append("\"param1\":\"").append(param1).append("\"").append(",\"param2\":\"").append(param2).append("\"");
    amountBuilder.append("\"value\":\"").append(amount).append("\"").append(",\"currency\":\"INR\"");    
    StringBuilder resBuilder = new StringBuilder("{");    
    resBuilder.append("\"merchantTxnId\"").append(":").append("\"").append(txnID).append("\"")        
              .append(",")        
              .append("\"requestSignature\"").append(":").append("\"").append(hmac).append("\"")        
              .append(",")        
              .append("\"merchantAccessKey\"").append(":").append("\"").append(accessKey).append("\"")        
              .append(",")        
              .append("\"returnUrl\"").append(":").append("\"").append(returnUrl).append("\"")        
              .append(",")        
              .append("\"amount\"").append(":").append("{").append(amountBuilder).append("}") 
             .append(",") 
             
              // custom parameter dob added
              .append("\"customParameters\"").append(":").append("{").append(customBuilder).append("}")
              .append("}");  
              out.print(resBuilder);   %>
                  