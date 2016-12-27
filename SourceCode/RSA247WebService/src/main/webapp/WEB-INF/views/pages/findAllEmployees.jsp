<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<spring:url value="/resources/bootstrap" var="bootstrap" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" dir="ltr">
<head>
<title>RSA24/7 Admin Console</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script type="text/javascript">
   $(document).ready(function () {
	     $('.emloyeeapprove').click(function () {
        	var insert = [];
           var result=$("input[name='empname']:checked");
           
           if(result.length > 0)
        	   {
        	   
        	   var resultvalues=result.length;
        	  
        	  result.each(function(){
        		      
        		  resultvalues = $(this).val();
        		  insert.push(resultvalues)
        		  <c:forEach var="employeeInfo" items="${findAllEmployees.employeeDTO}" >
        		  if(resultvalues == "${employeeInfo.userId}"){
        			  if("${employeeInfo.isEnabled}" == "true"){
        		  alert("Employee already Approved");
        	  } else {
        		  insert=insert.toString();
                  
                  $.ajax({  
              	     type : "Post",   
              	     url : "employeeapprovel.html",
              	     data : "&var1=" + insert, 
              	      success : function(response) {  
              	    	alert(response);
              	    	window.location.reload( true );
              	    },  
              	     error : function(e) {  
              	    	 alert("error");   
              	     }  
              	    });
        	  }
        		  }
                  </c:forEach>
        		          	   }); 
        	   
        	   } 
           else
        	   {
        	   alert("no Employee check boxes selected")
        	   }
           
        }); 
   }); 
   
   $(document).ready(function () {
	     $('.showEmployeeImage').click(function () {
      	var insert = [];
      	
         var result=$("input[name='empname']:checked");
         
         if(result.length > 0)
      	   {
      	   
      	   var resultvalues=result.length;
      	  
      	  result.each(function(){
      		      
      		  resultvalues = $(this).val();
      		  insert.push(resultvalues)
      		  insert=insert.toString();
      		$("#imageloader").show();
      		$.ajax({
				type : "Get",
				url : "employeeImages.html",
				contentType: "image/jpg",
				data : "employeeID=" + insert,
				success : function(data) {
					$("#imageloader").hide();
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
						 dvPreview.html(''); */
						 alert("Employee Image is not available .");
					 } 
				    }	
			});
      		          	   }); 
      	   
      	   } 
         else
      	   {
      	   alert("no Employee check boxes selected")
      	   }
         
      }); 
 }); 
	     
	      /* $(".searchemp").click(function(){
		  	   var mobileNo = $('#employeeId').val();
		  	   alert("Emp number="+mobileNo);
		  	/*  window.location.replace("http://192.168.1.9:2020/RSAAdmin/searchEmployeeDetails/"+employeeId); */ 
		  	 
		  	/*  $.ajax({  
	       	     type : "Post",   
	       	     url : "http://localhost:8080/RSAAdmin/searchEmployeeDetails",
	       	     data : "&mobileNo=" + mobileNo, 
	       	      success : function(response) {  
	       	    	alert(mobileNo+"Employ-----");
	       	    	
	       	      //alert("sucess"+response);  
	       	    	//window.location.replace("http://192.168.1.9:2020/RSAAdmin/servicesproviders");

	       	     },  
	       	     error : function(e) {  
	       	    	 alert("error");   
	       	     }  
	       	    });


		  	 
		      }); */ 
  
  $(document).ready(
			function() {
				$('.editbtn').click(
						function() {
							var currentTD = $(this).parents('tr')
									.find('td');
							if ($(this).html() == 'Edit') {
								$.each(currentTD, function() {
									$(this).prop('contenteditable', true)

								});
							} else {
								$.each(currentTD, function() {
									$(this).prop('contenteditable', false)
								});
								var emp_id = $(this).parents('tr').find(
										'td:eq(1)').text();
								/* var id = document.getElementById("id").innerHTML; */
								var emp_name = $(this).parents('tr').find(
										'td:eq(2)').text();
								var mobile_number = $(this).parents('tr').find(
										'td:eq(3)').text();
								var emp_email = $(this).parents('tr').find(
										'td:eq(4)').text();
								var owner = $(this).parents('tr')
										.find('td:eq(5)').text();
								var gcmID = $(this).parents('tr')
								.find('td:eq(6)').text();
								var serviceProviderID = $(this).parents('tr')
								.find('td:eq(7)').text();
								var status = $(this).parents('tr')
										.find('td:eq(8)').text();
								$.ajax({
									type : "Get",
									url : "editEmployee.html",
									data : "emp_id=" + emp_id
											+ "&emp_name=" + emp_name
											+ "&mobile_number=" + mobile_number
											+ "&emp_email=" + emp_email
											+ "&owner=" + owner
											+ "&gcmID=" +gcmID
											+ "&serviceProviderID=" + serviceProviderID
											+ "&status="
											+ status,
									success : function(response) {
										alert(response);
									},
									error : function(e) {
										alert('Error: ' + e);
									}
								});
							}

							$(this).html(
									$(this).html() == 'Edit' ? 'Save'
											: 'Edit')

						});

			});
