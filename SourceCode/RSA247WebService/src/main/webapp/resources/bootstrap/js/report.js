currentReportName = "";

function generateReport(reportName) {

	var reporturl = "/RSA247WebService/newReports?ReportName=" + reportName
			+ "&ReportFormat=html";

	$("#reportData")
			.html(
					"Loading...<br><img src='/RSA247WebService/resources/bootstrap/images/loading_icon.gif' align='middle' >");

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

function ServiceProvidersReport(reportName, format) {

	var startDate = $('#startDate').find("input").val().replace(/ /gi, "%20");
	var endDate = $('#endDate').find("input").val().replace(/ /gi, "%20");

	if (startDate == "") {
		alert("Please Select the Start Date.");
		return;
	}
	if (endDate == "") {
		alert("Please Select the End Date.");
		return;
	}
	var reporturl = "";

	if (format === "html") {
		reporturl = "/RSA247WebService/newReports?ReportName=" + reportName
				+ "&StartDate=" + startDate + "&EndDate=" + endDate
				+ "&ReportFormat=html";
		$("#reportData")
				.html(
						"Loading...<br><img src='/RSA247WebService/resources/bootstrap/images/loading_icon.gif' align='middle' >");

		$('#reportData').load(reporturl, function(response, status, xhr) {
			if (status == "error") {
				var msg = "Sorry but there was an error getting details ! ";
				$("#reportData").html(msg + xhr.status + " " + xhr.statusText);
			}
		});
	} else {
		reporturl = "/RSA247WebService/newReports?ReportName=" + reportName
				+ "&StartDate=" + startDate + "&EndDate=" + endDate
				+ "&ReportFormat=" + format;
		window.location.href = reporturl;
	}
	currentReportName = reportName;
}

function CustomersReport(reportName, format) {

	var startDate = $('#startDate').find("input").val().replace(/ /gi, "%20");
	var endDate = $('#endDate').find("input").val().replace(/ /gi, "%20");

	if (startDate == "") {
		alert("Please Select the Start Date.");
		return;
	}
	if (endDate == "") {
		alert("Please Select the End Date.");
		return;
	}

	var reporturl = "";

	if (format === "html") {
		reporturl = "/RSA247WebService/newReports?ReportName=" + reportName
				+ "&StartDate=" + startDate + "&EndDate=" + endDate
				+ "&ReportFormat=html";
		$("#reportData")
				.html(
						"Loading...<br><img src='/RSA247WebService/resources/bootstrap/images/loading_icon.gif' align='middle' >");

		$('#reportData').load(reporturl, function(response, status, xhr) {
			if (status == "error") {
				var msg = "Sorry but there was an error getting details ! ";
				$("#reportData").html(msg + xhr.status + " " + xhr.statusText);
			}
		});
	} else {
		reporturl = "/RSA247WebService/newReports?ReportName=" + reportName
				+ "&StartDate=" + startDate + "&EndDate=" + endDate
				+ "&ReportFormat=" + format;
		window.location.href = reporturl;
	}
	currentReportName = reportName;
}

function CustomerIssueReport(reportName, format) {

	var startDate = $('#startDate').find("input").val().replace(/ /gi, "%20");
	var endDate = $('#endDate').find("input").val().replace(/ /gi, "%20");
	var statusVal = prompt("Enter the status : ");

	if (startDate == "") {
		alert("Please Select the Start Date.");
		return;
	}
	if (endDate == "") {
		alert("Please Select the End Date.");
		return;
	}
	var reporturl = "";
	if (format == "html") {
		reporturl = "/RSA247WebService/newReports?ReportName=" + reportName
				+ "&Status=" + statusVal + "&StartDate=" + startDate
				+ "&EndDate=" + endDate + "&ReportFormat=html";

		$("#reportData")
				.html(
						"Loading...<br><img src='/RSA247WebService/resources/bootstrap/images/loading_icon.gif' align='middle' >");
		$('#reportData').load(reporturl, function(response, status, xhr) {
			if (status == "error") {
				var msg = "Sorry but there was an error getting details ! ";
				$("#reportData").html(msg + xhr.status + " " + xhr.statusText);
			}
		});

	} else {
		reporturl = "/RSA247WebService/newReports?ReportName=" + reportName
				+ "&Status=" + statusVal + "&StartDate=" + startDate
				+ "&EndDate=" + endDate + "&ReportFormat=" + format;
		window.location.href = reporturl;
	}

	currentReportName = reportName;
}

function downloadReport1(format) {

	if (currentReportName == "") {
		alert("Please Select the report.");
		return;
	}

	if (currentReportName == "CustomerIssuesDate.rptdesign") {
		CustomerIssueReport(currentReportName, format);
	} else if (currentReportName == "CustomersDate.rptdesign") {
		CustomersReport(currentReportName, format);
	} else if (currentReportName == "ServiceProviderDate.rptdesign") {
		ServiceProvidersReport(currentReportName, format);
	}

}
