<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>主页面</title>
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
						<li class="active"><a style="cursor: pointer">导航</a></li>
					</ul>

					<ul class="alt-buttons">
						<li><a href="#" title=""><i class="icon-signal"></i><span>Stats</span></a></li>
						<li><a href="#" title=""><i class="icon-comments"></i><span>Messages</span></a></li>
						<li class="dropdown"><a href="#" title=""
							data-toggle="dropdown"><i class="icon-tasks"></i><span>Tasks</span>
								<strong>(+16)</strong></a>
							<ul class="dropdown-menu pull-right">
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

				<!-- Action tabs -->
				<div class="actions-wrapper">
					<div class="actions">

						<div id="user-stats">
							<ul class="round-buttons">
								<li><div class="depth">
										<a href="" title="Add new post" class="tip"><i
											class="icon-plus"></i></a>
									</div></li>
								<li><div class="depth">
										<a href="" title="View statement" class="tip"><i
											class="icon-signal"></i></a>
									</div></li>
								<li><div class="depth">
										<a href="" title="Media posts" class="tip"><i
											class="icon-reorder"></i></a>
									</div></li>
								<li><div class="depth">
										<a href="" title="RSS feed" class="tip"><i
											class="icon-rss"></i></a>
									</div></li>
								<li><div class="depth">
										<a href="" title="Create new task" class="tip"><i
											class="icon-tasks"></i></a>
									</div></li>
								<li><div class="depth">
										<a href="" title="Layout settings" class="tip"><i
											class="icon-cogs"></i></a>
									</div></li>
							</ul>
						</div>

						<div id="quick-actions">
							<ul class="statistics">
								<li>
									<div class="top-info">
										<a href="#" title="" class="blue-square"><i
											class="icon-plus"></i></a> <strong>12,476</strong>
									</div>
									<div class="progress progress-micro">
										<div class="bar" style="width: 60%;"></div>
									</div> <span>User registrations</span>
								</li>
								<li>
									<div class="top-info">
										<a href="#" title="" class="red-square"><i
											class="icon-hand-up"></i></a> <strong>621,873</strong>
									</div>
									<div class="progress progress-micro">
										<div class="bar" style="width: 20%;"></div>
									</div> <span>Total clicks</span>
								</li>
								<li>
									<div class="top-info">
										<a href="#" title="" class="purple-square"><i
											class="icon-shopping-cart"></i></a> <strong>562</strong>
									</div>
									<div class="progress progress-micro">
										<div class="bar" style="width: 90%;"></div>
									</div> <span>New orders</span>
								</li>
								<li>
									<div class="top-info">
										<a href="#" title="" class="green-square"><i
											class="icon-ok"></i></a> <strong>$45,360</strong>
									</div>
									<div class="progress progress-micro">
										<div class="bar" style="width: 70%;"></div>
									</div> <span>General balance</span>
								</li>
								<li>
									<div class="top-info">
										<a href="#" title="" class="sea-square"><i
											class="icon-group"></i></a> <strong>562K+</strong>
									</div>
									<div class="progress progress-micro">
										<div class="bar" style="width: 50%;"></div>
									</div> <span>Total users</span>
								</li>
								<li>
									<div class="top-info">
										<a href="#" title="" class="dark-blue-square"><i
											class="icon-facebook"></i></a> <strong>36,290</strong>
									</div>
									<div class="progress progress-micro">
										<div class="bar" style="width: 93%;"></div>
									</div> <span>Facebook fans</span>
								</li>
							</ul>
						</div>

						<div id="map">
							<div id="google-map"></div>
						</div>

						<ul class="action-tabs">
							<li><a href="#user-stats" title="">Quick actions</a></li>
							<li><a href="#quick-actions" title="">Website statistics</a></li>
							<li><a href="#map" title="" id="map-link">Google map</a></li>
						</ul>
					</div>
				</div>
				<!-- /action tabs -->
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
