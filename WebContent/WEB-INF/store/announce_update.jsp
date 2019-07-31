<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>外卖订单系统 - 公告管理</title>
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
						<form id="validate" class="form-horizontal" action="Announce"
							method="post">
							<input type="hidden" class="btn" name="oper" value="updatedeal" />
							<input type="hidden" class="btn" name="storeId"
								value="${storeId}" />
							<div style="font-weight: bold; color: red;">${msg}</div>
							<!-- Form validation -->
							<div class="widget">
								<div class="well row-fluid">
									<div class="control-group">
										<label class="control-label">公告内容: <span
											class="text-error">*</span></label>
										<div class="controls">
											<textarea class="validate[required] span12" name="announce"
												id="req">${announce}</textarea>
										</div>
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
</body>
</html>
