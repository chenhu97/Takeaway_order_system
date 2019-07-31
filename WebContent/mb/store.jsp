<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>外卖订单系统 - 店铺管理</title>
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

			<div class="widget">
				<div class="navbar">
					<div class="navbar-inner">
						<h6>店铺列表</h6>
					</div>
				</div>
				<form action="Article" method="get" id="listform">
					<div class="text-c">
						<input type="hidden" name="oper" value="listdeal" /><input
							type="text" style="width: 250px" placeholder="输入类目名称" id=""
							name="catName" value="${catName}">
						<button type="submit" class="btn btn-success radius" id="search"
							name="search">搜索</button>
						<button type="reset" class="btn btn-success radius"
							onclick="javascript:location.href='Article?oper=list';">清除</button>

					</div>



				</form>
				<div class="cl pd-5 bg-1 bk-gray mt-20">
					<span class="l"><button onclick="javascript:datadel()"
							class="btn btn-danger radius ">批量删除</button>
						<button onclick="javascript:location.href='Article?oper=insert';"
							class="btn btn-primary radius">添加文章</button> </span>


				</div>
				<div class="table-overflow">
					<table class="table table-hover" id="dataList">
						<thead>
							<tr>

								<th width="50"><input type="checkbox" name="checkall"
									id="checkall" class="checkall" value=""></input></th>
								<th>店面</th>
								<th>店铺编号</th>
								<th>店面</th>
								<th>店铺名称</th>
								<th>店铺地址</th>
								<th>联系电话</th>
								<th>店铺类别</th>
								<th>状态</th>
								<th>联系电话</th>
								<th width="200">操作</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input type="checkbox" value=""></input></td>
								<td>Mark</td>
								<td>Otto</td>
								<td>@mdo</td>
								<td>@mdo</td>
								<td>Otto</td>
								<td>@mdo</td>
								<td>@mdo</td>
								<td>Mark</td>
								<td>Mark</td>
								<td><a href="Article?oper=update&id=${bean.articleId}"><i
											class="icon-pencil">编辑&nbsp;&nbsp;</i></a> <a href="javascript:"
										onclick="item_del(this, ${bean.articleId})"> <i
											class="icon-remove"> 删除&nbsp;&nbsp;&nbsp;</i>
									</a> <a href="Article?oper=detail&id=${bean.articleId}"><i
											class="icon-detail">查看</i></a></td>

								</tr>
						</tbody>
						
					</table>
					
				</div>
			</div>
			<!-- /table hover -->

		</div>
		<!-- /content -->

	</div>
	<!-- /content container -->


	<!-- Footer -->
	<%@ include file="_footer.jsp"%>
	<!-- /footer -->

	<script type="text/javascript">
	jQuery(function() {
		jQuery("#checkall").change(function() {
			var $otherCheckList = $("input:checkbox:not('#checkall')");
			var checkAllState = $("#checkall").prop("checked");
			$otherCheckList.prop("checked", checkAllState);
		});
	});
</script>
</body>
</html>
