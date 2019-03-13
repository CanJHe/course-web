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

    <title>所有学生信息</title>
    <!--引入bookstrap文件-->
    <!-- 由于在sprig中映射了，之后直接在那开始就可以接着,css导入到前目录就可以 -->
    <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/icon/iconfont.css">
        <link rel="stylesheet" href="css/icon.demo.css">
    <!--引入bookstrap文件还依赖于JQuery文件，所以也要导入JQuery文件-->
    <script src="js/jquery-2.2.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body style="background-image: url(images/6.jpg);background-repeat: no-repeat">
<div class="container">
    <div class="row" >
        <div class="page-header">
            <h1>WEB课程资源库系统<small>所有学生信息</small></h1>
        </div>
    </div>
    <!-- Single button -->
    <div class="btn-group">
        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            操作 <span class="caret"></span>
        </button>
        <ul class="dropdown-menu">
            <li><a href="user/userDetail">个人中心</a></li>
            <li><a href="user/updateInfoPrompt">修改个人信息</a></li>
            <li><a href="user/reset">修改密码</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="user/students">查看学生</a></li>
            <li><a href="user/addStudentPrompt">添加学生</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="posts/stu/allPost">查看帖子</a></li>
            <li><a href="resource/resources">查看资源</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="student/logout">退出登录</a></li>
        </ul>
    </div>

    <div class="row">
        &nbsp;
    </div>
    <div class="header-search" style="float: right">
        <form id="search-form" action="student/findStudent"  method="get">
            <input id="search-text" class="search-text" type="search" id="search" name="name" placeholder="查询学生">
            <input class="search-btn iconfont"  type="submit" name="" value="&#xe60b;">
        </form>
    </div>
    <div class="clear"></div>

    <h3>学生信息</h3>
    <table class="table table-striped table-bordered">
        <tr>
            <td>序号</td>
            <td>学生学号</td>
            <td>学生姓名</td>
            <td>学生班级</td>
            <td>联系方式</td>
            <td>自我描述</td>
            <td>学生状态</td>
            <td>操作</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${students}" var="student" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${student.studentid}</td>
                <td>${student.name}</td>
                <td>${student.stuClass}</td>
                <td>${student.stuPhone}</td>
                <td>${student.selfdescn}</td>
                <td>
                    <c:if test="${student.stuState == 1}">
                        <p class="form-control-static">正常</p>
                    </c:if>
                    <c:if test="${student.stuState == 0}">
                        <p class="form-control-static">禁言中</p>
                    </c:if>
                </td>
                <td><a href="user/deleteStudent/${student.studentid}">删除</a></td>
                <td><a href="user/updateStudentPrompt/${student.studentid}">修改</a></td>
            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>
