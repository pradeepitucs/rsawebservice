<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
#empopup{
border-radius: 10px;
margin-top:20px;
margin-left:150px;
height:400px;
width: 600px;
display:none;
border-style:ridge;
background-color:#FFFFF0;
position:relative;

}


#customerpopup{

border-radius: 10px;
margin-top:20px;
margin-left:150px;
height:400px;
width: 600px;
display:none;
border-style:ridge;
background-color:#FFFFF0;
position:relative;
}



#paymentpopup
{
border-radius: 10px;
margin-top:200px;
margin-left:250px;
height:400px;
width: 600px;
display:none;
border-style:ridge;
background-color:#FFFFF0;
position:absolute;

}




</style>



<title>RSA24/7 Admin Console</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#CustomerInfo").click(function(){
					      var customerrequestid = $("input[name='issueckboxname']:checked").parent().siblings("#issueId").text();
					        	//alert("---"+customerrequestid);
					        	if(customerrequestid=="")
					        		{
					        		alert("please select radio button");
					        		}
					        	$.ajax({  
					       		 type : "GET",   
					          	     url : "http://localhost:8080/RSA247WebService/servicerequest/customerrequestid.json",
					          	     data : "&customerrequestid=" + customerrequestid, 
					          	  	dataType : "json",
					          	      success : function(response) { 
					   			   alert("======="+response);
					   			   
					   			
					   			var obj=JSON.stringify( response);  
					   			var json = $.parseJSON(obj);
					   			$.each(json, function (id,value) {
						   			console.log(value);
						   			
						   			$.each(value, function (id1,value1){
						   				console.log(value1);
						   				if(id1 == "firstName" || id1 == "emailId" )
						   				{
						   				document.getElementById("customerpopup").innerHTML += value1 ;
						   				
						   				}
					     	    		var pop=document.getElementById("customerpopup").style.display="block";
						   				
						   			});
						   			
						   			
						   		});
					   			      },  
					         	     error : function(e) {  
					         	    	 alert("error"+e);   
					         	     }  
					         	    });
					        	});
						$("#paymentInfo").click(function(){
						      var issue_id = $("input[name='issueckboxname']:checked").parent().siblings("#issueId").text();
						        	//alert("---"+issue_id);
						        	
						        	if(issue_id=="")
					        		{
					        		alert("please select radio button");
					        		}
						 $.ajax({  
				       		 type : "GET",   
				          	     url : "http://localhost:8080/RSA247WebService/servicerequest/paymentDetail.json",
				          	     data : "&issue_id=" + issue_id, 
				          	  	dataType : "json",
				          	      success : function(response) { 
				   			 	var json2 = response;
				   			$.each(response, function (id1,value1) {
				   				$.each(value1,function(id2,value2){
				   					var content ="";
				   					$.each(value2,function(id3,value3){
				   						if(id3 == "serviceType" || id3 == "serviceTypeId" )
				   							{
				   							content += "<td>"+value3+"</td>";
						     	    		//var pop=document.getElementById("customerpopup").style.display="block";
				   							}
				   					});
				   					console.log(content);
				   					document.getElementById("divTable").innerHTML = "<tr>"+content+"</tr>";
				   					document.getElementById("customerpopup").style.display="block";
				   					//console.log(value2.serviceType);
				   					
				   				});
				   			});   
				   			   
				   		 	      },  
				         	     error : function(e) {  
				         	    	 alert("error"+e);   
				         	     }  
				         	    });
				        	   });
						
						
						$("#employeeInfo").click(function(){
						      var employeeInfo_By_issueid = $("input[name='issueckboxname']:checked").parent().siblings("#issueId").text();
						        	//alert("---"+employeeInfo_By_issueid);
						        	if(employeeInfo_By_issueid=="")
					        		{
					        		alert("please select radio button");
					        		}
						        	
						        	
						        	 $.ajax({  
							       		 type : "GET",   
							          	     url : "http://localhost:8080/RSA247WebService/servicerequest/employeeInfobyissueid.json",
							          	     data : "&employeeInfo_By_issueid=" + employeeInfo_By_issueid, 
							          	  	dataType : "json",
							          	      success : function(response) { 
							   			 	alert(response)
							          	      
							   			 var json2 = response;
								   			$.each(response, function (id1,value1) {
								   				$.each(value1,function(id2,value2){
								   					console.log(value2);
								   					
								   					if(id2 == "employeeName" || id2 == "mobileNo" )
								   					{
								   					document.getElementById("empopup").innerHTML += value2;
								   					}
							          	    		var pop=document.getElementById("empopup").style.display="block";
								   					
								   				});
								   			}); 
							   			 	
							   			 	
							   			 	
							   			 	
							          	      
							          	      
							          	      
							          	      
							          	      },  
							         	     error : function(e) {  
							         	    	 alert("error"+e);   
							         	     }  
							         	    });
						        	
						        	
						        	
						        	
						        	
						        	
						        	
						        	
						        	
						        	
						
						});
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
					});
	
	
	
	   function cancelfunction() {
	    	var pop=document.getElementById("customerpopup").style.display="none";
	    	var pop=document.getElementById("paymentpopup").style.display="none";
	    	 location.reload();
		}
	
