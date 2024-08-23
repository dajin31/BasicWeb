<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정</title>
</head>
<body>
<!-- 사용자가 서버에 데이터를 전송할때 반드시 form태그를 사용
1.input : 종류에따라 text, password ,radio ,checkbox ,file,  hidden ,submix ,reset , image
				HTML5버전에서 추가된 종류 - tel , serach,number,color, email,range,...
2.select : drop down list , combobox라고 하는 선택할 수 있는 태그
3.textarea : 여러줄의 문자를 입력받을때 사용하는 태그
4.button : 입력이 아닌 동작에 해당하는 태그  
주의 : 반드시 name 속성이 존재해야 서버로 데이터가 전달됨
 -->
 <form action="/member/update" method="post">
 <div>
 	<label>아이디:
 		<input type="text" name="memId" value="${member.memId}" readonly="readonly">
 	</label>
 </div>
  <div>
 	<label>이름:
 		<input type="text" name="memName" value="${member.memName}">
 	</label>
 </div>
  <div>
 	<label>생년월일:
 		<input type="date" name="memBir"value="${member.memBir}">
 	</label>
 </div>
  <div>
 	<label>폰번:
 		<input type="tel" name="memHp" value="${member.memHp}">
 	</label>
 </div>
  <div>
 	<label>이메일:
 		<input type="email" name="memMail" value="${member.memMail}">
 	</label>
 </div>
 <div>
 	<button type="submit">수정</button>
 </div>
 </form>
</body>
</html>