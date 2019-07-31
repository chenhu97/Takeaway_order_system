<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>mb</title>
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
			<!-- Content wrapper 内容 -->
			    <!-- Breadcrumbs line -->
			    <div class="crumbs">
		            <ul id="breadcrumbs" class="breadcrumb">
		                <li><a href="index.html">Dashboard</a></li>
		                <li class="active"><a href="calendar.html" title="">Calendar</a></li>
		            </ul>

		            <ul class="alt-buttons">
		                <li><a href="#" title=""><i class="icon-signal"></i><span>Stats</span></a></li>
		                <li><a href="#" title=""><i class="icon-comments"></i><span>Messages</span></a></li>
		                <li class="dropdown"><a href="#" title="" data-toggle="dropdown"><i class="icon-tasks"></i><span>Tasks</span> <strong>(+16)</strong></a>
		                	<ul class="dropdown-menu pull-right">
		                        <li><a href="#" title=""><i class="icon-plus"></i>Add new task</a></li>
		                        <li><a href="#" title=""><i class="icon-reorder"></i>Statement</a></li>
		                        <li><a href="#" title=""><i class="icon-cog"></i>Settings</a></li>
		                	</ul>
		                </li>
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
			    			<div id="total-visits" class="chart">10,14,8,45,23,41,22,31,19,12, 28, 21, 24, 20</div>
			    		</li>
			    		<li>
			    			<div class="showcase">
			    				<span>My balance</span>
			    				<h2>$16.290</h2>
			    			</div>
			    			<div id="balance" class="chart">10,14,8,45,23,41,22,31,19,12, 28, 21, 24, 20</div>
			    		</li>
			    	</ul>
			    </div>
			    <!-- /page header -->
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
