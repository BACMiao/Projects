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
</head>
<body>
<form action="/user/updateUser?uid=2" method="post">
    <table width="25%" border="1">
        <tr>
            <td>用户名</td>
            <td><input name="username" type="text" value="${user.username}" /></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input name="password" type="password" value="${user.password}" /></td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><input name="email" type="text" value="${user.email}" /></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input name="sex" type="text" value="${user.sex}" /></td>
        </tr>

        <tr>
            <td>生日</td>
            <td><input name="birthday" type="text" value="<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>" /></td>
        </tr>

    </table>
    <input type="submit" value="修改"/>
</form>
</body>
</html>
