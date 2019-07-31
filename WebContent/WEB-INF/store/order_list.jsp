<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>个人店铺管理 - 订单管理 - 订单列表</title>
<%@ include file="_store_link.jsp"%>

<%@ include file="_store_link.jsp"%>
<style type="text/css">
.table-overflow .Fisrt {
	margin-right: 20px;
}

#shangchu {
	width: 60px;
}

#reset {
	margin-right: 10px;
}
</style>

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
											<th>内容</th>
											<th>下单时间</th>
											<th>状态</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="item" items="${OrderList}" varStatus="i">
											<c:if test="${item.status eq -1 }">
												<tr>
													<td><input type="checkbox" name="checkbox"
														value="${item.orderId}"></input></td>
													<td>${i.count}</td>
													<td>${item.nickName}</td>
													<td>${item.phone}</td>
													<td>${item.address}</td>
													<td>${item.remark}</td>
													<td>${foodNameList.get(i.index)}</td>
													<td>${item.createOn}</td>
													<td>未接单</td>

													<td><a class="btn"
														href="Order?oper=receiveDeal&id=${item.orderId}"> <i
															class="icon-edit"></i>&nbsp;&nbsp;接单
													</a> <a class="btn"
														href="Order?oper=refuseDeal&id=${item.orderId}"> <i
															class="icon-trash"> </i>&nbsp;&nbsp;拒接
													</a> <%-- <a class="btn btn-info"
													href="Foods?oper=detail&id=${item.foodId}"><i
														class="ico-eye-open"></i>&nbsp;&nbsp;查看</a> --%></td>
												</tr>
											</c:if>
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
				target="_blank">店长管理订单</a>
		</div>
	</div>

</body>
</html>



