package com.zg.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 隔壁老王
 */

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String flag = req.getParameter("flag");
        //获取当前类的字节码对象
        Class c = this.getClass();
        try {
            //根据flag值找到对应方法
            Method m = c.getDeclaredMethod(flag,HttpServletRequest.class,HttpServletResponse.class);
            //打破修饰符限制
            m.setAccessible(true);
            //执行该方法
            m.invoke(this,req,resp);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
