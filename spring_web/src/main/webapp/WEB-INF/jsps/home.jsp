<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery-3.2.1.js"></script>
<script type="text/javascript">

function updateCount(data) {
	$("#countDiv").text(data.count);
}
function updatePage() {
	$.getJSON("<c:url value='/jsonAjaxTest'/>", updateCount);
}
function onLoad() {
	updatePage();
	window.setInterval(updatePage, 10000);
}
$(document).ready(onLoad);

</script>

<title>Insert title here</title>
</head>
<body>
	Current value of count is : <span id="countDiv"></span>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
	<p><a href="${pageContext.request.contextPath}/users">Users</a></p>
	</sec:authorize>
	<p><a href="${pageContext.request.contextPath}/offers">Offers</a></p>
	<p><a href="${pageContext.request.contextPath}/offers/new">Create Offer</a></p>
	<sec:authorize access="!isAuthenticated()">
	<p><a href="${pageContext.request.contextPath}/login">Login</a></p>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
	<p><a href="${pageContext.request.contextPath}/logout">Logout</a></p>
	</sec:authorize>
</body>
</html>