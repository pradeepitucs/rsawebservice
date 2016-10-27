<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles"	uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags"%>
<tiles:insertDefinition name="base-definition" />

<script src="https://code.jquery.com/jquery-1.12.3.js"></script>
<script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>


<script>
	$(document).ready(function() {
	    $('#cities').DataTable();
	} );
</script>

<br>
<br>

<div class="bs-docs-example wow fadeInUp animated" data-wow-delay=".5s">
	<table class="table display table-striped table-bordered table:hover" id="cities" >
		<thead>
			<tr>
				<th>City ID</th>
				<th>City Code</th>
				<th>City Name</th>
				<th>Active</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="city" items="${cities.cityDTOs}">
				<tr >
					<td>${city.cityId}</td>
					<td>${city.cityCode}</td>
					<td>${city.cityName}</td>
					<td>${city.isEnabled}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>