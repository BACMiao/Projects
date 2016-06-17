<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2016/6/13
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <link href="${ctx}/resources/css/head.css" rel="stylesheet" type="text/css"/>
    <title>head</title>
</head>
<body>
<div id="header">
    <div id="logo"><img src="${ctx}/resources/image/logo.png" title="logo"  height="100" width="250" /></div>
    <div id="user">
        您还未登陆！|
        <a href="/user/register" id="register">注册</a>|
        <a href="/user/login" id="login">登录</a>|
        <a href="/user/editUser?uid=2" id="editUser">编辑信息</a>
    </div>
</div>
</body>
</html>
