<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<tiles:insertDefinition name="base-definition" />

<script src="//code.jquery.com/jquery-1.12.3.js"></script>

<script
	src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js"></script>

<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"></script>
<script
	src="https://cdn.datatables.net/1.10.12/css/dataTables.bootstrap.min.css"></script>


<script>
	$(document).ready(function() {
		$('#cities').DataTable();
	});
</script>

<br>
<br>

<div class="w3-row">

	<div class="w3-col m3">
		<div class="w3-container"></div>
	</div>

	<div class="w3-col m9">
		<div class="w3-container ">
			<table class="table display table-striped table-bordered table:hover"
				cellspacing="0" width="100%" id="cities" style="size: em;">
				<thead>
					<tr>
						<th>Vehicle Model ID</th>
						<th>Vehicle Model Name</th>
						<th>Active</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vehicleModel" items="${vehicles.vehicleDTOs}">
						<tr>
							<td>${vehicleModel.vehicleModelId}</td>
							<td>${vehicleModel.modelName}</td>
							<td>${vehicleModel.isEnabled}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>




