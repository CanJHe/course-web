<%--
  Created by IntelliJ IDEA.
  User: CanJ
  Date: 2018/12/26
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <title>管理员注册</title>
    <!--引入bookstrap文件-->
    <!-- 由于在sprig中映射了，之后直接在那开始就可以接着,css导入到前目录就可以 -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <!--引入bookstrap文件还依赖于JQuery文件，所以也要导入JQuery文件-->
    <script src="js/jquery-2.2.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body style="background-image: url(images/3.jpg);background-repeat: no-repeat;">
<div class="container">
    <div class="row" >
        <div class="page-header">
            <h1>WEB课程资源库系统<small>管理员注册</small></h1>
        </div>
    </div>
    <%--<img src="images/1.png" style="width:100%;height: 100% ">--%>

    <div class="row">
        <ul class="nav nav-tabs">
            <li role="presentation" ><a href="skip/skipTeaRegister">Teacher</a></li>
            <li role="presentation" class="active"><a href="#">Admin</a></li>
            <%--<li role="presentation"><a href="#">Messages</a></li>--%>
        </ul>
    </div>

    <div class="row">
        &nbsp;
    </div>
    <form class="form-horizontal" id="admin_register">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" name="name" placeholder="请输入用户名">
            </div>
        </div>
        <div class="form-group">
            <label for="userPhone" class="col-sm-2 control-label">联系方式</label>
            <div class="col-sm-10">
                <input type="tel" class="form-control" id="userPhone" name="userPhone" placeholder="请输入联系方式">
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
                <button type="button" class="btn btn-default" id="register">注册</button>
            </div>
        </div>
    </form>
</div>

<script>
    $("#register").click(function () {
        if ($("#name").val() == ""){
            alert("用户名不能为空！！！")
        }else if($("#userPhone").val() == ""){
            alert("联系方式不能为空！！！");
        }else if ($("#password").val() =="" || $("#password2").val() == ""){
            alert("密码不能为空哦！！！");
        }else if($("#password2").val() != $("#password").val()){
            alert("两个密码必须一致哦！！！");
        }else {
            $.ajax({
               url:"user/register",
               type:"post",
               dataType:"json",
               data:$("#admin_register").serialize(),
               success:function (data) {
                   if(data){
                       alert("注册成功！！！");
                       //跳到管理员登录页面
                       location.href="skip/skip1";
                   }else {
                       alert("用户已存在,注册失败！！！");
                   }
               }
            });
        }
    });
</script>

</body>
</html>
