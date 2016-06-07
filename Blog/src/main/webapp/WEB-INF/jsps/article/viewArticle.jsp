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
    <title>博文</title>
    <script type="text/javascript">
        $.getJSON("/article/json",function(article){
            msg = article.msg;
            $("#resText").html(msg);
        })

    </script>
</head>
<body>
<div id="resText"></div>
</body>
</html>
