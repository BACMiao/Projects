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
    <link href="${ctx}/resources/css/base.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/resources/css/head.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/resources/css/home.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/resources/css/main.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/resources/css/foot.css" rel="stylesheet" type="text/css"/>
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
    <div id="header">
        <div id="logo"><img src="${ctx}/resources/image/logo.png" title="logo"  height="100" width="250"  /></div>
        <div id="user">
            您还未登陆！|
            <a href="/user/register">注册</a>|
            <a href="/user/login">登录</a>|
            <a href="/user/editUser?uid=2">编辑信息</a>
        </div>
    </div>

    <div id="home">
        陈淼的博客(欢迎大家收藏此博客)
        <div id="change">
            <ul>
            <li><a href="#">博文</a></li>
            <li><a href="#">收藏</a></li>
            <li><a href="#">留言</a></li>
            <li><a href="#">关于我</a></li>
            </ul>
        </div>
    </div>

    <div id="main">
        <div id="left">

        </div>
        <div id="right">
            文章列表：
            <hr/>
            <c:forEach var="article" items="${articles}" >
                <a href="/article/viewArticle?id=${article.id} " id="a1" style="text-decoration: none;">[${article.categoryName}]&nbsp;&nbsp;${article.title}</a>&nbsp;&nbsp;${article.createTime}
                <br>
            </c:forEach>
        </div>
    </div>
    <div id="footer">
        <hr/>
        <p>声明：本博客所有文章版权属于<a href="/admin/login" style="text-decoration: none;color: black">作者</a>。没有作者许可不得转载，若作者同意转载，必须以超链接形式标明文章原始出处和作者。</p>
    </div>

</body>
</html>
