package com.zg.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 隔壁老王
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public static final String LOGIN_URI = "user_login.jsp";
    public static final String ADD_URI = "user_add.jsp";
    public static final String USER_SERVLET = "UserServlet";
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String uri = request.getRequestURI();
        System.out.println(uri);
        String source = uri.substring(uri.lastIndexOf("/")+1);
        if ("/".equals(uri) || LOGIN_URI.equals(source) || ADD_URI.equals(source) || USER_SERVLET.equals(source)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            if (username != null){
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                PrintWriter out = servletResponse.getWriter();
                out.print("<h2 style='text-align: center;color:red'>账号未登录，2秒后转至登录界面！</h2>");
                response.setHeader("refresh", "2;url=user_login.jsp");
            }
        }
    }
}
