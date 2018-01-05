<%@ page import="com.lanou3g.bean.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: java-201707211014
  Date: 2018/1/4
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    if(session.getAttribute("username") !=null){

  %>
  <h1>登录成功,账号信息如下</h1>
  <h1>账号:
    <%
      out.write(session.getAttribute("username").toString());
    %>
  </h1>
  <h1>密码:
    <%
      out.write(session.getAttribute("password").toString());

    %>
  </h1>
  <%

  }else
  {
  %>

  <%
    }
  %>
  <h1>书籍信息</h1>
  <table border="1px">
    <tr>
      <th>id</th>
      <th>书名</th>
      <th>书价</th>
      <th>书作者</th>
    </tr>

    <%
      Object book = session.getAttribute("book");
    %>

    <% List<Book> books = (List<Book>) book; %>
    <% for (Book book1 : books) {
    %>
    <tr>
      <td>
        <%
          out.write(book1.getId() + "");

        %>
      </td>
      <td>
        <a href="book.jsp">
          <%
            out.write(book1.getBookName());
            session.setAttribute("bookName",book1.getBookName());
          %>
        </a>
      </td>
      <td>
        <%
          out.write(book1.getBookPrice());
        %>
      </td>
      <td>
        <%
          out.write(book1.getBookWriter());
          session.setAttribute("bookWriter",book1.getBookWriter());
        %>
      </td>
    </tr>
    <%
      }
    %>





  </table>

  <h1><a href="login.jsp" style="text-decoration: none">退出页面


  </a></h1>



  </body>
</html>
