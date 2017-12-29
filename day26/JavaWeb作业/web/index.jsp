<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2017/12/28
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>用户注册</title>
    <script type="text/javascript" src="jquery-3.2.1.min.js"></script>
  </head>
  <body>
  <form action="user" method="post">
    <label for="user">用户名</label>
    <input id="user" type="text" name="username"><br>
    <label for="passd">密码</label>
    <input id="passd" type="password" name="password">
    <br>
    <button type="submit">提交</button>
  </form>
  <br>
  <button id="btn">点击获取用户信息</button>
  <table border="1">

  </table>
  </body>
<script type="text/javascript">
$('#btn').click(function () {
    $.getJSON({url:"http://localhost:8080/u",datatype:"jsonp",type:"post",jsonpCallback:"jsonpCallback"},function (data, studes) {
      var json = $.parseJSON(data);
      if(json!=null){
        $('table').append($('<tr>').append($('<th>').text('ID'))
            .append($('<th>').text('用户名'))
            .append($('<th>').text('密码'))
        );
        $.each(json,function (index,obj) {
            console.log(index);
            console.log(obj);
        })

      }


    })
})


</script>
</html>
