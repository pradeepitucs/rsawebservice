<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">

<script>
	$(document).ready(function() {

		var table = $('#cities').DataTable();

		$('a.toggle-vis').on('click', function(e) {
			e.preventDefault();

			// Get the column API object
			var column = table.column($(this).attr('data-column'));

			// Toggle the visibility
			column.visible(!column.visible());
		});

		$('#cities tbody').on('click', 'tr', function() {
			if ($(this).hasClass('selected')) {
				$(this).removeClass('selected');
			} else {
				table.$('tr.selected').removeClass('selected');
				$(this).addClass('selected');
			}
		});

		$("#newbtn").click(function() {
			console.log();
			$("#newVehicleFuelType").modal('show');
		});

		$("#editbtn").click(function() {
			console.log();
			$("#editVehicleFuelType").modal('show');
		});
	});
</script>

<br>
<br>
<br>
<br>

<br>
<br>

<div class="w3-row">

	<div class="w3-col m3">
		<div class="w3-container"></div>
	</div>

	<div class="w3-col m9">
		<div class="w3-container dataTables_wrapper ">

			<div>
				Toggle column: <a class="btn btn-default btn-xs toggle-vis"
					data-column="0">Vehicle Fuel Type ID</a> <a
					class="btn btn-default btn-xs toggle-vis" data-column="1">Vehicle
					Fuel Type Name</a> <a class="btn btn-default btn-xs toggle-vis"
					data-column="2">Active</a>
			</div>

			<div>
				<a class="btn btn-default btn-xs" id="newbtn" href="javascript:;">
					<span class="glyphicon glyphicon-add"></span> New
				</a> <a class="btn btn-default btn-xs" id="editbtn" href="javascript:;">
					<span class="glyphicon glyphicon-pencil"></span> Edit
				</a> <a class="btn btn-default btn-xs" id="removebtn"
					href="javascript:;"> <span class="glyphicon glyphicon-remove"></span>
					Remove
				</a> <a class="btn btn-default btn-xs" id="viewbtn" href="javascript:;">
					<span class="glyphicon glyphicon-search"></span> View
				</a>
			</div>

			<table class="display" cellspacing="0" width="100%" id="cities"
				style="size: em;">
				<thead>
					<tr>
						<th>Vehicle Fuel Type ID</th>
						<th>Vehicle Fuel Type Name</th>
						<th>Active</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vehicleFuel"
						items="${vehiclefueltypes.vehicleFuelTypeDTOs}">
						<tr>
							<td id="id" >${vehicleFuel.vehicleFuelTypeId}</td>
							<td id="name" >${vehicleFuel.vehicleFuelTypeName}</td>
							<td id="active" >${vehicleFuel.isEnabled}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<spring:url value="/uservehicle/updatefueltype" var="userActionUrl" />

	<!-- New Fuel Type Modal -->
	<div id="newVehicleFuelType" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<form class="form-horizontal" 
					id="VehicleFuelTypeNew" method="post" role="form" action="${userActionUrl}" >
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">New Vehicle Fuel Type Information</h4>
					</div>
					<div class="modal-body" id="displayNewVehicleFuel">
						<input type="hidden" id="FuelTypeID" name="FuelTypeID" value="0">
					
						<div class="form-group">
							<label class="col-md-4 control-label">Fuel Type Name</label>
							<div class="col-md-8">
								<input type="text" class="form-control"
									id="FuelTypeName" name="FuelTypeName" >
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Active</label>
							<div class="col-md-8">
								<input type="checkbox" class="form-control" name="Active" id="Active" checked="checked" >
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-default" data-dismiss="modal" value="Submit" />
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Close" />
					</div>
				</form>
			</div>

		</div>
	</div>

	<!-- Update Fuel Type Modal -->
	<div id="editVehicleFuelType" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<form class="form-horizontal" 
					id="VehicleFuelTypeEdit" method="post" action="${userActionUrl}">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">New Vehicle Fuel Type Information</h4>
					</div>
					<div class="modal-body" id="displayNewVehicleFuel">
						<div class="form-group">
							<label class="col-md-4 control-label">Fuel Type ID</label>
							<div class="col-md-8">
								<input type="text" class="form-control"
									placeholder="FuelTypeID">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Fuel Type Name</label>
							<div class="col-md-8">
								<input type="text" class="form-control"
									placeholder="FuelTypeName">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Active</label>
							<div class="col-md-8">
								<input type="checkbox" class="form-control" placeholder="Active">
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-default" data-dismiss="modal">Update</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</form>
			</div>

		</div>
	</div>

</div>




