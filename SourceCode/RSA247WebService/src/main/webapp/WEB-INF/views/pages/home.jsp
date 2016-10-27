<!-- Page Container -->

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/bootstrap" var="bootstrap" />

<div class="w3-container w3-content"
	style="max-width: 1400px; margin-top: 80px">
	<!-- The Grid -->
	<div class="w3-row">
		<!-- Left Column -->
		<div class="w3-col m3">
			<!-- Profile -->
			<div class="w3-card-2 w3-round w3-white">
				<div class="w3-container">
					<h5 class="w3-center" style="font-size: 12px;">Issues
						Management</h5>
					<p class="w3-center">
						<a href="${pageContext.servletContext.contextPath}/servicerequest/findAllCustomerRequests"
							title="Issues Management"><i class="fa fa-info-circle"
							style="font-size: 40px; color: #fe6722;"></i></a>
					</p>
					<hr>
					<h4 class="w3-center" style="font-size: 12px;">Customer</h4>
					<p class="w3-center">
						<a href="#" title="Customer"><i class="fa fa-user"
							style="font-size: 40px; color: #02bad2;"></i></a>
					</p>
					<hr>
					<h4 class="w3-center" style="font-size: 12px;">Service
						Provider</h4>
					<p class="w3-center">
						<a
							href="${pageContext.servletContext.contextPath}/user/findAllServiceProviders?page="
							title="Service Provider"><i class="fa fa-cogs"
							style="font-size: 40px; color: #ac71a9;"></i></a>
					</p>
					<hr>
					<h4 class="w3-center" style="font-size: 12px;">Vendor
						Verification</h4>
					<p class="w3-center">
						<a href="#" title="Vendor Verification"><i
							class="fa fa-check-square-o"
							style="font-size: 40px; color: #6bca6c;"></i></a>
					</p>
					<hr>
					<h4 class="w3-center" style="font-size: 12px;">Survey</h4>
					<p class="w3-center">
						<a href="#" title="Survey"><i class="fa fa-safari"
							style="font-size: 40px; color: #019482;"></i></a>
					</p>

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

							<!-- <h6 class="w3-opacity">Search with Mobile Number</h6> -->
							<!-- <section style="display: flex;">
				<div style="flex: 1;">
					<input type="text" placeholder="Search with Mobile Number..." style="padding: .5em 1em; width: 100%;"/>
				</div>
				<div style="flex: 0; margin: 0 0 0 1rem;">
					<button class="w3-btn w3-theme"><i class="fa fa-search" aria-hidden="true"></i> Search</button>
				</div>
			  </section> -->
							<!-- <p contenteditable="true" class="w3-border w3-padding">Status: Feeling Blue</p> 
			  <input class="w3-border w3-padding" type="text">
              <button type="button" class="w3-btn w3-theme"><i class="fa fa-search" aria-hidden="true"></i>  Search</button> -->
						</div>
					</div>
				</div>
			</div>

			<!-- End Middle Column -->
		</div>

	</div>

	<!-- End Page Container -->
</div>