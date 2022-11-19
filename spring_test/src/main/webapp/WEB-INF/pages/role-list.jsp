<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>数据 - AdminLTE2定制版</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">

    <!-- Tell the browser to be responsive to screen width -->
    <meta
            content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
            name="viewport">

    <link rel="stylesheet"
          href="../../plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="../../plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="../../plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet"
          href="../../plugins/iCheck/square/blue.css">
    <link rel="stylesheet"
          href="../../plugins/morris/morris.css">
    <link rel="stylesheet"
          href="../../plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet"
          href="../../plugins/datepicker/datepicker3.css">
    <link rel="stylesheet"
          href="../../plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet"
          href="../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet"
          href="../../plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet"
          href="../../plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet"
          href="../../plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet"
          href="../../plugins/select2/select2.css">
    <link rel="stylesheet"
          href="../../plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet"
          href="../../plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet"
          href="../../plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet"
          href="../../plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet"
          href="../../css/style.css">
    <link rel="stylesheet"
          href="../../plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet"
          href="../../plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet"
          href="../../plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet" href="../../plugins/layui/css/layui.css">
</head>
<style>
    .layui-table-cell .layui-form-checkbox[lay-skin="primary"] {
        top: 5px;
        padding: 0;
    }

    #pressDetails > p {
        text-align: justify;
        text-indent: 2em;
    }

</style>
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <!--<jsp:include page="header.jsp"/>-->
    <!-- 页面头部 /-->
    <header class="main-header">
        <!-- Logo -->
        <a href="all-admin-index.html" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>数据</b></span> <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>数据</b>后台管理</span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas"
               role="button"> <span class="sr-only">Toggle navigation</span>
            </a>

            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">

                    <li class="dropdown user user-menu"><a href="#"
                                                           class="dropdown-toggle" data-toggle="dropdown"> <img
                            src="../../img/user2-160x160.jpg"
                            class="user-image" alt="User Image"> <span class="hidden-xs">
