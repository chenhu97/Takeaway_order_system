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
								<h3>Forms</h3>
							</div>
							<div class="module-body">



								<br />

								<form class="form-horizontal row-fluid">
									<div class="control-group">
										<label class="control-label" for="basicinput">Basic
											Input</label>
										<div class="controls">
											<input type="text" id="basicinput"
												placeholder="Type something here..." class="span8">

										</div>
									</div>

									<div class="control-group">
										<label class="control-label" for="basicinput">Basic
											Input</label>
										<div class="controls">
											<input type="text" id="basicinput"
												placeholder="Type something here..." class="span8">

										</div>
									</div>

									<div class="control-group">
										<label class="control-label" for="basicinput">Tooltip
											Input</label>
										<div class="controls">
											<input data-title="A tooltip for the input" type="text"
												placeholder="Hover to view the tooltip…"
												data-original-title="" class="span8 tip">
										</div>
									</div>

									<div class="control-group">
										<label class="control-label" for="basicinput">Prepended
											Input</label>
										<div class="controls">
											<div class="input-prepend">
												<span class="add-on">#</span><input class="span8"
													type="text" placeholder="prepend">
											</div>
										</div>
									</div>

									<div class="control-group">
										<label class="control-label" for="basicinput">Appended
											Input</label>
										<div class="controls">
											<div class="input-append">
												<input type="text" placeholder="5.000" class="span8"><span
													class="add-on">$</span>
											</div>
										</div>
									</div>

									<div class="control-group">
										<label class="control-label" for="basicinput">Dropdown
											Button</label>
										<div class="controls">
											<div class="dropdown">
												<a class="dropdown-toggle btn" data-toggle="dropdown"
													href="#">Dropdown Button <i class="icon-caret-down"></i></a>
												<ul class="dropdown-menu" role="menu"
													aria-labelledby="dLabel">
													<li><a href="#">First Row</a></li>
													<li><a href="#">Second Row</a></li>
													<li><a href="#">Third Row</a></li>
													<li><a href="#">Fourth Row</a></li>
												</ul>
											</div>
										</div>
									</div>

									<div class="control-group">
										<label class="control-label" for="basicinput">Dropdown</label>
										<div class="controls">
											<select tabindex="1" data-placeholder="Select here.."
												class="span8">
												<option value="">Select here..</option>
												<option value="Category 1">First Row</option>
												<option value="Category 2">Second Row</option>
												<option value="Category 3">Third Row</option>
												<option value="Category 4">Fourth Row</option>
											</select>
										</div>
									</div>

									<div class="control-group">
										<label class="control-label">Radiobuttons</label>
										<div class="controls">
											<label class="radio"> <input type="radio"
												name="optionsRadios" id="optionsRadios1" value="option1"
												checked=""> Option one
											</label> <label class="radio"> <input type="radio"
												name="optionsRadios" id="optionsRadios2" value="option2">
												Option two
											</label> <label class="radio"> <input type="radio"
												name="optionsRadios" id="optionsRadios3" value="option3">
												Option three
											</label>
										</div>
									</div>

									<div class="control-group">
										<label class="control-label">Inline Radiobuttons</label>
										<div class="controls">
											<label class="radio inline"> <input type="radio"
												name="optionsRadios" id="optionsRadios1" value="option1"
												checked=""> Option one
											</label> <label class="radio inline"> <input type="radio"
												name="optionsRadios" id="optionsRadios2" value="option2">
												Option two
											</label> <label class="radio inline"> <input type="radio"
												name="optionsRadios" id="optionsRadios3" value="option3">
												Option three
											</label>
										</div>
									</div>

									<div class="control-group">
										<label class="control-label">Checkboxes</label>
										<div class="controls">
											<label class="checkbox"> <input type="checkbox"
												value=""> Option one
											</label> <label class="checkbox"> <input type="checkbox"
												value=""> Option two
											</label> <label class="checkbox"> <input type="checkbox"
												value=""> Option three
											</label>
										</div>
									</div>

									<div class="control-group">
										<label class="control-label">Inline Checkboxes</label>
										<div class="controls">
											<label class="checkbox inline"> <input
												type="checkbox" value=""> Option one
											</label> <label class="checkbox inline"> <input
												type="checkbox" value=""> Option two
											</label> <label class="checkbox inline"> <input
												type="checkbox" value=""> Option three
											</label>
										</div>
									</div>

									<div class="control-group">
										<label class="control-label" for="basicinput">Textarea</label>
										<div class="controls">
											<textarea class="span8" rows="5"></textarea>
										</div>
									</div>

									<div class="control-group">
										<div class="controls">
											<button type="submit" class="btn">Submit Form</button>
										</div>
									</div>
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
					url : 'Store?oper=deleteDeal&id=' + id,
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
							url : "Store",
							async : false,// 要使用同步
							data : {
								"oper" : "deleteDeal",
								"id" : id
							},
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
				alert('要删除' + total + '行记录，成功删除' + num + '行记录');
				location.reload();
			}
		}
	</script>

</body>