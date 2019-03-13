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

    <title>资源详情</title>
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
            <h1>WEB课程资源库系统<small>资源详情</small></h1>
        </div>
    </div>
    <div style="width: 100%;height: 300px;color: #0b0b0b">
        <h4 style="text-align: center;line-height: 80px;font-size: 28px;">
            ${resource.name}
            <span style="display: inline-block;font-size: 18px;color: grey">${resource.descn}</span>
        </h4>
        <span style="float: right;display: inline-block;margin-left: 10px;">资源上传者:
            <c:if test="${!empty resource.studentName}">
                ${resource.studentName}同学
            </c:if>
            <c:if test="${!empty resource.teaName}">
                ${resource.teaName}老师
            </c:if>
        </span>
        <span style="float: right;">上传时间 : <fmt:formatDate value="${resource.uploadTime}" pattern="yyyy-MM-dd hh:mm:ss"/></span>
        <hr/>
        <div style="width: 150px;height: 150px;margin: 0 auto;">
            <p class="form-control-static">资源图片 : </p>
            <img src="${resource.image}" style="width:100px;height: 100px;" alt=""/>
        </div>
        <span style="float: right;">资源等级 : ${resource.level}</span>
        <div class="css3" style="float:right;margin-right: 10px;">
            <c:if test="${!empty sessionScope.student}">
                <a href="resource/download/${resource.resourceid}" target="_blank" style="color: #9CB43A">下载</a>
                <c:if test="${!empty isCollection}">
                    <a href="collection/stu/cancelResource/${resource.resourceid}" style="color: red">${isCollection}</a>
                </c:if>
                <c:if test="${empty isCollection}">
                    <a href="collection/stu/resource/${resource.resourceid}" style="color: red">收藏</a>
                </c:if>
            </c:if>

            <c:if test="${!empty sessionScope.teacher}">
                <a href="resource/download/${resource.resourceid}" target="_blank" style="color: #9CB43A">下载</a>
                <c:if test="${!empty isCollection}">
                    <a href="collection/tea/cancelResource/${resource.resourceid}" style="color: red">${isCollection}</a>
                </c:if>
                <c:if test="${empty isCollection}">
                    <a href="collection/tea/resource/${resource.resourceid}" style="color: red">收藏</a>
                </c:if>
            </c:if>
        </div>

        <div class="row" style="margin-top: 20px;">
            <div style="width: 100%;background: rgba(244,68,68,0.9);height: 80px;color: #fff;"><h4 style="text-align: center;line-height: 80px;">${resource.name}相关资源</h4></div>
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

