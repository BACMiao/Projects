<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2016/6/2
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <title>登录</title>
    <link href="${ctx}/resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<form action="#" id="userLogin" method="post">
        <div id="loginModal" class="modal show text-center">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span></button>
                        <h3 class="text-primary">登录</h3>
                    </div>
                    <div class="modal-body">
                        <div class="control-group">
                            <input type="text" class="form-control input-lg" name="username" id="username" style="height:40px; width: 360px; font-size: large" placeholder="用户名" />
                        </div>
                        <div class="control-group">
                            <input type="password" class="form-control input-lg" name="password" id="password" style="height:40px; width: 360px; font-size: large" placeholder="登录密码"/>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-primary btn-lg btn-block" style="width: 360px; height: 50px; font-size: large" type="submit">立刻登录</button>
                        <span><a href="#">找回密码</a></span>
                    </div>
                </div>
            </div>
        </div>
</form>

<script src="${ctx}/resources/js/jquery-1.12.1.min.js"></script>
<script src="${ctx}/resources/js/bootstrap.js"></script>
<script src="${ctx}/resources/js/jquery.validate.js"></script>

<script type="text/javascript">
    $('#loginModal').modal({backdrop: 'static', keyboard: false}).css({
        width: 'auto',
        'margin-left': function () {
            return -($(this).width() / 2);
        }
    });

    $(function(){
        $("#userLogin").validate({
            rules:{
                username:{
                    required:true,
                },
                password:{
                    required:true,
                },
            },
            messages:{
                username : {
                    required :'<div class="alert alert-danger" role="alert">请输入用户名</div>',
                },
                password : {
                    required :'<div class="alert alert-danger" role="alert">请输入密码</div>',
                }
            },
            highlight : function(element) {
                $(element).closest('.control-group').addClass('error');
            },
            success : function(element) {
                $(element).closest('.control-group').removeClass('error');
            }
        })
    });

    $(function(){
        $("button").click(function(){
            $.getJSON("/user/exist",
                    { username : $("#username").val(), password : $("#password").val()},
                    function(json){
                        if(json.result){
                            alert("正确");
                        }else {
                            alert("错误");
                        }
                    });
            });
    });

</script>
</body>
</html>
