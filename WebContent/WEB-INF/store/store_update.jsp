<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>个人店铺管理 - 修改店铺信息</title>
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

.table th, .table td {
	padding: 8px 35px;
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
						<form action="Main?oper=updateDeal" method="post" id="tab"
							enctype="multipart/form-data">
							<input type="hidden" name="announceId" value="${announceId}" />
							<div>
								<label>店铺名称</label> <input type="text" class="input-xlarge"
									name="storeName" value="${storeName}">
							</div>

							<div>
								<label>店铺类别</label> <select id="storeCatId" name="storeCatId">
									<c:forEach var="bean" items="${StoreCatNameList}">
										<option value="${bean.storeCatId}">${bean.storeCatName}</option>
									</c:forEach>
								</select>
							</div>
							<div>
								<label>经营者</label> <input type="text" class="input-xlarge"
									name="storeBoss" value="${storeBoss}" />
							</div>
							<div>
								<label>店铺地址</label> <input type="text" class="input-xlarge"
									name="address" value="${address}" />
							</div>
							<div>
								<label>店铺图片</label>
								<div>
									<img src="${AppRootPath}${picPath}">
								</div>
								<input type="file" class="input-xlarge" name="picPath" />
							</div>
							<div>
								<label>店铺公告</label> <input type="text" class="input-xlarge"
									name="announce" value="${announce}" />
							</div>
							<div>
								<label>联系电话</label> <input type="text" class="input-xlarge"
									name="phone" value="${phone}" />
							</div>


							<div>
								<span style="color: red; font-weight: bolc;">${msg}</span>
							</div>
							<div style="margin: 30px 0px 0px 30px">
								<input type="submit" class="btn"
									value="&nbsp;&nbsp;提交&nbsp;&nbsp;"> <input type="reset"
									class="btn" value="&nbsp;&nbsp;重置&nbsp;&nbsp;">
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
	<script>
		$("#storeCatId").val("${storeCatId}");
	</script>

</body>
</html>