<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
<title>Spring Form</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	function memberListCall() {
		$.ajax({
			url : "ajax/members",
			type : "post",
			data : "hey",
			datatype : "json",
			success : function(data) {
				console.log(data);
				resultHtml(data);
			},
			error : function(e) {
			}
		});
	};

	function resultHtml(data) {
		var html = "<table border = '1'>";
		html += "<tr>";
		html += "<th>이메일</th>";
		html += "<th>이름</th>";
		html += "<th>회원구분</th>";
		html += "</tr>";

		$.each(data, function(key, value) {
			html += "<tr align = 'center'>";
			html += "<td>" + value.email + "</td>";
			html += "<td>" + value.name + "</td>";
			html += "<td>" + value.gubun + "</td>";
			html += "</tr>";
		});

		html += "</table>";
		$("#list").append(html);
	}
</script>
</head>
<body>
	<div align="center">
		<div>
			<h1>여기서 시작</h1>
		</div>
		<div>
			<h3>
				<a href="memberInputForm">회원등록</a>
			</h3>
			<h3>
				<a href="step1">메시지연습</a>
			</h3>
			<h3>
				<a href="memberLoginForm">로그인</a>
			</h3>
			<h3>
				<a href="api/members">jsonData</a>
			</h3>
			<h3>
				<a href="memberList">회원목록</a>
			</h3>
			<h3>
				<button type="button" onclick="memberListCall()">회원목록(JSON)</button>
			</h3>
			<h3>
				<a href="api/member">회원목록(JSON-RestController)</a>
			</h3>
		</div>
			<span><spring:message code="main" text="*"/></span>
		<div id="list"></div>
	</div>
</body>
</html>
