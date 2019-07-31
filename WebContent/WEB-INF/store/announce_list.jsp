<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>外卖订单系统 - 公告管理 - 列表</title>
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
									<tr>
										<td>公告</td>
										<td>操作</td>
									</tr>
									<tr>
										<td>${announce}</td>
										<td><a class="btn btn-success"
											href="Announce?oper=update"><i></i>&nbsp;&nbsp;编辑</a>
									</tr>
								</table>

							</div>
						</div>
						<!--/.content-->
					</div>
					<!--/.span9-->
				</div>
			</div>
		</div>
		<!--/.container-->
	</div>


</body>
</html>
