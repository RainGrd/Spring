<%--
  Created by IntelliJ IDEA.
  User: RainGrd
  Date: 2022/6/20
  Time: 10:48:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <title>员工管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/layui-master/src/css/layui.css">
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <%--<jsp:include page="header.jsp"/>--%>
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">员工管理系统</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <%--        <ul class="layui-nav layui-layout-left">
                    <!-- 移动端显示 -->
                    <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-header-event="menuLeft">
                        <i class="layui-icon layui-icon-spread-left"></i>
                    </li>

                    <li class="layui-nav-item layui-hide-xs"><a href="">nav 1</a></li>
                    <li class="layui-nav-item layui-hide-xs"><a href="">nav 2</a></li>
                    <li class="layui-nav-item layui-hide-xs"><a href="">nav 3</a></li>
                    <li class="layui-nav-item">
                        <a href="javascript:;">nav groups</a>
                        <dl class="layui-nav-child">
                            <dd><a href=""></a></dd>
                            <dd><a href="">menu 22</a></dd>
                            <dd><a href="">menu 33</a></dd>
                        </dl>
                    </li>
                </ul>--%>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                <a href="javascript:;">
                    <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"
                         class="layui-nav-img">
                    tester
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">Your Profile</a></dd>
                    <dd><a href="">Settings</a></dd>
                    <dd><a href="http://localhost:8080/web-test/login.jsp">Sign out</a></dd>
                </dl>
            </li>
            <%--            <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
                            <a href="javascript:;">
                                <i class="layui-icon layui-icon-more-vertical"></i>
                            </a>
                        </li>--%>
        </ul>
    </div>
    <%-- <jsp:include page="aside.jsp"/>--%>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">员工</a>
                    <dl class="layui-nav-child">
                        <dd><a href="#"
                               onclick="locationPage('http://localhost:8080/web-test/person-list.jsp')">查询员工</a></dd>
                        <dd><a href="#" onclick="locationPage('http://localhost:8080/web-test/addPerson.jsp')">新增员工</a></dd>
                        <%--                        <dd><a href="javascript:;">menu 3</a></dd>--%>
                        <%--                        <dd><a href="">the links</a></dd>--%>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">部门</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">查询部门</a></dd>
                        <dd><a href="javascript:;">新增部门</a></dd>
                        <%--                        <dd><a href="">超链接</a></dd>--%>
                    </dl>
                </li>
                <%--                <li class="layui-nav-item"><a href="javascript:;">click menu item</a></li>--%>
                <%--                <li class="layui-nav-item"><a href="">the links</a></li>--%>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <%--<div style="padding: 15px;">内容主体区域。记得修改 layui.css 和 js 的路径</div>--%>
        <iframe src="" id="main" width="100%" height="100%">

        </iframe>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        <%--        底部固定区域--%>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/assets/layui-master/src/layui.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js">
</script>
</html>
