package com.zg.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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

    protected void queryStudentByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String queryName = request.getParameter("queryName");
        System.out.println(queryName);
        List<Students> list = ss.queryStudentByName(queryName);
        System.out.println(list);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        PrintWriter out = response.getWriter();
        out.print(json);
    }
}