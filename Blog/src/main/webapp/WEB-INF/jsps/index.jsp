<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2016/5/21
  Time: 12:34
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <script src="${ctx}/resources/js/jquery-1.12.1.min.js"></script>
    <title>Title</title>
    <script type="text/javascript">
        $(document).ready(function(){
            var $cr = $("#cr");
            $cr.click(function(){
                if ($cr.is(":checked")){
                    alert("谢谢");
                }
            })
        });
    </script>
</head>
<body>
    <a href="/user/register">注册</a>
    <a href="/user/login">登录</a>
    <a href="/user/editUser?uid=2">编辑信息</a>
    <a href="/admin/login">管理员登录</a>
    <a href="/category/add">添加类别</a>
    <a href="/article/add">添加文章</a>

<div>
    <c:forEach var="article" items="${articles}" >
        <a href="/article/viewArticle?id=${article.id} " style="text-decoration: none;">${article.categoryId}&nbsp;&nbsp;${article.title}&nbsp;&nbsp;${article.createTime}</a>
        <br>
    </c:forEach>
</div>
</body>
</html>
