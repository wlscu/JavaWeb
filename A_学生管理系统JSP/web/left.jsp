
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <li>学生信息管理
        <ol>
            <li><a href="stu_add.jsp" target="right">学生信息注册</a></li>
            <li><a href="stu_updatepage.jsp" target="right">学号-查·改·删</a></li>
            <li><a href="StudentServlet?flag=deleteUpdateStusByPage&page=1" target="right">姓名-查·改·删</a></li>
        </ol>
    </li>
</ul>
</body>
</html>
