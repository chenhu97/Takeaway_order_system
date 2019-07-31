<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>个人店铺管理 - 菜品管理 - 菜品修改</title>
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
						<h5 class="widget-name">
							<i class="icon-ok"></i>修改菜品
						</h5>
						<form id="validate" class="form-horizontal" action="Foods?oper=updatedeal&foodId=${foodId}"
							method="post" enctype="multipart/form-data">
							<input type="hidden" class="btn" name="storeId" value="${storeId}" />
							<div style="font-weight: bold; color: red;">${msg}</div>
							<!-- Form validation -->
							<div class="widget">
								<div class="well row-fluid">
									<div class="control-group">
										<label class="control-label">菜品类目: <span
											class="text-error">*</span>
										</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select name="catId">
											<c:forEach var="item" items="${DataList}">
												<option value="${item.catId}">${item.catName}</option>
											</c:forEach>
										</select>
									</div>
									<div class="control-group">
										<label class="control-label">菜品名称: <span
											class="text-error">*</span></label>
										<div class="controls">
											<input type="text" class="validate[required] span12"
												name="foodName" id="req" value="${foodName}"/>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">备注: <span
											class="text-error">*</span></label>
										<div class="controls">
											<input type="text" class="validate[required] span12"
												name="remark" id="req" value="${remark}"/>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">图片路径: <span
											class="text-error">*</span></label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span
											class="field"> <input type="file" id="picpath"
											name="picpath" value="" class="mediuminput">
										</span>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">价格: <span
										class="text-error">*</span></label>
									<div class="controls">
										<input type="text" class="validate[required] span12"
											name="price" id="req" value="${price}"/>
									</div>
								</div>

								<div class="form-actions align-right">
									<button type="submit" class="btn btn-info">提交</button>
									<button type="reset" class="btn">重置</button>
								</div>

							</div>
						</form>
					</div>
					<!--/.content-->
				</div>
				<!--/.span9-->
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
</body>