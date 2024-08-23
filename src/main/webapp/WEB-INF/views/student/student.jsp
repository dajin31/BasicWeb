
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생목록</title>
</head>
<body>
	<table>
		<tr>
			<th>넘버</th>
			<th>학과</th>
			<th>이름</th>
			<th>주소</th>
			<th>폰번</th>
		</tr>
		<c:forEach items="${student}" var="student">
			<tr>
				<td>${student.no}</td>
				<td>${student.depart}</td>
				<td>${student.name}</td>
				<td>${student.address}</td>
				<td>${student.phone}</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>






































