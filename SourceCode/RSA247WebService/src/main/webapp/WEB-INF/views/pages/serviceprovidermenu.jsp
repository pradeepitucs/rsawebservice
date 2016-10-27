<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/listCollapse.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/cookie.js"></script>
<script type="text/javascript">
window.onload = function () {
  compactMenu('treeversion',false,'&plusmn; ');
  stateToFromStr('treeversion',retrieveCookie('menuState'));
}
window.onunload = function () {
  setCookie('menuState',stateToFromStr('treeversion'));
}
</script>
<style>
ul.maketree, ul.maketree ul, ul.maketree li {
  margin: 0;
  padding: 5px;
  list-style-type: none;
}
ul.maketree ul { padding-left: 0.3em; }
ul.maketree li {
  border-left: 1px dotted #000;
  padding-left: 13px;
  background: url(../images/minus.gif) scroll no-repeat 1px 0.8em;
}
ul.maketree li.last {
  border-left-width: 0px;
  padding-left: 14px;
  background: url(../images/plus.gif) scroll no-repeat left top;
}
ul.maketree li a{ color:#000000; font-size:14px; font-weight:bold; padding:5px;}
ul.maketree li a:hover{ text-decoration:none; border-bottom: 1px solid #a9db80;}
</style>
</head>
<body>
<div class="wrapper row2">
  <div id="container">
    <!-- content body -->
    <aside id="left_column">
      <nav>
        <ul class="maketree" id="treeversion">
			<li>Service Provider
				<ul>
					<li><a href="${pageContext.servletContext.contextPath}/servicesproviders">All Service Provider</a></li>
					
					<%-- <ul>
				      <li><a href="${pageContext.servletContext.contextPath}/page2">Survey Data</a></li>
				      <li><a href="${pageContext.servletContext.contextPath}/page3">User Data</a></li>
				      <li><a href="${pageContext.servletContext.contextPath}/page5">Survey</a></li>
				      <li><a href="${pageContext.servletContext.contextPath}/page6">Category</a></li>
				      </ul> --%>
				      <%--  <li> <a href="${pageContext.servletContext.contextPath}/dbbackup" >DB Backup</a></li> --%>
				      <!-- <li><a href="someHref">Chapter 2</a></li>
				      <li><a href="someHref">Chapter 3</a></li>
				      <li><a href="someHref">Chapter 4</a></li> -->
				</ul>
			</li>
			<li>Employee
				<ul>
					<li><a href="${pageContext.servletContext.contextPath}/allemployees">All Employee</a></li>
					
				      <%-- <ul>
				          <li><a href="${pageContext.servletContext.contextPath}/verifyPage">Verify Vendor Data</a></li>
				          <li><a href="${pageContext.servletContext.contextPath}/onBoardedPage">On-Boarding Data</a></li>
				         <!--  <li><a href="someHref">Ex 2</a></li> -->
				        </ul> --%>
				        
				        <!-- <li><a href="javascript:notA();">Database Backup</a></li> -->
				</ul>
			</li>
		</ul>
      </nav>
    </aside>
	</div>
</div>
</body>
</html>