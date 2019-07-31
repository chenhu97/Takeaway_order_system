<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>外卖订单系统-管理员后台-登录</title>
</head>
<%@ include file="_link.jsp"%>
<body class="no-background">
	<!-- Fixed top -->
	<div id="top">
		<div class="fixed">
			<a href="index.html" title="" class="logo"><img
				src="${AppRootPath}/static/cpts_1078_bpt/img/logo.png" alt="" /></a>
			<ul class="top-menu">
				<li class="dropdown"><a class="login-top"
					data-toggle="dropdown"></a>
					<ul class="dropdown-menu pull-right">
						<li><a href="#" title=""><i class="icon-group"></i>Change
								user</a></li>
						<li><a href="#" title=""><i class="icon-plus"></i>New
								user</a></li>
						<li><a href="#" title=""><i class="icon-cog"></i>Settings</a></li>
						<li><a href="#" title=""><i class="icon-remove"></i>Go to
								the website</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	<!-- /fixed top -->

	<!-- Login block -->
	<div class="login">
		<div class="navbar">
			<div class="navbar-inner">
				<h6>
					<i class="icon-user"></i>Login page
				</h6>
				<div class="nav pull-right">
					<a href="#" class="dropdown-toggle navbar-icon"
						data-toggle="dropdown"><i class="icon-cog"></i></a>
					<ul class="dropdown-menu pull-right">
						<li><a href="#"><i class="icon-plus"></i>Register</a></li>
						<li><a href="#"><i class="icon-refresh"></i>Recover
								password</a></li>
						<li><a href="#"><i class="icon-cog"></i>Settings</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="well">
			<form action="Login" class="row-fluid" method="post">
				<input type="hidden" name="oper" value="loginDeal" />
				<div class="control-group">
					<div style="color: red; font-weight: bold;">${msg}</div>
					<label class="control-label">账号：</label>
					<div class="controls">


						<input class="span12" type="text" name="adminName"
							placeholder="请输入账号" value="${adminName}" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">密码:</label>
					<div class="controls">


						<input class="span12" type="password" name="adminPass"
							placeholder="请输入密码" />

					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<label class="checkbox inline"><input type="checkbox"
							name="checkbox1" class="styled" value="" checked="checked">记住密码</label>
					</div>
				</div>

				<div class="login-btn">
					<input type="submit" value="登录" class="btn btn-danger btn-block" />
				</div>
			</form>
		</div>
	</div>
	<!-- /login block -->
	<!-- Footer -->
	<%@ include file="_footer.jsp"%>
	<!-- /footer -->
</body>
</html>