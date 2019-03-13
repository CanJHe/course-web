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

    <title>管理员中心</title>
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
            <h1>WEB课程资源库系统<small>管理员中心</small></h1>
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
            <li><a href="user/logout">退出登录</a></li>>
        </ul>
    </div>

    <div class="row">
        &nbsp;
    </div>
    <div class="row">
        &nbsp;
    </div>

    <form class="form-horizontal">
                <div class="form-group" id="tea_register">
                    <label for="name" class="col-sm-2 control-label">学生名</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="name" name="name" placeholder="请输入学生名">
                    </div>
                </div>
                <div class="form-group">
                    <label for="stuClass" class="col-sm-2 control-label">学生班级</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="stuClass" name="stuClass" placeholder="请输入学生班级">
                    </div>
                </div>
                <div class="row"></div>
               <div class="form-group">
                    <label for="stuPhone" class="col-sm-2 control-label">联系方式</label>
                    <div class="col-sm-10">
                        <input type="tel" class="form-control" id="stuPhone" name="stuPhone" placeholder="请输入联系方式">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password2" class="col-sm-2 control-label">确认密码</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="password2" name="password2" placeholder="请再次确认密码">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="button" class="btn btn-default" id="register">添加</button>
                    </div>
                </div>
            </form>
</div>
<script>

    $("#register").click(function () {
        if ($("#name").val() == ""){
            alert("用户名不能为空！！！")
        }else if($("#tea_phone").val() == ""){
            alert("联系方式不能为空！！！");
        }else if ($("#password").val() =="" || $("#password2").val() == ""){
            alert("密码不能为空哦！！！");
        }else if($("#password2").val() != $("#password").val()){
            alert("两个密码必须一致哦！！！");
        }else {
            $.ajax({
                url:"user/addStudent",
                type:"post",
                dataType:"json",
                data:{
                    name:$("#name").val(),
                    password:$("#password").val(),
                    stuPhone:$("#stuPhone").val(),
                    stuClass:$("#stuClass").val()
                },
                success:function (data) {
                    if (data){
                        alert("添加成功！！！");
                        location.href = "user/students";
                    }else {
                        alert("学生已存在，添加失败！！！");
                    }
                }
            });
        }
    });

</script>
</body>
</html>
