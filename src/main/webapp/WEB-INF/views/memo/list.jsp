<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 목록</title>
</head>
<body>
<a href="/memo/insert">메모 등록</a>
	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
		</tr>
		<c:forEach var="memo" items="${memoList}">
		<tr>
			<th>${memo.mNo}</th>
			<th><a href="/memo/view?mNo=${memo.mNo }">${memo.title }</a></th>
			<th>${memo.writer }</th>
			<th>${memo.registerDate }</th>
		</tr>
		</c:forEach>
	</table>
</body>
</html>