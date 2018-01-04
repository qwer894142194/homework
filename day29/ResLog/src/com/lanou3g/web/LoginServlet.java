package com.lanou3g.web;

import com.lanou3g.dao.BookDao;
import com.lanou3g.dao.UserDao;
import com.lanou3g.main.Book;
import com.lanou3g.main.User;
import net.sf.json.JSONArray;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
          //  System.out.println(user.getUsername() + user.getPassword());
           if (user.getUsername().length()>5 &&user.getPassword().length() > 5){

               HttpSession session = request.getSession();
                session.setAttribute("username",user.getUsername());
               session.setAttribute("password",user.getPassword());
                response.sendRedirect("http://localhost:8080/index.jsp");
               BookDao book = new BookDao();
               List<Book> books = book.queryAll();
               System.out.println(books.toString());
               session.setAttribute("book",books);
           } else{

               response.sendRedirect("http://localhost:8080/index.html");
           }


         /*  if (u.getUsername().equals(user.getUsername())){
                if (u.getPassword().equals(user.getPassword())){
                    response.setStatus(302);
                    response.setHeader("location","http://localhost:8080/index.jsp");
                }else{
                    response.setStatus(302);
                    response.setHeader("location","http://localhost:8080/index.html");
                }
            }else {
                    response.setStatus(302);
                    response.setHeader("location","http://localhost:8080/index.html");
            }*/

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }






/*

            boolean b =  user.queryAll1(username,password);

            if (b==true){
                    response.setStatus(302);
                    response.setHeader("location","http://localhost:8080/Day29/h1.html");
            }else {
                response.setStatus(302);
                response.setHeader("location","http://localhost:8080/Day29/Res.html");
            }
*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
