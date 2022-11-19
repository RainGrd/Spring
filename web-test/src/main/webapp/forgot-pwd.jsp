<%--
  Created by IntelliJ IDEA.
  User: RainGrd
  Date: 2022/6/21
  Time: 7:45:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>忘记密码</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/layui-master/src/css/layui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/forgot-pwd.css">
<body>
<div id="container">
    <div></div>
    <div class="admin-login-background">
        <div class="admin-header">
            <span>忘记密码</span>
        </div>
        <form class="layui-form" action="">
            <div>
                <i class="layui-icon layui-icon-cellphone admin-icon"></i>
                <input type="text" name="phone" placeholder="请输入手机号码" autocomplete="off"
                       class="layui-input admin-input admin-input-username">
            </div>
            <div>
                <i class="layui-icon layui-icon-password admin-icon"></i>
                <input type="password" name="password" placeholder="请输入你要修改的密码" autocomplete="off"
                       class="layui-input admin-input">
            </div>
            <%--            <div>
                            <i class="layui-icon layui-icon-password admin-icon"></i>
                            <input type="password" name="rPassword" placeholder="请确认你修改的密码" autocomplete="off"
                                   class="layui-input admin-input">
                        </div>--%>
            <button class="layui-btn admin-button" lay-submit="" lay-filter="login">修改密码</button>
        </form>
    </div>
</div>
<script src="${pageContext.request.contextPath}/assets/layui-master/src/layui.js"></script>
<script src="${pageContext.request.contextPath}/assets/JQuery/JQuery.min.js"></script>
<script>
    layui.use(['form','layer'], function () {
        var form = layui.form,
            layer = layui.layer;

        // 登录过期的时候，跳出ifram框架
        /*if (top.location !== self.location) top.location = self.location;*/

        // 进行登录操作
        form.on('submit(login)', function (data) {
            let field = data.field;
            console.log(field)
            if (field.phone === '') {
                layer.msg('手机号码不能为空');
                return false;
            }
            if (field.password === '') {
                layer.msg('密码不能为空');
                return false;
            }
            /*            if (data.rPassword === '') {
                            layer.msg('确认密码不能为空');
                            return false;
                        }*/
            $.ajax({
                type: 'put',
                url: "http://localhost:8080/web-test/admin/forgotPwd",
                data: JSON.stringify(field),
                success: function (res) {
                    console.log(res)
                    if (res === 'forgotPwdSuccess') {
                        layer.msg('修改成功', function () {
                            window.location = 'login.jsp';
                        });
                    }
                }, error: function (error) {
                    console.log('出错了');
                }
            });
            return  false;
        });
    });
</script>
</body>
</html>
