<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty msg }">
			<div style="color: red;">${msg}</div>
			<div>
				<a href="javascript:history.back();">뒤로가기</a>
			</div>
		</c:when>
		<c:otherwise>
			<form action="/boards/modify" method="post">
				<div>
					<label> <input type="hidden" name="id"
						value="${board.id}">
					</label>
				</div>
				<div>
					<label>제목: <input type="text" name="title"
						value="${board.title}">
					</label>
				</div>
				<div>
					<label>내용: <input type="text" name="content"
						value="${board.content}">
					</label>
				</div>
				<div>
					<label>작성자: <input type="text" name="writer"
						value="${board.writer}">
					</label>
				</div>
				<div>
					<button>수정</button>
				</div>
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>