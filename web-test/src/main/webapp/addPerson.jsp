<%--
  Created by IntelliJ IDEA.
  User: RainGrd
  Date: 2022/6/20
  Time: 18:56:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加页面</title>
</head>
<body>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/layui-master/src/css/layui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css">
<div style="width: 1200px;margin: 0 auto">
    <h1 style="text-align:center;">新增员工</h1>
    <form class="layui-form" action="" lay-filter="example">
        <div class="layui-form-item">
            <label class="layui-form-label">员工姓名</label>
            <div class="layui-input-block">
                <input type="text" name="name" lay-verify="title" autocomplete="off" placeholder="请输入员工姓名"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="text" name="gender" lay-verify="title" autocomplete="off" placeholder="请输入员工性别"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">薪水</label>
            <div class="layui-input-block">
                <input type="text" name="salary" lay-verify="title" autocomplete="off" placeholder="请输入员工薪水"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">入职部门</label>
            <div class="layui-input-block">
                <input type="checkbox" lay-filter="oneCheck" value="1" name="dept" title="a">
                <input type="checkbox" lay-filter="oneCheck" value="2" name="dept" title="b">
                <input type="checkbox" lay-filter="oneCheck" value="3" name="dept" title="c">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">其他</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入内容" class="layui-textarea" name="remark"></textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <%-- <button type="button" class="layui-btn layui-btn-normal" id="LAY-component-form-setval">赋值</button>
                 <button type="button" class="layui-btn layui-btn-normal" id="LAY-component-form-getval">取值</button>--%>
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="updateForm">提交</button>
            </div>
        </div>
    </form>
</div>
</body>
<script src="${pageContext.request.contextPath}/assets/layui-master/src/layui.js"></script>
<script src="${pageContext.request.contextPath}/assets/JQuery/JQuery.min.js"></script>
<script type="text/javascript">
    layui.use(['laypage', 'layer', 'jquery', 'form'], function () {
        var form = layui.form;
        form.on('checkbox(oneCheck)', function (data) {
            $("input[name='deptName']").prop("checked", false);
            $(this).prop("checked", true);
            form.render('checkbox');
        });
        form.on('submit(updateForm)', function (data) {
            let field = data.field;
            /*发送ajax请求*/
            $.ajax({
                type: "post",
                url: 'http://localhost:8080/web-test/person/insert',
                data: JSON.stringify(field),
                success: function (data) {
                    console.log(data)
                    if(data==='insertSuccess'){
                        /*跳转页面*/
                        location.href='http://localhost:8080/web-test/person-list.jsp'
                    }
                }, error: function (error) {
                    console.log('出错了');
                }
            })
            return false
        })
    });
</script>
</html>
