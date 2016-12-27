<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<spring:url value="/resources/bootstrap" var="bootstrap" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" dir="ltr">
<head>
<title>RSA24/7 Admin Console</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('.approve')
								.click(
										function() {
											var insert = [];

											var result = $("input[name='spname']:checked");

											if (result.length > 0) {

												var resultvalues = result.length;

												result
														.each(function() {

															resultvalues = $(
																	this).val();
															insert
																	.push(resultvalues)
															<c:forEach var="serProvider" items="${findAllServiceProviders.serviceProviderDTOs}" >
															if (resultvalues == "${serProvider.userId}") {
																if ("${serProvider.enabled}" == "true") {
																	alert("Service Provider already Approved");
																} else {
																	insert = insert
																			.toString();

																	$
																			.ajax({
																				type : "Post",
																				url : "approve.html",
																				data : "&var1="
																						+ insert,
																				success : function(
																						response) {
																					alert(response);
																					window.location
																							.reload(true);
																				},
																				error : function(
																						e) {
																					alert("error");
																				}
																			});
																}
															}
															</c:forEach>
														});
											} else {
												alert("No check boxes selected")
											}
										});
					});

	$(document)
			.ready(
					function() {
						$('.showImage')
								.click(
										function() {
											var insert = [];

											var result = $("input[name='spname']:checked");

											if (result.length > 0) {

												var resultvalues = result.length;

												result
														.each(function() {

															resultvalues = $(
																	this).val();
															insert
																	.push(resultvalues)
															insert = insert
																	.toString();
															$("#imageloader")
																	.show();
															$
																	.ajax({
																		type : "Get",
																		url : "orgImages.html",
																		contentType : "image/jpg",
																		data : "serviceProviderID="
																				+ insert,
																		success : function(
																				data) {
																			$(
																					"#imageloader")
																					.hide();
																			var dvPreview = $("#imgalign");
																			dvPreview
																					.html('');
																			var xx = data
																					.split(",");

																			for (var i = 0; i < xx.length; i++) {

																				var img = $('<img src="data:image/png;base64,' + xx[i] + '" />');
																				img
																						.attr(
																								"style",
																								"height:200px;width: 200px");
																				dvPreview
																						.append(img);
																			}
																		},
																		error : function(
																				request,
																				status,
																				error) {
																			if (error.responseText == "undefined") {
																				alert("Responsive data is UnDefined.");
																			} else {
																				/*  var dvPreview = $("#imgalign");
																				 dvPreview.html(''); */
																				alert("Service Provider image is not available.");
																			}
																		}
																	});
														});
											} else {
												alert("No check boxes selected")
											}
										});
					});

	$(document)
			.ready(
					function() {
						$('.showIDImage')
								.click(
										function() {
											var insert = [];

											var result = $("input[name='spname']:checked");

											if (result.length > 0) {

												var resultvalues = result.length;

												result
														.each(function() {

															resultvalues = $(
																	this).val();
															insert
																	.push(resultvalues)
															insert = insert
																	.toString();
															$("#imageloader")
																	.show();
															$
																	.ajax({
																		type : "Get",
																		url : "idImages.html",
																		contentType : "image/jpg",
																		data : "serviceProviderID="
																				+ insert,
																		success : function(
																				data) {
																			$(
																					"#imageloader")
																					.hide();
																			var dvPreview = $("#imgalign");
																			dvPreview
																					.html('');
																			var xx = data
																					.split(",");

																			for (var i = 0; i < xx.length; i++) {

																				var img = $('<img src="data:image/png;base64,' + xx[i] + '" />');
																				img
																						.attr(
																								"style",
																								"height:200px;width: 200px;border:1px solid #434343; margin:5px;");
																				dvPreview
																						.append(img);
																			}
																		},
																		error : function(
																				request,
																				status,
																				error) {
																			if (error.responseText == "undefined") {
																				alert("Responsive data is UnDefined.");
																			} else {
																				/*  var dvPreview = $("#imgalign");
																				 dvPreview.html(''); */
																				alert("ID image is not available.");
																			}
																		}
																	});
														});
											} else {
												alert("No check boxes selected")
											}
										});
					});

	/*  $(document).ready(
			function() {
				$('.showIDImage').click(
						function() {
							var currentTD = $(this).parents('tr')
									.find('td');
							 
								$.each(currentTD, function() {
									$(this).prop('contenteditable', false)
								});
								var ocr = $(this).parents('tr').find(
										'td:eq(1)').text();
								var tag = $("<div></div>");	
								
								$.ajax({
									type : "Get",
									url : "idImages.html",
									contentType: "image/jpg",
									data : "serviceProviderID=" + ocr,
									success : function(data) {
									var dvPreview = $("#imgalign");
							            dvPreview.html('');
							            var xx=data.split(",");
										
							            for (var i = 0; i < xx.length; i++) {
							                
				                        	 var img = $('<img src="data:image/png;base64,' + xx[i] + '" />');
				                        	 img.attr("style", "height:200px;width: 200px");				                       		 
				                        	 dvPreview.append(img);
				                        }
									},
									 error: function (request, status, error) {
									 if(error.responseText=="undefined"){
											 alert("Responsive data is UnDefined.");
										 }										 
										 else
										{ 
											/*  var dvPreview = $("#imgalign");
											 dvPreview.html(''); 
											 alert("ID image is not available.");
										 }
										}	
								});
							});
	}); */
