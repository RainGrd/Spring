<%--
  Created by IntelliJ IDEA.
  User: RainGrd
  Date: 2022/6/20
  Time: 10:44:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/layui-master/src/css/layui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css">
<div class="layuimini-container">
    <div class="layuimini-main">
        <%--<fieldset class="table-search-fieldset">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">员工姓名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">员工性别</label>
                            <div class="layui-input-inline">
                                <input type="text" name="sex" autocomplete="off" class="layui-input">
                            </div>
                        </div>
&lt;%&ndash;                        <div class="layui-inline">
                            <label class="layui-form-label">薪水城市</label>
                            <div class="layui-input-inline">
                                <input type="text" name="city" autocomplete="off" class="layui-input">
                            </div>
                        </div>&ndash;%&gt;
                        <div class="layui-inline">
                            <label class="layui-form-label">部门</label>
                            <div class="layui-input-inline">
                                <input type="text" name="classify" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <button type="submit" class="layui-btn layui-btn-primary"  lay-submit lay-filter="data-search-btn"><i class="layui-icon"></i> 搜 索</button>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>--%>
        <table class="layui-table" id="tableDataList" style="text-align:center;"></table>
        <!--分页条-->
        <div id="page"></div>
    </div>
</div>
<!--修改窗口-->
<div id="update" style="display: none">
    <form class="layui-form" action="" lay-filter="example">
        <div class="layui-form-item">
            <label class="layui-form-label">员工姓名</label>
            <div class="layui-input-block">
                <input type="text" name="name" lay-verify="title" autocomplete="off" placeholder="请输入要修改的员工姓名"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="text" name="gender" lay-verify="title" autocomplete="off" placeholder="请输入要修改的员工性别"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">薪水</label>
            <div class="layui-input-block">
                <input type="text" name="salary" lay-verify="title" autocomplete="off" placeholder="请输入要修改的员工薪水"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">修改部门</label>
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
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="updateForm">确定修改</button>
            </div>
        </div>
    </form>
</div>
</body>
<script src="${pageContext.request.contextPath}/assets/layui-master/src/layui.js"></script>
<script src="${pageContext.request.contextPath}/assets/JQuery/JQuery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/person-list.js"></script>
</html>
