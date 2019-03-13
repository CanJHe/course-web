<%--
  Created by IntelliJ IDEA.
  User: CanJ
  Date: 2019/1/2
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
    //获取当前的项目名路径(本来前面就有"/")
    String path = request.getContextPath();
    //配置基础路径，协议+服务名+服务端口号+项目路径，就为当前项目的基本路径
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
    <div class="row">
        <div class="page-header">
            <h1>WEB课程资源库系统
                <small>教师中心</small>
            </h1>
        </div>
    </div>
    <!-- Single button -->
    <div class="btn-group">
        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                aria-expanded="false">
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

    <form>
        <table class="table table-striped table-bordered">
            <tr>
                <td>序号</td>
                <td>课程编号</td>
                <td>课程名称</td>
                <td>学生姓名</td>
                <td>分数</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${courses}" var="course" varStatus="status">
                <form  action="course/teaUpdate" method="post">
                <input type="hidden" name="courId" value="${course.courId}">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${course.courNumber}</td>
                    <td>${course.courName}</td>
                    <td>${course.stuName}</td>
                    <td><input type="text"  name="grade" value="${course.grade}"></td>
                    <td>
                        <button class="btn btn-default" type="submit" >提交</button>
                    </td>
                </tr>
                </form>
            </c:forEach>
        </table>
    </form>
</div>

<script>
    // $("submit").click(function () {
    //     $.ajax({
    //         url: "course/teaUpdate",
    //         type: "post",
    //         dataType: "json",
    //         data: {
    //             courId: $("#courId").val(),
    //             grade:$("#grade").val()
    //         },
    //         success:function (data) {
    //             if (data){
    //                location.href="course/teaCourse";
    //             }else {
    //                 alert("修改失败！！！");
    //             }
    //         }
    //     });
    // });
</script>

</body>
</html>
