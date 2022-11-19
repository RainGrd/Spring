<%--
  Created by IntelliJ IDEA.
  User: RainGrd
  Date: 2022/7/4
  Time: 10:44:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/book/add">
  书籍名：<input type="text" name="title">
  作者:<input type="text" name="author" >
  价格:<input type="text" name="price">
</form>
</body>
</html>
