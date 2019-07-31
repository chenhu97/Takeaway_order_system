<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>外卖订单系统 - 管理员信息管理 - 列表</title>
<%@ include file="_link.jsp"%>
<style>
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
			<!-- Content wrapper -->
			<div class="wrapper">
				<!-- Breadcrumbs line -->
				<div class="crumbs">
					<ul id="breadcrumbs" class="breadcrumb">
						<li><a href="Main">主页面</a></li>
						<li><a href="Admin?oper=list">管理员列表</a></li>
						<li class="active"><a style="cursor: pointer">添加</a></li>
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

				<!-- Form validation -->
				<h5 class="widget-name">
					<i class="icon-ok"></i>添加管理员
				</h5>
				<form id="validate" class="form-horizontal" action="Admin">
					<input type="hidden" class="btn" name="oper" value="insert" />
					<fieldset>
						<!-- Form validation -->
						<div class="widget">
							<div class="navbar">
								<div class="navbar-inner">
									<h6>添加表单</h6>
								</div>
							</div>
							<div class="well row-fluid">

								<div class="control-group">
									<label class="control-label">管理员名称: <span
										class="text-error">*</span></label>
									<div class="controls">
										<input type="text" class="validate[required] span12"
											name="adminName" id="req" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">管理员密码: <span
										class="text-error">*</span></label>
									<div class="controls">
										<input type="text" class="validate[required] span12"
											name="adminPass" id="req" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">管理员性别: <span
										class="text-error">*</span></label>
									<div class="controls">
										<input type="text" class="validate[required] span12"
											name="adminSex" id="req" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">管理员联系方式: <span
										class="text-error">*</span></label>
									<div class="controls">
										<input type="text" class="validate[required] span12"
											name="phone" id="req" />
									</div>
								</div>


								<div class="form-actions align-right">
									<button type="submit" class="btn btn-info">提交</button>
									<button type="reset" class="btn">重置</button>
								</div>

							</div>

						</div>
						<!-- /form validation -->

					</fieldset>
				</form>
				<!-- /form validation -->

			</div>
			<!-- /content wrapper -->

		</div>
		<!-- /content -->

	</div>
	<!-- /content container -->


	<!-- Footer -->
	<jsp:include page="_footer.jsp" flush="true" />
	<!-- /footer -->


</body>
</html>
