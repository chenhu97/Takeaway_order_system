<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="description" content="Free Responsive Html5 Templates">
<title>个人信息修改页面</title>
<jsp:include page="__link.jsp" flush="true" />
<!-- jiangjiangxiede store专用单独引入  -->
<link rel="stylesheet"
	href="${AppRootPath}/static/zero_20_zChocoCake(qiantai)/css/store.css">

<style type="text/css">
#tab {
	border-collapse: collapse;
	margin: 0 auto;
	text-align: center;
}

#tab td {
	width: 500px;
}

#tab td, #tab th {
	border: 1px solid #cad9ea;
	color: #666;
	height: 30px;
}

#tab thead th {
	background-color: #CCE8EB;
	width: 100px;
}

#tab tr:nth-child(odd) {
	background: #fff;
}

#tab tr:nth-child(even) {
	background: #F5FAFA;
}
</style>

</head>

<body class="sub-page">
	<div class="wrap-body">

		<header class="clearfix">

			<!--Navigation-->
			<nav id="menu" class="navbar">
				<div class="container">
					<div class="navbar-header">
						<!--<span id="heading" class="visible-xs">Categories</span>-->
						<button type="button" class="btn btn-navbar navbar-toggle"
							data-toggle="collapse" data-target=".navbar-ex1-collapse">
							<i class="fa fa-bars"></i>
						</button>
						<a class="navbar-brand" href="#"> <img
							src="${AppRootPath}/static/zero_20_zChocoCake(qiantai)/images/logo.png"
							width="250px" />
						</a>
					</div>
					<div class="collapse navbar-collapse navbar-ex1-collapse">
						<ul class="nav navbar-nav">
							<li><a href="MemberMain?oper=list">首页</a></li>
							<li><a href="StoreMain?oper=order">我的订单</a></li>
							<li><a href="contact.html">加盟合作</a></li>
							<li><a href="archive.html">规则中心</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">${bean.nickName} <i
									class="fa fa-chevron-down"></i></a>
								<div class="dropdown-menu">
									<div class="dropdown-inner">
										<ul class="list-unstyled">
											<li><a href="MemberMain?oper=update">个人中心</a></li>
											<li><a href="#">我的收藏</a></li>
											<li><a href="#">我的地址</a></li>
											<li><a href="#">安全设置</a></li>
											<li><a href="MemberLogin?oper=loginout">退出登录</a></li>
										</ul>
									</div>
								</div></li>
						</ul>
					</div>
				</div>
			</nav>
			<!-- Static Header -->
			<div class="header-text">
				<div class="col-md-12 text-center">
					<span>个人信息</span>
					<h1>Personal Info</h1>
				</div>
			</div>
			<!-- /header-text -->

		</header>
		<!-- /Section: intro -->

		<!-- /////////////////////////////////////////Content -->
		<div id="page-content">
			<!-----------------Content-------------------->
			<section class="box-content box-2 box-style-2">
				<div class="container-fluid">
					<div class="collapse navbar-collapse navbar-ex1-collapse"
						id="nav_tab"></div>

					<div class="flex-box row">

						<div class="col-sm-9">
							<div id="owl-product-1" class="owl-carousel">
								<div class="item" style="margin-left: 150px;">
									<div class="item_miao">
										<a name="miao1">个人信息修改<span class="leimu_remark"></span></a>
									</div>
									<form action="MemberMain" method="post" id="myform">
										<input type="hidden" name="oper" value="updatedeal">
										<input type="hidden" name="id" value="${bean.userId}">
										<div>
											<label for="nickName">用户名</label> <input type="text"
												name="nickName" id="nickName" value="${bean.nickName}">
										</div>
										<div>
											<label for="sex">性别</label>
											<input type="radio" name="sex" value="男" checked="checked">男
											<input type="radio" name="sex" value="女">女
										</div>
										<div>
											<label for="phone">联系方式</label> <input type="text"
												name="phone" id="phone" value="${bean.phone}">
										</div>
										<div>
											<label for="address">地址</label> <input type="text"
												name="address"  value="${bean.address}">
										</div>
										
										<div>
											<label for="userPass">请输入新密码</label> <input type="password"
												name="userPass" id="userPass">
										</div>
										<div>
											<label for="userPass2">请再次输入密码</label> <input type="password"
												name="userPass2" id="userPass2">
										</div>
										<div>
											<span style="color: red; font-weight: bold;">${msg}</span>
										</div>
										<input type="submit" class="btn" value="提交"> <input
											type="reset" class="btn" value="重置">
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- ////////////Content Box 05 -->
			<jsp:include page="__box5.jsp" flush="true" />
			<!-- ////////////Content Box 05 -->
		</div>
		<!-- Footer -->
		<jsp:include page="__footer.jsp" flush="true" />
		<!-- /Footer -->
		<!-- JS -->
		<script
			src="${AppRootPath}/static/zero_20_zChocoCake(qiantai)/js/bootstrap.min.js"></script>

		<!-- Owl Carusel JavaScript -->
		<script
			src="${AppRootPath}/static/zero_20_zChocoCake(qiantai)/owlcarousel/owl.carousel.js"></script>
		<script>
			$(document).ready(function() {
				var b1_box = $("#owl-product-1");
				b1_box.owlCarousel({

					loop : true,
					lazyLoad : true,
					items : 1
				});
				// Custom Navigation Events 1
				$(".next-b_1-slide").click(function() {
					b1_box.trigger('next.owl.carousel');
				});
				$(".prev-b_1-slide").click(function() {
					b1_box.trigger('prev.owl.carousel');
				});

				var b2_box = $("#owl-product-2");
				b2_box.owlCarousel({

					loop : true,
					lazyLoad : true,
					items : 1
				});
				// Custom Navigation Events 1
				$(".next-b_2-slide").click(function() {
					b2_box.trigger('next.owl.carousel');
				});
				$(".prev-b_2-slide").click(function() {
					b2_box.trigger('prev.owl.carousel');
				});
			});
			function intoStore(obj) {
				var id = $(obj).find("input").val();
				location.href = "StoreMain?oper=list&storeId=" + id;
			};
		</script>

		<script
			src="${AppRootPath}/static/zero_20_zChocoCake(qiantai)/js/main.js"></script>

	</div>
</body>
</html>
