package com.lanou3g.web;

import com.lanou3g.dao.UserDao;
import com.lanou3g.main.User;
import net.sf.json.JSONArray;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserDao user = new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 指定允许其他域名访问
        response.addHeader("Access-Control-Allow-Origin","*");
// 响应类型
        response.addHeader("Access-Control-Allow-Methods","POST");
// 响应头设置
        response.addHeader("Access-Control-Allow-Headers","x-requested-with,content-type");


        List<User> users;
        users =  user.queryAll();
        JSONArray jsonArray = JSONArray.fromObject(users);

        for (int i = 0; i < users.size() ; i++) {
            User user = users.get(i);
            if (user.equals(username) && user.equals(password)){
                    response.setStatus(302);
                    response.setHeader("location","http://localhost:8080/index.jsp");
            }else {
                response.setStatus(301);
                response.setHeader("location","http://localhost:8080/index.html");
            }
        }
        }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
