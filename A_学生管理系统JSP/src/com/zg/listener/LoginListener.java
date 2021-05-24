package com.zg.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;

/**
 * @author 隔壁老王
 */
@WebListener
public class LoginListener implements ServletContextListener, HttpSessionAttributeListener, HttpSessionListener {
    ServletContext sc = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //在服务器启动时在ServletContext中放入一个空的集合
        sc = sce.getServletContext();
        sc.setAttribute("online", new ArrayList<String>());
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        //获取ServletContext中的集合
        ArrayList<String> online = (ArrayList<String>) sc.getAttribute("online");
        //判断向session中放的数据是否为username,如果是放入集合
        if ("username".equals(se.getName())) {
            //同一个浏览器未退出直接进登录页重新登陆，会产生一个新的session
            // 判断集合中是否已经包含该用户名，如果不包含获取用户名放入session中的值
            if (!online.add((String) se.getValue())) {
                online.add((String) se.getValue());
            }
        }
        //将集合放回ServletContext
        sc.setAttribute("online", online);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("替换进来了");
        //获取ServletContext中的集合
        ArrayList<String> online = (ArrayList<String>) sc.getAttribute("online");
        //判断向session中放的数据是否为username,如果是放入集合
        if ("username".equals(se.getName())) {
            //同一个浏览器更换用户登录，会产生一个新的session,判断集合中是否已经包含该用户名，获取放入session中的值
            if (!online.contains((String) se.getSession().getAttribute("username"))) {
                online.add((String) se.getSession().getAttribute("username"));
            }
        }
        //将集合放回ServletContext
        sc.setAttribute("online", online);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("销毁进来了");
        //获取ServletContext中的集合
        ArrayList<String> online = (ArrayList<String>) sc.getAttribute("online");
        //获取当前登录账户
        String username = (String) se.getSession().getAttribute("username");
        //从集合中移除当前用户
        online.remove(username);
        //将集合放回ServletContext
        sc.setAttribute("online", online);
    }
}
