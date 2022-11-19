<%--
  Created by IntelliJ IDEA.
  User: RainGrd
  Date: 2022/7/4
  Time: 8:51:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--加入该标签手动开启el功能--%>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="add.jsp">添加</a>
<table border="1" id="table">
    <tr>
        <th>编号</th>
        <th>书名</th>
        <th>作者</th>
        <th>价格</th>
    </tr>
    <c:forEach items="${bookPageInfo.data}" var="book" varStatus="book_id">
        <tr align="center">
            <td>${(book_id.index+1)}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.price}</td>
        </tr>
    </c:forEach>
</table>
<div>
    <!--分页工具栏-->
    <span class="home">首页</span>
    <span class="up">上一页</span>
    <span class="down">下一页</span>
    <span class="last">最后一页</span>
    现在是第<span class="index">1</span>页 一共有<span class="page">
    ${bookPageInfo.countPages}</span>页 一共有<span class="count">${bookPageInfo.totalCount}</span>条记录 按
    <select class="totalCount">
        <option value="5">5</option>
        <option value="10">10</option>
        <option value="15">15</option>
    </select>
    条显示
</div>
<script src="${pageContext.request.contextPath}/js/JQuery.min.jS">
</script>
<script src="${pageContext.request.contextPath}/js/index.js">

</script>
</body>
</html>
