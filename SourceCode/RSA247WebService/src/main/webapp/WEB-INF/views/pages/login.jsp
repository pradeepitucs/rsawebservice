<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<spring:url value="/resources/bootstrap" var="bootstrap" />
<spring:url value="/login-process" var="loginUrl" />
<spring:url value="/logout" var="logoutUrl" />

<sec:authorize ifAnyGranted="ROLE_USER,ROLE_ADMIN">
	<c:set var="loggedIn" value="true" />
</sec:authorize>

<!-- Need to added in message -->
<spring:message var="indexTitle" 		code="index.title" />
<%-- <spring:message var="indexDescription" 	code="index.description" /> --%>
<spring:message var="login" 			code="login" />
<spring:message var="welcome" 			code="welcome" arguments="${username}" />
<spring:message var="formUsername" 		code="index.login.form.username" />
<spring:message var="formPassword" 		code="index.login.form.password" />
<spring:message var="formSubmit" 		code="index.login.form.submit" />



<div class="w3-container w3-content"
	style="max-width: 1400px; margin-top: 80px">
	<!-- The Grid -->
	<div class="w3-row">
		<!-- Left Column -->
		<div class="w3-col m3">
			<!-- Profile -->
			<div class="w3-card-2 w3-round w3-white">
				<div class="w3-container">
				<br><br>
					<p class="w3-center"><img src="/RSA247WebService/resources/bootstrap/images/rsaround.png" class="w3-circle" style="height:106px;width:106px" alt="Avatar"></p>
					<hr>
					 
					<c:if test="${empty loggedIn}">
						<div style="text-align:center"><h1>${indexTitle}</h1>
						<h5>${indexDescription}</h5></div>
						<form action="${loginUrl}" method="POST">
							<fieldset>
								<legend>${login}</legend>
								<c:if test="${not empty param.loginError}">
									<div class="form-group col-lg-12">
										<p class="text-danger">${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
									</div>
								</c:if>
								<label for="j_username">${formUsername}</label><input type="text" id="j_username" name="j_username"
										 style="padding: .5em 1em; width: 100%;"/>
								<!-- <div class="form-group col-lg-12">
									<label for="j_username">${formUsername}</label> <input type="text"
										class="form-control" id="j_username" name="j_username"
										placeholder="Username">
								</div> -->
								<br><br>
								<label for="j_password">${formPassword}</label><input type="password" id="j_password"
										name="j_password" style="padding: .5em 1em; width: 100%;"/>
								<!-- <div class="form-group col-lg-12">
									<label for="j_password">${formPassword}</label> <input
										type="password" class="form-control" id="j_password"
										name="j_password" placeholder="Password">
								</div> -->
								<br><br>
								<button type="submit" class="w3-btn w3-theme-d1 w3-margin-bottom"><i class="fa fa-arrow-right"></i> ${formSubmit}</button>
							</fieldset>
						</form>
					</c:if>
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
							<br> <img src="${bootstrap}/images/rsaround.png" alt="Avatar"
								class="w3-left w3-circle w3-margin-right" style="width: 60px">
							<!-- <span class="w3-right w3-opacity">32 min</span> -->
							<h4>RSA 24/7 Admin Console</h4>
							<br>
							<hr class="w3-clear">
							<!-- <p>Have you seen this?</p> -->
							<img src="${bootstrap}/images/rsa_admin_console.jpg" style="width: 100%"
								class="w3-margin-bottom">
						</div>
					</div>
				</div>
			</div>

			<!-- End Middle Column -->
		</div>

	</div>

	<!-- End Page Container -->
</div>