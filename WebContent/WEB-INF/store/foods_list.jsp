<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>个人店铺管理 - 菜品管理 - 菜品列表</title>
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

								<form class="navbar-search pull-left input-append"
									action="Foods">
									<input type="hidden" name="oper" value="listDeal" /> <a
										class="btn" href="javascript:datadel()"><span class="icon-minus"></span></a> <a
										href="Foods?oper=insert" class="btn"><span
										class="icon-plus"></span></a> 
									<input type="text" class="span3" name="search" placeholder="请输入商品名称">
									<button class="btn" type="submit" id="search">
										<i class="icon-search"></i>
									</button>
									<button class="btn" type="reset"
										onclick="javascript:location.href='Foods?oper=list'">
										<i class="icon-repeat"></i>
									</button>
								</form>
								<table class="table table-striped table-bordered"
									id="data-table">

									<thead>
										<tr>
											<th><input type="checkbox" name="checkall" id="checkall"
												class="checkall" value=""></input></th>
											<th>菜品序号</th>
											<th>图片</th>
											<th>菜品类目</th>
											<th>菜品名称</th>
											<th>备注</th>
											<th>价格</th>
											<th>创建时间</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${DataList}" varStatus="i">
											<tr>
												<td><input type="checkbox" name="checkbox"
													value="${item.foodId}"></input></td>
												<td>${i.count}</td>
												<td><c:if test="${not empty item.picPath && fn:length(item.picPath)>0}">
														<img alt="商品图片" style="width: 80px; height: 80px;"
															src="${pageContext.request.contextPath}${item.picPath}" />
													</c:if></td>
												<td>${item.catName}</td>
												<td>${item.foodName}</td>
												<td>${item.remark}</td>
												<td>${item.price}</td>
												<td>${item.createOn}</td>
												<td><a class="btn"
													href="Foods?oper=update&id=${item.foodId}"><i
														class="icon-edit"></i>编辑</a> <a class="btn"
													href="javascript:" onclick="item_del(this, ${item.foodId})">
														<i class="icon-trash"> </i>&nbsp;&nbsp;删除
												</a> <%-- <a class="btn btn-info"
													href="Foods?oper=detail&id=${item.foodId}"><i
														class="ico-eye-open"></i>&nbsp;&nbsp;查看</a> --%></td>
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
			<b class="copyright">&copy; 20119 personalStore </b>Deal<a href="#"
				target="_blank">店长管理店铺</a>
		</div>
	</div>
	<script>
	function item_del(obj, id) {
		if (confirm('确认要删除吗？')) {
			$.ajax({
				type : 'POST',
				url : 'Foods?oper=delete&id=' + id,
				//dataType : 'json',
				success : function(data) {
					if (data == "ok") {
						$(obj).parents("tr").remove();
						alert('已删除!');
					} else {
						alert('删除失败!');
					}
				},
				error : function(data) {
				},
			});
		}
		;
	}
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
					url : "Foods",
					async : false,// 要使用同步
					data : {"oper":"delete","id" : id},
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
		alert('要删除'+total+'行记录，成功删除'+num+'行记录');
		location.reload();
	}
}
</script>
</body>
</html>



