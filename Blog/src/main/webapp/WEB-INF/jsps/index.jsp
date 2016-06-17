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
//        $(function(){
//            $("#viewDiscuss h5.head").bind("click", function(){
//                var $content = $(this).next();
//                if ($content.is(":visible")){
//                    $content.hide();
//                }else {
//                    $content.show();
//                }
//            });
//        })
    </script>
</head>
<body>
    <jsp:include page="base/head.jsp"/>
    <jsp:include page="base/home.jsp"/>
    <div id="main">
        <jsp:include page="base/left.jsp"/>
        <div id="right">
            文章列表：
            <hr/>
            <c:forEach var="article" items="${articles}" >
                <a href="/article/viewArticle?id=${article.id} " id="a1" style="text-decoration: none;" class="article">[${article.categoryName}]&nbsp;&nbsp;${article.title}</a>&nbsp;&nbsp;${article.createTime}
                <br>
                ${article.articleDescribe}
            </c:forEach>
        </div>
    </div>
    <jsp:include page="base/foot.jsp"/>
</body>
</html>
