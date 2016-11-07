currentReportName = "";

function generateReport(reportName) {

	var reporturl = "/RSA247WebService/newReports?ReportName=" + reportName
			+ "&ReportFormat=html";
	
	$("#reportData")
	.html("Loading...<br><img src='/RSA247WebService/resources/bootstrap/images/loading_icon.gif' align='middle' >");

	$('#reportData').load(reporturl, function(response, status, xhr) {
		if (status == "error") {
			var msg = "Sorry but there was an error getting details ! ";
			$("#reportData").html(msg + xhr.status + " " + xhr.statusText);
		}
	});

	currentReportName = reportName;
}

function generateReport1(reportName, Status) {

	var reporturl = "/RSA247WebService/newReports?ReportName=" + reportName
			+ "&Status=" + Status + "&ReportFormat=html";
	
	$("#reportData")
	.html("Loading...<br><img src='/RSA247WebService/resources/bootstrap/images/loading_icon.gif' align='middle' >");

	$('#reportData').load(reporturl, function(response, status, xhr) {
		if (status == "error") {
			var msg = "Sorry but there was an error getting details ! ";
			$("#reportData").html(msg + xhr.status + " " + xhr.statusText);
		}
	});

	currentReportName = reportName;
}

function downloadReport(format) {

	if (currentReportName == "") {
		alert("Please Select the report.");
		return;
	}
	
	var reporturl = "/RSA247WebService/newReports?ReportName="
			+ currentReportName + "&ReportFormat=" + format;

	window.location.href = reporturl;

}
