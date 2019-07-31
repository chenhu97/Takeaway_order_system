<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">
<head>
<meta charset="utf-8">
<title>登录</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS -->
<link rel='stylesheet'
	href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
<link rel="stylesheet"
	href="${AppRootPath}/static/azmind_3_xd/assets/css/reset.css">
<link rel="stylesheet"
	href="${AppRootPath}/static/azmind_3_xd/assets/css/supersized.css">
<link rel="stylesheet"
	href="${AppRootPath}/static/azmind_3_xd/assets/css/style.css">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

</head>
<style>
.zhuce a {
	text-shadow: 0 1px 3px rgba(0, 0, 0, .2);
	color: #fff;
	text-decoration: none;
	margin: 0px 70px;
}

.zhuce {
	margin: 15px;
}
</style>
<body>

	<div class="page-container">
		<h1>Login</h1>
		<form action="MemberLogin" method="post">
			<input type="hidden" value="logindeal" name="oper" /> <input
				type="text" name="userName" class="username" placeholder="账号">
			<input type="password" name="userPass" class="password"
				placeholder="密码">
			<button type="submit">登录</button>
			<div class="error">
				<span>+</span>
			</div>
			<div style="font-weight: bold; color: red;">${msg}</div>
		</form>
		<div class="zhuce">
			<a href="regist.jsp">注册</a><a href="#">忘记密码</a>
		</div>
		<div class="connect">
			<p>Or connect with:</p>
			<p>
				<a class="facebook" href=""></a> <a class="twitter" href=""></a>
			</p>
		</div>
	</div>
	<div align="center">
		from <a href="http://www.baidu.com/" target="_blank"
			title="java_1903_7th">java_1903_7th</a>
	</div>

	<!-- Javascript -->
	<script
		src="${AppRootPath}/static/azmind_3_xd/assets/js/jquery-1.8.2.min.js"></script>
	<script
		src="${AppRootPath}/static/azmind_3_xd/assets/js/supersized.3.2.7.min.js"></script>
	<script
		src="${AppRootPath}/static/azmind_3_xd/assets/js/supersized-init.js"></script>
	<script src="${AppRootPath}/static/azmind_3_xd/assets/js/scripts.js"></script>

</body>

</html>