</script>
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/validatation.js"></script>
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
	td:nth-of-type(1):before {
		content: "Select";
	}
	td:nth-of-type(2):before {
		content: "ServiceProviderId";
	}
	td:nth-of-type(3):before {
		content: "Mobile Number";
	}
	td:nth-of-type(4):before {
		content: "ServiceProvider City";
	}
	td:nth-of-type(5):before {
		content: "ServiceProvider Name";
	}
	td:nth-of-type(6):before {
		content: "ServiceProvider Website";
	}
	td:nth-of-type(7):before {
		content: "ServiceProvider Timing";
	}
	td:nth-of-type(8):before {
		content: "Status";
	}
	td:nth-of-type(9):before {
		content: "ServiceProvider Comments";
	}
	td:nth-of-type(10):before {
		content: "ServiceProvider NightOperation";
	}
	td:nth-of-type(11):before {
		content: "ServiceProvider Premium";
	}
	td:nth-of-type(12):before {
		content: "ServiceProvider Latitude";
	}
	td:nth-of-type(13):before {
		content: "ServiceProvider Longitude";
	}
	td:nth-of-type(14):before {
		content: "ServiceProvider MaxDistanceToOperate";
	}
	td:nth-of-type(15):before {
		content: "ImageFolderName";
	}
	td:nth-of-type(16):before {
		content: "Rating";
	}
	td:nth-of-type(17):before {
		content: "ServiceProvider Timestamp";
	}
	td:nth-of-type(18):before {
		content: "FourWheeler";
	}
	td:nth-of-type(19):before {
		content: "TwoWheeler";
	}
	td:nth-of-type(20):before {
		content: "ElectricalType";
	}
	td:nth-of-type(21):before {
		content: "MechanicalType";
	}
	td:nth-of-type(22):before {
		content: "BodyRepair";
	}
	/*td:nth-of-type(23):before { content: ""; }
		td:nth-of-type(24):before { content: ""; }*/
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
	<br>
	<br>
	<!-- Page Container -->
	<div class="w3-container w3-content"
		style="max-width: 1400px; margin-top: 50px">
		<!-- The Grid -->
		<div class="w3-row">
			<!-- Left Column -->
			<div class="w3-col m3">
				<!-- Profile -->
				<div class="w3-card-2 w3-round w3-white">
					<div class="w3-container">
						<h4 class="w3-center">Filters</h4>
						<div class="w3-accordion w3-white">

							<spring:url value="/user/filteredServiceProviders"
								var="userActionUrl" />

							<form class="form-horizontal" id="filteredServiceProviders"
								method="post" action="${userActionUrl}">


								<input type="hidden" id="page" name="page" value=""> <a
									onclick="myFunction('Demo1')"
									class="w3-btn-block w3-theme-l1 w3-left-align"> <i
									class="fa fa-university fa-fw w3-margin-right"></i> City
								</a>

								<div id="Demo1" class="w3-accordion-content w3-container">
								<!-- 	<c:set var="name" value="Dinesh" scope="page" />  -->
									<c:forEach items="${serviceProviderCities}" var="cities">
										<c:forEach items="${cities}" var="citys" >
											<input type="radio" value="${citys}" name="city" id="city" />${citys}
					        				<br>
										</c:forEach>
									</c:forEach>
								</div>

								<a onclick="myFunction('Demo2')"
									class="w3-btn-block w3-theme-l1 w3-left-align"> <i
									class="fa fa-calendar-check-o fa-fw w3-margin-right"></i>
									Status
								</a>

								<div id="Demo2" class="w3-accordion-content w3-container">
									<a><input type="radio" value="true" name="approve"
										id="approve"> Approve</a> <a><input type="radio"
										value="flase" name="approve" id="approve"> Non Approve</a>
								</div>

								<input type="submit" name="apply" class="w3-btn w3-theme"
									 />

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

								<form
									action="${pageContext.request.contextPath}/user/searchServiceProvidersByMobileNo"
									method="post" id="seachMobileNoForm" role="form">

									<input type="hidden" id="page" name="page" value="">
									<section style="display: flex;">
									<div style="flex: 1;">
										<input type="text" name="mobileNo" id="mobileNo"
											placeholder="Search with Mobile Number..."
											style="padding: .5em 1em; width: 100%;" />
									</div>
									<div style="flex: 0; margin: 0 0 0 1rem;">
										<button type="submit" class="w3-btn w3-theme">
											<i class="fa fa-search" aria-hidden="true"></i> Search
										</button>
									</div>
									</section>

								</form>

								<br> <span><a id="btn1" class="approve" href="#"
									style="margin-bottom: 16px !important; border: 1px solid #000; display: inline-block; outline: 0; padding: 6px 16px; vertical-align: middle; overflow: hidden; text-decoration: none !important; text-align: center; cursor: pointer; white-space: nowrap; color: #000 !important; background-color: #faed1b !important">Approve</a></span>
								<span><a id="myBtn" class="showImage" href="#"
									style="margin-bottom: 16px !important; border: 1px solid #000; display: inline-block; outline: 0; padding: 6px 16px; vertical-align: middle; overflow: hidden; text-decoration: none !important; text-align: center; cursor: pointer; white-space: nowrap; color: #000 !important; background-color: #faed1b !important">Service
										Provider Image</a></span> <span><a id="myBtn1" class="showIDImage"
									href="#"
									style="margin-bottom: 16px !important; border: 1px solid #000; display: inline-block; outline: 0; padding: 6px 16px; vertical-align: middle; overflow: hidden; text-decoration: none !important; text-align: center; cursor: pointer; white-space: nowrap; color: #000 !important; background-color: #faed1b !important">ID
										Image</a></span>

								<table id="dataTable"
									style="display: block; overflow-x: auto; max-width: 100%; height: 450px;">
									<thead>
										<tr>
											<th>Select</th>
											<th style="display: none;">Provider Id</th>
											<th>Status</th>
											<th>Mobile</th>
											<th>City</th>
											<th>Name</th>
											<th>Website</th>
											<th>Timing</th>
											<th>Comments</th>
											<th>Night Operation</th>
											<th>Premium</th>
											<th>Latitude</th>
											<th>Longitude</th>
											<th>MaxDistance To Operate</th>
											<th>Image Folder Name</th>
											<th>Rating</th>
											<th>Times tamp</th>
											<th>Four Wheeler</th>
											<th>Two Wheeler</th>
											<th>Electrical Type</th>
											<th>Mechanical Type</th>
											<th>Body Repair</th>
											<!--<th>Service ProviderImage</th>
							<th>IDImage</th>  -->
										</tr>
									</thead>

									<tbody>

										<c:forEach var="serProvider"
											items="${findAllServiceProviders.serviceProviderDTOs}">
											<tr>
												<td><input type="radio" name="spname"
													id="serviceProviderid" value="${serProvider.userId}" /></td>
												<td style="display: none" class="serviceProviderIdclass"
													id="id">${serProvider.userId}</td>
												<td class="olderserviceProviderIdclass" id="id"><c:choose>
														<c:when test="${serProvider.enabled}">
															Approved
														</c:when>
														<c:otherwise>
															Not Approved
														</c:otherwise>
													</c:choose></td>
												<td class="olderserviceProviderIdclass" id="id">${serProvider.mobileNo}</td>
												<td class="serviceProviderNameclass" id="id">${serProvider.serviceProviderCity}</td>
												<td class="serviceProviderCityclass" id="id">${serProvider.serviceProviderName}</td>
												<td class="serviceProviderIdclass" id="id">${serProvider.serviceProviderWebsite}</td>
												<td class="olderserviceProviderIdclass" id="id">${serProvider.serviceProvidertiming}</td>
												<%-- <td class="olderserviceProviderIdclass" id="id">${serProvider.enabled}</td> --%>
												<td class="serviceProviderCityclass" id="id">${serProvider.serviceProviderComments}</td>
												<td class="serviceProviderIdclass" id="id">${serProvider.serviceProviderNightOperation}</td>
												<td class="olderserviceProviderIdclass" id="id">${serProvider.serviceProviderPremium}</td>
												<td class="olderserviceProviderIdclass" id="id">${serProvider.serviceProviderLatitude}</td>
												<td class="serviceProviderNameclass" id="id">${serProvider.serviceProviderLongitude}</td>
												<td class="serviceProviderCityclass" id="id">${serProvider.serviceProviderMaxDistanceToOperate}</td>
												<td class="serviceProviderIdclass" id="id">${serProvider.imageFolderName}</td>
												<td class="olderserviceProviderIdclass" id="id">${serProvider.rating}</td>
												<td class="olderserviceProviderIdclass" id="id">${serProvider.serviceProviderTimestamp}</td>
												<td class="serviceProviderNameclass" id="id">${serProvider.fourWheeler}</td>
												<td class="serviceProviderCityclass" id="id">${serProvider.twoWheeler}</td>
												<td class="serviceProviderIdclass" id="id">${serProvider.electricalType}</td>
												<td class="olderserviceProviderIdclass" id="id">${serProvider.mechanicalType}</td>
												<td class="olderserviceProviderIdclass" id="id">${serProvider.bodyRepair}</td>
												<!-- <td><a id="btn" class="showImage" href="#" style="width:135px">Service Provider Image</a></td>
							<td><a id="btn" class="showIDImage" href="#" style="width:60px">ID Image</a></td> -->
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

			<!-- The Modal -->
			<div id="myModal" class="modal">

				<!-- Modal content -->
				<div class="modal-content">
					<div class="modal-header">
						<span class="close">x</span>
						<!--<img class="close" src="Close.png" alt="">-->
						<h2></h2>
					</div>
					<div class="modal-body">
						<!--<img src="Logomakr.png" alt="">
			<p>Some text in the Modal Body</p>
			<p>Some other text...</p>-->
						<img id="imageloader"
							style="display: none; width: 200px; height: 200px"
							src="${bootstrap}/images/loading_icon.gif">
						<div id="imgalign" class="magnific-gallery"
							style="width: 100%; text-align: center;"></div>
						<div id="dvPreview" style="width: 100%; text-align: center;"></div>

					</div>
				</div>
				<script>
					// Get the modal
					var modal = document.getElementById('myModal');

					// Get the button that opens the modal
					var btn = document.getElementById("myBtn");
					var btn1 = document.getElementById("myBtn1");

					// Get the <span> element that closes the modal
					var span = document.getElementsByClassName("close")[0];

					// When the user clicks the button, open the modal 
					btn.onclick = function() {
						modal.style.display = "block";
					}
					btn1.onclick = function() {
						modal.style.display = "block";
					}

					// When the user clicks on <span> (x), close the modal
					span.onclick = function() {
						var dvPreview = $("#imgalign");
						dvPreview.html('');
						modal.style.display = "none";
					}

					// When the user clicks anywhere outside of the modal, close it
					window.onclick = function(event) {
						if (event.target == modal) {
							var dvPreview = $("#imgalign");
							dvPreview.html('');
							modal.style.display = "none";
						}
					}
				</script>
			</div>

			<!-- End Grid -->
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