</script>
<style>
	
	/* 
	Max width before this PARTICULAR table gets nasty
	This query will take effect for any screen smaller than 760px
	and also iPads specifically.
	*/
	@media 
	only screen and (max-width: 760px),
	(min-device-width: 768px) and (max-device-width: 1024px)  {
	
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
		
		tr { border: 1px solid #ccc; }
		
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
		td:nth-of-type(1):before { content: "Select"; }
		td:nth-of-type(2):before { content: "employeeID"; }
		td:nth-of-type(3):before { content: "employeeName"; }
		td:nth-of-type(4):before { content: "olderEmployeeID"; }
		td:nth-of-type(5):before { content: "mobileNo"; }
		td:nth-of-type(6):before { content: "isEnabled"; }
		/*td:nth-of-type(7):before { content: ""; }*/
	}
	
	/* Smartphones (portrait and landscape) ----------- */
	@media only screen
	and (min-device-width : 320px)
	and (max-device-width : 480px) {
		body { 
			padding: 0; 
			margin: 0; 
			width: 320px; }
		}
	
	/* iPads (portrait and landscape) ----------- */
	@media only screen and (min-device-width: 768px) and (max-device-width: 1024px) {
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
<div class="w3-container w3-content" style="max-width:1400px;margin-top:10px">    
  <!-- The Grid -->
  <div class="w3-row">
  	<br>
  	<br>
    <!-- Left Column -->
    <div class="w3-col m3">
      <!-- Profile -->
      <div class="w3-card-2 w3-round w3-white">
        <div class="w3-container">
         <h4 class="w3-center">Filters</h4> 
			<div class="w3-accordion w3-white">
			<spring:url value="/user/filteredEmployees"
								var="userActionUrl" />

			<form class="form-horizontal" id="filteredEmployees"
				method="post" action="${userActionUrl}">
				
				<input type="hidden" id="page" name="page"
							value="">
							
				<a onclick="myFunction('Demo1')"
					class="w3-btn-block w3-theme-l1 w3-left-align"> <i
					class="fa fa-calendar-check-o fa-fw w3-margin-right"></i>
					Status
				</a>
				
			  <div id="Demo1" class="w3-accordion-content w3-container">
				<a href="#"> <input type="radio" name="approve" value="true"> Approve</a> 
				<a href="#"> <input type="radio" value="flase" name="approve"> Non Approve</a>
			  </div>
<!-- 			   <button onclick="myFunction('Demo2')" class="w3-btn-block w3-theme-l1 w3-left-align"><i class="fa fa-circle-o-notch fa-fw w3-margin-right"></i> My Events</button> -->
<!-- 			  <div id="Demo2" class="w3-accordion-content w3-container"> -->
<!-- 				<p>Some other text..</p> -->
<!-- 			  </div>  -->
			  
			  	<input type="submit" name="apply" class="w3-btn w3-theme" />
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
						action="${pageContext.request.contextPath}/user/searchEmployeesByMobileNo"
						method="post" id="seachCityForm" role="form">
            	<section style="display: flex;">
            		
						
						<input type="hidden" id="searchAction" name="searchAction"
							value="searchByName">
						<input type="hidden" id="page" name="page"
							value="">
							
						<div style="flex: 1; margin-top: 10px;">
							<input type="text" name="mobileNo" id="mobileNo" placeholder="Search with Mobile Number..." style="padding: .5em 1em; width: 100%;"/>
						</div>
						<div style="margin: 10px 0 0 1rem;">
							<button type="submit" class="w3-btn w3-theme"><i class="fa fa-search" aria-hidden="true"></i> Search</button>
						</div>
					
				 </section>
				 
				 </form>
				 <br>
	             <span><a id="btn1" class="emloyeeapprove" href="#" style="margin-bottom:16px!important; border:1px solid #000;display:inline-block;outline:0;padding:6px 16px;vertical-align:middle;overflow:hidden;text-decoration:none!important;text-align:center;cursor:pointer;white-space:nowrap;color:#000 !important; background-color:#faed1b !important">Approve Employee</a></span>
				 <span><a id="myBtn" class="showEmployeeImage" href="#" style="margin-bottom:16px!important; border:1px solid #000;display:inline-block;outline:0;padding:6px 16px;vertical-align:middle;overflow:hidden;text-decoration:none!important;text-align:center;cursor:pointer;white-space:nowrap;color:#000 !important; background-color:#faed1b !important">Employee Image</a></span>
	
				<table id="employeeData" style="display: block; overflow-x: auto; max-width:100%; height:450px;">
					<thead>
						<tr>
							<th>Select</th>
							 <th  style="display: none;">employeeID</th> 
							<th>Employee Name</th>
							<th>Mobile Number</th> 
							<th>Employee Email</th>
							<th>Owner</th> 
							<th  style="display: none;">GCM ID</th> 
							<th  style="display: none;">Service Provider ID</th> 
							<th>Status</th>
							<!-- <th>Employee Image</th> -->
						</tr>
					</thead>
					
					<tbody>
					<c:forEach var="employeeInfo" items="${findAllEmployees.employeeDTO}" >
						<tr>
							<td><input type="radio"  name="empname" id="employeeid" value="${employeeInfo.userId}"/></td>
							<td class="serviceProviderIdclass" style="display: none;" id="id">${employeeInfo.userId}</td> 
							<td class="serviceProviderIdclass" id="id">${employeeInfo.employeeName}</td>
							<td class="olderserviceProviderIdclass" id="id">${employeeInfo.mobileNo}</td>
							<td class="olderserviceProviderIdclass" id="id">${employeeInfo.employeeEmail}</td>
							<td class="olderserviceProviderIdclass" id="id">${employeeInfo.onwer}</td>
							<td class="olderserviceProviderIdclass" style="display: none;" id="id">${employeeInfo.gcmId}</td> 
							<td class="olderserviceProviderIdclass" style="display: none;" id="id">${employeeInfo.serviceProviderID}</td>
							<td class="olderserviceProviderIdclass" id="id">               
								<c:choose>
									<c:when test="${employeeInfo.isEnabled}">
										Approved
									</c:when>
									<c:otherwise>
										Not Approved
									</c:otherwise>
								</c:choose>
							</td>
							<!-- <td><a id="btn" class="showEmployeeImage" href="#" style="width:95px">Employee Image</a></td> -->
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
			<img id="imageloader"  style="display: none;width:200px;height: 200px" src="${bootstrap}/images/loading_icon.gif">
			<div id="imgalign" class="magnific-gallery" style="width:100%; text-align:center;"></div>
			<div id="dvPreview" style="width:100%; text-align:center;"></div>
			
	    </div>
	  </div>
	  <script>
		// Get the modal
		var modal = document.getElementById('myModal');
		
		// Get the button that opens the modal
		var btn = document.getElementById("myBtn");
		
		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];
		
		// When the user clicks the button, open the modal 
		btn.onclick = function() {
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
        x.previousElementSibling.className = 
        x.previousElementSibling.className.replace(" w3-theme-d1", "");
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