<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<sec:authorize  access="!isAuthenticated()">
	<a href="loginform.html">login</a>
</sec:authorize>

<sec:authorize  access="isAuthenticated()">
	welcome~~~~    <sec:authentication property="name"/>    <a href="logout">logout</a>
</sec:authorize>

<br> <hr>

<a href="todo.html">todo</a>
</body>
</html>
