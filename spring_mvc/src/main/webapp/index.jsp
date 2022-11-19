<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入JSTL--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--加入该标签手动开启el功能--%>
<%@page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<script src="${pageContext.request.contextPath}/js/JQuery.min.js"></script>
<body>

<h1>成功！</h1>
</body>
<script type="text/javascript">
    $.post("http://localhost:8080/spring_mvc/testServlet",{name:"小明"},function (resp) {
        console.log(resp)
    })
</script>
</html>