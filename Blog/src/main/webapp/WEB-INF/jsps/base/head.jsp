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
                <li><a href="/" class="dh"><i class="icon-home icon-white"></i>&nbsp;本站</a></li>
                <li class="dropdown">
                        <a class="dropdown-toggle dh" id="dLabel" role="button" data-toggle="dropdown" data-target="#" href="/page.html"><i class="icon-list icon-white"></i>&nbsp;类别</a>
                        <ul class="dropdown-menu dropdown-menu-right" role="menu"  aria-labelledby="dLabel">
                            <li class="dropdown-submenu dropdown-menu-right">
                                <a tabindex="-1" href="#">Action</a>
                                <ul class="dropdown-menu">
                                    <li><a tabindex="-1" href="#">Another action</a></li>
                                    <li><a tabindex="-1" href="#">Something else here</a></li>
                                </ul>
                            </li>
                            <li role="presentation" class="divider"></li>
                            <li><a tabindex="-1" href="#">Another action</a></li>
                            <li role="presentation" class="divider"></li>
                            <li><a tabindex="-1" href="#">Something else here</a></li>
                            <li class="divider"></li>
                            <li><a tabindex="-1" href="#">Separated link</a></li>
                        </ul>
                </li>
                <li><a href="#" class="dh userLogin">您还未登陆！</a></li>
                <li><a href="#" class="dh edit">欢迎，${sessionScope.loginUsername}</a></li>
                <li><a data-toggle="modal" href="#" id="register" class="dh userLogin"><i class="icon-road icon-white"></i>&nbsp;注册</a></li>
                <li><a data-toggle="modal" href="#" id="login" class="dh userLogin"><i class="icon-lock icon-white"></i>&nbsp;登录</a></li>
                <li><a data-toggle="modal" href="#" id="editUser" class="dh edit"><i class="icon-road icon-white"></i>&nbsp;编辑信息</a></li>
                <li><a data-toggle="modal" href="/user/userLogout" id="logout" class="dh edit"><i class="icon-lock icon-white"></i>&nbsp;登出</a></li>
            </ul>
            <div id="registerDiv"></div>
            <div id="loginDiv"></div>
            <div id="editDiv"></div>

        </div>
        <h1>Black apocalypse</h1>
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
            $('.dropdown-toggle').dropdown();
        });

        $(document).ready(function(){
            var loginUsername="<%=session.getAttribute("loginUsername")%>";
            if (loginUsername=='null'){
                $(".edit").hide();
            }
            else if (loginUsername!='null'){
                $(".userLogin").hide();
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
