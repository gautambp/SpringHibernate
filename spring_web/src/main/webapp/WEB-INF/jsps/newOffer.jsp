<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sf:form method="post" action="${pageContext.request.contextPath}/offers/create" commandName="offerVO">
		<table class="formtable">
			<tr>
				<td class="label">Your Offer: </td>
				<td><sf:textarea path="text"></sf:textarea></td>
			</tr>
			<tr>
				<td class="label">Create Offer: </td>
				<td><input type="submit"/></td>
			</tr>
		</table>
	</sf:form>
	<p><a href="${pageContext.request.contextPath}/">Home</a></p>	
</body>
</html>