<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>店家登录(后台)界面</title>
<link rel="stylesheet" type="text/css"
	href="${AppRootPath}/static/cpts_1078_bpt/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="${AppRootPath}/static/cpts_1078_bpt/css/body.css" />
</head>
<body>
	<div class="container">
		<div id="content">
			<form action="Login" method="post">
				<input type="hidden" name="oper" value="loginDeal" />
				<h1>用户登录</h1>
				<div style="font-weight:bold;color:red;">${msg}</div>
				<div>
					<input type="text" placeholder="账号" required="" name="userName" id="username" />
				</div>
				<div>
					<input type="password" placeholder="密码" required="" name="userPass" id="password" />
				</div>
				<div class="">
					<span class="help-block u-errormessage" id="js-server-helpinfo">&nbsp;</span>
				</div>
				<div>
					<input type="submit" value="登录" style="margin: 20px 0px 35px 20px;"
						id="js-btn-login" />
				</div>
			</form>
			<div class="reg">
				<input type="button" value="注册" style="margin: -70px 0px 0px 220px"
					onclick="javascript:location.href='${AppRootPath}/memberStoreRegist?oper=insert'" />
			</div>
		</div>
	</div>
</body>
</html>