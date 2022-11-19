<%--
  Created by IntelliJ IDEA.
  User: RainGrd
  Date: 2022/6/15
  Time: 20:16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="js/JQuery.min.js"></script>
<link rel="stylesheet" href="plugins/layui/css/layui.css">
<script src="plugins/layui/layui.js"></script>
<body>
<div style="margin: 0 auto; width: 960px">
    <form class="layui-form" action="${pageContext.request.contextPath}/account/save">
        <div class="layui-form-item">
            <label class="layui-form-label">账户名称:</label>
            <div class="layui-input-block">
                <input type="text" name="accountName" required lay-verify="required" placeholder="请输入账户名称"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">账户金额:</label>
            <div class="layui-input-block">
                <input type="text" name="accountMoney" required lay-verify="required" placeholder="请输入账户金额"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script>
    //Demo
    layui.use('form', function () {
        var form = layui.form;
        //提交
        form.on('submit(formDemo)', function (data) {
            $.ajax({
                url:'/spring_ssm/account/save',
                type:"post",
                data:data,
            })
            return false;
        });
    });
</script>
</body>
</html>
