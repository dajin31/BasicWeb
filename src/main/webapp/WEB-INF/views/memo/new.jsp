<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 등록</title>
</head>
<body>
	<div style="color: red">${msg}</div>
	<form action="/memo/insert" method='post'>
		<div>
			제목:<input type="text" name="title">
		</div>
		<div>
			내용:<input type="text" name="content">
		</div>
		<div>
			작성자<input type="text" name="writer">
		</div>
		<div>
			<button>저장</button>
		</div>
	</form>
</body>
</html>