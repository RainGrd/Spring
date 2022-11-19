<%--
  Created by IntelliJ IDEA.
  User: RainGrd
  Date: 2022/6/20
  Time: 20:34:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
<body>
<div class="form-div">
    <div class="reg-content">
        <h1>欢迎注册</h1>
        <span>已有帐号？</span> <a href="login.jsp">登录</a>
    </div>
    <form action="" id="registered" method="POST">
        <p class="inputs">
            <span>用户名</span>:&nbsp;&nbsp;&nbsp;
            <input name="username" type="text" id="userName">
            <br/>
            <span id="userName_err" class="err_msg"></span>
        </p>
        <p class="inputs">
            <span>密码</span>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input name="password" type="password" id="password">
            <br/>
            <span id="password_err" class="err_msg"></span>
        </p>
        <p class="inputs">
            <span>真实姓名</span>:
            <input name="name" type="text" id="name">
            <br/>
            <span id="emailName_err" class="err_msg"></span>
        </p>

        <p class="inputs">
            手机号码：
            <input name="phone" type="text" id="phone">
            <br/>
            <span id="tel_err" class="err_msg"></span>
        </p>
        <!--<p class="inputs">
            验证码：
            <input name="checkCode" type="text" id="checkCode">&nbsp;
            <img id="verify_img" src="/items/checkCodeServlet">
            <a href="#" id="changeImg">换一张?</a>
            <br/>
            <span id="checkCode_err" class="err_msg"></span>
        </p>-->
        <div class="buttons">
            <span class="err_msg" style="text-indent: 6em"></span>
            <input value="注 册" type="submit" class="button" id="reg_btn" style="margin-left: 100px">
        </div>
    </form>
</div>
</body>
<script src="${pageContext.request.contextPath}/assets/JQuery/JQuery.min.js"></script>
<script>
    $('#registered').submit(function () {
        /*获取值*/
        let $admin={
            name:'',
            username:'',
            password:'',
            phone:'',
        }
        $admin.username=$('#userName').val();
        $admin.password=$('#password').val();
        $admin.name=$('#name').val();
        $admin.phone=$('#phone').val();
        /*发送ajax请求*/
        $.ajax({
            type:'post',
            url:'http://localhost:8080/web-test/admin/registered',
            data:JSON.stringify($admin),
            success:function (data) {
               location.href='http://localhost:8080/web-test/login.jsp';
            },error:function (error) {
                console.log('出错了')
            }
        })
        return false;

    })
</script>
</html>
