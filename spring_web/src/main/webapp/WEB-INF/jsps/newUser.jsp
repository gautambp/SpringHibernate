<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %> 
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery-3.2.1.js"></script>
<script type="text/javascript">

function onLoad() {
	$("#password").keyup(checkPasswordMatch);
	$("#confirmPassword").keyup(checkPasswordMatch);
	$("#userForm").submit(canSubmit);
}

function checkPasswordMatch() {
	var pwd = $("#password").val();
	var conPwd = $("#confirmPassword").val();
	if (pwd.length > 3 || conPwd.length > 3) {
		if (pwd == conPwd) {
			$("#passwordMatchDiv").text("<fmt:message key='MatchedPassword.userVO.password'/>");
			$("#passwordMatchDiv").removeClass("error");
		} else {
			$("#passwordMatchDiv").text("<fmt:message key='UnmatchedPassword.userVO.password'/>");
			$("#passwordMatchDiv").addClass("error");
		}
	}
}

function canSubmit() {
	var pwd = $("#password").val();
	var conPwd = $("#confirmPassword").val();
	if (pwd == conPwd) return true;
	alert("<fmt:message key='UnmatchedPassword.userVO.password'/>");
	return false;
}

$(document).ready(onLoad);

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sf:form id="userForm" method="post" action="${pageContext.request.contextPath}/users/create" commandName="userVO">
		<table class="formtable">
			<tr>
				<td class="label">Username: </td>
				<td>
					<sf:input type="text" path="username" name="username"/><br/>
					<sf:errors path="username" cssClass="error"></sf:errors>
				</td>
			</tr>
			<tr>
				<td class="label">Name: </td>
				<td>
					<sf:input type="text" path="name" name="name"/><br/>
					<sf:errors path="name" cssClass="error"></sf:errors>
				</td>
			</tr>
			<tr>
				<td class="label">Email: </td>
				<td>
					<sf:input type="text" path="email" name="email"/><br/>
					<sf:errors path="email" cssClass="error"></sf:errors>
				</td>
			</tr>
			<tr>
				<td class="label">Password: </td>
				<td>
					<sf:input id="password" type="password" path="password" name="password"/><br/>
					<sf:errors path="password" cssClass="error"></sf:errors>
				</td>
			</tr>
			<tr>
				<td class="label">Confirm Password: </td>
				<td>
					<input id="confirmPassword" type="password" name="confirmPassword"/><br/>
					<div id="passwordMatchDiv"></div><br/>
				</td>
			</tr>
			<tr>
				<td class="label">Create User: </td>
				<td><input type="submit"/></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>