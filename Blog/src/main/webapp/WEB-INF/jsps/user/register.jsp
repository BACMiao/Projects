<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2016/6/1
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <title>注册</title>
    <script type="text/javascript" src="${ctx}/resources/js/Calendar3.js"></script>
    <script src="${ctx}/resources/js/jquery-1.12.1.min.js"></script>

    <script type="text/javascript">
        $(function(){
            $("#sub").bind("click", function(event){
                var username = $("#username").val();
                var password = $("#password").val();
                if (username==""){
                    $("#usernamemsg").html("<p style='color: red'>用户名不能为空</p>");
                    event.preventDefault();
                }

                if (password==""){
                    $("#passwordmsg").html("<p style='color: red'>密码不能为空</p>");
                    event.preventDefault();
                }
            });

            $("form :input.required").each(function(){
                var $required = $("<strong class='high' style='color: #FF0000'>*</strong>");
                $(this).parent().append($required);
            });
        });
    </script>
</head>
<body>
<form action="/user/saveUser" method="post">
    <table width="18%" border="1">
        <caption>用户注册</caption>
        <tr>
            <td>用户名</td>
            <td><input name="username" type="text" id="username" class="required"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input name="password" type="password" id="password" class="required"/></td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><input name="email" type="text" id="email" class="required"/></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input name="sex" type="text" /></td>
        </tr>

        <tr>
            <td>生日</td>
            <td><input name="birthday" type="text" onclick="new
            Calendar().show(this);" readonly="readonly"/></td>
        </tr>
    </table>
    <input type="submit" value="注册" id="sub"/>
</form>
</body>
</html>
