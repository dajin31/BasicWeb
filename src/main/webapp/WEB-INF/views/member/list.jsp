
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
<!-- html 주석 이건 F12하면 보임  -->
<%-- 자바쪽 주석 이건 안보임--%>
<%--${members }--%> <!-- EL(Expression Language) 값을 표현할때 쓰는거 -->
<table>
 <tr>
<th>아이디</th>
<th>이름</th>
<th>휴대전화번호</th>
<th>이메일</th>
 </tr>
 <c:forEach items="${members}" var="member">
 <tr>
	<td>${member.memId}</td>
	<td><a href="/member/detail?id=${member.memId}">${member.memName}</a></td>
	<td>${member.memHp}</td>
    <td>${member.memMail}</td>
 </tr>
</c:forEach>

</table>
</body>
</html>






































