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
<form action="/user/exist" method="post">
        <div id="loginModal" class="modal show">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close">x</button>
                        <h1 class="text-center text-primary">登录</h1>
                    </div>
                    <div class="modal-body">
                        <form action="" class="form col-md-12 center-block">
                            <div class="form-group">
                                <input type="text" class="form-control input-lg" name="username" placeholder="用户名">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control input-lg" name="password" placeholder="登录密码">
                            </div>
                            <div class="form-group">
                                <button class="btn btn-primary btn-lg btn-block" type="submit">立刻登录</button>
                                <span><a href="#">找回密码</a></span>
                                <span><a href="#" class="pull-right">注册</a></span>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">

                    </div>
                </div>
            </div>
        </div>
</form>

<script src="${ctx}/resources/js/jquery-1.12.1.min.js"></script>
<script src="${ctx}/resources/js/bootstrap.js"></script>
<script>
    $(function(){
        $(".btn").click(function(){
            $("#mymodal").modal("toggle");
        });
    });
</script>
</body>
</html>
