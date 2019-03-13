<%--
  Created by IntelliJ IDEA.
  User: CanJ
  Date: 2018/12/27
  Time: 13:21
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

    <title>完成</title>
    <!--引入bookstrap文件-->
    <!-- 由于在sprig中映射了，之后直接在那开始就可以接着,css导入到前目录就可以 -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <!--引入bookstrap文件还依赖于JQuery文件，所以也要导入JQuery文件-->
    <script src="js/jquery-2.2.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body style="background-image: url(images/4.jpg); background-repeat: no-repeat">
<div class="container">
    <div class="row" >
        <div class="page-header">
            <h1>WEB课程资源库系统<small>重置成功</small></h1>
        </div>
    </div>

    <div class="row">
        &nbsp;
    </div>

    <div class="btn-group btn-group-justified" role="group" aria-label="...">
        <div class="btn-group" role="group">
            <button type="button" class="btn btn-default" >手机号重置</button>
        </div>
        <div class="btn-group" role="group">
            <button type="button" class="btn btn-default" >确认密码</button>
        </div>
        <div class="btn-group" role="group">
            <button type="submit" class="btn btn-default" style="background: #0AA4FC">完成</button>
        </div>
    </div>

    <div class="row">
        &nbsp;
    </div>

    <div class="row">
        &nbsp;
    </div>

    <div class="row">
        &nbsp;
    </div>

    <div class="jumbotron">
        <h1>恭喜您成功修改密码!</h1>
        <p>本系统为您提供更多的资源，更好的体验，更好的未来。您已经成功修改密码，赶紧去体检吧！</p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button">去登录</a></p>
    </div>

</div>
</body>
</html>
