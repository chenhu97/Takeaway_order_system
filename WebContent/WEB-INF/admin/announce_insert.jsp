<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>外卖订单系统 - 公告管理 - 公告添加</title>
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
			<!-- Content wrapper 内容 -->
			<div class="wrapper">
				<!-- Breadcrumbs line -->
				<div class="crumbs">
					<ul id="breadcrumbs" class="breadcrumb">
						<li><a href="Main">主页面</a></li>
						<li><a href="Announce?oper=list">公告列表</a></li>
						<li class="active"><a style="cursor: pointer">公告添加</a></li>
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
				<form action="Announce?oper=insertDeal" method="post" id="tab"
					enctype="multipart/form-data">

					<div>
						<label>公告标题</label> <input type="text" class="input-xlarge"
							name="title">
					</div>
					<div>
						<label>图片路径</label> <input type="file" name="picPath">
					</div>
					<div>
						<label>公告内容</label>
						<textarea name="content"></textarea>
					</div>

					<div>
						<span style="color: red; font-weight: bold;">${msg}</span>
					</div>
					<div style="margin: 30px 0px 0px 30px">
						<input type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;"> <input
							type="reset" value="&nbsp;&nbsp;重置&nbsp;&nbsp;">
					</div>
				</form>


			</div>
			<!-- /Content wrapper 内容 -->

		</div>
		<!-- /content -->
	</div>
	<!-- /content container -->


	<!-- Footer -->
	<%@ include file="_footer.jsp"%>
	<!-- /footer -->


</body>
</html>
