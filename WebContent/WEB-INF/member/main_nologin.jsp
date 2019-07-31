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
<title>用户主界面</title>
<jsp:include page="__link.jsp" flush="true" />
<style type="text/css">
.nav a {
	color: black;
}

.nav a:hover {
	color: red;
}

.nav ul li {
	float: left;
	margin: 5px 20px 0px -15px;
}
#querenLogon{
	text-align: center;
}
</style>
</head>

<body class="index-page">
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
						<a class="navbar-brand" href="/"> <img
							src="${AppRootPath}/static/zero_20_zChocoCake(qiantai)/images/logo.png"
							width="250px" />
						</a>
						
						<ul id="address_ul">
							<li id="address">当前位置：${indexAddress}<a
								href="${AppRootPath}/index.jsp">[切换位置]</a></li>
						</ul>
						
					</div>
					<div class="collapse navbar-collapse navbar-ex1-collapse">
						<ul class="nav navbar-nav">

							<li><a href="MemberMain?oper=list">首页</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">加盟合作 <i class="fa fa-chevron-down"></i></a>
								<div class="dropdown-menu" style="margin-left: -203.625px;">
									<div class="dropdown-inner">
										<ul class="list-unstyled">
											<li><a href="archive.html">Text 301</a></li>
											<li><a href="archive.html">Text 302</a></li>
											<li><a href="archive.html">Text 303</a></li>
											<li><a href="archive.html">Text 304</a></li>
											<li><a href="archive.html">Text 305</a></li>
										</ul>
										<ul class="list-unstyled">
											<li><a href="archive.html">Text 306</a></li>
											<li><a href="archive.html">Text 307</a></li>
											<li><a href="archive.html">Text 308</a></li>
											<li><a href="archive.html">Text 309</a></li>
											<li><a href="archive.html">Text 310</a></li>
										</ul>
										<ul class="list-unstyled">
											<li><a href="archive.html">Text 311</a></li>
											<li><a href="archive.html">Text 312</a></li>
											<li><a href="archive.html#">Text 313</a></li>
											<li><a href="archive.html#">Text 314</a></li>
											<li><a href="archive.html">Text 315</a></li>
										</ul>
									</div>
								</div></li>
							<li><a href="#">规则中心</a></li>
							<li><a href="MemberLogin">登录</a></li>
							<li><a href="MemberMain?oper=insert">注册</a></li>
						</ul>

					</div>
					<div id="search">
						<form action="#" method="post" class="search_form">
							<input type="text" placeholder="search...." id="search_input" />
							<input type="submit" value="搜索" class="btn btn-warning"
								id="search_submit" />
						</form>

					</div>
				</div>
			</nav>

			<!-- Static Header -->
			<div class="header-text">
				<div class="col-md-12 text-center">
					<span>欢迎光临</span>
					<h1>CHOCOLATE CAKES AND CANDIES</h1>
					<p>
						A place where food and coziness compliment each other.<br>Call
						java1907_7th
					</p>

				</div>
			</div>
			<!-- /header-text -->

		</header>
		<!-- /Section: intro -->

		<!-- /////////////////////////////////////////Content -->
		<div id="page-content">

			

			<!-- ////////////Content Box 02 -->
			<section class="box-content box-2 box-style-2">
				<div class="container-fluid">
					<div class="row heading">
						<div class="col-lg-12">
							<h2>店家列表</h2>
							<div class="intro">Lorem ipsum dolor sit amet</div>
						</div>
					</div>
					<div class="flex-box row">
						<div class="col-sm-12 col-md-12 ">
							<div id="owl-product-1" class="owl-carousel">
								<div class="item" id="querenLogon">
									
					请先<a href="MemberLogin" style="color: red; font-weight: bold;">登录!</a>
				
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
			}
			function storeCat(storeCatId) {
				$
						.ajax({
							type : 'POST',
							url : "MemberMain",
							async : false,// 要使用同步
							data : {
								"oper" : "list",
								"id" : storeCatId
							},
							success : function(data) {
								alert("success");
								location.href = "MemberMain?oper=list&id="
										+ storeCatId;
							},
							error : function(data) {
								alert("Error");
							},
						});
			}
		</script>

		<script
			src="${AppRootPath}/static/zero_20_zChocoCake(qiantai)/js/main.js"></script>

	</div>
</body>
</html>
