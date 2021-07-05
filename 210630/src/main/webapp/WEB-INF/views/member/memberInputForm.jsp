<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<!--  스프링 폼태그 사용  Spring 폼태그 -->
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<div align="center">
	<h1>회원가입</h1><br>
	<form:form action="memberRegister" modelAttribute="member" enctype="multipart/form-data">
		<label>email</label>
		<form:input path="email"/><br>
		
		<label>password</label>
		<form:input path="password"/><br>

		<label>passwordCheck</label>
		<input type="password" id="passwordCheck"/><br>
		
		<label>이름</label>
		<form:input path="name"/><br>
		
		<label>사진</label>
		<input type="file" id="file" name="file"/><br>
		
		<label>회원구분</label>
		<form:select path="gubun" items="${loginType }" />
		<br><br>
		<input type="submit" value="회원가입">
	</form:form>
</div>
</body>
</html>