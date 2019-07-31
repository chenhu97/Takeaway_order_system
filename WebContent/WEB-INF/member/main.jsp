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
<link
	href="${AppRootPath}/static/zero_20_zChocoCake(qiantai)/css/jiangjiang.css"
	rel="stylesheet">
<style type="text/css">
.nav a {
	color: black;
}

.nav a:hover {
	color: #EC495E;
}

.nav_store a:hover {
	text-decoration: none;
	color: #EC495E;
}

.nav ul li { .storeCatShow a { color:black;
	
}

.storeCatShow a:hover {
	color: red;
}

.storeCatShow ul li {
	float: left;
	margin: 5px 20px 0px -15px;
}

.userUl ul {
	list-style: none;
}

.userUl ul li {
	line-height: 20px;
	float: none;
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
								href="MemberLogin?oper=loginout">[切换位置]</a></li>
						</ul>
					</div>
					<div class="collapse navbar-collapse navbar-ex1-collapse">
						<ul class="nav navbar-nav">

							<li><a href="MemberMain?oper=list">首页</a></li>
							<li><a href="StoreMain?oper=order">我的订单</a></li>
							<li><a href="archive.html">加盟合作</a></li>
							<li><a href="archive.html">规则中心</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">${name} <i class="fa fa-chevron-down"></i></a>
								<div class="dropdown-menu">
									<div class="dropdown-inner">
										<ul class="list-unstyled">
											<li><a href="javascript:" onclick="validatePass()">个人中心</a></li>
											<li><a href="Favorite?oper=list">我的收藏</a></li>
											<li><a href="#">我的地址</a></li>
											<li><a href="#">安全设置</a></li>
											<li><a href="MemberLogin?oper=loginout">退出登录</a></li>
										</ul>
									</div>
								</div></li>
						</ul>

					</div>
					<ul class="userUl"
						style="display: none; margin-left: 88%; margin-top: -50px;">
						<li><a href="javascript:void(0);" onclick="validatePass()">个人信息</a></li>
						<li><a href="MemberLogin?oper=loginout">注销</a></li>
					</ul>
					<div id="search">
						<form action="MemberMain" method="post" class="search_form">
							<input type="hidden" name="oper" value="listDeal" /> <input
								type="text" placeholder="请输入店名" name="search" id="search_input" />
							<input type="submit" value="搜索" class="btn btn-warning"
								id="search_submit" />
						</form>
					</div>
				</div>
			</nav>

			<!-- Static Header -->
			<div class="header-text">
				<div class="col-md-12 text-center">

					<span>每日公告${news}</span>
					<h1>Daily Announce</h1>

					<p>
						A place where food and coziness compliment each other.<br>Call
						java1903_7th
					</p>

				</div>
			</div>
			<!-- /header-text -->

		</header>
		<!-- /Section: intro -->

		<!-- /////////////////////////////////////////Content -->
		<div id="page-content">

			<!-- ////////////Content Box 01 -->


			<!-- ////////////Content Box 02 -->
			<section class="box-content box-2 box-style-2">
				<div class="container-fluid">
					<div class="nav_store">
						<p>商家分类：</p>
						<ul style="list-style: none;">
							<li style="float: left;"><a href="javascript:storeCat(-1)">全部商家</a>
								<c:forEach var="item" items="${StoreCatList}" varStatus="status">
									<li style="float: left;"><a
										href="javascript:storeCat(${item.storeCatId})">${item.storeCatName}</a>
									</li>
								</c:forEach>
						</ul>
					</div>
					<div class="row heading">
						<div class="col-lg-12">
							<h2>店家列表</h2>
							<div class="intro">Lorem ipsum dolor sit amet</div>
						</div>
					</div>
					<div class="flex-box row">
						<div class="col-sm-12 col-md-12 ">
							<div id="owl-product-1" class="owl-carousel">
								<div class="item">
									<c:forEach var="item" items="${DataList}">
										<div id="foodsdiv" class="portfolio-box col-md-2 col-xs-3"
											onclick="intoStore(this)">
											<div class="portfolio-box-inner">
												<c:if
													test="${not empty item.storePic && fn:length(item.storePic)>0}">
													<img alt="商品图片"
														src="${pageContext.request.contextPath}${item.storePic}" />
												</c:if>
												<c:if
													test="${ empty item.storePic && fn:length(item.storePic)<=0}">
													<img alt="商品图片"
														src="${AppRootPath}/static/zero_20_zChocoCake(qiantai)/images/1.jpg" />
												</c:if>
												<div class="portfolio-box-caption">
													<input type="hidden" name="storeId" value="${item.storeId}" />
													<p class="product-price">${item.storeName}</p>
													<div class="portfolio-box-description">
														<p class="product-category ">${item.address}</p>
													</div>
												</div>
												<div>
													<p class="store_name">${item.storeName}</p>
												</div>
											</div>
										</div>
									</c:forEach>
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
				$.ajax({
					type : 'POST',
					url : "MemberMain",
					async : false,// 要使用同步
					data : {
						"oper" : "listDeal",
						"id" : storeCatId
					},
					success : function(data) {
						//alert("success");
						//alert("success");
						location.href = "MemberMain?oper=listDeal&id="
								+ storeCatId;
					},
					error : function(data) {
						alert("Error");
					},
				});
			}
			function show(obj) {
				var deal = $(".userUl").css("display");
				if (deal == "block") {
					$(".userUl").css("display", "none");
				} else {
					$(".userUl").css("display", "block");
				}
			};
			function validatePass() {
				var password = prompt("请验证密码:");
				if ($.trim(password) == $.trim("${userPass}")
						&& password != null) {
					alert("验证通过,正在前往个人信息修改页面....");
					location.href = "MemberMain?oper=update";
				} else {
					alert("验证失败");
					return;
				}
			};
		</script>

		<script
			src="${AppRootPath}/static/zero_20_zChocoCake(qiantai)/js/main.js"></script>

	</div>
</body>
</html>
