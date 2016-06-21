<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2016/6/6
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <script src="${ctx}/resources/js/jquery-1.12.1.min.js"></script>
    <link href="${ctx}/resources/css/base.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/resources/css/main.css" rel="stylesheet" type="text/css"/>
    <title>${article.title}</title>
    <script type="text/javascript">
        $(function(){
            url = "/article/json?id=" + ${article.id};
            $.getJSON(url,function(article){
                msg = article.msg;
                $("#Article").html(msg);
            });

            $("#viewDiscuss div.head").bind("click", function(){
                var loginUsername="<%=session.getAttribute("loginUsername")%>";
                var $content = $(this).next();
                if (loginUsername=='null'){
                    alert("请先登录！")
                }else {
                    if ($content.is(":visible")){
                        $content.hide();
                    }else {
                        $content.show();
                    }
                }
            });
        })
    </script>
</head>
<body>
 <jsp:include page="../base/head.jsp"/>
 <jsp:include page="../base/home.jsp"/>
<div id="main">
    <jsp:include page="../base/left.jsp"/>
    <div id="Article"></div>
    <div id="Discuss">
        <div id="viewDiscuss">
            <c:forEach var="discuss" items="${discuss}" varStatus="idx">
                ${idx.index+1}楼：<br/>
                ${discuss.username}&nbsp;&nbsp;<fmt:formatDate value="${discuss.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/><br/>
                ${discuss.message}<br/>
                <hr/>
                <c:forEach var="replies" items="${reply}">
                    <c:if test="${replies.parentId == discuss.ownId}">
                        ${replies.username}&nbsp;&nbsp;<fmt:formatDate value="${replies.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/><br/>
                        ${replies.message}<br/>
                    </c:if>
                </c:forEach>
                <div class="head">回复</div>
                <div id="content" style="display:none;">
                    <form action="/discuss/reply?parentId=${discuss.did}" method="post">
                        <textarea id="reply" name="message" rows="10" cols="70"></textarea>
                        <input type="submit" value="回复">
                    </form>
                </div>
                <br/>
            </c:forEach>
            <hr/>
            发表评论：
            <form action="/discuss/add?articleId=${article.id}" method="post">
                <div>
                    <textarea id="message" name="message" rows="10" cols="70"></textarea>
                    <input type="submit" value="评论">
                </div>
            </form>
        </div>
    </div>
</div>

 <%--<jsp:include page="../base/foot.jsp"/>--%>
</body>
</html>
