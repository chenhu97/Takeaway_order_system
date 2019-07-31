<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>个人店铺管理 - 查看店铺信息</title>
<%@ include file="_store_link.jsp"%>
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
	<%@ include file="_store_top.jsp"%>
	<div class="wrapper">
		<div class="container">
			<div class="row">
				<%@ include file="_store_nav.jsp"%>
				<!--/.span3-->
				<!-- 主要内容 -->
				<div class="span9">
					<div class="content">
						<div class="mainbar">
							<input type="button" class="btn"
								onclick="javasctipt:location.href='Main?oper=update'" value="修改" />
							<div class="post_list">
								<div
									style="font-size: 35px; margin-top: 10px; font-family: 宋体; font-weight: bold">
									<span>店名:</span><span>${bean.storeName}<br /></span> <br />
								</div>
								<div style="font-size:20px;">
									<span>店铺类别:</span><span>${bean.storeCatName}<br /></span>
								</div>
								<div style="border-bottom: 3px solid #4dc9dc;"></div>
								<div
									style="padding-top: 40px; font-size: 15px; font-weight: bold">商家信息：</div>
								<c:if
									test="${not empty bean.storePic && fn:length(bean.storePic)>0}">
									<img alt="商品图片"
										src="${pageContext.request.contextPath}${bean.storePic}" />
								</c:if>
							</div>
							<div
								style="padding-top: 40px; font-size: 15px; font-weight: bold">
								经营者： ${bean.storeBoss}
								<hr style="border-bottom: 1px solid" />
								<br />
							</div>

							<div
								style="padding-top: 40px; font-size: 15px; font-weight: bold">
								商家地址： ${bean.address}
								<hr style="border-bottom: 1px solid" />
								<br />
							</div>
							<div
								style="padding-top: 40px; font-size: 15px; font-weight: bold">
								店铺公告： ${bean.announce}
								<hr style="border-bottom: 1px solid" />
								<br />
							</div>
							<div
								style="padding-top: 40px; font-size: 15px; font-weight: bold">
								商家电话： ${bean.phone}
								<hr style="border-bottom: 1px solid" />
								<br />
							</div>

						</div>

					</div>
				</div>
			</div>
		</div>
		<!--/.content-->
	</div>
	<!--/.span9-->
	<!--/.container-->
	<!--/.wrapper-->
	<div class="footer" style="margin-left: 300px;">
		<div class="container">
			<b class="copyright">&copy; 20119 personalStore </b>Deal<a href="#"
				target="_blank">店长管理店铺</a>
		</div>
	</div>
</body>