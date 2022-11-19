<%--
  Created by IntelliJ IDEA.
  User: RainGrd
  Date: 2022/6/20
  Time: 13:17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="layui-header">
    <div class="layui-logo layui-hide-xs layui-bg-black">员工管理系统</div>
    <!-- 头部区域（可配合layui 已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
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
    </ul>
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
                <dd><a href="">Sign out</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
            <a href="javascript:;">
                <i class="layui-icon layui-icon-more-vertical"></i>
            </a>
        </li>
    </ul>
</div>
