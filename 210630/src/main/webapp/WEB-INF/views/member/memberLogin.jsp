<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<c:if test="${!empty id}">
				<spring:message code="register.login" arguments="${member.name }" />
				${member.email } 
			</c:if>
			<c:if test="${empty id}">
				<spring:message code="register.loginFail" />
			</c:if>
			<br><br>
			<button type="button" onclick="location.href='home'">홈으로</button>
		</div>
	</div>
</body>
</html>