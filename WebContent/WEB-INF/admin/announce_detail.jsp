<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>外卖订单系统 - 公告管理 - 公告详情</title>
<%@ include file="_link.jsp"%>

<style type="text/css">
table.gridtable {
	margin-left: 80px;
	width: 80%;
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
	width: 80%;
}

table.gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}

table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
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
						<li><a href="Announce?oper=list">公告列表</a></li>
						<li class="active"><a style="cursor: pointer">公告详情</a></li>
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
				<!-- Breadcrumbs line -->
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

						<!-- Headings, standard font -->
						<div class="widget">
							<div class="navbar">
								<div class="navbar-inner">
									<h6>公告详情</h6>
								</div>
							</div>
							<div class="well body">

								<h1 style="margin-top: 0;">
									公告标题 - 【${title}】
								<br>
								&nbsp;&nbsp;&nbsp;&nbsp;<small>创建于:${createOn}</small>
									&nbsp;&nbsp;&nbsp;&nbsp;
									<c:if test="${not empty updateOn}">
										<small>最近修改:${updateOn}</small>
									</c:if>
								</h1>


							</div>
							<!-- 内容 -->

							<div class="navbar">
								<div class="navbar-inner">
									<h6>公告内容</h6>
								</div>
							</div>
							<div class="well body">
								<p style="font-size: 20px;" class="sans">${content}</p>
								<p>${content}</p>
								<img src="${AppRootPath}${picPath}">
							</div>

							<!-- /内容 -->
						</div>
						<!-- /headings, standard font -->

					</div>
					<!-- /column -->

				</div>
				<!-- /headings -->

			</div>


		</div>
		<!-- /content wrapper -->

	</div>
	<!-- /content -->

	<!-- /content container -->


	<!-- Footer -->
	<%@ include file="_footer.jsp"%>
	<!-- /footer -->


</body>
</html>
