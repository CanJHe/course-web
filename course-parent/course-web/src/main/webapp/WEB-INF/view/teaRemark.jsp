<%--
  Created by IntelliJ IDEA.
  User: CanJ
  Date: 2019/1/3
  Time: 22:19
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

    <title>学生帖子</title>
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
            <h1>WEB课程资源库系统<small>帖子详情</small></h1>
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

    <%--<table id="post_pub">--%>
        <%--<tr>--%>
            <%--<td>--%>
                <%--<input type="text" class="form-control" id="post" name="content" placeholder="我要发帖">--%>
            <%--</td>--%>
            <%--<td><button class="btn btn-default" type="button" id="publish">发表</button></td>--%>
        <%--</tr>--%>
    <%--</table>--%>
            <form>
                <table class="table table-striped">
                <input type="hidden" name="postid" id="postid" value="${post.postId}">
                <tr>
                    <td>${status.index + 1}、<a href="teacher/introduce?stuId=${post.stuId}">${post.stuName}</a>:${post.content}</td>
                    <td>
                        <fmt:formatDate value="${post.time}" pattern="yyyy-MM-dd hh:mm:ss"/>
                    </td>
                </tr>
                <tr>
                        <%--<input type="text" class="form-control" id="content" name="content" placeholder="请输入你的评论">--%>
                    <td>
                        <input type="text" class="form-control" id="content" name="content" placeholder="请输入你的评论">
                    </td>
                    <td><button class="btn btn-default" type="button" id="submit">提交</button></td>
                </tr>
                </table>
            </form>
        <c:forEach items="${remarks}" var="remark">
            <form class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label"><a href="teacher/introduce?stuId=${remark.stuId}">${remark.name}</a>:${remark.content}</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">
                            <fmt:formatDate value="${remark.date}" pattern="yyyy-MM-dd hh:mm:ss"/>
                        </p>
                    </div>
                </div>
            </form>
        </c:forEach>

</div>

<script>
    $("#submit").click(function () {
        $.ajax({
            url:"remark/insertTea",
            type:"post",
            dataType:"json",
            data:{
                postId:$("#postid").val(),
                content:$("#content").val()
            },
            success:function (data) {
                if(data.flag == "true"){
                    location.href="remark/flushTea?postId="+data.message;
                }else {
                    alert("评论失败！！！");
                }
            }
        });
    });
</script>

</body>
</html>
