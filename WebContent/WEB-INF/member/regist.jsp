<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--
	Author: W3layouts
	Author URL: http://w3layouts.com
	License: Creative Commons Attribution 3.0 Unported
	License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html lang="en">
<head>
<title>注册</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Classy Register Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- Meta tag Keywords -->
<!-- css files -->
<link href="${AppRootPath}/static/regist/css/style.css" rel="stylesheet"
	type="text/css" media="all">
<!-- //css files -->
<!-- online-fonts -->
<link href="${AppRootPath}/static/regist/css/index.css" rel="stylesheet">
<!--//online-fonts -->
</head>
<style>
.form-date-w3-agileits {
	color: white;
}

#phone {
	margin-top: 20px;
}
</style>
<body>

	<div class="w3-main">
		<!-- Main -->
		<div class="about-bottom main-agile book-form">
			<div class="alert-close"
				onclick="javascript:location.href='MemberMain'"></div>

			<form action="MemberMain" method="post">
				<input type="hidden" name="oper" value="insertdeal" />
				<div class="form-date-w3-agileits">
					<label> 账号 </label> <input type="text" name="userName"
						placeholder="请输入账号" required=""> <label> 密码 </label> <input
						type="password" name="userPass" placeholder="请输入密码" required="">
					<label> 确认密码 </label> <input type="password" name="userPass2"
						placeholder="请再次输入密码" required=""> <label> 昵称 </label> <input
						type="text" name="nickName" placeholder="请输入你的昵称" required="">
					<label> 性别 </label> <input type="radio" name="sex"
						checked="checked" value="男">男&nbsp;&nbsp;&nbsp;&nbsp; <input
						type="radio" name="sex" value="女">女 <label id="phone">
						电话 </label> <input type="text" name="phone" placeholder="请输入你的电话号码"
						required="">
				</div>
				<div class="make wow shake">
					<input type="submit" value="注册">
				</div>
			</form>
		</div>
		<!-- //Main -->
	</div>
	<!-- footer -->
	<div class="footer-w3l">
		<p>
			&copy; 2017 Classy Register Form. All rights reserved | Design by <a
				href="http://w3layouts.com">W3layouts</a>
		</p>
	</div>
	<!-- //footer -->
	<!-- js-scripts-->
	<script type="application/x-javascript">
		 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
	</script>
	<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
	<script>
		$(document).ready(function(c) {
			$('.alert-close').on('click', function(c) {
				$('.main-agile').fadeOut('slow', function(c) {
					$('.main-agile').remove();
				});
			});
		});
	</script>
	<!-- //js-scripts-->
</body>
</html>
