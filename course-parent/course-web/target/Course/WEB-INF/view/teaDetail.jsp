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

    <title>教师中心</title>
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
            <h1>WEB课程资源库系统<small>教师中心</small></h1>
        </div>
    </div>
    <!-- Single button -->
    <div class="btn-group">
        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            操作 <span class="caret"></span>
        </button>
        <ul class="dropdown-menu">
            <li><a href="teacher/teaDetail">个人中心</a></li>
            <li><a href="teacher/updateSelf">修改个人信息</a></li>
            <li><a href="teacher/teaReset">修改密码</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="course/teaCourse">评分情况</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="posts/tea/allPost">查看帖子</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="focus/tea/findAllFocus">我的关注</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="resource/tea/uploadPrompt">上传资源</a></li>
            <li><a href="resource/resources">下载资源</a></li>
            <li><a href="teacher/logout">退出登录</a></li>
        </ul>
    </div>

    <div class="row">
        &nbsp;
    </div>
    <div class="row">
        &nbsp;
    </div>

    <form class="form-horizontal">
        <div class="form-group">
            <label class="col-sm-2 control-label">教师编号</label>
            <div class="col-sm-10">
                <p class="form-control-static">${teacher.teacherid}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">教师姓名</label>
            <div class="col-sm-10">
                <p class="form-control-static">${teacher.name}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">联系方式</label>
            <div class="col-sm-10">
                <p class="form-control-static">${teacher.teaPhone}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">自我描述</label>
            <div class="col-sm-10">
                <p class="form-control-static">${teacher.selfdescn}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">教师状态</label>
            <div class="col-sm-10">
                <c:if test="${teacher.teState == 1}">
                    <p class="form-control-static">正常</p>
                </c:if>
                <c:if test="${teacher.teState == 0}">
                    <p class="form-control-static">禁言中</p>
                </c:if>
            </div>
        </div>
    </form>

</div>
</body>
</html>
