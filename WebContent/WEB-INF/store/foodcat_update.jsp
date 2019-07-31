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
</style>
</head>
<body>
	<%@ include file="_store_top.jsp"%>
	<!-- /navbar-inner -->
	<!-- /navbar -->
	<div class="wrapper">
		<div class="container">
			<div class="row">
				<%@ include file="_store_nav.jsp"%>
				<!--/.span3-->
				<!-- 主要内容 -->
				<div class="span9">
					<div class="content">

						<div class="module">
							<div class="module-head">
								<h3>添加菜品类目</h3>
							</div>
							<div class="module-body">



								<form class="form-horizontal  row-fluid" action="FoodCat"
									method="post">

									<input type="hidden" name="oper" value="updateDeal" /> <input
										type="hidden" name="catId" value="${catId}" /> <label
										class="control-label" for="basicinput">菜品类目：</label>
									<div class="controls">
										<input type="text" id="catName" name="catName"
											placeholder="Type your catName here..." class="span8"
											value="${catName}"> <span
											style="color: red; font-weight: bold;">${msg} </span>
									</div>


									<p class="stdformbutton"
										style="padding-left: 350px; padding-top: 20px;">
										<input type="submit" class="btn btn-primary" value="提交" />
										&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset"
											class="btn btn-warning" value="重置">
									</p>

								</form>
								<button class="btn btn-success"
									onclick="javascript:location.href='FoodCat?oper=list';">返回列表</button>
							</div>
						</div>



					</div>
					<!--/.content-->
				</div>
				<!--/.span9-->
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
				target="_blank">店铺类目修改</a>
		</div>
	</div>
</body>