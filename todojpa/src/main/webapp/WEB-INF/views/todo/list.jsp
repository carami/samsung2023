<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>todo list </title>
</head>
<body>
<h1> ToDo List</h1>
<form method="post" action="add">
	할일 : <input type="text" name="todo">
	<input type="submit" value="할일 추가"> 
</form>
<c:forEach var="todo" items="${todoList }">
	<p>
		 <c:if test="${todo.done }">완료^^</c:if>
		 <c:if test="${!todo.done }">진행중...... </c:if>
		<a href="update?id=${todo.id }">${todo.todo} </a>
		<a href="delete?id=${todo.id }">삭제 </a>
	</p>

</c:forEach>
</body>
</html>