<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<div align="center">
	<div><h1>로그인</h1></div>
	<c:if test="${!empty id }">
		<h1>${id }님은 이미 로그인 중입니다. </h1>		
		<button type="button" onclick="location.href='home'">홈으로</button>
	</c:if>
	<c:if test="${empty id }">
	<form:form modelAttribute="member" action="memberLogin" method="post">
		<label>이메일 :</label>
		<form:input path="email"/> <br>
		<label>비밀번호 :</label>
		<form:password path="password" /> <br><br>
		<input type="submit" value="로그인">
	</form:form>
	</c:if>
</div>
</body>
</html>