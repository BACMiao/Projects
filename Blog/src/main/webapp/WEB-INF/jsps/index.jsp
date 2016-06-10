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

    <style type="text/css">
        div{text-align:center;}
    </style>
</head>
<body>
    <div>
        <img src="${ctx}/resources/image/logo.png" title="logo"  height="100" width="200"  />
        <a href="#">主页</a>
        <a href="#">热门文章</a>
        <a href="/user/register">注册</a>
        <a href="/user/login">登录</a>
        <a href="/user/editUser?uid=2">编辑信息</a>
    </div>
    <div>
        <c:forEach var="article" items="${articles}" >
            <a href="/article/viewArticle?id=${article.id} " style="text-decoration: none;">${article.categoryId}&nbsp;&nbsp;${article.title}&nbsp;&nbsp;${article.createTime}</a>
            <br>
        </c:forEach>
    </div>
    <a href="/admin/login">管理员登录</a>
</body>
</html>
