<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2016/6/1
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <title>注册</title>
    <link href="${ctx}/resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<form action="/user/saveUser" method="post">
    <div id="registerModal" class="modal show text-center">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span></button>
                    <h2 class="text-primary">注册</h2>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <input type="text" class="form-control input-lg required" name="username" style="height:40px; width: 360px; font-size: large" placeholder="新用户名" >
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control input-lg required" name="password" style="height:40px; width: 360px; font-size: large" placeholder="密码"/>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control input-lg required" name="password2" style="height:40px; width: 360px; font-size: large" placeholder="确认密码"/>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control input-lg required" name="email" style="height:40px; width: 360px; font-size: large" placeholder="邮箱"/>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary btn-lg btn-block" style="width: 360px; height: 50px; font-size: large" type="submit">注册完毕</button>
                </div>
            </div>
        </div>
    </div>
</form>

<script src="${ctx}/resources/js/jquery-1.12.1.min.js"></script>
<script src="${ctx}/resources/js/bootstrap.min.js"></script>

<script type="text/javascript">
    $('#registerModal').modal({backdrop: 'static', keyboard: false}).css({
        width: 'auto',
        'margin-left': function () {
            return -($(this).width() / 2);
        }
    });

    $(function(){
        $("#sub").bind("click", function(event){
            var username = $("#username").val();
            var password = $("#password").val();
            if (username==""){
                $("#usernamemsg").html("<p style='color: red'>用户名不能为空</p>");
                event.preventDefault();
            }

            if (password==""){
                $("#passwordmsg").html("<p style='color: red'>密码不能为空</p>");
                event.preventDefault();
            }
        });

        $("form :input.required").each(function(){
            var $required = $("<strong class='high' style='color: #FF0000'>*</strong>");
            $(this).parent().append($required);
        });
    });

</script>
</body>
</html>
