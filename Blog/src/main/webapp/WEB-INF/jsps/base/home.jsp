<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2016/6/13
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <link href="${ctx}/resources/css/home.css" rel="stylesheet" type="text/css"/>
    <title>home</title>
</head>
<body>
<div id="home">
    陈淼的博欢迎大家收藏此博客)
    <div id="change">
        <ul>
            <li><a href="#" class="dh">博文</a></li>
            <li><a href="#" class="dh">收藏</a></li>
            <li><a href="#" class="dh">留言</a></li>
            <li><a href="#" class="dh">关于我</a></li>
        </ul>
    </div>
</div>
</body>
</html>
