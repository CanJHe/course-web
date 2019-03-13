<%--
  Created by IntelliJ IDEA.
  User: CanJ
  Date: 2018/12/26
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    //获取当前的项目名路径(本来前面就有"/")
    String path = request.getContextPath();
    //配置基础路径，协议+服务名+服务端口号+项目路径，就为当前项目的基本路径
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <%-- 设置当前项目的基本路径 --%>
    <base href="<%=basePath %>">

    <title>上传资源</title>
    <!--引入bookstrap文件-->
    <!-- 由于在sprig中映射了，之后直接在那开始就可以接着,css导入到前目录就可以 -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <!--引入bookstrap文件还依赖于JQuery文件，所以也要导入JQuery文件-->
    <script src="js/jquery-2.2.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body style="background-image: url(images/2.jpg)">
<div class="container">
    <div class="row" >
        <div class="page-header">
            <h1>WEB课程资源库系统<small>上传资源</small></h1>
        </div>
    </div>
    <%--<img src="images/1.png" style="width:100%;height: 100% ">--%>

    <div class="row">
        <ul class="nav nav-tabs">
            <li role="presentation" ><a href="skip/skip2">Home</a></li>
            <li role="presentation" class="active"><a href="skip/skip3">Teacher</a></li>
            <li role="presentation" ><a href="skip/skip1">Admin</a></li>
            <%--<li role="presentation"><a href="#">Messages</a></li>--%>
        </ul>
    </div>

    <div class="row">
        &nbsp;
    </div>

    <div class="row">
        <div class="col-md-4">
            <form id="uploadFileForm" method="post" enctype="multipart/form-data" action="resource/tea/upload">
                <div class="form-group">
                    <label for="name">资源名</label>
                    <input type="text" id="name" name="name" >
                </div>
                <div class="form-group">
                    <label for="level">资源等级</label>
                    <input type="text" id="level" name="level" >
                </div>
                <div class="form-group">
                    <label for="desc">资源描述</label>
                    <input type="text" id="desc" name="desc">
                </div>
                <div class="form-group">
                    <label for="image">上传运行截图</label>
                    <input type="file" id="image" name="image" value="上传运行截图">
                </div>
                <div class="form-group">
                    <label for="code">上传代码</label>
                    <input type="file" id="code" name="code" value="上传代码">
                </div>
                <input type="hidden" name="flag" value="2">
                <input type="submit" class="btn btn-default" id="uploadFileBtn">上传</input>
            </form>
        </div>
    </div>
</div>
</body>
</html>

