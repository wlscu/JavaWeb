<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生管理系统---登录</title>
    <style type="text/css">
        table {
            width: 500px;
            height: 300px;
            border: 2px black solid;
            text-align: center;
            margin: auto;
            background: aqua;
        }
    </style>
    <script>
        window.onload = function (){
            if (window.top !== window.self){
                window.top.location = window.self.location;
            }
        }
    </script>
</head>
<body>
<%
    //获取Cookie
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("username".equals(cookie.getName())) {
                pageContext.setAttribute("username", cookie.getValue());
            }
            if ("password".equals(cookie.getName())) {
                pageContext.setAttribute("password", cookie.getValue());
            }
        }
    }
%>
<form action="UserServlet" method="post">
    <input type="hidden" name="flag" value="loginUser">
    <table border="2">
        <tr>
            <td colspan="2"><h1>学生管理系统---登录</h1></td>
        </tr>
        <tr>
            <td align="right"> 用户姓名：</td>
            <td><input type="text" name="username" value="${username}"></td>
        </tr>
        <tr>
            <td align="right"> 用户密码：</td>
            <td><input type="password" name="password" value="${password}"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="checkbox" name="remember" value="ok" ${empty username?'':'checked'}>记住密码</td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="用户登录">&nbsp&nbsp&nbsp&nbsp<input type="reset"></td>
        </tr>
        <tr>
            <td colspan="2"><a href="user_add.jsp">&nbsp&nbsp没有账号？点击立即注册&nbsp&nbsp</a></td>
        </tr>
    </table>
</form>
</body>
</html>
