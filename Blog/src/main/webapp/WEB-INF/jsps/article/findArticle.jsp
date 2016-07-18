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
    <link href="${ctx}/resources/css/main.css" rel="stylesheet" type="text/css"/>
    <title>Title</title>
    <script type="text/javascript">
    </script>
</head>
<body>
    <jsp:include page="../base/head.jsp"/>
    <div id="main">
        <jsp:include page="../base/left.jsp"/>
        <div id="right">
            <br/>
            &nbsp;搜寻文章列表：
            <hr/>
            <c:forEach var="article" items="${articleCustoms}" >
                <a href="/article/viewArticle?id=${article.id} " id="a1" style="text-decoration: none;" class="article">[${article.categoryName}]&nbsp;${article.title}</a>
                <p class="describe">${article.articleDescribe}</p>
                <div class="bottom">${article.createTime}|浏览|评论|博客分类：${article.categoryName}</div>
                <hr style="border-top-style:dotted"/>
            </c:forEach>
        </div>
        <%--<jsp:include page="base/foot.jsp"/>--%>
    </div>

</body>
</html>