<!--							<security:authentication property="principal.username" />-->
					</span>

                    </a>
                        <ul class="dropdown-menu">
                            <!-- User image -->
                            <li class="user-header"><img
                                    src="../../img/user2-160x160.jpg"
                                    class="img-circle" alt="User Image"></li>

                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="#" class="btn btn-default btn-flat">修改密码</a>
                                </div>
                                <div class="pull-right">
                                    <a href="../../login.jsp"
                                       class="btn btn-default btn-flat">注销</a>
                                </div>
                            </li>
                        </ul>
                    </li>

                </ul>
            </div>
        </nav>
    </header>
    <!-- 导航侧栏 -->
    <!--<jsp:include page="aside.jsp"/>-->
    <!-- 导航侧栏 /-->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="../../img/user2-160x160.jpg"
                         class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>
                        <!--                        <security:authentication property="principal.username" />-->
                    </p>
                    <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
                </div>
            </div>

            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">
                <li class="header">菜单</li>
                <li id="admin-index"><a
                        href="main.jsp"><i
                        class="fa fa-dashboard"></i> <span>首页</span></a></li>

                <li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
                    <span>系统管理</span> <span class="pull-right-container"> <i
                            class="fa fa-angle-left pull-right"></i>
				</span>


                </a>
                    <ul class="treeview-menu">

                        <li><a
                                href="user-list.html"> <i
                                class="fa fa-circle-o"></i> 用户管理
                        </a></li>
                        <li><a
                                href="/spring_test/pages/role-list.html"> <i
                                class="fa fa-circle-o"></i> 角色管理
                        </a></li>
                        <li><a
                                href="syslog-list.jsp"> <i
                                class="fa fa-circle-o"></i> 访问日志
                        </a></li>
                    </ul>
                </li>
                <li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
                    <span>基础数据</span> <span class="pull-right-container"> <i
                            class="fa fa-angle-left pull-right"></i>
				</span>
                </a>
                    <ul class="treeview-menu">

                        <li><a
                                href="#">
                            <i class="fa fa-circle-o"></i> 产品管理
                        </a></li>
                        <li><a
                                href="#">
                            <i class="fa fa-circle-o"></i> 订单管理
                        </a></li>

                    </ul>
                </li>

            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>
    <!-- 内容区域 -->
    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                角色管理 <small>全部角色</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="../../index.jsp"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a
                        href="http://localhost:8080/spring_test/role/findAll.do">角色管理</a></li>
                <li class="active">全部角色</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content"> <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">列表</h3>
                </div>

                <div class="box-body">
                    <!-- 数据表格 -->
                    <!--<div class="table-box">

                        &lt;!&ndash;工具栏&ndash;&gt;
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default" title="新建"
                                            onclick="location.href='../pages/role-add.jsp'">
                                        <i class="fa fa-file-o"></i> 新建
                                    </button>

                                    <button type="button" class="btn btn-default" title="刷新">
                                        <i class="fa fa-refresh"></i> 刷新
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="box-tools pull-right">
                            <div class="has-feedback">
                                <input type="text" class="form-control input-sm"
                                       placeholder="搜索"> <span
                                    class="glyphicon glyphicon-search form-control-feedback"></span>
                            </div>
                        </div>
                        &lt;!&ndash;工具栏/&ndash;&gt;

                        &lt;!&ndash;数据列表&ndash;&gt;
                        <table id="dataList"
                               class="table table-bordered table-striped table-hover dataTable">
                            <thead>
                            <tr>
                                <th class="" style="padding-right: 0px"><input
                                        id="selall" type="checkbox" class="icheckbox_square-blue">
                                </th>
                                <th class="sorting_asc">ID</th>
                                <th class="sorting_desc">角色名称</th>
                                <th class="sorting">角色描述</th>
                                <th class="sorting">操作</th>
                            </tr>
                            </thead>
                            <tbody>

                            <tr>
                                <td><input name="ids" type="checkbox"></td>
                                <td>1</td>
                                <td>院长</td>
                                <td>java学院整体工作管理</td>
                                <td class="text-center">
                                    <a href="#" class="btn bg-olive btn-xs">删除</a>
                                </td>
                            </tr>
                            <tr>
                                <td><input name="ids" type="checkbox"></td>
                                <td>2</td>
                                <td>课程研究员</td>
                                <td>课程的研究</td>
                                <td class="text-center">
                                    <a href="#" class="btn bg-olive btn-xs">删除</a>
                                </td>
                            </tr>
                            <tr>
                                <td><input name="ids" type="checkbox"></td>
                                <td>3</td>
                                <td>讲师</td>
                                <td>授课工作</td>
                                <td class="text-center">
                                    <a href="#" class="btn bg-olive btn-xs">删除</a>
                                </td>
                            </tr>
                            </tbody>

                        </table>
                        &lt;!&ndash;数据列表/&ndash;&gt;

                    </div>-->
                    <!-- 数据表格 /-->
                    <table class="layui-hide" id="test" lay-filter="test"></table>
                    <!--工具栏-->
                    <script type="text/html" id="toolbarDemo">
                        <div class="layui-btn-container">
                            <!--<button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
                            <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
                            <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>-->
                            <button type="button" class="layui-btn layui-btn-sm" title="新建"
                                    onclick="location.href='role-add.html'">
                                <i class="fa fa-file-o"></i> 新建
                            </button>
                            <button type="button" class="layui-btn layui-btn-sm" title="刷新">
                                <i class="fa fa-refresh"></i> 刷新
                            </button>
                        </div>
                    </script>
                    <!--表格操作-->
                    <script type="text/html" id="barDemo">
                        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
                    </script>
                </div>
                <!-- /.box-body -->

            </div>

        </section>
        <!-- 正文区域 /-->

    </div>
    <!-- @@close -->
    <!-- 内容区域 /-->

    <!-- 底部导航 -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0.8
        </div>
        <strong>Copyright &copy; 2018-2020 <a
                href="http://www.itcast.cn">研究院研发部</a>.
        </strong> All rights reserved.
    </footer>
    <!-- 底部导航 /-->

</div>