</script>
<style>

/* 
	Max width before this PARTICULAR table gets nasty
	This query will take effect for any screen smaller than 760px
	and also iPads specifically.
	*/
@media only screen and (max-width: 760px) , ( min-device-width : 768px)
	and (max-device-width: 1024px) {
	/* Force table to not be like tables anymore */
	table, thead, tbody, th, td, tr {
		display: block;
	}

	/* Hide table headers (but not display: none;, for accessibility) */
	thead tr {
		position: absolute;
		top: -9999px;
		left: -9999px;
	}
	tr {
		border: 1px solid #ccc;
	}
	td {
		/* Behave  like a "row" */
		border: none;
		border-bottom: 1px solid #eee;
		position: relative;
		padding-left: 50%;
	}
	td:before {
		/* Now like a table header */
		position: absolute;
		/* Top/left values mimic padding */
		top: 6px;
		left: 6px;
		width: 45%;
		padding-right: 10px;
		white-space: nowrap;
	}

	/*
		Label the data
		*/
	/*td:nth-of-type(1):before { content: "Select"; }*/
	td:nth-of-type(1):before {
		content: "Service Type";
	}
	td:nth-of-type(2):before {
		content: "Issue Id";
	}
	td:nth-of-type(3):before {
		content: "Issue Status";
	}
	td:nth-of-type(4):before {
		content: "Issue Start Time";
	}
	td:nth-of-type(5):before {
		content: "Cust Vehicle No";
	}
	td:nth-of-type(6):before {
		content: "Date";
	}
	td:nth-of-type(7):before {
		content: "Time";
	}
}

/* Smartphones (portrait and landscape) ----------- */
@media only screen and (min-device-width : 320px) and (max-device-width
	: 480px) {
	body {
		padding: 0;
		margin: 0;
		width: 320px;
	}
}

/* iPads (portrait and landscape) ----------- */
@media only screen and (min-device-width: 768px) and (max-device-width:
	1024px) {
	body {
		width: 495px;
	}
}
</style>

<script language="javascript">
 function process1(showed) {
    document.getElementById("issue_id").value = showed.value;
}
</script>

