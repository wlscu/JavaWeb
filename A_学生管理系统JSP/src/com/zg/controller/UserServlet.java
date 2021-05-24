package com.zg.controller;

import com.zg.entity.Users;
import com.zg.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * @author 隔壁老王
 */

@MultipartConfig
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
    public static final String OK = "ok";
    UserServiceImpl us = new UserServiceImpl();

    protected void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");
        PrintWriter out = response.getWriter();
        //文件上传,获取上传的文件对象，文件存储到D://upload文件夹中，文件路径保存到数据库的photo列中
        Part part = request.getPart("photo");
        String filename = part.getSubmittedFileName();
        String path = "D:\\Stu_System\\User_Photo\\";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String photo = UUID.randomUUID() + filename;
        part.write(path + "\\" + photo);
        //数据库存储
        Users user = new Users(null, username, password, sex, email, photo);
        boolean res = us.addUser(user);
        if (res) {
            out.print("<h1 style='text-align: center;color:red'>注册成功,2秒后返回登录界面。</h1>");
            response.setHeader("refresh", "2;url=user_login.jsp");
        } else {
            out.print("<h1 style='text-align: center;color:red'>注册失败,2秒后返回注册界面。</h1>");
            response.setHeader("refresh", "2;url=user_add.jsp");
        }
    }

    protected void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        boolean res = us.loginUser(username, password);
        if (!res) {
            out.print("<h1 style='text-align: center;color:red'>账号密码错误，请重新登录！</h1>");
            response.setHeader("refresh", "2;url=user_login.jsp");
        } else {
            //登录成功，获取记住密码复选框的值,存储帐号cookie
            String remember = request.getParameter("remember");
            if (OK.equals(remember)) {
                //记住密码
                Cookie nameCookie = new Cookie("username", username);
                Cookie pwdCookie = new Cookie("password", password);
                // 设置时效
                nameCookie.setMaxAge(60 * 60 * 24 * 30);
                pwdCookie.setMaxAge(60 * 60 * 24 * 30);
                //发送回客户端
                response.addCookie(nameCookie);
                response.addCookie(pwdCookie);
            } else {
                //如果记住密码状态为未选中，通过Cookie的覆盖特性，将Cookie的帐号密码覆盖清除
                Cookie nameCookie = new Cookie("username", null);
                Cookie pwdCookie = new Cookie("password", null);
                nameCookie.setMaxAge(0);
                pwdCookie.setMaxAge(0);
                response.addCookie(nameCookie);
                response.addCookie(pwdCookie);
            }
            //获取session,传递用户名,用户欢迎页面显示用户名
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            //登录成功，进入首页面
            out.print("<h1 style='text-align: center;color:red'>登录成功！</h1>");
            response.setHeader("refresh", "1;url=index.jsp");
        }
    }

    protected void loginOutUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("user_login.jsp");
    }
}
