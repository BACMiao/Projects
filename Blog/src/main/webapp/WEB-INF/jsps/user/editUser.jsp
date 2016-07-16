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
    <title>修改用户信息</title>
    <link href="${ctx}/resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<form action="/user/updateUser?username=${sessionScope.loginUsername}" method="post">
    <div id="editModal" class="modal show text-center">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span></button>
                    <h2 class="text-primary">修改信息</h2>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <input type="text" class="form-control input-lg" value="${user.username}" name="username" style="height:40px; width: 360px; font-size: large" placeholder="用户名" />
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control input-lg" value="${user.password}" name="password" style="height:40px; width: 360px; font-size: large" placeholder="密码"/>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control input-lg required" value="${user.email}" name="email" style="height:40px; width: 360px; font-size: large" placeholder="邮箱"/>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary btn-lg btn-block" style="width: 360px; height: 50px; font-size: large" type="submit">立刻登录</button>
                    <span><a href="#">找回密码</a></span>
                </div>
            </div>
        </div>
    </div>
    <%--<table width="25%" border="1">--%>
        <%--<tr>--%>
            <%--<td>用户名</td>--%>
            <%--<td><input name="username" type="text" value="${user.username}" /></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>密码</td>--%>
            <%--<td><input name="password" type="password" value="${user.password}" /></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>邮箱</td>--%>
            <%--<td><input name="email" type="text" value="${user.email}" /></td>--%>
        <%--</tr>--%>

    <%--</table>--%>
    <%--<input type="submit" value="修改"/>--%>
</form>
</body>
</html>
