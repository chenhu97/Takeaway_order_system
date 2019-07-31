<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>店铺注册申请</title>
<%@ include file="_store_link.jsp"%>
<style type="text/css">
	.span9 {
    	margin-left: 15%;
	}
</style>
</head>
<body>

	<!-- /navbar-inner -->
	<!-- /navbar -->
	<div class="wrapper  ">
		<div class="container">
			<div class="row ">
				<!--/.span3-->
				<!-- 主要内容 -->
				<div class="span9">
					<div class="content">

						<div class="module">
							<div class="module-head">
								<h3>店铺注册申请表</h3>
							</div>
							<div class="module-body">



								<br />

								<form class="form-horizontal row-fluid" method="post"
									enctype="multipart/form-data"
									action="memberStoreRegist?oper=insertdeal">

									<div>
										<span style="color: red; font-weight: bold;">${msg} </span>
									</div>

									<div class="control-group">
										<label class="control-label" for="storeLogName">店铺登入账号：</label>
										<div class="controls">
											<input type="text" id="storeLogName" name="storeLogName"
												placeholder="店铺登入账号..." class="span8"
												value="${storeLogName}">
										</div>
									</div>

									<div class="control-group">
										<label class="control-label" for="storePass"> 店铺登入密码：</label>
										<div class="controls">
											<input type="password" id="storePass" name="storePass"
												placeholder="店铺登入密码..." class="span8" value="${storePass}">
										</div>
									</div>

									<div class="control-group">
										<label class="control-label" for="storePass2">确认店铺登入密码：</label>
										<div class="controls">
											<input type="password" id="storePass2" name="storePass2"
												placeholder="确认店铺登入密码..." class="span8"
												value="${storePass2}">
										</div>
									</div>

									<div class="control-group">
										<label class="control-label" for="storeName">店名：</label>
										<div class="controls">
											<input type="text" id="storeName" name="storeName"
												placeholder="店名..." class="span8" value="${storeName}">
										</div>
									</div>

									<div class="control-group">
										<label class="control-label" for="address">店铺地址：</label>
										<div class="controls">
											<input type="text" id="address" name="address"
												placeholder="店铺地址..." class="span8" value="${address}">
										</div>
									</div>

									<div class="control-group">
										<label class="control-label" for="storeCatName">店铺类别</label>
										<div class="controls">
											<select tabindex="1" data-placeholder="请选择.." id="storeCatId"
												name="storeCatId" class="span8">
												<option value="">请选择:</option>
												<c:forEach var="bean" items="${DataList}">
													<option value="${bean.storeCatId}">${bean.storeCatName}</option>

												</c:forEach>
											</select>
										</div>
									</div>

									<div class="control-group">
										<label class="control-label" for="storeBoss">店铺经营者：</label>
										<div class="controls">
											<input type="text" id="storeBoss" name="storeBoss"
												placeholder="店铺经营者.." class="span8" value="${storeBoss}">
										</div>
									</div>

									<div class="control-group">
										<label class="control-label" for="phone">联系方式：</label>
										<div class="controls">
											<input type="text" id="phone" name="phone"
												placeholder="联系方式.." class="span8" value="${phone}">
										</div>
									</div>

									<div class="control-group">
										<label class="control-label" for="storePic">店面展示图片：</label>
										<div class="controls">
											<input type="file" id="storePic" name="storePic"
												class="span8" value="">
										</div>
									</div>

									<p class="stdformbutton"
										style="padding-left: 280px; padding-top: 40px;">
										<input type="submit" class="btn" value="提交" />
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="reset" class="btn" value="重置" />
									</p>
								</form>
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
	<!--/.wrapper-->
	<div class="footer" style="text-align: center;">
		<div class="container">
			<b class="copyright">&copy; 2019 personalStore </b>Deal<a href="#"
				target="_blank">店铺注册</a>
		</div>
	</div>
</body>