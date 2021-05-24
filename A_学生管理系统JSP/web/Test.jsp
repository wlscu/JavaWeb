<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/21
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int a =5;
    application.setAttribute("a","789");
    session.setAttribute("a","456");
    request.setAttribute("a","123");
    application.removeAttribute("a");
%>
<c:out value="${a}"></c:out>


</body>
</html>
