<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2016/5/21
  Time: 12:34
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <link href="${ctx}/resources/css/base.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/resources/css/main.css" rel="stylesheet" type="text/css"/>
    <title>BApocalypse</title>
</head>
<body>
    <jsp:include page="base/head.jsp"/>
    <jsp:include page="base/home.jsp"/>
    <div id="main">
        <jsp:include page="base/left.jsp"/>
        <div id="right">
            <br/>
            &nbsp;文章列表：
            <hr/>
            <c:forEach var="article" items="${articles}" >
                <a href="/article/viewArticle?id=${article.id} " id="a1" style="text-decoration: none;" class="article">[${article.categoryName}]&nbsp;${article.title}</a>
                <p class="describe">${article.articleDescribe}</p>
                <div class="bottom"><fmt:formatDate value="${article.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>|评论|博客分类：${article.categoryName}</div>
                <hr style="border-top-style:dotted"/>
            </c:forEach>
        </div>
        <jsp:include page="base/foot.jsp"/>
    </div>

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
