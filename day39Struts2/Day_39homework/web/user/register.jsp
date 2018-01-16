<%--
  Created by IntelliJ IDEA.
  User: java-201707211014
  Date: 2018/1/15
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>

        <form action="register.action" method="post">
                <input type="hidden" name="method" value="register">
                  账号:  <input type="text" name="username"><br>
                  密码:   <input type="password" name="password"><br>
                    <input type="submit" value="提交">
        </form>
        <a href="login.jsp">去登录界面</a>
</body>
</html>
