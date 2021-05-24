<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生管理系统---注册</title>
    <style type="text/css">
        table {
            width: 500px;
            height: 300px;
            border: 2px black solid;
            text-align: center;
            margin: auto;
            background: bisque;
        }
    </style>
</head>
<body>
<form action="UserServlet" method="post" enctype="multipart/form-data">
    <input type="hidden" name="flag" value="addUser">
    <table border="2">
        <tr>
            <td colspan="2"><h1>学生管理系统---注册</h1></td>
        </tr>
        <tr>
            <td align="right"> 用户姓名：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td align="right"> 用户密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td align="right"> 用户性别：</td>
            <td><input type="radio" name="sex" value="男">男<input type="radio" name="sex" value="女">女</td>
        </tr>
        <tr>
            <td align="right"> 邮箱：</td>
            <td><input type="email" name="email"></td>
        </tr>
        <tr>
            <td align="right"> 头像：</td>
            <td><input type="file" name="photo"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="用户注册">&nbsp&nbsp&nbsp&nbsp<input type="reset"></td>
        </tr>
        <tr>
            <td colspan="2"><a href="user_login.jsp">&nbsp&nbsp已有账号？点击立即登录&nbsp&nbsp</a></td>
        </tr>
    </table>
</form>
</body>
</html>
