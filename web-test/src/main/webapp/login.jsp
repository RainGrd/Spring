<%--
  Created by IntelliJ IDEA.
  User: RainGrd
  Date: 2022/6/20
  Time: 10:40:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/layui-master/src/css/layui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
<body>
<div class="main-body">
    <div class="login-main">
        <div class="login-top">
            <span>LayuiMini后台登录</span>
            <span class="bg1"></span>
            <span class="bg2"></span>
        </div>
        <form class="layui-form login-bottom">
            <div class="center">
                <div class="item">
                    <span class="icon icon-2"></span>
                    <input type="text" name="username" lay-verify="required" placeholder="请输入登录账号" maxlength="24"/>
                </div>
                <div>${registeredMsg}</div>
                <div class="item">
                    <span class="icon icon-3"></span>
                    <input type="password" name="password" lay-verify="required" placeholder="请输入密码" maxlength="20">
                    <span class="bind-password icon icon-4"></span>
                </div>
            </div>
            <div class="tip">
                <a href="http://localhost:8080/web-test/registered.jsp" style="text-decoration:underline; color: red">没有账号，注册一个</a>
                <%-- <span class="icon-nocheck"></span>
                 <span class="login-tip">保持登录</span>--%>
                <a href="forgot-pwd.jsp" class="forget-password">忘记密码？</a>
            </div>
            <div class="layui-form-item" style="text-align:center; width:100%;height:100%;margin:0px;">
                <button class="login-btn" lay-submit="" lay-filter="login">立即登录</button>
            </div>
        </form>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/assets/layui-master/src/layui.js"></script>
<script src="${pageContext.request.contextPath}/assets/JQuery/JQuery.min.js"></script>
<script>
    layui.use(['laypage', 'layer', 'jquery', 'form'], function () {
        var form = layui.form, layer = layui.layer, $ = layui.jquery;
        $('.bind-password').on('click', function () {
            if ($(this).hasClass('icon-5')) {
                $(this).removeClass('icon-5');
                $("input[name='password']").attr('type', 'password');
            } else {
                $(this).addClass('icon-5');
                $("input[name='password']").attr('type', 'text');
            }
        });

        $('.icon-nocheck').on('click', function () {
            if ($(this).hasClass('icon-check')) {
                $(this).removeClass('icon-check');
            } else {
                $(this).addClass('icon-check');
            }
        });
        form.on('submit(login)', function (data) {
            let field = data.field;
            /*发送ajax请求*/
            $.ajax({
                type: 'post',
                url: '/web-test/admin/login',
                data: JSON.stringify(field),
                success: function (data) {
                    if (data === 'loginSuccess') {
                        location.href = '/web-test/index.jsp'
                    }
                }, error: function (error) {
                    console.log('出错了');
                }
            })
            return false;
        })
    })
</script>
</html>
