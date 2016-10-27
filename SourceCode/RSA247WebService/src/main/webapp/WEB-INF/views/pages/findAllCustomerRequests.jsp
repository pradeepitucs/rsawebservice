<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
						var table = $('#employeeData'),
			            rows = table.find('tr'), cells, background, code,status ;        
			        for (var i = 0; i < rows.length; i+=1) {
			            cells = $(rows[i]).children('td');
			            code = $(cells[1]).text();  
			             status = $(cells[3]).text();
			             background = '#FFFFFF';
			             switch (code) {
			                case '1':
			                	cells[1].innerHTML ="Ambulance";
			                	if(status!="Completed")
			                	background = '#E38029';
			                    break;
			                case '2':
			                	cells[1].innerHTML ="Police";
			                	if(status!="Completed")
			                    background = '#9E7B09';
			                    break;
			                case '3':
			                	cells[1].innerHTML = "Flat Tyre";
			                	background = '#FFFFFF';
			                	break;
			                case '4':
			                	cells[1].innerHTML = "Minor Repairs";
			                	background = '#FFFFFF';
			                	break;
			                case '5':
			                	cells[1].innerHTML = "Battery";
			                	background = '#FFFFFF';
			                	break;
			                case '6':
			                	cells[1].innerHTML = "Locked Out";
			                	background = '#FFFFFF';
			                	break;
			                case '7':
			                	cells[1].innerHTML = "Towing";
			                	background = '#FFFFFF';
			                	break;
			                case '8':
			                	cells[1].innerHTML = "Fuel Refill";
			                	background = '#FFFFFF';
			                	break;
			            } 
			            $(rows[i]).css('background-color', background);
			        }
					});
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
							<button onclick="myFunction('Demo1')"
								class="w3-btn-block w3-theme-l1 w3-left-align">
								<i class="fa fa-calendar-check-o fa-fw w3-margin-right"></i>
								Status
							</button>
							<div id="Demo1" class="w3-accordion-content w3-container">
								<a href="#"><input type="checkbox" value="Approve">
									Approve</a> <a href="#"><input type="checkbox"
									value="Non Approve"> Non Approve</a>
							</div>
							<button onclick="myFunction('Demo2')"
								class="w3-btn-block w3-theme-l1 w3-left-align">
								<i class="fa fa-circle-o-notch fa-fw w3-margin-right"></i> My
								Events
							</button>
							<div id="Demo2" class="w3-accordion-content w3-container">
								<p>Some other text..</p>
							</div>
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
									<input type="text" placeholder="Search with Mobile Number..." style="padding: .5em 1em; width: 100%;" />
								</div>
								<div style="margin: 10px 0 0 1rem;">
									<button class="w3-btn w3-theme"><i class="fa fa-search" aria-hidden="true"></i> Search</button>
								</div>
								</section>

								<hr class="w3-clear">
					             <span><a id="btn1" class="emloyeeapprove" href="#" style="margin-bottom:16px!important; border:1px solid #000;display:inline-block;outline:0;padding:6px 16px;vertical-align:middle;overflow:hidden;text-decoration:none!important;text-align:center;cursor:pointer;white-space:nowrap;color:#000 !important; background-color:#faed1b !important">Employee Info</a></span>
								 <span><a id="myBtn" class="showEmployeeImage" href="#" style="margin-bottom:16px!important; border:1px solid #000;display:inline-block;outline:0;padding:6px 16px;vertical-align:middle;overflow:hidden;text-decoration:none!important;text-align:center;cursor:pointer;white-space:nowrap;color:#000 !important; background-color:#faed1b !important">Customer Info</a></span>
								 <span><a id="myBtn" class="showEmployeeImage" href="#" style="margin-bottom:16px!important; border:1px solid #000;display:inline-block;outline:0;padding:6px 16px;vertical-align:middle;overflow:hidden;text-decoration:none!important;text-align:center;cursor:pointer;white-space:nowrap;color:#000 !important; background-color:#faed1b !important">Payment Info</a></span>
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
												<td><input type="radio"  name="issueckboxname" id="issueckboxid" value="${customerRequestIssues.issueId}"/>
												<td class="serviceProviderIdclass" id="id">${customerRequestIssues.serviceTypeModel.serviceTypeId}</td>
												<td class="serviceProviderIdclass" id="id">${customerRequestIssues.issueId}</td>
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

											</tr>

											<!-- Modal -->
											<div id="myModal" class="modal fade" role="dialog">
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
																value="${customerRequestIssues.customerModel.userId}" />
																<br>
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

</body>
</html>