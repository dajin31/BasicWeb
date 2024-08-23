<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<div style="color:red;">${mas}</div>
	<form action="/login" method="post">
		<div>
			아이디: <label> <input type="text" name="userId" value="${cookie.rememberId.value}">
			</label>
		</div>
		<div>
			비번: <label> <input type="password" name="userPw">
			</label>
		</div>
		<div>
			<label> <input type="checkbox" name="rememberMe" value="remember-me">아이디 저장
			</label> 
		</div>
		<div>
			<button>로그인</button>
			<button type="reset">취소</button>
		</div>
	</form>
</body>
</html>