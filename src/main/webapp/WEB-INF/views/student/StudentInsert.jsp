<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생등록</title>
</head>
<body>
	<form action="/Student/new" method="post">
		<div>
			<label>학번: <input type="text" name="no">
			</label>
		</div>
		<div>
			<label>학과: <input type="text" name="depart">
			</label>
		</div>
		<div>
			<label>이름: <input type="text" name="name">
			</label>
		</div>
		<div>
			<label>주소: <input type="text" name="address">
			</label>
		</div>
		<div>
			<label>폰번: <input type="tel" name="phone">
			</label>
		</div>
		<div>
			<button type="submit">등록</button>
		</div>
	</form>
</body>
</html>