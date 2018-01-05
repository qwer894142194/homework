<%--
  Created by IntelliJ IDEA.
  User: java-201707211014
  Date: 2018/1/4
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>book</title>
</head>
<body>
<%
    String bookName="";
    String bookWriter="";

    bookName =  session.getAttribute("bookName").toString();
    bookWriter=session.getAttribute("bookWriter").toString();
    out.write("这是" +bookName + "由"  +bookWriter + "写的" );
%>
</body>
</html>
