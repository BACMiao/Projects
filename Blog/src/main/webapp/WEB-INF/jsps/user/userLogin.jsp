<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2016/6/2
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <title>登录</title>
    <link href="${ctx}/resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<form action="/user/exist" class="form col-md-12 center-block" method="post">
        <div id="loginModal" class="modal show" style="width:auto;">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span></button>
                        <h1 class="text-center text-primary">登录</h1>
                    </div>
                    <div class="modal-body">
                            <div class="form-group">
                                <input type="text" class="form-control input-lg" name="username" style="height:40px; width: 360px; font-size: large" placeholder="用户名" >
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control input-lg" name="password" style="height:40px; width: 360px; font-size: large" placeholder="登录密码">
                            </div>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-primary btn-lg btn-block" style="height: 50px; width: 360px; font-size: large" type="submit">立刻登录</button>
                        <span><a href="#">找回密码</a></span>
                    </div>
                </div>
            </div>
        </div>
</form>

<script src="${ctx}/resources/js/jquery-1.12.1.min.js"></script>
<script src="${ctx}/resources/js/bootstrap.js"></script>
</body>
</html>
