<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:choose>
		<c:when test="${not empty member}">
			<div>
				${sessionScope.member.memName}님하이용~ <a
					href="/logout?id=${sessionScope.member.memId}">로그아웃</a>
			</div>
		</c:when>
		<c:otherwise>
			<div>
				<a href="/login">로그인</a>
			</div>
		</c:otherwise>
	</c:choose>
	<a href="/boards/register">게시글 등록</a>
	<table>
		<tr>
			<th>게시글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일수</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${boards}" var="board">
			<tr>
				<th>${board.id}</th>
				<th><a href="/boards/detail?id=${board.id}"> ${board.title}</a></th>
				<th>${board.writer}</th>
				<th>${board.registerDate}</th>
				<th>${board.hits}</th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>