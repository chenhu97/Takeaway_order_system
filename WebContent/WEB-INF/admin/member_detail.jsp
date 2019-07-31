<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>外卖订单系统 - 用户列表 - 用户详情</title>
<%@ include file="_link.jsp"%>
<style>
.search input[type=text] {
	width: 88%;
}

.search-options {
	position: absolute;
	right: 130px;
	top: 7px;
	background: white;
}

.search input[type=submit] {
	position: absolute;
	top: -2px;
	right: 60px;
	padding: 10px 13px 9px 13px;
	line-height: 13px;
}

.search input[type=reset] {
	position: absolute;
	top: -2px;
	right: 0px;
	padding: 10px 13px 9px 13px;
	line-height: 13px;
}

.navbar .btn {
	float: right;
}
</style>
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
			<!-- Content wrapper 内容 -->
			<div class="wrapper">
				<!-- Breadcrumbs line -->
				<div class="crumbs">
					<ul id="breadcrumbs" class="breadcrumb">
						<li><a href="Main">主页面</a></li>
						<li><a href="Member?oper=list">用户列表</a></li>
						<li class="active"><a style="cursor: pointer">用户详情</a></li>
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
				<!-- Page header -->
				<div class="page-header">
					<div class="page-title">
						<h5>Dashboard</h5>
						<span>Good morning, Eugene!</span>
					</div>

					<ul class="page-stats">
						<li>
							<div class="showcase">
								<span>New visits</span>
								<h2>22.504</h2>
							</div>
							<div id="total-visits" class="chart">10,14,8,45,23,41,22,31,19,12,
								28, 21, 24, 20</div>
						</li>
						<li>
							<div class="showcase">
								<span>My balance</span>
								<h2>$16.290</h2>
							</div>
							<div id="balance" class="chart">10,14,8,45,23,41,22,31,19,12,
								28, 21, 24, 20</div>
						</li>
					</ul>
				</div>
				<!-- /page header -->

				<!-- Headings -->
				<div class="row-fluid">

					<!-- Column -->
					<div class="span6">
						<!-- Headings, content -->
						<div class="widget">
							<div class="navbar">
								<div class="navbar-inner">
									<h2>个人信息</h2>
								</div>
							</div>
							<div class="well body">

								<h3 style="margin-top: 0;">
									用户名:<span>${bean.userName}</span>
								</h3>
								<h3 style="margin-top: 0;">
									用户性别::<span>${bean.sex}</span>
								</h3>
								<h3 style="margin-top: 0;">
									联系方式:<span>${bean.phone}</span>
								</h3>
							</div>
						</div>
						<!-- /headings content-->
					</div>
					<!-- /column -->
				</div>
				<!-- /headings -->


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
