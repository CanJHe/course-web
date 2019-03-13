<%--
  Created by IntelliJ IDEA.
  User: CanJ
  Date: 2018/12/25
  Time: 20:40
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

    <title>管理员登录</title>
    <!--引入bookstrap文件-->
    <!-- 由于在sprig中映射了，之后直接在那开始就可以接着,css导入到前目录就可以 -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <!--引入bookstrap文件还依赖于JQuery文件，所以也要导入JQuery文件-->
    <script src="js/jquery-2.2.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body style="background-image: url(images/6.jpg);background-repeat: no-repeat">
<div class="container">
    <div class="row" >
        <div class="page-header">
            <h1>WEB课程资源库系统<small>管理员登录</small></h1>
        </div>
    </div>
    <%--<img src="images/1.png" style="width:100%;height: 100% ">--%>

    <div class="row">
        <ul class="nav nav-tabs">
            <li role="presentation" ><a href="skip/skip2">Home</a></li>
            <li role="presentation" ><a href="skip/skip3">Teacher</a></li>
            <li role="presentation" class="active"><a href="skip/skip1">Admin</a></li>
            <%--<li role="presentation"><a href="#">Messages</a></li>--%>
        </ul>
    </div>

    <div class="row">
        &nbsp;
    </div>

    <div class="row">
        <div class="col-md-4">
            <form action="user/adlogin" method="post">
                <div class="form-group">
                    <label for="name">用户名</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="请输入用户名">
                </div>
                <div class="form-group">
                    <label for="password">密码</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                </div>
                <div class="form-group">
                    <a href="skip/adForgetPass">忘记密码？</a>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox">记住密码
                    </label>
                </div>
                    <button type="submit" class="btn btn-default">登录</button>
                    <button type="button" class="btn btn-default"><a href="skip/skipAdminRegister" style="text-decoration: none">注册</a></button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
