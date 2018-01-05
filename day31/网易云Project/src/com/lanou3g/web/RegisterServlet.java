package com.lanou3g.web;

import com.lanou3g.dao.UserDao;
import com.lanou3g.bean.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "RegisterServlet" ,urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private UserDao userDao = new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws          ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.length()>1 && password.length()>1) {
            response.setStatus(302);    
            response.setHeader("location","http://localhost:8080/yun/login.html");
        }else {
            response.setStatus(302);
            response.setHeader("location","http://localhost:8080/yun/register.html");
        }
        //直接把map中内容设置到对象上
        User user = new User();
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            BeanUtils.populate(user, parameterMap);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        userDao.insertUser(user);
        System.out.println("SUCCESS");

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
