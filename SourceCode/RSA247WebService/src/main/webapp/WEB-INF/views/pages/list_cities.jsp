<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">

	<h2>Cities</h2>
	<!--Search Form -->
	<form action="/employee" method="get" id="seachEmployeeForm"
		role="form">
		<input type="hidden" id="searchAction" name="searchAction"
			value="searchByName">
		<div class="form-group col-xs-5">
			<input type="text" name="employeeName" id="employeeName"
				class="form-control" required="true"
				placeholder="Type the Name or Last Name of the employee" />
		</div>
		<button type="submit" class="btn btn-info">
			<span class="glyphicon glyphicon-search"></span> Search
		</button>
		<br></br> <br></br>
	</form>

	<!--Employees List-->
	<c:if test="${not empty message}">
		<div class="alert alert-success">${message}</div>
	</c:if>
	<form action="/employee" method="post" id="employeeForm" role="form">
		<input type="hidden" id="idEmployee" name="idEmployee"> <input
			type="hidden" id="action" name="action">
		<c:choose>
			<c:when test="${not empty employeeList}">
							
			</c:when>
			<c:otherwise>
				<br>
				<div class="alert alert-info">No city found matching your
					search criteria</div>
			</c:otherwise>
		</c:choose>
	</form>
</div>