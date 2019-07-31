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
<style>
button.btn.option_list {
	background-color: #9999e4;
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
											<li><a href="javascript:void(0);" onclick="validatePass()">个人中心</a></li>
											<li><a href="Favorite?oper=list">我的收藏</a></li>
											<li><a href="#">我的地址</a></li>
											<li><a href="#">安全设置</a></li>
											<li><a href="MemberLogin?oper=loginout">退出登录</a></li>
										</ul>
									</div>
								</div></li>
							<c:if test="${empty FavoriteResult}">
								<li>
									<a id="shopguide-favor" href="#">
										<i class="glyphicon glyphicon-heart icon_favorite"></i>
										<span >收藏</span>
									</a>
							</c:if>
							<c:if test="${not empty FavoriteResult}">
								<li>
									<a id="shopguide-favor" href="#">
										<i class="glyphicon glyphicon-heart icon_favorite"></i>
										<span >已收藏</span>
									</a>
							</c:if>
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
						<div class="list_btn">
							<c:set var="id" scope="session" value="${storeId}" />
							<button class="btn all_list"
								onclick="javascript:location.href='StoreMain?oper=alllist&storeId=${id}';">
								<span class="glyphicon glyphicon-list"></span>
							</button>
							<button class="btn option_list"
								onclick="javascript:location.href='StoreMain?oper=optionlist&storeId=${id}';">
								<span class="glyphicon glyphicon-indent-left"></span><span
									class="glyphicon glyphicon-indent-right"></span>
							</button>
						</div>
					</div>

					<div class="flex-box row">

						<div class="col-sm-9">
							<div class="row heading">
								<div class="col-lg-11" id="leimu">
									<a>所有分类：</a>
									<c:forEach var="item" items="${CatDataList}" varStatus="i">
										<a href="#miao${i.count}">${item.catName}</a>
									</c:forEach>
								</div>
							</div>

							<div id="owl-product-1" class="owl-carousel">
								<c:forEach var="item" items="${CatDataList}" varStatus="m">
									<div class="item">

										<div class="item_miao">
											<a name="miao${m.count}">${item.catName}<span
												class="leimu_remark">${item.remark}</span></a>
										</div>
										<c:forEach var="bean" items="${FoodDataList}" varStatus="i">
											<c:if test="${item.catName.equals(bean.catName)}">
												<div class="portfolio-box col-md-4 col-xs-6">

													<div class="portfolio-box-inner">
														<c:if
															test="${not empty bean.picPath && fn:length(bean.picPath)>0}">
															<img
																src="${pageContext.request.contextPath}${bean.picPath}"
																class="img-responsive" alt="" />
														</c:if>
														<c:if
															test="${ empty bean.picPath && fn:length(bean.picPath)<=0}">
															<img alt="菜品图片"
																src="${AppRootPath}/static/zero_20_zChocoCake(qiantai)/images/1.jpg" />
														</c:if>
														<div class="portfolio-box-caption">
															<p class="product-price">
																<span>${bean.price}<span><sup>$</sup>
															</p>
															<div class="portfolio-box-description">
																<h3 class="product-name">${bean.foodName}</h3>
																<p class="product-category">${bean.remark}</p>
															</div>
														</div>
													</div>

													<div>
														<button class="btn btn-skin add_cart_large btnCart">
															<span class="glyphicon glyphicon-shopping-cart"></span>加入购物车
														</button>
													</div>
												</div>
											</c:if>
										</c:forEach>

									</div>
								</c:forEach>

								<!-- item2 -->
							</div>
						</div>

						<div class="col-sm-3 col-md-3 col-xs-3" id="announce">
							<div class="box-image intro-block">
								<div class="heading-block">
									<h2>商家公告</h2>
								</div>
								<div class="content-block">
									<p>${bean.announce}</p>
									<a href="#" class="btn btn-skin" id="view_all">查看所有</a>
									<div class="owl-controls">
										<div class="btn next next-b_1-slide">
											<i class="fa fa-chevron-left"></i>
										</div>
										<div class="btn prev prev-b_1-slide">
											<i class="fa fa-chevron-right"></i>
										</div>
									</div>
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
			</div>
	<div class="shop-cartbasket">
	<form action="/Takeaway_order_system/order/confirm" method="get">
		<div class="car_header">
			购物车<a href="#" class="car_qingkong">[清空]</a><span
				class="glyphicon glyphicon-shopping-cart car_header_icon"></span>
		</div>
		<div class="car_contennt"></div>
		<div class="car_footer">
			<div class="cat_price">
				<span>总计￥</span><span class="total"></span>
			</div>
			<div>
				<button class="car_jiesuang">去结算></button>
			</div>
		</div>
		</form>
	</div>
		<!-- JS -->
		<script
			src="${AppRootPath}/static/zero_20_zChocoCake(qiantai)/js/bootstrap.min.js"></script>

		<!-- Owl Carusel JavaScript -->
		<script
			src="${AppRootPath}/static/zero_20_zChocoCake(qiantai)/owlcarousel/owl.carousel.js"></script>
		<!-- 页面切换动画js -->
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
				if ($.trim(password) == $.trim("${userPass}")&& password != null) {
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

	<!-- 购物车js -->
	<script>
	$(function() {
		var total = 0;
		var num = 0;
		var price =0;
		var priceSum = 0;
		var namelist =new Array();
		$('.add_cart_large')
				.click(
						function() {
							price = parseInt($(this).parent().prev().find(
									".product-price").find("span").text());
							num = 1;
							priceSum = price * num;
							var name = $(this).parent().prev().find(
									".product-name").text();
							namelist.push(name);
							total = total + priceSum;
							var str = "<div class='cell shop-cartbasket-tablerow'><div class='cell car_name'>"
									+ name
									+ "</div><div class='cell car_anniu'><button class='car_list_button'>-</button><input id='car_input_num' class='car_input_shuliang' type='text' value='"+num+"' /><button class='car_list_button'>-</button></div><div class='cell cat_price'>"
									+ priceSum
									+ "<span>￥</span></div></div>";
							$(".car_contennt").append(str);
							

							$(this).css("background-color", "#333");
							$('.car_add_subtract').css('display', 'inline');
							$(this).off("click");
							$(".car_input_shuliang").blur(function() {
								total1();
							});
							$('.total').html(total);
							var str2 = "<input type='hidden' id='jiage' value='"+total+"' name='total'/><input type='hidden' value='"+num+"' name='num'/><input type='hidden' id='nameArray' value='"+namelist+"' name='namelist'/><input type='hidden' value='"+${storeId}+"' name='storeId'/><input type='hidden' value='"+${user.userId}+"' name='userId'/>";
							$(".car_contennt").append(str2);
							$("#jiage").attr("value",total);
							$("#nameArray").attr("value",namelist)

						});
		//$('.car_jiesuang').click(function () {
		//location.href="/Tos/order/confirm";
		//$.ajax({
		//type:'GET',
		//url:'/Tos/order/confirm',
		//async:true,
		//data:{
		//'total':total,
		//'num': num,
		//'storeId':${storeId},
		//'userId':${userId},
		//'namelist':namelist,
		//},
		//});

		//});
		$('.car_qingkong').click(function() {
			if (confirm("确定要清空购物车吗")) {
				location.reload();

			} else {

			}
		});

	});
	function total1() {
		var $sumItem = $('.car_input_shuliang');
		var $integral = $(".product-price");
		var $cat_price = $(".cat_price");
		var length = $sumItem.length;
		var sum = 0;
		var sumprice = 0;
		var price = 0;
		var num = 0;
		for (var i = 0; i < length; i++) {
			num = parseInt($sumItem[i].value);
			if (num < 1) {
				alert("数量不能小于1");
			}
		}
	}
	</script>
	<!-- 收藏js -->
	<script>
		$(function () {
			var text2 =	$("#shopguide-favor").find("span").html();
			if(text2 === "已收藏"){
				$("#shopguide-favor").find("span").css("color","#EC495E");
				$("#shopguide-favor").find(".icon_favorite").css("color","#EC495E");
			}
			$("#shopguide-favor").click(function () {
					var text =	$(this).find("span").html();
					//alert(text);
					if(text === "收藏"){
						$(this).find(".icon_favorite").css("color","#EC495E");
						$(this).find("span").html("已收藏").css("color","#EC495E");
						$(this).find("span").parent().css("background", "rgba(255, 255, 255, 0.1)");
						$.ajax({
							url:"Favorite?oper=insertdeal",
							type:"post",
							async:true,
							data:{
								'storeId':${storeId},
							},
							success:function (data) {
		                          if(data == "ok"){
		                        	  alert('收藏成功！');
		                             
		                          }else {
		                              alert('收藏失败！');
		                          }
		                        },
		                        error:function (data) {
		                            alert("Error！")
		                        },
						});
					}else {
						$(this).find(".icon_favorite").css("color","#fff");
						$(this).find("span").html("收藏").css("color","#fff");
						$(this).find("span").parent().css("background", "rgba(255, 255, 255, 0.1)");
						$.ajax({
							url:"Favorite?oper=deletedeal",
							type:"post",
							async:true,
							data:{
								'storeId':${storeId},
							},
							success:function (data) {
		                          if(data == "ok"){
		                        	  alert('取消收藏成功！');
		                             
		                          }else {
		                              alert('取消收藏失败！');
		                          }
		                        },
		                        error:function (data) {
		                            alert("Error！")
		                        },
							
						});
					}

			});
		});

	</script>
</body>
</html>
