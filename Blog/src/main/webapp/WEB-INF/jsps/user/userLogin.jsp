<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2016/6/2
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="/user/exist" method="post">
    <caption>用户登陆</caption>
    <table width="25%" border="1">
        <tr>
            <td>用户名</td>
            <td><input name="username" type="text" /></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input name="password" type="password" /></td>
        </tr>
    </table>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
