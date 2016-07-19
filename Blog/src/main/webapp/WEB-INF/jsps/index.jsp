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
    <title>BApocalypse</title>
    <link href="${ctx}/resources/css/base.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/resources/css/main.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div id="background">
        <div id="main">
            <jsp:include page="base/head.jsp"/>
            <div id="maintain">
                <div id="slidershow" class="carousel slide" data-wrap="false" >
                    <!-- 设置图片轮播的顺序 -->
                    <ol class="carousel-indicators">
                        <li data-target="#slidershow" data-slide-to="0" class="active"></li>
                        <li data-target="#slidershow" data-slide-to="1"></li>
                        <li data-target="#slidershow" data-slide-to="2"></li>
                    </ol>
                    <!-- 设置轮播图片 -->
                    <div class="carousel-inner" role="listbox">
                        <div class="item active">
                            <img src="${ctx}/resources/image/carousel1.jpg"/>
                            <!-- 图片对应标题和描述内容 -->
                            <div class="carousel-caption">
                                <h4>图片标题</h4>
                                <p>描述内容...</p>
                            </div>
                        </div>
                        <div class="item">
                            <img src="${ctx}/resources/image/carousel2.jpg"/>
                            <div class="carousel-caption">
                                <h4>图片标题</h4>
                                <p>描述内容...</p>
                            </div>
                        </div>
                        <div class="item">
                            <div class="carousel-caption">
                                <h4>图片标题</h4>
                                <p>描述内容...</p>
                            </div>
                            <img src="${ctx}/resources/image/carousel3.jpg"/>
                        </div>
                    </div>
                    <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
                    <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
                </div>
            </div>
            <%--<div id="right">--%>
                <%--<br/>--%>
                <%--&nbsp;文章列表：--%>
                <%--<hr/>--%>
                <%--<c:forEach var="article" items="${articles}" >--%>
                    <%--<a href="/article/viewArticle?id=${article.id} " id="a1" style="text-decoration: none;" class="article">[${article.categoryName}]&nbsp;${article.title}</a>--%>
                    <%--<p class="describe">${article.articleDescribe}</p>--%>
                    <%--<div class="bottom"><fmt:formatDate value="${article.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>|评论|博客分类：${article.categoryName}</div>--%>
                    <%--<hr style="border-top-style:dotted"/>--%>
                <%--</c:forEach>--%>
            <%--</div>--%>
            <jsp:include page="base/tooltip.jsp"/>

            <%--<jsp:include page="base/foot.jsp"/>--%>
        </div>

    </div>


    <script src="${ctx}/resources/js/jquery-1.12.1.min.js"></script>
    <script src="${ctx}/resources/js/bootstrap.js"></script>
    <script>
        $(function(){
            $("#slidershow").carousel({
                interval:4000
            });
            $("#slidershow a.left").click(function(){
                $(".carousel").carousel("prev");
            });
            $("#slidershow a.right").click(function(){
                $(".carousel").carousel("next");
            });
        });
    </script>
</body>
</html>
