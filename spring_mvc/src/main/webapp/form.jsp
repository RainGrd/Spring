<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/quick13" method="post">
    姓名:<input type="text" name="data[0].username"><br/>
    年龄:<input type="text" name="data[0].age"><br/>
    <input type="submit">
</form>
</body>
</html>
