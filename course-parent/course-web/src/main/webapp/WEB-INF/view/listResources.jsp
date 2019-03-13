<%--
  Created by IntelliJ IDEA.
  User: CanJ
  Date: 2018/12/25
  Time: 17:14
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

    <title>所有资源</title>
    <!--引入bookstrap文件-->
    <!-- 由于在sprig中映射了，之后直接在那开始就可以接着,css导入到前目录就可以 -->
    <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/icon/iconfont.css">
    <!--引入bookstrap文件还依赖于JQuery文件，所以也要导入JQuery文件-->
    <script src="js/jquery-2.2.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row" >
        <div class="page-header">
            <h1>WEB课程资源库系统<small>所有资源</small></h1>
        </div>
    </div>

    <c:if test="${! empty sessionScope.student}">
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
    </c:if>
    <c:if test="${! empty sessionScope.user}">
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
                <li><a href="user/logout">退出登录</a></li>
            </ul>
        </div>
    </c:if>

    <div class="header-search" style="float: right;margin-bottom: 10px;">
        <form id="search-form" action="resource/resource"  method="get">
            <input id="search-text" class="search-text" type="search" id="search" name="name" placeholder="搜索资源">
            <input class="search-btn iconfont"  type="submit" name="" value="&#xe60b;">
        </form>
    </div>
    <%--<img src="images/1.png" style="width:100%;height: 100% ">--%>

    <div class="row">
        <div style="width: 100%;background: rgba(244,68,68,0.9);height: 80px;color: #fff;"><h4 style="text-align: center;line-height: 80px;">资源列表</h4></div>
        <table class="table table-striped table-bordered">
            <tr>
                <td>序号</td>
                <td>资源名称</td>
                <td>资源描述</td>
                <td>上传时间</td>
                <c:if test="${! empty sessionScope.user}">
                    <td>操作</td>
                </c:if>
            </tr>
            <c:forEach items="${resources}" var="resource" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td><a href="resource/resourceDetail/${resource.resourceid}" target="_blank">${resource.name}</a></td>
                    <td>${resource.descn}</td>
                    <td>
                        <fmt:formatDate value="${resource.uploadTime}" pattern="yyyy-MM-dd hh:mm:ss"/>
                    </td>
                    <c:if test="${! empty sessionScope.user}">
                    <td>
                        <p class="form-control-static">
                             <a href="resource/delete/${resource.resourceid}">删除资源</a>
                        </p>
                    </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<script>
    $("#submit").click(function(){
        $.ajax({
            url:"student/stuLogin",
            type:"post",
            cache:"true",
            dataType:"json",
            // data:{
            //     name:$("#name").val(),
            //     password:$("#password").val(),
            //     flag:"1",
            //     renumber:$(":input[type='checkbox']:checked").val()
            // },
            data: $("#sub").serialize(),
            success:function(data) {
                if (data){
                    location.href = "skip/success";
                }else {
                    alert("用户名或密码错误！");
                }
            }
        });
    });
</script>

</body>
</html>

