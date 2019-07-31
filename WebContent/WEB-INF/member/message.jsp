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
<title>商家页面</title>
<jsp:include page="__link.jsp" flush="true" />
<!-- jiangjiangxiede store专用单独引入  -->
<link rel="stylesheet"
	href="${AppRootPath}/static/zero_20_zChocoCake(qiantai)/css/store.css">
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
								data-toggle="dropdown">${user.nickName} <i
									class="fa fa-chevron-down"></i></a>
								<div class="dropdown-menu">
									<div class="dropdown-inner">
										<ul class="list-unstyled">
											<li><a href="#">个人中心</a></li>
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
					<span>${bean.storeName}</span>
					<h1>Menu Page</h1>
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
						id="nav_tab">
						<ul id="tab">
							<li><a href="StoreMain?oper=list&storeId=${storeId}"> &nbsp; &nbsp;所有商品
									&nbsp; &nbsp; </a>|</li>
							<li><a href="StoreMain?oper=message&storeId=${storeId}">
									&nbsp; &nbsp;评价 &nbsp; &nbsp; </a>|</li>
							<li><a href="#"> &nbsp; &nbsp;商家资质 &nbsp;
									&nbsp; </a></li>
						</ul>
						<div id="nav_search">
							<form action="#" method="post" class="search_form">
								<input type="text" placeholder="搜索商家美食...." id="search_input" />
								<input type="submit" value="搜索" class="btn btn-warning"
									id="search_submit" />
							</form>

						</div>
					</div>

					<div class="flex-box row">

						<div class="col-sm-9">

							<div>评论数量(${num})</div>
							<c:forEach var="item" items="${DataList}">
								<table class="table table-striped table-bordered"
									id="data-table">
									<tr>
										<th>用户昵称：${item.nickName}
											<hr style="border-bottom: 1px solid" />商品：${item.foodName}
											<hr style="border-bottom: 1px solid" /> 评价内容：${item.content}
										</th>
									<tr>
								</table>
							</c:forEach>

							<!-- item2 -->
						</div>
						<div class="col-sm-3 col-md-3 col-xs-3" id="announce">
							<div class="box-image intro-block">
								<div class="heading-block">
									<h2>商家公告</h2>
								</div>
								<div class="content-block">
									<p>${bean.announce}</p>
									<a href="#" class="btn btn-skin" id="view_all">查看所有</a>
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
		</script>

		<script
			src="${AppRootPath}/static/zero_20_zChocoCake(qiantai)/js/main.js"></script>

	</div>
</body>
</html>
