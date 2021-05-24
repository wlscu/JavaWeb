<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息注册</title>
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
<form action="StudentServlet" method="post" enctype="multipart/form-data">
    <input type="hidden" name="flag" value="addStu">
    <table>
        <tr>
            <td colspan="2"><h2>学生信息注册</h2></td>
        </tr>
        <tr>
            <td align="right"> 学生姓名：</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td align="right"> 学生密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td align="right"> 学生年龄：</td>
            <td><input type="number" name="age"></td>
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
            <td colspan="2"><input type="submit" value="学生注册">&nbsp&nbsp&nbsp&nbsp<input type="reset"></td>
        </tr>
    </table>
</form>
</body>
</html>
