<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo 등록</title>
</head>
<body>
	<!-- 
		url:get     view?tNo=1 에서 tNo가 파라미터
		form: get,post   name 속성의 값이 파라미터
		참고:
		요청할 때 parameter와 attribute 를 사용해서 데이터를 전달한다.
		parameter = 사용자가 보내는 데이터 =>getParameter()는 있는데,  setParanmeter 없음
		파라미터는 set이 없음.
		개발자가 사용자 몰래 데이터를 심어놓고 전달하는 방식????
		그건바로!!
		setParameter 가 없는 대신 <input type = "hidden" name="" value="">을 사용해서 전달가능
		attribute = 개발자가 보내는 데이터 =>getAttribute() ,setAttribute() 둘다있음
 -->
	<div style="color: red">${msg}</div>
	<form action="/todo/insert" method='post'>
		<div>
			할일: <input type="text" name="title">
			<!-- 저 name이 파라미터임 -->
		</div>
		<div>
			작성자: <input type="text" name="writer">
		</div>
		<div>
			완료일자: <input type="date" name="dueDate">
		</div>
		<div>
			<button>등록</button>
		</div>
	</form>
</body>
</html>