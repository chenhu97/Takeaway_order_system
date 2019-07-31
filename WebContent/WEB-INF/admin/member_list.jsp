<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>外卖订单系统 - 用户列表</title>
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
						<li class="active"><a href="Member?oper=list">用户列表</a></li>
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
				<!-- Search widget -->
				<form class="search widget" action="Member" id="listform"
					method="post">
					<input type="hidden" name="oper" value="listdeal" />
					<div class="autocomplete-append">
						<input type="text" placeholder="根据地址进行搜索" id="search"
							name="search" value="" ${search} /> <input type="submit"
							class="btn" value="搜索" /> <input type="reset" class="btn"
							value="重置" onclick="location.href='Member?oper=list'" />
					</div>
				</form>
				<!-- /search widget -->
				<!-- Table hover -->
				<div class="widget">
					<div class="navbar">
						<div class="navbar-inner">
							<h6>${search}用户列表</h6>
							<input type="button" class="btn" value="批量禁用"
								onclick="javascript:datadel()" />
						</div>
					</div>
					<div class="table-overflow">
						<table class="table">
							<thead>
								<tr>
									<th width="50"><input type="checkbox" name="checkall"
										id="checkall" class="checkall" value=""></input></th>
									<th>用户序号</th>
									<th>用户昵称</th>
									<th>用户姓名</th>
									<th>常用地址</th>
									<th>用户创建时间</th>
									<th>&nbsp;&nbsp;操作&nbsp;&nbsp;</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="bean" items="${DataList}" varStatus="i">
									<tr>
										<td><input type="checkbox" name="checkRow" class="styled"
											value="${bean.userId}" /></td>
										<td>${i.count}</td>
										<td>${bean.nickName}</td>
										<td>${bean.userName}</td>
										<td>${bean.address}</td>
										<td>${bean.createOn}</td>
										<td><a class="btn btn-info"
											href="Member?oper=detail&id=${bean.userId}"> <i
												class="ico-eye-open"></i> &nbsp;&nbsp;查看
										</a> <a class="btn btn-danger" href="javascript:"
											onclick="item_del(this, ${bean.userId})"> <i
												class="ico-trash"> </i> &nbsp;&nbsp;禁用
										</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<!-- /Table hover -->
				<jsp:include page="__pager.jsp" flush="true"></jsp:include>
			
			</div>
			<!-- /content wrapper -->

		</div>
		<!-- /content -->

	</div>
	<!-- /content container -->


	<!-- Footer -->
	<%@ include file="_footer.jsp"%>
	<!-- /footer -->
	<script>
		//单项删除
		function item_del(obj,id){
			if(confirm('确定要禁用吗?')){
				$.ajax({
					type : 'POST',
					url : 'Member?oper=deleteDeal&id=' + id,
					success : function(data){
						if(data == 'ok'){
							$(obj).parents("tr").remove();
							alert('已禁用用户。');
						}else{
							alert('禁用失败!');
						}
					},
					error : function(data){
						
					},
				});
			}
		};
		//ajax实现批量删除
		function datadel(){
			if(confirm('是否确定执行批量禁用功能吗?')){
				var num = 0;
				var total = 0;
				var obj = null;
				var id = 0;
				var $otherCheckedList = $("input:checkbox:checked:not(#checkall)");
				
			$otherCheckedList.each(function(){
					obj = this;
					id = $(this).val();
					if(id != null && id != "" && id != "0"){
						total++;
						$.ajax({
							type : 'POST',
							url : 'Member',
							async : false,
							data : {"oper":"deletedeal","id":id},
							success : function(data){
								if(data == 'ok'){
									$(obj).parents("tr").remove();
									num++;
								}else{
									alert('禁用失败');
									return;
								}
							},
							error : function(data){
								alert('错误！');
							},
							
						});
					}
				});
				alert("要禁用" + total+"行记录,成功禁用" + num + "行记录。");
				location.reload();
			}
		};
	</script>
</body>
</html>
