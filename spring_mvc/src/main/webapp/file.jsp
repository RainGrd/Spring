<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入JSTL--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--加入该标签手动开启el功能--%>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="${pageContext.request.contextPath}/js/JQuery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/ajaxfileupload.js"></script>
<body>

<form action="${pageContext.request.contextPath}/fileServlet" id="form" method="post" enctype="multipart/form-data">
    名称：<input type="text" name="fileName"><br/>
    上传文件:<input type="file" name="file"><br/>
    <%--    上传文件:<input type="file" name="uploadFiles">--%>
    <input type="submit">
</form>
<div>
    <p><input type="file" id="file" name="file" onchange="ajaxFileUpload()"></p>
    <div id="imgDiv"></div>
    <a>下载文件</a>
    <div id="play">





    </div>
</div>
<%--<form action="${pageContext.request.contextPath}/user/quick20" method="post" enctype="multipart/form-data">
    名称：<input type="text" name="fileName"><br/>
    上传文件:<input type="file" name="uploadFile"><br/>
    文件：<input type="file" name="uploadFile2">
    <input type="submit">
</form>--%>
</body>
<script>
    let is=true;
    mp4=function () {
        let vcr = document.getElementById("vcr");

    }
    let $play = $('#play');
    ajaxFileUpload = function () {
        $play.removeClass("");
        $.ajaxFileUpload({
            url: '/spring_mvc/fileServlet',//用于文件上传的服务器端请求地址
            secureuri: false,//一般设置为false
            dataType: "text",
            fileElementId: 'file',//文件上传控件的id属性  <input type="file" id="pimage" name="pimage" />
            success: function (obj) {
                /*清空原有数据*/
                $('#imgDiv').empty();
                if (obj.lastIndexOf('.') !== -1) {
                    var imgObj;
                    if (obj.lastIndexOf(".png") !== -1 || obj.lastIndexOf(".jpg") !== -1 || obj.lastIndexOf(".gif") !== -1) {
                        /**/
                        imgObj = $("<img>")
                        imgObj.attr("src", obj);
                        $("#imgDiv").append(imgObj);
                    } else if (obj.lastIndexOf(".wmv") !== -1 || obj.lastIndexOf(".mp4") !== -1  || obj.lastIndexOf(".avi") !== -1) {
                        $play.removeClass().addClass("show");
                        imgObj=$("<video id='vcr'></video>")
                        imgObj.attr({
                            autoplay:'autoplay',
                            src:obj,
                            width:'500px',
                            controls:'controls',
                        })
                        $("#imgDiv").append(imgObj);
                    }
                } else {
                    $("#imgDiv").append("此文件不支持回显");
                }
            }, error: function (error) {
                console.log("出错了！")
            }
        })
    }
</script>
</html>
