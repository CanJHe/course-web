<%--
  Created by IntelliJ IDEA.
  User: CanJ
  Date: 2019/1/1
  Time: 20:02
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

    <title>学生中心</title>
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
            <h1>WEB课程资源库系统<small>我的收藏</small></h1>
        </div>
    </div>
    <!-- Single button -->
    <div class="btn-group">
        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            操作 <span class="caret"></span>
        </button>
        <ul class="dropdown-menu">
            <li><a href="student/stuDetail">个人中心</a></li>
            <li><a href="student/updateSelf">修改个人信息</a></li>
            <li><a href="student/stuReset">修改密码</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="course/studentId">课程情况</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="posts/stu/allPost">查看帖子</a></li>
            <li><a href="resource/resources">查看资源</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="focus/stu/findAllFocus">我的关注</a></li>
            <li><a href="collection/stu/resources">我的收藏</a></li>
            <li><a href="resource/myResource">我的资源</a></li>
            <li><a href="posts/stu/myPosts">我的帖子</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="resource/stu/uploadPrompt">上传资源</a></li>
            <li><a href="resource/resources">下载资源</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="student/logout">退出登录</a></li>
        </ul>
    </div>

    <div class="row">
        &nbsp;
    </div>
    <div class="row">
        &nbsp;
    </div>

    <form class="form-horizontal">
        <h3>我的收藏</h3>

        <table class="table table-striped table-bordered">
            <tr>
                <td>序号</td>
                <td>资源名</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${collections}" var="collection" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td><a href="resource/resourceDetail/${collection.resource.resourceid}" target="_blank">${collection.resource.name}</a></td>
                    <td>
                        <p class="form-control-static">
                            <a href="collection/stu/cancelResource/${collection.resource.resourceid}">取消收藏</a>
                        </p>
                    </td>
                </tr>
            </c:forEach>
        </table>
</div>
</body>
</html>
