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
<title>订单页面</title>
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

#tda a {
	color: black;
}

#tda a:hover {
	color: red;
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
								data-toggle="dropdown">${user.nickName} <i
									class="fa fa-chevron-down"></i></a>
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
				</div>
			</nav>
			<!-- Static Header -->
			<div class="header-text">
				<div class="col-md-12 text-center">
					<span>我的订单</span>
					<h1>Order Page</h1>
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


					<div class="flex-box row">

						<div class="col-sm-9">
							<div id="owl-product-1" class="owl-carousel">
								<div class="item" style="margin-left: 150px;">
									<div class="item_miao">
										<a name="miao1">订单<span class="leimu_remark"></span></a>
									</div>
									<table id="tab">
										<tr>
											<td>订单编号</td>
											<td>店铺名称</td>
											<td>下单时间</td>
											<td>订单内容</td>
											<td>支付金额</td>
											<td>状态</td>
											<td>备注</td>
											<td>操作</td>
										</tr>
										<c:forEach var="item" items="${userOrderList}"
											varStatus="status">
											<tr>
												<td>${item.orderId}</td>
												<td>${storeNameList.get(status.index)}</td>
												<td>${item.createOn}</td>
												<td>${foodNameList.get(status.index)}</td>
												<td>${item.money}</td>
												<td><c:if test="${item.status=='2'}">已退单</c:if> <c:if
														test="${item.status=='1'}">已完成订单</c:if> <c:if
														test="${item.status=='0'}">正在派送</c:if> <c:if
														test="${item.status=='-1'}">商家尚未接单</c:if></td>
												<td>${item.remark}</td>
												<td id="tda">
													<p>
														<a
															href='StoreMain?oper=list&storeId=${storeIdList.get(status.index)}'>店铺详情</a>
													</p> <c:if test="${item.status=='0'}">
														<a href='StoreMain?oper=orderDeal&orderId=${item.orderId}'>确认收货</a>
													</c:if> <c:if
														test="${item.status=='1'&& messaged.get(status.index)==0}">
														<a
															href='StoreMain?oper=message_insert&foodName=${foodNameList.get(status.index)}&orderId=${item.orderId}'>评论</a>
													</c:if>
												</td>
											</tr>
										</c:forEach>
									</table>
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
			function validatePass() {
				var password = prompt("请验证密码:");
				if ($.trim(password) == $.trim("${user.userPass}")) {
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
