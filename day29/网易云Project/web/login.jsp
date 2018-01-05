<%--
  Created by IntelliJ IDEA.
  User: java-201707211014
  Date: 2018/1/4
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<style type="text/css">
    *{
        padding: 0;
        margin: 0;
        font-family:宋体;
    }
    a{
        text-decoration: none;
    }
    body{
        background-color: #F4F8FB
    }
    header{
        height: 82px;
        line-height: 82px;
        background-color: white;
    }
    .DV{
        float: right;
        padding-right: 40px;
    }
    .DV a{
        color: rgb(124,149,202);
        font-weight: bold;
    }
    .SON{
        padding: 0  10px;
        color: rgb(234,234,234);
    }
    #NB{
        position: absolute;
        top:300px;
        left:200px;
    }
    form{
        width: 510px;
        height: 600px;
        background-color: white;
        position: absolute;
        top:210px;
        right: 210px;
    }
    form h2{
        height: 110px;
        line-height: 110px;
        text-align: center;
    }
    .T1{
        margin: 0 50px 25px;
        width: 400px;
        height: 50px;
        line-height: 50px;
        font-size: 18px;
        text-indent: 50px
    }
    .T2{
        padding:60px 50px 0;
        width:400px;
        line-height: 12px;

    }
    .T2 input{
        vertical-align: middle;
    }
    #B{
        color: rgb(124,149,202);
    }
    .T2 span{
        font-size: 12px;
    }
    .M{
        float: right;
    }
    .TBQ{
        margin: 20px 50px  10px;
        width: 400px;
        background-color: #3C81E6;
        text-align: center;
        line-height: 60px;
        height: 60px;
        color: white;
        font-size: 18px;

    }
    .UZI{
        padding: 0 50px;
        font-size:12px;
    }
    .UZI a{
        color: rgb(124,149,202);
    }
    .faker{
        float: right;
        text-indent: 20px;
    }
</style>

</head>
<body>
<header>
    <div id="time1"></div>
    <img src="img/1.png">
    <div class="DV">
        <span><a href="#">网易云首页</a></span>
        <span class="SON">|</span>
        <span><a href="#">帮助与文档</a></span>
    </div>
</header>
<img src="img/2.jpg" id="NB">
<form action="login" method="post">
    <h2>网易云登录</h2>
    <%
        session.removeAttribute("username");
        session.removeAttribute("password");
    %>
    <input type="text" name="username" placeholder="网易云帐号/网易邮箱帐号"
           class="T1" onfocus="inputOnfocus(this)" onblur="inputOnblur()"
            <%
                Cookie[] cookies = request.getCookies();
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("user")){
            %>
           value= "<% out.write(cookie.getValue()); %> "
    <%
                    }
    }

    %>
    >

    <input type="password" name="password" placeholder="登录密码"  class="T1">
    <div class="T2">
        <span><input type="checkbox" name="">同意并遵守<a href="#" id="B">《服务条款》</a></span>
        <span class="M"><input type="checkbox" name="">15天免登录</span>
    </div>
    <input type="submit" name="" value="登录" class="TBQ">
    <div class="UZI"><span>还没有帐号  <a href="Res.html">免费注册</a></span><span class="faker"><a href="#">忘记密码?</a></span></div>
</form>

</body>
<script type="text/javascript">
    document.write(Date().toLocaleString());

    function inputOnfocus(ele) {

        ele.style.borderColor="red";
        ele.style.fontSize="25px";

    }
    function inputOnblur(ele) {
        ele.style.borderColor="gray";
        ele.style.fontSize="18px";
    }
</script>
</body>
</html>
