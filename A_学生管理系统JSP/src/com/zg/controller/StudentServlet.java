package com.zg.controller;

import com.zg.entity.Students;
import com.zg.service.impl.StudentServiceImpl;
import com.zg.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

/**
 * @author 隔壁老王
 */

@MultipartConfig
@WebServlet("/StudentServlet")
public class StudentServlet extends BaseServlet {
    StudentServiceImpl ss = new StudentServiceImpl();

    protected void addStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String agestr = request.getParameter("age");
        Integer age = Integer.valueOf(agestr);
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");
        //文件上传,获取上传的文件对象，文件存储到D://upload文件夹中，文件路径保存到数据库的photo列中
        Part part = request.getPart("photo");
        String filename = part.getSubmittedFileName();
        String path = "D:\\Stu_System\\Stu_Photo";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String photo = UUID.randomUUID() + filename;
        System.out.println(photo);
        part.write(path + "\\" + photo);
        //数据库存储
        Students stu = new Students(null, name, password, age, sex, email, photo);
        boolean res = ss.addStu(stu);
        PrintWriter out = response.getWriter();
        if (res) {
            out.print("<h2 style='text-align: center;color:red'>学生注册成功！</h2>");
        } else {
            out.print("<h2 style='text-align: center;color:red'>学生注册失败,2秒后返回注册界面。</h2>");
        }
        response.setHeader("refresh", "2;url=stu_add.jsp");
    }

    protected void getUpdateStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sidstr = request.getParameter("id");
        Integer sid = Integer.valueOf(sidstr);
        Students stu = ss.getUpdateStu(sid);
        PrintWriter out = response.getWriter();
        if (stu != null) {
            request.setAttribute("stu", stu);
            request.getRequestDispatcher("stu_update.jsp").forward(request, response);
        } else {
            out.print("<h2 style='text-align: center;color:red'>无此学生，请核对后再次输入！</h2>");
            response.setHeader("refresh", "2;url=stu_updatepage.jsp");
        }
    }

    protected void updateStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String agestr = request.getParameter("age");
        Integer age = Integer.valueOf(agestr);
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");
        //文件上传,获取上传的文件对象，文件存储到D:\Stu_System\Stu_Photo文件夹中，文件路径保存到数据库的photo列中
        Part part = request.getPart("photo");
        String photo = "";
        String filename = part.getSubmittedFileName();
        //判断是否选择照片，没选择则沿用原路径，选择了则写入新照片
        if ("".equals(filename)) {
            photo = request.getParameter("oldPhoto");
        } else {
            photo = UUID.randomUUID() + filename;
            String path = "D:\\Stu_System\\Stu_Photo";
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            part.write(path + "\\" + photo);
        }
        String idstr = request.getParameter("id");
        Integer id = Integer.valueOf(idstr);
        Students stu = new Students(id, name, password, age, sex, email, photo);
        PrintWriter out = response.getWriter();
        boolean res = ss.updateStu(stu);
        if (res) {
            out.print("<h2 style='text-align: center;color:red'>学生修改成功！</h2>");
        } else {
            out.print("<h2 style='text-align: center;color:red'>学生修改失败！</h2>");
        }
        response.setHeader("refresh", "2;url=stu_updatepage.jsp");
    }

    protected void deleteStuByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sidstr = request.getParameter("id");
        String page = request.getParameter("page");
        Integer sid = Integer.valueOf(sidstr);
        boolean res = ss.deleteStuByName(sid);
        PrintWriter out = response.getWriter();
        if (res) {
            out.print("<h2 style='text-align: center;color:red'>学生删除成功！</h2>");
        } else {
            out.print("<h2 style='text-align: center;color:red'>学生删除失败！</h2>");
        }
        response.setHeader("refresh", "1;url=StudentServlet?flag=deleteUpdateStusByPage&page="+page);
    }

    protected void deleteStuById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sidstr = request.getParameter("id");
        Integer sid = Integer.valueOf(sidstr);
        boolean res = ss.deleteStuById(sid);
        PrintWriter out = response.getWriter();
        if (res) {
            out.print("<h2 style='text-align: center;color:red'>学生删除成功！</h2>");
        } else {
            out.print("<h2 style='text-align: center;color:red'>学生删除失败！</h2>");
        }
        response.setHeader("refresh", "2;url=stu_updatepage.jsp");
    }


    protected void deleteUpdateStusByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        int countRows = ss.getCountRows();
        PageUtil pu = new PageUtil(page, countRows);
        List<Students> list = ss.deleteUpdateStusByPage(pu);
        request.setAttribute("sList", list);
        request.setAttribute("pu", pu);
        request.getRequestDispatcher("stu_delete.jsp").forward(request, response);
    }

    protected void deleteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sids = request.getParameter("sids");
        String page = request.getParameter("page");
        boolean res = ss.deleteAll(sids);
        PrintWriter out = response.getWriter();
        if (res) {
            out.print("<h2 style='text-align: center;color:red'>学生批量删除成功！</h2>");
        } else {
            out.print("<h2 style='text-align: center;color:red'>批量删除失败，请稍后重试！</h2>");
        }
        response.setHeader("refresh", "1;url=StudentServlet?flag=deleteUpdateStusByPage&page="+page);
    }

    protected void queryStudentByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String queryName = request.getParameter("queryName");
        String page = request.getParameter("page");
        int countRows = ss.getCountRowsBySname(queryName);
        PageUtil pu = new PageUtil(page, countRows);
        List<Students> list = ss.queryStudentByName(queryName, pu);
        request.setAttribute("sList", list);
        request.setAttribute("pu", pu);
        request.setAttribute("queryName", queryName);
        request.getRequestDispatcher("stu_delete.jsp").forward(request, response);
    }
}