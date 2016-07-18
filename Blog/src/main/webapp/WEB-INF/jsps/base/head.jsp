<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2016/6/13
  Time: 14:36
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <title>head</title>
    <link href="${ctx}/resources/css/head.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div id="header">
        <div id="user">
            <ul>
                <li><a href="#" class="dh"><i class="icon-home icon-white"></i>&nbsp;本站</a></li>
                <li><a href="#" class="dh"><i class="icon-list icon-white"></i>&nbsp;类别</a></li>
                <li><a href="#" class="dh">您还未登陆！</a></li>
                <li><a data-toggle="modal" href="#" id="register" class="dh"><i class="icon-road icon-white"></i>&nbsp;注册</a></li>
                <li><a data-toggle="modal" href="#" id="login" class="dh"><i class="icon-lock icon-white"></i>&nbsp;登录</a></li>
            </ul>
            <%--<div id="userLogin">您还未登陆！|--%>
                <%--<a data-toggle="modal" href="#" >注册</a>|--%>
                <%--<a data-toggle="modal" href="#" >登录</a>--%>
            <%--</div>--%>
            <%--<div id="edit">--%>
                <%--欢迎您，${sessionScope.loginUsername}&nbsp;--%>
                <%--<a data-toggle="modal" href="#" id="editUser">编辑信息</a>--%>
                <%--<a href="/user/userLogout">安全退出</a>--%>
            <%--</div>--%>
            <div id="registerDiv"></div>
            <div id="loginDiv"></div>
            <div id="editDiv"></div>
        </div>
    </div>


    <script src="${ctx}/resources/js/jquery-1.12.1.min.js"></script>
    <script src="${ctx}/resources/js/bootstrap.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#register").click(function(){
                $('#registerDiv').load('/user/register');
            });
            $("#login").click(function(){
                $('#loginDiv').load('/user/login');
            });
        });

        $(document).ready(function(){
            var loginUsername="<%=session.getAttribute("loginUsername")%>";
            if (loginUsername=='null'){
                $("#edit").hide();
            }
            else if (loginUsername!='null'){
                $("#userLogin").hide();
            }
        });

        $(function(){
            $("#editUser").click(function(){
                $('#editDiv').load('/user/editUser?username=${sessionScope.loginUsername}');
            });
        });
    </script>
</body>
</html>