<script src="../../plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="../../plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script src="../../plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="../../plugins/raphael/raphael-min.js"></script>
<script src="../../plugins/morris/morris.min.js"></script>
<script src="../../plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="../../plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="../../plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="../../plugins/knob/jquery.knob.js"></script>
<script src="../../plugins/daterangepicker/moment.min.js"></script>
<script src="../../plugins/daterangepicker/daterangepicker.js"></script>
<script src="../../plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script src="../../plugins/datepicker/bootstrap-datepicker.js"></script>
<script
        src="../../plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script
        src="../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="../../plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="../../plugins/fastclick/fastclick.js"></script>
<script src="../../plugins/iCheck/icheck.min.js"></script>
<script src="../../plugins/adminLTE/js/app.min.js"></script>
<script src="../../plugins/treeTable/jquery.treetable.js"></script>
<script src="../../plugins/select2/select2.full.min.js"></script>
<script src="../../plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script
        src="../../plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script src="../../plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script
        src="../../plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script src="../../plugins/bootstrap-markdown/js/markdown.js"></script>
<script src="../../plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script src="../../plugins/ckeditor/ckeditor.js"></script>
<script src="../../plugins/input-mask/jquery.inputmask.js"></script>
<script
        src="../../plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="../../plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script src="../../plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../../plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="../../plugins/chartjs/Chart.min.js"></script>
<script src="../../plugins/flot/jquery.flot.min.js"></script>
<script src="../../plugins/flot/jquery.flot.resize.min.js"></script>
<script src="../../plugins/flot/jquery.flot.pie.min.js"></script>
<script src="../../plugins/flot/jquery.flot.categories.min.js"></script>
<script src="../../plugins/ionslider/ion.rangeSlider.min.js"></script>
<script src="../../plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script src="../../plugins/layui/layui.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        // 选择框
        $(".select2").select2();

        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
        });
    });

    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }

    $(document).ready(function () {
        // 激活导航位置
        setSidebarActive("admin-datalist");

        // 列表按钮
        $("#dataList td input[type='checkbox']")
            .iCheck(
                {
                    checkboxClass: 'icheckbox_square-blue',
                    increaseArea: '20%'
                });
        // 全选操作
        $("#selall")
            .click(
                function () {
                    var clicks = $(this).is(
                        ':checked');
                    if (!clicks) {
                        $(
                            "#dataList td input[type='checkbox']")
                            .iCheck(
                                "uncheck");
                    } else {
                        $(
                            "#dataList td input[type='checkbox']")
                            .iCheck("check");
                    }
                    $(this).data("clicks",
                        !clicks);
                });
    });
    /*查询条件*/
    let pojo = {
        roleName: '',
        roleDesc: '',
    }
    layui.use(['table', 'element', 'layer', 'jquery', 'form',], function () {
        let table = layui.table,
            element = layui.element,
            layer = layui.layer,
            $ = layui.$,
            form = layui.form;
        table.render({
            elem: '#test',
            method:'post'
            /*请求地址*/
            , url: '/spring_test/role/list',
            /*返回的数据格式*/
            parseData: function (res) {
                return {
                    "code": res.code,
                    "msg": res.msg,
                    "count": res.count,
                    "data": res.data,
                }
            },
            where:pojo
            , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            , defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                title: '提示'
                , layEvent: 'LAYTABLE_TIPS'
                , icon: 'layui-icon-tips'
            }]
            , title: '角色数据表'
            , cols: [[
                {type: 'checkbox', fixed: 'left'}
                , {
                    field: 'id',
                    minWidth: 100,
                    type: 'numbers',
                    title: 'ID',
                    width: 80,
                    fixed: 'left',
                    align: "center",
                    unresize: true,
                    sort: true
                }
                , {field: 'roleName', minWidth: 150, title: '角色名', edit: 'text', align: "center",}
                , {field: 'roleDesc', title: '角色描述', edit: 'text', align: "center",}
                , {fixed: 'right', minWidth: 150, title: '操作', toolbar: '#barDemo', align: "center",}
            ]],
            /*初始化的页数*/
            limit: 5
            /*自动分页*/
            , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                , limits: [5, 10, 20]
            },
            even: true
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
</script>
</body>

</html>