<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>学生信息修改</title>
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
    <script type="text/javascript" src="js/jquery-3.6.0.js"></script>
    <script type="text/javascript">
        $(function (){
            $("#btn").click(function(){
                if(confirm("您真的要删除吗？")){
                    window.location.href = "StudentServlet?flag=deleteStuById&id="+${stu.sid};
                }
            })
        });
    </script>
</head>
<body>
<form action="StudentServlet" method="post" enctype="multipart/form-data">
    <input type="hidden" name="flag" value="updateStu">
    <table border="2">
        <tr>
            <td colspan="2"><h2>查询·修改·删除</h2></td>
        </tr>
        <tr>
            <td align="right"> 学生学号：</td>
            <td><input type="text" name="id" readonly value='${stu.sid}'></td>
        </tr>
        <tr>
            <td align="right"> 学生姓名：</td>
            <td><input type="text" name="name" value='${stu.sname}'></td>
        </tr>
        <tr>
            <td align="right"> 学生密码：</td>
            <td><input type="password" name="password" value='${stu.spassword}'></td>
        </tr>
        <tr>
            <td align="right"> 学生年龄：</td>
            <td><input type="number" name="age" value='${stu.sage}'></td>
        </tr>
        <tr>
            <td align="right"> 用户性别：</td>
            <td><input type="radio" name="sex" value="男" ${stu.ssex eq '男'?'checked':''}>男
                <input type="radio" name="sex" value="女" ${stu.ssex eq '女'?'checked':''}>女</td>
        </tr>
        <tr>
            <td align="right"> 邮箱：</td>
            <td><input type="email" name="email" value='${stu.semail}'></td>
        </tr>
        <tr>
            <td align="right"> 头像：</td>
            <td><input type="file" name="photo">
                <img src="http://localhost:8080/Stu_System/Stu_Photo/${stu.sphoto}" width="80" align="absmiddle">
                <input type="hidden" name="oldPhoto" value="${stu.sphoto}">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交修改">&nbsp&nbsp&nbsp&nbsp
                <input type="button" value="删除" id="btn">
        </tr>
    </table>
</form>
</body>
</html>
