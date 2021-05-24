<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>查询学生</title>
    <style type="text/css">
        div {
            width: 500px;
            text-align: center;
            margin: auto;
        }
    </style>
    <script type="text/javascript" src="js/jquery-3.6.0.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url: "StudentServlet?flag=queryStudentByName",
                    data: {"queryName":$("#queryName").val()},
                    type: "post",
                    async: true,
                    dataType: "json",
                    success: function (obj) {
                        $.each(obj, function (index, content) {
                            var snameDiv = "<div>" + "学号:" + content.sid + ",姓名：" + content.sname + ",年龄:" + content.sage + "</div>";
                            $("#show").append(snameDiv);
                        })
                    }
                });
            });
        });
    </script>
</head>
<body>
<div style="align-content: center">
    学生姓名：<input type="text" id="queryName">
    <input type="button" value="搜索" id="btn">
</div>
<div id="show">
</div>
</body>
</html>
