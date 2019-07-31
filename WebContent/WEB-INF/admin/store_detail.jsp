<%@page import="com.sun.javafx.fxml.BeanAdapter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>外卖订单系统 - 店铺管理 - 店铺详情</title>
<%@ include file="_link.jsp"%>
</head>
<body>

	<!-- Fixed top -->
	<%@ include file="_top.jsp"%>
	<!-- /fixed top -->


	<!-- Content container -->
	<div id="container">

		<!-- Sidebar 左侧导航 -->
		<%@ include file="_nav.jsp"%>
		<!-- /sidebar -->

		<!-- Content -->
		<div id="content">
			<!-- Content wrapper -->
			<div class="wrapper">
				<!-- Breadcrumbs line -->
				<div class="crumbs">
					<ul id="breadcrumbs" class="breadcrumb">
						<li><a href="Main"> 主页面</a></li>
						<li><a href="Store?oper=list"> 店铺列表</a></li>
						<li class="active"><a style="cursor: pointer">店铺详情</a></li>
					</ul>

					<ul class="alt-buttons">
						<li><a href="#" title=""><i class="icon-signal"></i><span>Stats</span></a></li>
						<li><a href="#" title=""><i class="icon-comments"></i><span>Messages</span></a></li>
						<li class="dropdown"><a href="#" title=""
							data-toggle="dropdown"><i class="icon-tasks"></i><span>Tasks</span>
								<strong>(+16)</strong></a>
							<ul class="dropdown-menu ">
								<li><a href="#" title=""><i class="icon-plus"></i>Add
										new task</a></li>
								<li><a href="#" title=""><i class="icon-reorder"></i>Statement</a></li>
								<li><a href="#" title=""><i class="icon-cog"></i>Settings</a></li>
							</ul></li>
					</ul>
				</div>
				<!-- /breadcrumbs line -->


				<hr />
				<div class="mainbar">
					<div class="post_list">
						<div
							style="font-size: 35px; margin-top: 10px;; font-family: 宋体; font-weight: bold">

							<span>店名:</span><span>${bean.storeName}(${bean.address})<br /></span>
							<div
								style="padding-top: 40px; font-size: 15px; font-weight: bold">
								商家公告： ${bean.announce}</div>
							<br />
						</div>


						<div style="border-bottom: 3px solid #4dc9dc;"></div>
						<div style="padding-top: 40px; font-size: 15px; font-weight: bold">商家信息：</div>

						<c:if
							test="${not empty bean.storePic && fn:length(bean.storePic)>0}">
							<img alt="商品图片"
								src="${pageContext.request.contextPath}${bean.storePic}" />
						</c:if>
						<c:if
							test="${ empty item.storePic && fn:length(item.storePic)<=0}">
							<img alt="商品图片"
								src="${AppRootPath}/static/zero_20_zChocoCake(qiantai)/images/1.jpg" />
						</c:if>
					</div>

					<div style="padding-top: 40px; font-size: 15px; font-weight: bold">
						商家分类： ${bean.storeCatName}
						<hr style="border-bottom: 1px solid" />
						<br />
					</div>
					<div style="padding-top: 40px; font-size: 15px; font-weight: bold">
						商家地址： ${bean.address}
						<hr style="border-bottom: 1px solid" />
						<br />
					</div>
					<div style="padding-top: 40px; font-size: 15px; font-weight: bold">
						经营人： ${bean.storeBoss}
						<hr style="border-bottom: 1px solid" />
						<br />
					</div>
					<div style="padding-top: 40px; font-size: 15px; font-weight: bold">

						商家品类： ${bean.storeCatId}

						<div style="padding-top: 40px; font-size: 15px; font-weight: bold">

							商家电话： ${bean.phone}

							<hr style="border-bottom: 1px solid" />
							<br />
						</div>

					</div>


				</div>
				<!-- /content wrapper -->

			</div>
			<!-- /content -->
		</div>
		<!-- /content container -->

		<!-- Footer -->
		<%@ include file="_footer.jsp"%>
		<!-- /footer -->
</body>
</html>
