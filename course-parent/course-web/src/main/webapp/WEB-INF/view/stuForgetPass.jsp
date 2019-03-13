<%--
  Created by IntelliJ IDEA.
  User: CanJ
  Date: 2018/12/27
  Time: 21:50
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

    <title>忘记密码</title>
    <!--引入bookstrap文件-->
    <!-- 由于在sprig中映射了，之后直接在那开始就可以接着,css导入到前目录就可以 -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <!--引入bookstrap文件还依赖于JQuery文件，所以也要导入JQuery文件-->
    <script src="js/jquery-2.2.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body style="background-image: url(images/4.jpg); background-repeat: no-repeat">
<div class="container">
    <div class="row" >
        <div class="page-header">
            <h1>WEB课程资源库系统<small>找回密码</small></h1>
        </div>
    </div>
    <%--<img src="images/1.png" style="width:100%;height: 100% ">--%>


    <div class="row">
        &nbsp;
    </div>

    <div class="btn-group btn-group-justified" role="group" aria-label="...">
        <div class="btn-group" role="group">
            <button type="button" class="btn btn-default" style="background: #0AA4FC">手机号重置</button>
        </div>
        <div class="btn-group" role="group">
            <button type="button" class="btn btn-default">确认密码</button>
        </div>
        <div class="btn-group" role="group">
            <button type="button" class="btn btn-default">完成</button>
        </div>
    </div>

    <div class="row">
        &nbsp;
    </div>

    <div class="row">
        &nbsp;
    </div>

    <div class="row">
        &nbsp;
    </div>

    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-8">
            <form class="form-horizontal" id="stu_forget">
                <input type="hidden" name="flag" value="1">
                <div class="form-group">
                    <label for="stuPhone" class="col-sm-2 control-label">手机号</label>
                    <div class="col-sm-10">
                        <input type="tel" class="form-control" id="stuPhone" name="stuPhone" placeholder="请输入手机号">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="button" class="btn btn-default" id="forget">确定</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

    <script>
        $("#forget").click(function () {
            if ($("#stuPhone").val() == ""){
                alert("手机号不能为空！！！");
            }else {
                $.ajax({
                    url:"student/forget",
                    type:"post",
                    dataType:"json",
                    data:$("#stu_forget").serialize(),
                    success:function (data) {
                        if (data.flag){
                            alert(data.message);
                            location.href = "skip/stuResetPass?stuPhone="+data.message;
                        } else {
                            alert("手机号输入有误！！！");
                        }
                    }
                });
            }
        });
    </script>

</body>
</html>