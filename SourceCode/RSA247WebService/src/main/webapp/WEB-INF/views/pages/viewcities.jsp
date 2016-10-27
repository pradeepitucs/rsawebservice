<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="base-definition" />

<!-- Page Container -->
<div class="w3-container w3-content"
	style="max-width: 1400px; margin-top: 10px">
	<!-- The Grid -->
	<div class="w3-row">
		<!-- Left Column -->
		<div class="w3-col m3">
			<br> <br>
			<!-- Profile -->
			
			<div class="w3-card-2 w3-round w3-white">
				<div class="w3-container">
					<!--Search Form -->
					<h2>City By Name</h2>
					<form
						action="${pageContext.request.contextPath}/city/searchCityByName"
						method="get" id="seachCityForm" role="form">
						
						<input type="hidden" id="searchAction" name="searchAction"
							value="searchByName">
						<input type="hidden" id="page" name="page"
							value="">
								
						<div class="form-group col-xs-5">
							<input type="text" name="cityName" id="cityName"
								class="form-control" required="required"
								placeholder="Type the City Name" />
						</div>
						<button type="submit" class="btn btn-info">
							<span class="glyphicon glyphicon-search"></span> Search
						</button>
						<br></br> <br></br>
					</form>
				</div>
			</div>
		</div>

		<!-- Middle Column -->
		<div class="w3-col m7">
			<br> <br>
			<div class="bs-docs-example wow fadeInUp animated"
				data-wow-delay=".5s">
				<table class="table table-striped">
					<thead>
						<tr>
							<th><spring:message code="city.Id" text="City ID" /></th>
							<th><spring:message code="city.Code" text="City Code" /></th>
							<th><spring:message code="city.Name" text="City Name" /></th>
							<th><spring:message code="city.Active" text="Active" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="city" items="${viewcities.cityDTOs}">
							<tr>
								<td>${city.cityId}</td>
								<td>${city.cityCode}</td>
								<td>${city.cityName}</td>
								<td>${city.isEnabled}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<nav>
					<ul class="pagination">

						<%--For displaying Previous link except for the 1st page --%>
						<c:if test="${currentPage != 1}">
							<li><a
								href="${pageContext.request.contextPath}/city/findAllCities?page=${i}"
								aria-label="Previous"><span aria-hidden="true">«</span></a></li>
						</c:if>
						<c:if test="${currentPage == 1}">
							<li class="disabled"><a
								href="${pageContext.request.contextPath}/city/findAllCities?page=${i}"
								aria-label="Previous"><span aria-hidden="true">«</span></a></li>
						</c:if>

						<%--For displaying Page numbers. 
				The when condition does not display a link for the current page--%>
						<c:forEach begin="1" end="${noOfPages}" var="i">
							<c:choose>
								<c:when test="${currentPage eq i}">
									<li class="active"><a
										href="${pageContext.request.contextPath}/city/findAllCities?page=${i}">1
											<span class="sr-only">${i}</span>
									</a></li>
								</c:when>
								<c:otherwise>
									<li class="active"><a
										href="${pageContext.request.contextPath}/city/findAllCities?page=${i}">${i}
											<span class="sr-only">(current)</span>
									</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<%--For displaying Next link --%>
						<c:if test="${currentPage lt noOfPages}">
							<li><a
								href="${pageContext.request.contextPath}/city/findAllCities?page=${currentPage + 1}"
								aria-label="Next"><span aria-hidden="true">»</span></a></li>
						</c:if>
					</ul>
				</nav>
			</div>
		</div>
	</div>
</div>