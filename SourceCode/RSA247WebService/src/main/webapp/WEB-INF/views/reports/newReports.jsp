<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/bootstrap" var="bootstrap" />

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${bootstrap}/js/report.js">
	
</script>

<br>
<br>
<br>

<div>
	<h3 align="center" style="color: #84A9CF"> Eclipse Birt Reports </h3>

	<div style="float: left; width: 25%;">
		<fieldset style="background-color: white;">
			<legend>
				<b style="color: #84A9CF">Select Reports</b>
			</legend>
			<ul>
				<li><a href="#"
					onclick="generateReport('CustomerIssues.rptdesign')"> Customer
						Issue</a></li>
				<li><a href="#"
					onclick="generateReport1('FilterCustomerIssues.rptdesign', 'Open')"> Customer
						Issue</a></li>
				<li><a href="#" onclick="generateReport('Customers.rptdesign')">
						Customers </a></li>
				<li><a href="#"
					onclick="generateReport('ServiceProvider.rptdesign')"> Service
						Providers</a></li>
			</ul>
		</fieldset>
	</div>

	<fieldset style="background-color: white;">

		<legend>
			<b style="color: #84A9CF">Report Details:</b>
		</legend>

		<div id="downloadOptions" align="right">
			Download Report as: <br /> 
			<a href="#"	onclick="downloadReport('pdf')">PDF</a>, 
			<a href="#"	onclick="downloadReport('xls')">XLS</a>, 
			<a href="#"	onclick="downloadReport('doc')">DOC</a>, 
			<a href="#"	onclick="downloadReport('ppt')">PPT</a>,<br /> 
			<a href="#"	onclick="downloadReport('docx')">DOCX</a>, 
			<a href="#"	onclick="downloadReport('xlsx')">XLSX</a>, 
			<a href="#"	onclick="downloadReport('pptx')">PPTS</a>
		</div>

		<div id="reportData"
			style="height: auto; background-color: white; float: left; min-width: 70%; text-align: center;"
			align="center">
			<br> Reports will be loaded here when user selects report from
			left navigation.
		</div>

	</fieldset>

</div>