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
function validateform(){
		var adminname = document.getElementById("adminName").value;
		var mobileNo = document.getElementById("mobileNo").value;
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		var confirmpwd = document.getElementById("confirmpwd").value;
		
		 var pattern = /^\d{10}$/;
		 
		 var filter = /^[0-9-+]+$/;
		
		if(adminname=="")
			{
			alert("enter admin value");
			}
		if(mobileNo=="")	
		{
		alert("enter mobileNo value");
		}
		if (pattern.test(mobileNo))
		{
			
		}
		 else 
		{
			 alert("Enter numeric value with 10 digits");
		}
		 
		if(username=="")
		{
		alert("enter username value");
		}
		if(password=="")
		{
		alert("enter password value");
		}
		if(confirmpwd=="")
		{
		alert("enter confirmpwd value");
		}
		if(password!=confirmpwd)
		{
		alert ( "password miss match " );
		}
		
		 
		
		
		
} 

	
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
	<br><br>
	<br><br>
	<!-- Page Container -->
	
								<form
									action="${pageContext.request.contextPath}/admin/adminregistration"
									method="post" id="seachMobileNoForm" role="form">

									<section style="display: flex;">
									<div style="flex: 1;">
									
									name
									<br>
										<input type="text" name="adminName" id="adminName"
											
											style="padding: .5em 1em; width: 50%;" /> <br>
											
											mobile No:
											<br>
										<input type="text" name="mobileNo" id="mobileNo"
											
											style="padding: .5em 1em; width: 50%;" /><br>
											
											userName Or EmailId<br>
											
											<input type="text" name="username" id="username"
											
											style="padding: .5em 1em; width: 50%;" /><br>
											password
											<br>
											<input type="text" name="password" id="password"
											
											style="padding: .5em 1em; width: 50%;" /><br>
											confirm pwd
											<br>
											<input type="text" name="confirmpwd" id="confirmpwd"
											
											style="padding: .5em 1em; width: 50%;" />	<br>
											
											<button type="submit" class="w3-btn w3-theme" id="but" onclick="validateform()" style="color:red;">
											 submit
										</button>
											
									</div>
									
									</section>

								</form>
	</script>

</body>
</html>