</head>
<body>
	<!-- Page Container -->
	<div class="w3-container w3-content"
		style="max-width: 1400px; margin-top: 45px">
		<!-- The Grid -->
		<div class="w3-row">
			<br> <br>
			<!-- Left Column -->
			<div class="w3-col m3">
				<!-- Profile -->
				<div class="w3-card-2 w3-round w3-white">
					<div class="w3-container">
						<h4 class="w3-center">Filters</h4>
						<div class="w3-accordion w3-white">

							<spring:url value="/servicerequest/filteredCustomerIssues"
								var="userActionUrl" />

							<form class="form-horizontal" id="filteredCustomerIssues"
								method="post" action="${userActionUrl}">

								<input type="hidden" id="page" name="page" value=""> <a
									onclick="myFunction('Demo1')"
									class="w3-btn-block w3-theme-l1 w3-left-align"> <i
									class="fa fa-calendar-check-o fa-fw w3-margin-right"></i>
									Status
								</a>

								<div id="Demo1" class="w3-accordion-content w3-container">
									<a href="#"><input type="checkbox" name="approve"
										value="true"> Approve</a> <a href="#"><input
										type="checkbox" value="flase" name="approve"> Non
										Approve</a>
								</div>

								<a onclick="myFunction('Demo2')"
									class="w3-btn-block w3-theme-l1 w3-left-align"> <i
									class="fa fa-circle-o-notch fa-fw w3-margin-right"></i> Issue
									Status
								</a>

								<div id="Demo2" class="w3-accordion-content w3-container">
									<c:forEach items="${customerIssueStatus}"
										var="customerIssueStatus">
										<%-- 										<c:forEach items="${customerIssueStatus}" var="issueStatus" > --%>
										<input type="checkbox" value="${customerIssueStatus}"
											name="issueStatus" id="issueStatus" />
											<c:out value="${customerIssueStatus}"></c:out>
											
					        				<br>
										<%-- 										</c:forEach> --%>
									</c:forEach>
								</div>

								<a onclick="myFunction('Demo3')"
									class="w3-btn-block w3-theme-l1 w3-left-align"> <i
									class="fa fa-circle-o-notch fa-fw w3-margin-right"></i> Service
									Type
								</a>

								<div id="Demo3" class="w3-accordion-content w3-container">
									<c:forEach items="${serviceTypes}" var="serviceTypes">
										<%-- 										<c:forEach items="${serviceTypes}" var="types" > --%>
										<input type="checkbox" value="${serviceTypes.value}"
											name="types" id="types" />${serviceTypes.key}
					        				<br>
										<%-- 										</c:forEach> --%>
									</c:forEach>
								</div>

								<input type="submit" value="Submit">

							</form>

						</div>
						<p></p>

					</div>
				</div>
				<br>
			</div>

			<!-- Middle Column -->
			<div class="w3-col m7">

				<div class="w3-row-padding">
					<div class="w3-col m12">
						<div class="w3-card-2 w3-round w3-white">
							<div class="w3-container w3-padding">
								<!-- <h6 class="w3-opacity">Search with Mobile Number</h6> -->
								<section style="display: flex;">
								<div style="flex: 1; margin-top: 10px;">
									<input type="text" placeholder="Search with Mobile Number..."
										style="padding: .5em 1em; width: 100%;" />
								</div>
								<div style="margin: 10px 0 0 1rem;">
									<button class="w3-btn w3-theme">
										<i class="fa fa-search" aria-hidden="true"></i> Search
									</button>
								</div>
								</section>

								<hr class="w3-clear">

								<spring:url value="/servicerequest/customerInfo"
									var="CustomerInfo" />
									
								<spring:url value="/servicerequest/paymentDetail"
									var="PaymentInfo" />
								
								<input type="hidden" id="Info" value="" />
								
								<form action="${PaymentInfo}">
								
								<input type="hidden" id="issue_id" name="issue_id" value="" />
								
						
										
										
									<span><a href="#" id="employeeInfo"	>
										Employee Info</a></span> 	
										
										
								<span><a href="#" id="CustomerInfo"	>
										Customer Info</a></span> 
										
									<span><a href="#" id="paymentInfo"	>
										Payment Info</a></span> 	
										
								<!-- <span><input type="submit" id="PaymentInfo" class="showEmployeeImage" href="#" data-toggle="modal"
									data-target="#PaymentInfoModal"	style="margin-bottom: 16px !important; border: 1px solid #000; 
									display: inline-block; outline: 0; padding: 6px 16px; vertical-align: middle; 
									overflow: hidden; text-decoration: none !important; text-align: center; cursor: pointer; 
									white-space: nowrap; color: #000 !important; background-color: #faed1b !important"
										value="Payment Info ff" /></span> -->
								</form>

								<!-- Employee Modal -->
								<div id="EmployeeInfoModal" class="modal fade" role="dialog">
									<div class="modal-dialog">

										<!-- Modal content-->
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="modal-title">Employee Information</h4>
											</div>
											<div class="modal-body">
												<label id="customerID">Employee ID </label> <input
													readonly="readonly"
													value="${customerRequestIssues.customerModel.userId}" /> <br>
												<label id="customerName">Employee Name </label> <input
													readonly="readonly"
													value="${customerRequestIssues.customerModel.firstName}" />
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">Close</button>
											</div>
										</div>

									</div>
								</div>

								<!-- Customer Modal -->
								<div id="CustomerInfoModal" class="modal fade" role="dialog">
									<div class="modal-dialog">

										<!-- Modal content-->
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="modal-title">Customer Information</h4>
											</div>
											<div class="modal-body">
												<label id="customerID">Customer ID </label> <input
													readonly="readonly"
													value="${customerRequestIssues.customerModel.userId}" /> <br>
												<label id="customerName">Customer Name </label> <input
													readonly="readonly"
													value="${customerRequestIssues.customerModel.firstName}" />
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">Close</button>
											</div>
										</div>

									</div>
								</div>

								<!-- Payment Modal -->
								<div id="PaymentInfoModal" class="modal fade" role="dialog">
									<div class="modal-dialog">

										<!-- Modal content-->
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="modal-title">Payment Information</h4>
											</div>
											<div class="modal-body">
												<label id="customerID">Payment ID </label> <input
													readonly="readonly"
													value="${ServiceTypeDTO}" /> <br>
													
												<c:forEach items="${ServiceTypeDTO}" var="ServiceType">
													<c:out value="" />
												</c:forEach>
												<label id="customerName">Payment Name </label> <input
													readonly="readonly"
													value="${customerRequestIssues.customerModel.firstName}" />
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">Close</button>
											</div>
										</div>

									</div>
								</div>

								<table id="employeeData"
									style="display: block; overflow-x: auto; max-width: 100%; height: 450px;">
									<thead>
										<tr>
											<th>Select</th>
											<th>Service Type</th>
											<th>Issue Id</th>
											<th>Issue Status</th>
											<th>Issue Start Time</th>
											<th>Customer Vehicle Number</th>
											<th>Date</th>
											<th>Time</th>
											<!-- <th  style="border:none; width: 100px ;background: #696969;">olderEmployeeID</th> -->
											<!--<th  style="border:none; width: 100px ;background: #696969;">employeeName</th> 
					<th  style="border:none; width: 100px ;background: #696969;">serviceProviderCity</th>
					<th  style="border:none; width: 100px ;background: #696969;">serviceProviderName</th>  -->
										</tr>
									</thead>
									<tbody>
										<c:forEach var="customerRequestIssues"
											items="${findAllCustomerRequests.customerRequests}">
											<tr>
												<td><input type="radio" name="issueckboxname"
													id="issueckboxid" value="${customerRequestIssues.issueId}" onclick="process1(this)" />
												<td class="serviceProviderIdclass" id="id">${customerRequestIssues.serviceTypeModel.serviceTypeId}</td>
												<td class="serviceProviderIdclass" id="issueId">${customerRequestIssues.issueId}</td>
												<td class="serviceProviderIdclass" id="id">${customerRequestIssues.issueStatus}</td>
												<td class="serviceProviderIdclass" id="id">${customerRequestIssues.issueStartTime}</td>
												<td class="serviceProviderIdclass" id="id">${customerRequestIssues.customerVehicleNumber}</td>
												<%-- <td class="serviceProviderIdclass" id="cusId">
													<button type="button" class="btn btn-link"
														data-toggle="modal" data-target="#myModal">
														${customerRequestIssues.customerModel.userId}</button>
												</td> --%>
												<td class="serviceProviderIdclass" id="cusName">${customerRequestIssues.issueDate}</td>
												<td class="serviceProviderIdclass" id="cusName">${customerRequestIssues.issueTime}</td>
												<%-- <td class="serviceProviderIdclass" id="custId">${customerRequestIssues.customerModel.userId}</td> --%>
												
												

											</tr>

										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>


				<!-- End Middle Column -->
			</div>

		</div>

		<!-- End Page Container -->
	</div>
	<br>

	<script>
		// Accordion
		function myFunction(id) {
			var x = document.getElementById(id);
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
				x.previousElementSibling.className += " w3-theme-d1";
			} else {
				x.className = x.className.replace("w3-show", "");
				x.previousElementSibling.className = x.previousElementSibling.className
						.replace(" w3-theme-d1", "");
			}
		}

		// Used to toggle the menu on smaller screens when clicking on the menu button
		function openNav() {
			var x = document.getElementById("navDemo");
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
			} else {
				x.className = x.className.replace(" w3-show", "");
			}
		}
	</script>
<div id="customerpopup">
<input type="button" id="cancelComment" name="cancelComment" value="Cancel" onclick="cancelfunction()"/><br/><br/>
<table>
	<thead>
		<tr>
			<th>Id</th>
			<th>Value</th>
			</tr>
	</thead>
	<tbody id ="divTable">
		
	</tbody>
	
	
</table>
</div>
<div id="paymentpopup">
<input type="button" id="cancelEmpPopup" name="cancelComment" value="Cancel" onclick="cancelfunction()"/>
</div>

<div id="empopup">
<input type="button" id="cancelComment" name="cancelComment" value="Cancel" onclick="cancelfunction()"/>
</div>


</body>
</html>