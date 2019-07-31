<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>个人店铺管理</title>
<%@ include file="_store_link.jsp"%>
<style type="text/css">
	.table-overflow .Fisrt{
		margin-right:20px;
	}
	#shangchu{
		width: 60px;
		
	}
	#reset{
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
								<form class="navbar-search pull-left input-append"
									action="FoodCat" method="get">
									<input type="hidden" name="oper" value="listdeal" /> <input
										type="text" class="span3" name="catName"
										placeholder="search catName...">

									<button class="btn" type="submit" id="sousuo">
										<i class="icon-search"></i>
									</button>
									<input type="reset" class="btn" value="清空" id="reset"
										onclick="javascript:location.href='FoodCat?oper=list';" />
									<input class="btn btn-warning" id="shangchu" onclick="javascript:datadel()" value="全选删除"/>
									<a class="btn btn-primary"
										onclick="javascript:location.href='FoodCat?oper=insert';">添加</a>
								</form>
								
								<table class="table table-striped table-bordered"
									id="data-table">

									<thead>
										<tr>
											<th><input type="checkbox" name="checkall" id="checkall"
												class="checkall" value=""></input></th>
											<th>菜品类目id</th>
											<th>类目名称</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="bean" items="${DataList}" varStatus="status">
											<tr>
												<td><input type="checkbox" name="checkbox"
													value="${bean.catId}"></input></td>
												<td>${bean.catId}</td>
												<td>${bean.catName}</td>
												<td><a class="btn btn-success"
													href="FoodCat?oper=update&id=${bean.catId}"><i></i>&nbsp;&nbsp;编辑</a>
													<a class="btn btn-danger" href="javascript:"
													onclick="item_del(this, ${bean.catId})"> <i
														class="ico-trash"> </i>&nbsp;&nbsp;删除
												</a> <a class="btn btn-info"
													href="FoodCat?oper=detail&id=${bean.catId}"><i
														class="ico-eye-open"></i>&nbsp;&nbsp;查看</a></td>


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
			<!--/.container-->
		</div>
	</div>
	<!--/.wrapper-->
	<div class="footer" style="margin-left: 300px;">
		<div class="container">
			<b class="copyright">&copy; 20119 personalStore </b>Deal<a href="#"
				target="_blank">店长管理店铺</a>
		</div>
	</div>
	<script type="text/javascript">
	jQuery(function() {
		jQuery("#checkall").change(function() {
			var $otherCheckList = $("input:checkbox:not('#checkall')");
			var checkAllState = $("#checkall").prop("checked");
			$otherCheckList.prop("checked", checkAllState);
		});
	});
</script>
	<script type="text/javascript">
	function item_del(obj, id) {
		if (confirm('确认要删除吗？')) {
			$.ajax({
				type : 'POST',
				url : 'FoodCat?oper=deleteDeal&id=' + id,
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
</script>
	<script type="text/javascript">
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
					url : "FoodCat",
					async : false,// 要使用同步
					data : {"oper":"deleteDeal","id" : id},
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