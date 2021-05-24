<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table {
            width: 500px;
            height: 300px;
            border: 2px black solid;
            text-align: center;
            margin: auto;
            background: springgreen;
        }
    </style>
</head>
<body>
<form action="StudentServlet" method="get">
    <input type="hidden" name="flag" value="getUpdateStu">
    <table border="2">
        <tr>
            <td colspan="2"><h2>请输入要查询·修改·删除的学生学号</h2></td>
        </tr>
        <tr>
            <td align="right"> 学生学号：</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交">&nbsp&nbsp&nbsp&nbsp<input type="reset"></td>
        </tr>
    </table>
</form>
</body>
</html>
