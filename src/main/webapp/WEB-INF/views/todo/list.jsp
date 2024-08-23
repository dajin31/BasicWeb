<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>할일목록</title>
<style type="text/css">
.tr-line-through {
	text-decoration: line-through;
}
</style>
</head>
<body>
	<a href="/todo/insert">할일등록</a>
	<table>
		<tr>
			<th>번호</th>
			<th>할일</th>
			<th>작성자</th>
			<th>완료여부</th>
			<th>마감일자</th>
			<th>완료</th>
		</tr>
		<!-- 진짜 하나도 모르겟따. 
		 for(TodoVO todo : todoList){
			todo.getTNo();		 
		 }
		-->
		<c:forEach var="todo" items="${todoList}">
			<tr class="${todo.complete ? 'tr-line-through' : '' }">
				<td>${todo.tNo}</td>
				<td><a href="/todo/view?tNo=${todo.tNo }"> ${todo.title}</a></td>
				<td>${todo.writer}</td>
				<td>${todo.complete ? '완료' : '진행중'}</td>
				<td>${todo.dueDate}</td>
				<td><input type="checkbox" id="${todo.tNo}"
					${todo.complete?'checked':''}></td>
			</tr>
		</c:forEach>
	</table>
	<script>
		document.querySelectorAll("input[type=checkbox]").forEach(item =>{
			item.addEventListener("change",(evt)=>{
				const checkBox = evt.target;
				console.log(checkBox)
				if(checkBox.checked){
					console.log(checkBox.id+ "번 아이디 체크됨")
				}else{
					console.log(checkBox.id+ "번 아이디 체크해제됨")
				}
				//Ajax를 사용할떄 요즘 많이 사용하는 순수 자바스크립트 함수
				fetch(`/todo/complete?tNo=\${checkBox.id}&complete=\${checkBox.checked}`)
				//이제 파싱을 해서			
				.then(response => response.json())
				.then(data => {
					console.log(data.result);
					if (data.result === "success") {
					//	if(checkBox.checked){
					//		checkBox.parentElement.parentElement.style.textDecoration="line-through";
					//	} else {
					//		checkBox.parentElement.parentElement.style.textDecoration="none";
					//	}
					//		jsvascript classList : 클래스 속성을 변경
					// 		add(클래스추가) , remove(클래스 삭제), toggle(클래스가 존재하면 없애주고 없으면 추가해줌 스위치같은거)
							checkBox.parentElement.parentElement.classList.toggle("tr-line-through");
							checkBox.parentElement.parentElement.children[3].textContent = data.complete ? "완료" : "미완료";
					}
		
				});
			})
		});
	</script>
</body>
</html>