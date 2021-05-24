<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>查询删除修改学生</title>
    <style type="text/css">
        td{
            text-align: center;
        }
        div {
            width: 500px;
            text-align: center;
            margin: auto;
        }
    </style>
    <script type="text/javascript" src="js/jquery-3.6.0.js"></script>
    <script type="text/javascript">
        function del(id,page){
            if (confirm("您真的要删除吗？")){
                window.location.href = "StudentServlet?flag=deleteStuByName&id="+id+"&page="+page;
            }
        }

        $(function (){
            //全选及反选
            $("#checkall").click(function (){
                var statu = $("#checkall").prop("checked");
                $(".checkone").prop("checked",statu);
            });

            //批量删除
            $("#btn").click(function(){
                //创建数组用于保存后面循环出来的数据
                var array = [];
                //获取选中的checkone的value属性的值
                $(".checkone:checked").each(function(index,content){
                    //获取当前循环的checkone的value属性值，用于后期判断和删除
                    var sid = $(content).val();
                    //将得到的sid放到数组中
                    array.push(sid);
                });
                if(array.length === 0){
                    alert("请选择您要删除的数据");
                }else{
                    if(confirm("您真的要删除吗？")){
                        //将array转换成字符串,join()将数组中的数据转换成用逗号隔开的字符串
                        var sids = array.join();
                        //发送批量删除的请求
                        window.location.href = "StudentServlet?flag=deleteAll&sids="+sids+"&page="+${pu.page};
                    }
                }
            });
        });
    </script>
</head>
<body>
<div style="align-content: center">
<form action="StudentServlet" method="post">
    <input type="hidden" name="flag" value="queryStudentByName">
    学生姓名：<input type="text" name="queryName" value="${queryName}">
    <input type="submit" value="搜索">
</form>
</div>
<table border='2' align='center' cellspacing="0" cellpadding="0">
    <tr>
        <th><input type="checkbox" id="checkall">全选</th>
        <th>学生学号</th>
        <th>学生姓名</th>
        <th>学生密码</th>
        <th>学生年龄</th>
        <th>学生性别</th>
        <th>学生邮箱</th>
        <th>学生头像</th>
        <th>删除操作</th>
    </tr>
<c:forEach var="stu" items="${sList}">
    <tr>
        <td><input type="checkbox" class="checkone" value="${stu.sid}"></td>
        <td>${stu.sid}</td>
        <td>${stu.sname}</td>
        <td>${stu.spassword}</td>
        <td>${stu.sage}</td>
        <td>${stu.ssex}</td>
        <td>${stu.semail}</td>
        <td><img src="http://localhost:8080/Stu_System/Stu_Photo/${stu.sphoto}" width="80" align="absmiddle"></td>
        <td>
            <a href="StudentServlet?flag=getUpdateStu&id=${stu.sid}">修改</a>
            <a href="javascript:del('${stu.sid}','${pu.page}')">删除</a>
        </td>
    </tr>
    </c:forEach>
</table>
    <div>
        <input type="button" value="批量删除" id="btn">
        <a href="StudentServlet?flag=deleteUpdateStusByPage&page=1">首页</a>
        <a href="StudentServlet?flag=deleteUpdateStusByPage&page=${pu.prevPage}">上一页</a>
        ${pu.page}/${pu.countPages}
        <a href="StudentServlet?flag=deleteUpdateStusByPage&page=${pu.nextPage}">下一页</a>
        <a href="StudentServlet?flag=deleteUpdateStusByPage&page=${pu.countPages}">尾页</a>
    </div>
</body>
</html>
