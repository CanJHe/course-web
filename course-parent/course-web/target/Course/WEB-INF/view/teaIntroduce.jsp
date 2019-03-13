<%--
  Created by IntelliJ IDEA.
  User: CanJ
  Date: 2019/1/2
  Time: 22:03
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

    <div class="row">
        &nbsp;
    </div>

    <form class="form-horizontal" id="focus">
        <div class="form-group">
            <input type="hidden" name="teacherid" value="${teacher.teacherid}">
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
        <div class="form-group">
            <div class="col-sm-10">
                <button type="button" id="submit" class="btn btn-default" style="float: left;margin-left: 12%">关注</button>
            </div>
        </div>
    </form>
</div>

    <script>
        $("#submit").click(function () {
            $.ajax({
                    url:"focus/tea/focusTea",
                    type:"post",
                    dataType:"json",
                    data:$("#focus").serialize(),
                    success:function (data) {
                        if (data){
                            alert("成功关注该教师！！！");
                        } else {
                            alert("您之前已经关注了该教师！！！");
                        }
                    }
            });
        });
    </script>

</body>
</html>
