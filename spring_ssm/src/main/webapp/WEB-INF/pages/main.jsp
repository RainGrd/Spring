<%--
  Created by IntelliJ IDEA.
  User: RainGrd
  Date: 2022/6/15
  Time: 19:44:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="${pageContext.request.contextPath}/js/JQuery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/layui/css/layui.css">
<script src="${pageContext.request.contextPath}/plugins/layui/layui.js"></script>
<body>
<div style="margin: 0 auto;width: 1000px">
    <%--    <div class="layui-card-header">查询</div>
        <div class="layui-card-body">
            <table class="layui-hide" id="test" lay-filter="test"></table>

            <script type="text/html" id="toolbarDemo">
                <div class="layui-btn-container">
                    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
                    <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
                    <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
                </div>
            </script>

            <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
            </script>
        </div>--%>
    <table border="1" width="300px">
        <th>
            账户ID
        </th>
        <th>
            账户名称
        </th>
        <th>
            账户金额
        </th>
        <c:forEach items="${accountList}" var="account" varStatus="account_id">
            <tr align="center">
                <td>${account_id.index+1}</td>
                <td>${account.accountName}</td>
                <td>${account.accountMoney}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
<%--<script type="text/javascript">
    layui.use(['table', 'element'], function () {
        var table = layui.table;
        var element = layui.element;
        table.render({
            elem: '#test'
            , url: '/account'
            , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            , defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                title: '提示'
                , layEvent: 'LAYTABLE_TIPS'
                , icon: 'layui-icon-tips'
            }]
            , title: '账户数据表'
            , cols: [[
                {type: 'checkbox', fixed: 'left'}
                , {
                    field: 'id',
                    type: 'numbers', title: 'ID', width: 80, fixed: 'left', unresize: true, sort: true
                }
                , {field: 'accountName', title: '用户名', width: 120, edit: 'text'}
                , {
                    field: 'accountMoney', title: '邮箱', width: 150, edit: 'text', templet: function (res) {
                        return '<em>' + res.email + '</em>'
                    }
                }
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 150}
            ]]
            /*初始化的页数*/
            , limit: 5
            /*自动分页*/
            , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['page', 'count', 'prev', 'current', 'next', 'skip'] //自定义分页布局
                , limits: [5, 10, 20]
            }, even: true
            /*回显数据的函数*/
            , done: function (res) {
                console.log(res)
            }
        });

        //头工具栏事件
        table.on('toolbar(test)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'getCheckData':
                    var data = checkStatus.data;
                    layer.alert(JSON.stringify(data));
                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：' + data.length + ' 个');
                    break;
                case 'isAll':
                    layer.msg(checkStatus.isAll ? '全选' : '未全选');
                    break;

                //自定义头工具栏右侧图标 - 提示
                case 'LAYTABLE_TIPS':
                    layer.alert('这是工具栏右侧自定义的一个图标按钮');
                    break;
            }
        });

        //行工具事件
        table.on('tool(test)', function (obj) {
            var data = obj.data;
            //console.log(obj)
            if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    obj.del();
                    layer.close(index);
                });
            } else if (obj.event === 'edit') {
                layer.prompt({
                    formType: 2
                    , value: data.email
                }, function (value, index) {
                    obj.update({
                        email: value
                    });
                    layer.close(index);
                });
            }
        });
    });
</script>--%>
</html>
