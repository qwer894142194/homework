package com.lanou3g.work;

import com.mysql.jdbc.Driver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Server extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username+"  "+password);
        JDBCUtil.show(username,password);
        resp.getWriter().write("注册成功");
    }


}
