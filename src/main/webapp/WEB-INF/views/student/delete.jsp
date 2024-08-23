<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제</title>
</head>
<body>
	<form action="/Student/delete" method="post">
		<div>
			<label>삭제할 학과명: <input type="text" name="depart">
			</label>
		</div>
		<div>
			<button type="submit">전송</button>
		</div>
	</form>
</body>
</html>