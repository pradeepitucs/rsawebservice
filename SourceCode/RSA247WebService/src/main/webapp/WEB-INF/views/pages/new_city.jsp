<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<form action="/city/employee" method="post" role="form"
		data-toggle="validator">
		
		<c:if test="${empty action}">
			<c:set var="action" value="add" />
		</c:if>
		<input type="hidden" id="action" name="action" value="${action}">
		
		<input type="hidden" id="cityId" name="cityId"
			value="${city.cityId}">
		
		<h2>City</h2>
		<div class="form-group col-xs-4">
			
			<label for="name" class="control-label col-xs-4">City Name:</label> 
			<input
				type="text" name="name" id="name" class="form-control"
				value="${city.cityName}" required="required" /> 
			
			<label for="name" class="control-label col-xs-4">City Code:</label> 
			<input
				type="text" name="name" id="name" class="form-control"
				value="${city.cityCode}" required="required" /> 
			
			<label for="name" class="control-label col-xs-4">City Active:</label> 
			<input
				type="checkbox" name="name" id="name" class="form-control"
				value="${city.isEnabled}" required="required" /> 

			<button type="submit" class="btn btn-primary  btn-md">Accept</button>
		</div>
	</form>
</div>
