<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2016/6/17
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <script src="${ctx}/resources/js/jquery-1.12.1.min.js"></script>
    <title>left</title>
</head>
<body>
<div id="left">
    <div id="portrait">
        <img src="http://7xv9yx.com1.z0.glb.clouddn.com/bapocalypseHead.png"/>
    </div>
    <div id="category">
        文章分类：
        <br/>
        <c:forEach var="category" items="${category}">
            <a href="#">${category.categoryName}(${category.number})</a><br/>
        </c:forEach>

    </div>
</div>
</body>
</html>
