<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제목 상세</title>
</head>
<body>
	<div>
		<span>제목:</span> <span>${memo.mNo}</span>
	</div>
	<div>
		<span>작성자:</span> <span>${memo.writer}</span>
	</div>
	<div>
		<span>작성일자:</span> <span>${memo.registerDate}</span>
	</div>
	<div>
		<span>내용:</span> <span>${memo.content}</span>
	</div>
	<div>
	<a href="/memo/update?mNo=${memo.mNo}">수정</a>
	<a href="/memo/delete?mNo=${memo.mNo}">삭제</a>
	</div>
</body>
</html>