<!-- Default Header -->

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/resources/bootstrap" var="bootstrap" />
<spring:url value="/logout" var="logoutUrl" />

<link rel="stylesheet" media="screen" href="${bootstrap}/css/w3.css">
<link rel="stylesheet" media="screen" href="${bootstrap}/css/bootstrap.css">
<link rel="stylesheet" media="screen" href="${bootstrap}/css/bootstrap.css">
<link rel="stylesheet" media="screen"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<link rel="stylesheet" media="screen"
	href="${bootstrap}/css/opensans.css">

<style>
html, body, h1, h2, h3, h4, h5 {
	font-family: "Open Sans", sans-serif
}
</style>

<sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
	<c:set var="username" >
		<c:url value="guest" />
	</c:set>
</sec:authorize>

<sec:authorize ifNotGranted="ROLE_ANONYMOUS">
	<c:set var="username" scope="session">
		<c:url value="${user.username}" />
	</c:set>
	<c:set var="loggedIn" value="true" />
</sec:authorize>

<spring:message var="welcome" code="welcome" arguments="${username}" />

<div class="w3-theme-l5">

	<!-- Navbar -->
	<div class="w3-top">
		<ul class="w3-navbar w3-theme-d2 w3-left-align w3-large">
			<li class="w3-hide-medium w3-hide-large w3-opennav w3-right"><a
				class="w3-padding-large w3-hover-white w3-large w3-theme-d2"
				href="javascript:void(0);" onclick="openNav()"><i
					class="fa fa-bars"></i></a></li>
			<li><a href="${pageContext.servletContext.contextPath}"
				class="w3-padding-large w3-theme-d4"><img
					src="${bootstrap}/images/rsa.png" style="height: 40px;"></a></li>
			<li class="w3-hide-small w3-dropdown-hover"><a
				href="${pageContext.servletContext.contextPath}"
				class="w3-padding-large w3-hover-white" title="Home"><i
					class="fa fa-home"></i></a></li>
			<li class="w3-hide-small w3-dropdown-hover"><a
				href="#"
				class="w3-padding-large w3-hover-white" title="Issues Management"><i
					class="fa fa-info-circle"></i></a>
				<div class="w3-dropdown-content w3-white w3-card-4">
					<a href="${pageContext.servletContext.contextPath}/servicerequest/findAllCustomerRequests">All Issues</a> <a href="#">Open Issues</a> <a href="#">Completed
						Issues</a>
				</div></li>
			<li class="w3-hide-small"><a href="#"
				class="w3-padding-large w3-hover-white" title="Customer"><i
					class="fa fa-user"></i></a></li>
			<li class="w3-hide-small  w3-dropdown-hover"><a href="#"
				class="w3-padding-large w3-hover-white" title="Service Provider"><i
					class="fa fa-cogs"></i></a>
				<div class="w3-dropdown-content w3-white w3-card-4">
					<a
						href="${pageContext.servletContext.contextPath}/user/findAllServiceProviders?page=">Service Providers</a> <a
						href="${pageContext.servletContext.contextPath}/user/findAllEmployees?page=">Employees</a>
				</div></li>
			<li class="w3-hide-small"><a href="#"
				class="w3-padding-large w3-hover-white" title="Vendor Verification"><i
					class="fa fa-check-square-o"></i></a></li>
			<li class="w3-hide-small"><a href="#"
				class="w3-padding-large w3-hover-white" title="Survey"><i
					class="fa fa-safari"></i> <!-- <span class="w3-badge w3-right w3-small w3-green">3</span> --></a>

			</li>
				
			<li class="w3-hide-small w3-right w3-dropdown-hover"><a href="#" class="w3-padding-large w3-hover-white" title="My Account">
			  <label class="" style="font-size:12px; vertical-align:middle;"><img src="/RSA247WebService/resources/bootstrap/images/img_avatar2.png" class="w3-circle" style="height:35px;width:35px; margin-right:5px;" alt="Avatar">${welcome}</label>
			  
				<div class="w3-dropdown-content w3-white w3-card-4">
				<c:if test="${empty loggedIn}">
				  <a href="${pageContext.request.contextPath}/login"><span data-hover="Login">Login</span></a>
				  <!-- <a href="#">John Doe posted on your wall</a>
				  <a href="#">Jane likes your post</a> -->
				</c:if>
				<c:if test="${not empty loggedIn}">
					<a href="${pageContext.request.contextPath}/user/cities"><span data-hover="Cities1">Cities1</span></a>
					<a href="${pageContext.request.contextPath}/city/findAllCities?page="><span data-hover="Cities2">Cities2</span></a>
					<a href="${logoutUrl}">Logout ${loggedIn}</a>
				</c:if>
				</div>
			  </li>	
			
			
			<!-- <li class="active">${welcome}</li>
			<c:if test="${empty loggedIn}">
				<li><a href="${pageContext.request.contextPath}/login"><span data-hover="Login">Login</span></a></li>
			</c:if>
			<c:if test="${not empty loggedIn}">
				<li><a href="${pageContext.request.contextPath}/user/cities"><span data-hover="Cities1">Cities1</span></a></li>
				<li><a href="${pageContext.request.contextPath}/city/findAllCities?page="><span data-hover="Cities2">Cities2</span></a></li>
				
				<li class="w3-hide-small w3-right w3-dropdown-hover"><a
					href="#" class="w3-padding-large w3-hover-white" title="My Account">
						<img src="${bootstrap}/images/img_avatar2.png" class="w3-circle"
						style="height: 35px; width: 35px" alt="Avatar">
						<div class="w3-dropdown-content w3-white w3-card-4">
							<a href="${logoutUrl}">Logout ${loggedIn}</a>
						</div>
				</a></li>
			</c:if> -->
		</ul>
	</div>
	
	<!-- Navbar on small screens -->
	<div id="navDemo" class="w3-hide w3-hide-large w3-hide-medium w3-top" style="margin-top:51px">
	  <ul class="w3-navbar w3-left-align w3-large w3-theme">
	    <li><a class="w3-padding-largemob" href="#" style="font-size:15px">Home</a></li>
	    <li><a class="w3-padding-largemob" href="#" style="font-size:15px">Issues Management</a>
			<ul style="font-size:15px">
			    <li><a class="w3-padding-largemob" href="#" style="font-size:15px">All Issues</a></li>
		        <li><a class="w3-padding-largemob" href="#" style="font-size:15px">Open Issues</a></li>
				<li><a class="w3-padding-largemob" href="#" style="font-size:15px">Completed Issues</a></li>
			</ul>
		</li>
	    <li><a class="w3-padding-largemob" href="#" style="font-size:15px">Customer</a></li>
		<li><a class="w3-padding-largemob" href="#" style="font-size:15px">Service Provider</a>
			<ul style="font-size:15px">
			    <li><a class="w3-padding-largemob" href="#" style="font-size:15px">Service Provider</a></li>
		        <li><a class="w3-padding-largemob" href="#" style="font-size:15px">Employees</a></li>
			</ul>
		</li>
		<li><a class="w3-padding-largemob" href="#" style="font-size:15px">Vendor Verification</a></li>
	    <li><a class="w3-padding-largemob" href="#" style="font-size:15px">Survey</a></li>
	  </ul>
	</div>
	
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

</div>

<!-- //Default Header -->