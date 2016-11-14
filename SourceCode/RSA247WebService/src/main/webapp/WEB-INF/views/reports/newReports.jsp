<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/bootstrap" var="bootstrap" />

<link rel="stylesheet" media="screen"
	href="${bootstrap}/css/bootstrap-datetimepicker.min.css">

<!-- DO Not Chnage the Order JS and CSS  -->
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript"
	src="${bootstrap}/js/moment-with-locales.js"></script>
<script type="text/javascript"
	src="${bootstrap}/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="${bootstrap}/js/report.js"></script>


<br>
<br>
<br>

<div>
	<h3 align="center" style="color: #84A9CF">Eclipse Birt Reports</h3>

	<div style="float: left; width: 20%;">
		<fieldset style="background-color: white;">
			<legend>
				<b style="color: #84A9CF">Select Reports</b>
			</legend>
			<ul>
				<!-- 
				<li><a href="#"
					onclick="generateReport('CustomerIssues.rptdesign')"> Customer
						Issue</a></li>
				<li><a href="#"
					onclick="generateReport1('FilterCustomerIssues.rptdesign', 'Open')">
						Customer with Open Status Issue</a></li> 
				<li><a href="#" onclick="generateReport('Customers.rptdesign')">
						Customers </a></li> 
				<li><a href="#"
					onclick="generateReport('ServiceProvider.rptdesign')"> Service
						Providers</a></li>		
				-->

				<li><a href="#" onclick="CustomerIssueReport('CustomerIssuesDate.rptdesign', 'html')"> Customer
						Issue </a></li>
				<li><a href="#" onclick="CustomersReport('CustomersDate.rptdesign', 'html')"> Customers
						</a></li>
				<li><a href="#" onclick="ServiceProvidersReport('ServiceProviderDate.rptdesign', 'html')"> Service
						Providers </a></li>

			</ul>
		</fieldset>

		<fieldset style="background-color: white;">
			<div id="downloadOptions" align="left" style="margin-left: 5%;">
				Download Report as: <br /> <a href="#"
					onclick="downloadReport1('pdf')">PDF</a>, <a href="#"
					onclick="downloadReport1('xls')">XLS</a>, <a href="#"
					onclick="downloadReport1('doc')">DOC</a>, <a href="#"
					onclick="downloadReport1('ppt')">PPT</a>,<br /> <a href="#"
					onclick="downloadReport1('docx')">DOCX</a>, <a href="#"
					onclick="downloadReport1('xlsx')">XLSX</a>, <a href="#"
					onclick="downloadReport1('pptx')">PPTS</a>
			</div>
		</fieldset>

	</div>

	<fieldset style="background-color: white;">

		<legend>
			<b style="color: #84A9CF">Report Details:</b>
		</legend>

		<div class="container">
			<div class='col-md-5'>
				<div class="form-group">
					<label for="startDate">Start Date</label>
					<div class='input-group date' id='startDate'>
						<input type='text' class="form-control" /> <span
							class="input-group-addon"> <span
							class="glyphicon glyphicon-calendar"></span>
						</span>
					</div>
				</div>
			</div>
			<div class='col-md-5'>
				<div class="form-group">
					<label for="endDate">End Date</label>
					<div class='input-group date' id='endDate'>
						<input type='text' class="form-control" /> <span
							class="input-group-addon"> <span
							class="glyphicon glyphicon-calendar"></span>
						</span>
					</div>
				</div>
			</div>
		</div>

		<div id="reportData"
			style="height: auto; background-color: white; float: left; min-width: 80%; text-align: center;"
			align="center">
			<br> Reports will be loaded here when user selects report from
			left navigation.
		</div>

	</fieldset>

	<script type="text/javascript">
		$(function() {
			$('#startDate').datetimepicker({

			});
			$('#endDate').datetimepicker({
				useCurrent : false
			//Important! See issue #1075
			});
			$("#startDate").on("dp.change", function(e) {
				$('#endDate').data("DateTimePicker").minDate(e.date);
			});
			$("#endDate").on("dp.change", function(e) {
				$('#startDate').data("DateTimePicker").maxDate(e.date);
			});
		});

	</script>


</div>