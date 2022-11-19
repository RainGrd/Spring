<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/JQuery.min.js"></script>
    <script>
        var userList=new Array();
        userList.push({username:"zhangsan",age:18});
        userList.push({username:"list",age:28});
        $.ajax({
            type:"post",
            url : "${pageContext.request.contextPath}/user/quick14",
            data:JSON.stringify(userList),
            contentType : "application/json;chatset=utf-8",
            success:function(data) {
                console.log(data);
            }
        })
    </script>
</head>
<body>
</body>
</html>