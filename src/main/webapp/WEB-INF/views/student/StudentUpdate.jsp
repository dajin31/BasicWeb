<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생수정</title>
</head>
<body>
	<form action="/Student/update" method="post">
		<div>
			<label>구학과: <input type="text" name="oldDepart"
				value="${student.depart}">
			</label>
		</div>
		<div>
			<label>뉴학과: <input type="text" name="newDepart"
				value="${student.depart}">
			</label>
		</div>
		<div>
			<button type="submit">수정</button>
		</div>
	</form>
</body>
</html>