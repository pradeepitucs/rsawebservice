<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="java.util.Set" %>
<%@page import="java.util.Hashtable" %>   
<%@page import="javax.crypto.Mac" %>   
<%@page import="javax.crypto.spec.SecretKeySpec" %>   
<%@page import="java.util.Enumeration" %>   
<%@page import="java.util.HashMap" %>  
<%@page import="org.springframework.util.LinkedMultiValueMap" %>
<%@page import="org.springframework.util.MultiValueMap" %>
<%@page import="org.springframework.web.client.RestTemplate" %>
<%@page import="com.ucs.rsa.resource.RedirectURLResource" %>  
<%@page import="org.json.JSONArray" %>
<%@page import="org.json.JSONException" %>
<%@page import="org.json.JSONObject" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>  
<% 
String secretKey = "7fd89b14464b38a9292995c4d1b2ae650fdcf21d";    
Hashtable<String, String> reqValMap = new Hashtable<String, String>(){          
public synchronized String toString() {            
Enumeration<String> keys = keys();            
StringBuffer buff = new StringBuffer("{");            
while(keys.hasMoreElements()){                
String key = keys.nextElement();                  
String value = get(key);                         
buff.append("'").append(key).append("'")
 .append(":")
 .append("'").append(value).append("'")
 .append(',');             
}              
buff = new StringBuffer(buff.toString().substring(0, buff.toString().length()-1));              
buff.append("}");              
return buff.toString();         
}     
};       
Enumeration<String> parameterList = request.getParameterNames();      
while(parameterList.hasMoreElements())
{
String paramName = parameterList.nextElement();
String paramValue = request.getParameter(paramName);          
reqValMap.put(paramName, paramValue);      
}      
String dataString = new StringBuilder()                              
    .append(request.getParameter("TxId"))                             
    .append(request.getParameter("TxStatus"))                              
    .append(request.getParameter("amount"))                              
    .append(request.getParameter("pgTxnNo"))                                                         
    .append(request.getParameter("issuerRefNo"))                               
    .append(request.getParameter("authIdCode"))                              
    .append(request.getParameter("firstName"))                              
    .append(request.getParameter("lastName"))                             
    .append(request.getParameter("pgRespCode"))                              
    .append(request.getParameter("addressZip"))                              
    .toString(); 
System.out.println("txn ID------ : " + dataString);
SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA1");     
Mac mac = Mac.getInstance("HmacSHA1");      
mac.init(secretKeySpec);      
byte []hmacArr = mac.doFinal(dataString.getBytes());      
StringBuilder build = new StringBuilder();      
for (byte b : hmacArr) {          
build.append(String.format("%02x", b));      
}      
String hmac = build.toString();      
String reqSignature = request.getParameter("signature");      
System.out.println("txn ID : " + request.getParameter("TxId"));   
System.out.println("RESPONSE " + reqValMap.toString());  
System.out.println("RESPONSE " + "THIS IS TEST"); 
JSONArray jsonArrayObj = new JSONArray();
JSONObject js = new JSONObject();
try {
	js.put("param2",request.getParameter("param2"));
	js.put("param1", request.getParameter("param1"));
	js.put("TxId", request.getParameter("TxId"));
	js.put("TxStatus",request.getParameter("TxStatus"));
	js.put("amount",request.getParameter("amount"));
	js.put("pgTxnNo",request.getParameter("pgTxnNo"));
	js.put("issuerRefNo", request.getParameter("issuerRefNo"));
	js.put("authIdCode", request.getParameter("authIdCode"));
	//js.put("firstName",request.getParameter("firstName"));
	//js.put("lastName", request.getParameter("lastName"));
	js.put("pgRespCode",request.getParameter("pgRespCode"));
	//js.put("addressZip", request.getParameter("addressZip"));
	js.put("signature",request.getParameter("signature"));
	js.put("txRefNo", request.getParameter("TxRefNo"));
	js.put("txMsg",request.getParameter("TxMsg"));
	js.put("transactionId",request.getParameter("transactionId"));
	js.put("amount",request.getParameter("amount"));
	js.put("pgTxnNo", request.getParameter("pgTxnNo"));
} catch (JSONException e1) {
	e1.printStackTrace();
}	
jsonArrayObj.put(js);
String msg = jsonArrayObj.toString();
RestTemplate restTemplate = new RestTemplate();

MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
map.add("response",msg);
//http://localhost:2020/RSA247WebService/user/approve/serviceProvider.json	
// http://localhost:2020/RSA247WebService/user/approve/serviceProvider.json?serviceProviderId=1
restTemplate.postForObject("http://localhost:8080/RSA247WebService/redirecturl/response",map,String.class);
//new ModelAndView("redirect:/redirecturl/response?userresponse="+reqValMap);
/*  RedirectURLResource redirectURLResource= new RedirectURLResource();
redirectURLResource.returnUrlResponse(reqValMap);  */
%>   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" http://www.w3.org/TR/html4/loose.dtd">   
<html>      
<head>          
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">          
<title>Redirect URL</title>    
alert("abc");      
<script type="text/javascript">    
function abc() { }
function postResponse(data) {                  
document.write(data);  
CitrusResponse.pgResponse(data);          
}          
function postResponseiOS() {                  
return jsonObject;          
}                 
document.write(JSON.stringify(<%=reqValMap%>));              
var jsonObject;  
alert("abc1");
if('<%=hmac%>' === '<%=request.getParameter("signature")%>')
{                  
jsonObject = JSON.stringify(<%=reqValMap%>);                  
postResponse(jsonObject);                  
document.write(jsonObject);  
alert(reqValMap.toString);
alert("ab1c");
}else
{ 
	alert("abc");
var responseObj = { 
		
"Error" : "Transaction Failed",                         
"Reason" : "Signature Verification Failed"                     
};   
alert("ckacnaksc");
jsonObject = JSON.stringify(responseObj);
postResponse(jsonObject);
document.write(jsonObject);
}      
</script>      
</head>      
<body>        
</body>   
</html>