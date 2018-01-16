<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>left</title>
	  <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	  <base target="body"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		*{
			font-size:10pt;
			text-align: center;
		}
		div {
			background: #87CEFA; 
			margin: 3px; 
			padding: 3px;
		}
		a {
			text-decoration: none;
		}
	</style>
  </head>
  
  <body>
<div id="div">
	<a href="<c:url value='/jsps/book/list.jsp?cid=0'/>">全部分类</a>
		<%--<a href="<c:url value='/book?method=findAll'/>">全部分类</a>--%>
</div>
<c:forEach var="categorie" items="${sessionScope.categories}">
	<script type="text/javascript">

        $('#div').after($('<div>').html("<a href=\"<c:url value='/jsps/book/list.jsp?cid=${categorie.cid}'/>\">${categorie.cname}</a>"))
	</script>
</c:forEach>

<%--<div>--%>
	<%--<a href="<c:url value='/jsps/book/list.jsp?cid=1'/>">JavaSE分类</a>--%>
	<%--&lt;%&ndash;<a href="<c:url value='/book?method=category&category=1'/>">JavaSE分类</a>&ndash;%&gt;--%>
<%--</div>--%>
<%--<div>--%>
	<%--<a href="<c:url value='/jsps/book/list.jsp?cid=2'/>">JavaEE分类</a>--%>
<%--</div>--%>
<%--<div>--%>
	<%--<a href="<c:url value='/jsps/book/list.jsp?cid=3'/>">Javascript分类</a>--%>
<%--</div>--%>
  </body>
</html>
