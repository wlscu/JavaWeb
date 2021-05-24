<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 align='center'>欢迎你：<span style='color: red'>${sessionScope.get("username")}&nbsp;<a href="UserServlet?flag=loginOutUser">退出</a></span></h2>
<h2 align='center'>当前登录的用户有：</h2>
<c:forEach var="user" items="${applicationScope.get('online')}">
<h2 align='center'><span style='color: red'>${user}</span></h2>
</c:forEach>
</body>
</html>
