package com.lanou3g.web;

import com.lanou3g.dao.BookDao;
import com.lanou3g.dao.UserDao;
import com.lanou3g.bean.Book;
import com.lanou3g.bean.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserDao userDao = new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 指定允许其他域名访问
        response.addHeader("Access-Control-Allow-Origin", "*");
// 响应类型
        response.addHeader("Access-Control-Allow-Methods", "POST");
// 响应头设置
        response.addHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
        HttpSession session1 = request.getSession();
        session1.removeAttribute("username");
        session1.removeAttribute("password");
        User user = new User();

        try {
            BeanUtils.populate(user,request.getParameterMap());
            User u = userDao.queryByUsername(user.getUsername());
            Cookie cookie = new Cookie("user",user.getUsername());
            cookie.setMaxAge(60*60*60);
            cookie.setPath("/yun/login.jsp");

            response.addCookie(cookie);
            if (u !=null){
                if (user.getPassword().equals(u.getPassword())) {
                    HttpSession session = session1;
                    session.setAttribute("username", user.getUsername());
                    session.setAttribute("password", user.getPassword());
                    response.sendRedirect("http://localhost:8080/yun/index.jsp");
                    BookDao book = new BookDao();
                    List<Book> books = book.queryAll();

                    session.setAttribute("book", books);
                }
                else{
                    response.sendRedirect("http://localhost:8080/yun/login.html");
                }
           } else{
               response.sendRedirect("http://localhost:8080/yun/login.html");
           }


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
