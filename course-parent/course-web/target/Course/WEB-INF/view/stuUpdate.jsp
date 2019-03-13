<%--
  Created by IntelliJ IDEA.
  User: CanJ
  Date: 2019/1/2
  Time: 16:34
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
<body style="background-image: url(images/5.jpg);background-repeat: no-repeat">
<div class="container">
    <div class="row" >
        <div class="page-header">
            <h1>WEB课程资源库系统<small>学生中心</small></h1>
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

    <div class="row">
        <div class="col-md-8">
    <form class="form-horizontal" method="post" action="student/updateSelfs">
        <input type="hidden" name="studentid" value="${student.studentid}">
        <div class="form-group">
            <label class="col-sm-2 control-label">学生编号</label>
            <div class="col-sm-10">
                <p class="form-control-static">${student.studentid}</p>
            </div>
        </div>
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">学生姓名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" name="name" value="${student.name}" placeholder="请输入学生姓名">
            </div>
        </div>
        <div class="form-group">
            <label for="stuPhone" class="col-sm-2 control-label">联系方式</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="stuPhone" name="stuPhone" value="${student.stuPhone}" placeholder="请输入学生联系方式">
            </div>
        </div>
        <div class="form-group">
            <label for="stuClass" class="col-sm-2 control-label">所在班级</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="stuClass" name="stuClass" value="${student.stuClass}" placeholder="请输入学生所在班级">
            </div>
        </div>
        <div class="form-group">
            <label for="selfdescn" class="col-sm-2 control-label">自我描述</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="selfdescn" name="selfdescn" value="${student.selfdescn}" placeholder="请输入描述">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">学生状态</label>
            <div class="col-sm-10">
                <c:if test="${student.stuState == 1}">
                    <p class="form-control-static">正常</p>
                </c:if>
                <c:if test="${student.stuState == 0}">
                    <p class="form-control-static">禁言中</p>
                </c:if>
            </div>
        </div>
        <div class="form-group">
            <button type="submit" id="submit" class="btn btn-default" style="float:left;margin-left: 20%">提交</button>
        </div>
    </form>
    </div>
    </div>
</div>
</body>
</html>
