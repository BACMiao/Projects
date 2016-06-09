<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2016/6/6
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <script src="${ctx}/resources/js/jquery-1.12.1.min.js"></script>
    <title>${article.title}</title>
    <script type="text/javascript">
        url = "/article/json?id=" + ${article.id};
        $.getJSON(url,function(article){
            msg = article.msg;
            $("#Article").html(msg);
        })

    </script>
</head>
<body>
<div id="Article"></div>
${sessionScope.user.username}

<div id="viewDiscuss">
    <c:forEach var="discuss" items="${discuss}" >
        ${discuss.username}&nbsp;&nbsp;${discuss.createTime}<br/>
        ${discuss.message}<br/>
    </c:forEach>
</div>
<div id="Discuss">

    <form action="/discuss/add?articleId=${article.id}" method="post">
        <textarea id="message" name="message"></textarea>
        <input type="submit" value="评论">
    </form>
</div>
</body>
</html>
