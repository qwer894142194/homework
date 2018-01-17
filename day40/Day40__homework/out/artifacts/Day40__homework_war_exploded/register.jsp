<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: java-201707211014
  Date: 2018/1/16
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
        <form action="register.action" method="post">
                  账号:  <input type="text" name="user.username"><br><s:fielderror  fieldName="user.username" />
                  密码:  <input type="password" name="user.password"><br><s:fielderror fieldName="user.password"/>
              确认密码:  <input type="password" name="password1"><br><s:fielderror fieldName="surePassWord"/>
               电话号:   <input type="text" name="user.phoneNum"><br><s:fielderror fieldName="user.phoneNum"/>
                 邮箱:   <input type="text" name="user.email"><br><s:fielderror fieldName="user.email"/>
                 验证码: <input name="code" size="4"><img src="${pageContext.request.
contextPath}/codeImg.action">
                    <br>
                         <input type="submit" value="注册">
        </form>
</body>
</html>
