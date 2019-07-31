<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>个人店铺管理 - 订单管理 - 已完成订单列表</title>
<%@ include file="_store_link.jsp"%>
</head>
<body>
	<%@ include file="_store_top.jsp"%>
	<div class="wrapper">
		<div class="container">
			<div class="row">
				<%@ include file="_store_nav.jsp"%>
				<!--/.span3-->
				<!-- 主要内容 -->
				<div class="span9">
					<div class="content">
						<div class="widget">
							<div class="table-overflow">


								<table class="table table-striped table-bordered"
									id="data-table">

									<thead>
										<tr>
											<th><input type="checkbox" name="checkall" id="checkall"
												class="checkall" value=""></input></th>
											<th>订单序号</th>
											<th>用户名称</th>
											<th>联系方式</th>
											<th>收货地址</th>
											<th>备注</th>
											<th>下单时间</th>
											<th>状态</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${OrderList}" varStatus="i">

											<tr>
												<td><input type="checkbox" name="checkbox"
													value="${item.orderId}"></input></td>
												<td>${i.count}</td>
												<td>${item.nickName}</td>
												<td>${item.phone}</td>
												<td>${item.address}</td>
												<td>${item.remark}</td>
												<td>${item.createOn}</td>
												<c:if test="${item.status eq 1 }">
													<td>已完成</td>
												</c:if>
												<c:if test="${item.status eq 2 }">
													<td>已退单</td>
												</c:if>												

											</tr>

										</c:forEach>
									</tbody>
								</table>

							</div>
						</div>
						<%@include file="__pager.jsp"%>
						<!--/.content-->
					</div>
					<!--/.span9-->
				</div>
			</div>
		</div>
		<!--/.container-->
	</div>
	<!--/.wrapper-->
	<div class="footer" style="margin-left: 300px;">
		<div class="container">
			<b class="copyright">&copy; 20119 personalStore </b>@<a href="#"
				target="_blank">店长查看已完成订单</a>
		</div>
	</div>
	<script>
		function datadel() {
			if (confirm("真的要删除吗？")) {
				var num = 0;// 记录删除成功的行数
				var total = 0;// 记录要删除的行数
				var obj = null;// 记录当前对象
				var $otherCheckedList = jQuery("input:checkbox:checked:not('#checkall')");
				// 迭代所有已选中框
				$otherCheckedList.each(function() {
					obj = this;
					var id = $(this).val();
					if (id != null && id != "" && id != "0") {
						total++;
						$.ajax({
							type : 'POST',
							url : "Order",
							async : false,// 要使用同步
							data : {
								"oper" : "delete",
								"id" : id
							},
							success : function(data) {
								if (data == "ok") {
									num++;
								} else {
									alert("删除失败");
								}
							},
							error : function(data) {
								alert("Error");
							},
						});
					}
				});
				alert('要拒绝接单' + total + '行记录，成功拒接' + num + '行记录');
				location.reload();
			}
		}
	</script>
</body>
</html>



