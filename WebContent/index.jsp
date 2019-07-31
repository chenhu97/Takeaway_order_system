<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>首页</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400">
<!-- Google web font "Open Sans" -->
<link rel="stylesheet"
	href="${AppRootPath}/static/tpmo_510_letter(index)/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${AppRootPath}/static/tpmo_510_letter(index)/css/bootstrap.min.css">

<link rel="stylesheet"
	href="${AppRootPath}/static/tpmo_510_letter(index)/css/demo.css" />
<link rel="stylesheet"
	href="${AppRootPath}/static/tpmo_510_letter(index)/css/templatemo-style.css">

<script type="text/javascript"
	src="${AppRootPath}/static/tpmo_510_letter(index)/js/modernizr.custom.86080.js"></script>
<script type="text/javascript"
	src="${AppRootPath}/static/cpts_1078_bpt/js/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#mapOption').click(function() {
			location.href = "/Takeaway_order_system/member/Map";
		});
	});
</script>
<style>
#particles-js {
	color: white;
	margin-left: 30px;
}

#particles-js a {
	font-size: 16px;
	text-decoration: none
}

#particles-js .kaidian {
	font-size: 16px;
	padding: 0px;
	background-color: rgba(255, 255, 255, 0);
	color: white;
	border-radius: .5rem;
	border-color: white;
	cursor: pointer;
	width: 80px;
}

#particles-js .kaidian:hover {
	background-color: rgba(255, 255, 255, 0);
}

.tm-btn-subscribe {
	background-color: rgba(255, 255, 255, 0);
}

.tm-btn-subscribe:hover {
	
	background-color: rgba(255, 255, 255, 0);
}
</style>
</head>
<body>

	<div id="particles-js">
		<a href="${AppRootPath}/member/MemberLogin">登录</a>|<a
			href="${AppRootPath}/member/MemberMain?oper=insert">注册</a> <input
			type="button" value="我要开店"
			onclick="javascript:location.href='${AppRootPath}/memberStoreRegist'"
			class="kaidian" />
	</div>
	<ul class="cb-slideshow">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
	<div class="container-fluid">
		<div class="row cb-slideshow-text-container ">
			<div class="tm-content col-xl-6 col-sm-8 col-xs-8 ml-auto section">
				<header class="mb-5">
					<h1>welcome</h1>
				</header>
				<P class="mb-5">感谢您访问我们的网站!</P>

				<form action="${AppRootPath}/member/MemberMain" method="post"
					class="subscribe-form">
					<input type="hidden" name="oper" value="list" />
					<div class="row form-section">

						<div class="col-md-7 col-sm-7 col-xs-7">
							<input name="address" type="text" class="form-control"
								id="contact_email" placeholder="请输入您的收货地址..." required />
						</div>
						<div class="col-md-5 col-sm-5 col-xs-5">
							<button type="button" class="tm-btn-subscribe" id="mapOption">地图选择</button>
							<button type="submit" class="tm-btn-subscribe">提交</button>
						</div>
					</div>
				</form>

				<div class="tm-social-icons-container text-xs-center">
					<a href="#" class="tm-social-link"><i class="fa fa-facebook"></i></a>
					<a href="#" class="tm-social-link"><i class="fa fa-google-plus"></i></a>
					<a href="#" class="tm-social-link"><i class="fa fa-twitter"></i></a>
					<a href="#" class="tm-social-link"><i class="fa fa-linkedin"></i></a>
				</div>

			</div>
		</div>
		<div class="footer-link">
			<p>
				Copyright © 2019 页面设计者 : <a rel="nofollow" href="#" target="_parent">java1903_7th</a>
			</p>
		</div>
	</div>
</body>

<script type="text/javascript"
	src="${AppRootPath}/static/tpmo_510_letter(index)/js/particles.js"></script>
<script type="text/javascript"
	src="${AppRootPath}/static/tpmo_510_letter(index)/js/app.js"></script>

</html>
