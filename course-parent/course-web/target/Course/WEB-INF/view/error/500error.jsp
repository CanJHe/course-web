<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set value="<%=path%>" var="path" />
<!DOCTYPE html>
<html lang="en">
<head>
	<base href="<%=basePath %>">
	<title>500错误</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta content="2;url=<%=path %>" http-equiv="refresh">
	<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	<!-- Custom Theme files -->
	<link href="css/error-style.css" rel="stylesheet" type="text/css" media="all" />
	<!-- //Custom Theme files -->
	<!--pop-up-box-->
	<link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />
	<!--//pop-up-box-->
	<link rel="stylesheet" href="css/font-awesome.css">
	<!-- Font-Awesome-Icons-CSS -->
	<!-- //web font -->
</head>

<body>
	<div class="main-agileits">
		<h1>错误页面</h1>
		<!-- content -->
		<div class="mainw3-agileinfo form">
			<div class="agileits-subscribe">
				<div class="img-po-agile">
					<img src="images/mmmmk.png" alt="">
				</div>
				<div class="subscribe-w3lsbottom">
					<div class="w3l-page">
						<i class="fa fa-spinner" aria-hidden="true"></i>
						加载错误
					</div>
					<h6>服务器内部错误</h6>
					<h2>500</h2>
					<a class="play-icon popup-with-zoom-anim" href="../index.jsp">
						<span id="num">3</span>秒后返回主页</a>
				</div>
				<p class="page-agilemk">server error</p>
				<div class="img-po-agile posi-sgile-2">
					<img src="images/mmmmk2.png" alt="">
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<!-- //content -->
	</div>
		<!-- copyright -->
	<div class="w3copyright-agile">
			<p>Copyright &copy; 2019.Company name All rights reserved. <a href="#" target="_blank" title="课程资源系统">课程资源系统</a>
		</div>
		<!-- //copyright -->
		<!-- jquery -->
		<script src="js/jquery.min.js"></script>
		<script>
			var num = $('#num');
			var text = num.html();
			//设置定时器,每秒num文本数字减1
			var timer = window.setInterval(minusNum,1000);
			function minusNum(){
				text--;
				num.html(text);
			}
		</script>
		<!-- //jquery -->

</body>

</html>