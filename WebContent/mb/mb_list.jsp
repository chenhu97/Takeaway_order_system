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
	.search input[type=text]{
		width: 88%;
	}
	.search-options {
    position: absolute;
    right: 130px;
    top: 7px;
    background: white;
    }
    .search input[type=submit]{
    position: absolute;
    top: -2px;
    right: 60px;
    padding: 10px 13px 9px 13px;
    line-height: 13px;
    }
    .search input[type=reset]{
     position: absolute;
    top: -2px;
    right: 0px;
    padding: 10px 13px 9px 13px;
    line-height: 13px;
    }
    .navbar .btn {
    	float: right;
    }
    .table th, .table td {
    padding: 8px 35px;
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
		 <!-- Content wrapper -->
		    <div class="wrapper">
			<!-- Breadcrumbs line -->
		    <div class="crumbs">
	            <ul id="breadcrumbs" class="breadcrumb">
	                <li><a href="index.html">main</a></li>
	                <li class="active"><a href="calendar.html" title="">管理员列表</a></li>
	            </ul>

	            <ul class="alt-buttons">
	                <li><a href="#" title=""><i class="icon-signal"></i><span>Stats</span></a></li>
	                <li><a href="#" title=""><i class="icon-comments"></i><span>Messages</span></a></li>
	                <li class="dropdown"><a href="#" title="" data-toggle="dropdown"><i class="icon-tasks"></i><span>Tasks</span> <strong>(+16)</strong></a>
	                	<ul class="dropdown-menu ">
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
			<!-- Search widget -->
		    	<form class="search widget" action="#">
		    		<div class="autocomplete-append">
			    		<ul class="search-options">
			    			<li><a href="#" title="Go to search page" class="go-option tip"></a></li>
			    			<li><a href="#" title="Advanced search" class="advanced-option tip"></a></li>
			    			<li><a href="#" title="Settings" class="settings-option tip"></a></li>
			    		</ul>
			    		<input type="text" placeholder="search website..." id="autocomplete" />
			    		<input type="submit" class="btn" value="搜索" />
			    		<input type="reset" class="btn" value="清空" />
			    	</div>
		    	</form>
		    	<!-- /search widget -->
		   
			<!-- Table hover -->
			<div class="widget">
				<div class="navbar"><div class="navbar-inner"><h6>管理员列表</h6>
					<input type="button" class="btn" value="批量删除" />
					<input type="button" class="btn" value="添加" />
				</div></div>
				<div class="table-overflow">
					<table class="table table-hover">
						<thead>
							<tr>
								<th width="50"><input type="checkbox" name="checkall"id="checkall" class="checkall" value=""></input></th>
								<th>#</th>
								<th>管理员编号</th>
								<th>管理员名称</th>
								<th>管理员性别</th>
								<th>管理员联系方式</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="bean" items="${DataList}" varStatus="status">
							
							<tr>
							<td><input type="checkbox" name="checkbox"value="${bean.adminId}"></input></td>
								<td>${status.count }</td>
								<td>${bean.adminId }</td>
								<td>${bean.adminName }</td>
								<td>${bean.adminSex }</td>
								<td>${bean.phone }</td>
								<td>
								<a class="btn btn-success" href="Admin?oper=update&id=${bean.adminId}"><i class="icon-pencil"></i>&nbsp;&nbsp;编辑</a>
								<a class="btn btn-danger" href="javascript:"onclick="item_del(this, ${bean.adminId})"> <i class="ico-trash"> </i>&nbsp;&nbsp;删除</a>
								<a class="btn btn-info" href="Admin?oper=detail&id=${bean.adminId}"><i class="ico-eye-open"></i>&nbsp;&nbsp;查看</a></td>
								
							</tr>
						   </c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<!-- /table hover -->
			<jsp:include page="__pager.jsp" flush="true"/>
			 </div>
			<!-- /content wrapper -->
			
		</div>
		<!-- /content -->
		
	</div>
	<!-- /content container -->
	
	
	<!-- Footer -->
	<jsp:include page="_footer.jsp" flush="true"/>
	<!-- /footer -->


</body>
</html>
