<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2016/7/17
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <title>tooltip</title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <link href="${ctx}/resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/resources/css/tooltip.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div class="col-xs-3 pull-right" id="myScrollspy">
        <ul class="nav nav-tabs nav-stacked navbar-right" data-spy="affix">
            <li><a><span class="glyphicon glyphicon-user"></span></a></li>
            <li><a><span class="glyphicon glyphicon-qrcode"></span></a></li>
            <li><a href="#" id="back-to-top"><span class="glyphicon glyphicon-chevron-up"></span></a></li>
        </ul>
    </div>

<script src="${ctx}/resources/js/jquery-1.12.1.min.js"></script>
<script src="${ctx}/resources/js/bootstrap.js"></script>

<script>
    $(function(){
        //当滚动条的位置处于距顶部200像素以下时，跳转链接出现，否则消失
        $(function () {
            $(window).scroll(function(){
                if ($(window).scrollTop()>200){
                    $("#back-to-top").fadeIn(1000);
                }
                else
                {
                    $("#back-to-top").fadeOut(1000);
                }
            });

            //当点击跳转链接后，回到页面顶部位置
            $("#back-to-top").click(function(){
                $('body,html').animate({scrollTop:0},1000);
                return false;
            });
        });
    });
</script>
</body>
</html>
