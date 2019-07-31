<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="sidebar">

	<div class="sidebar-tabs">
		<ul class="tabs-nav two-items">
			<li><a href="#general" title=""><i class="icon-reorder"></i></a></li>
			<li><a href="#stuff" title=""><i class="icon-cogs"></i></a></li>
		</ul>

		<div id="general">
			<!-- Main navigation -->
			<ul class="navigation widget">
				<li class="active"><a href="Main"><i class="icon-home"></i>导航</a></li>
				<li><a onclick="change(this)" href="#" class="expand"><i
						class="icon-reorder"></i>店铺管理<strong>2</strong></a>
					<ul style="display: none;">
						<li><a href="Store?oper=checklist">店铺审核</a></li>
						<li><a href="Store?oper=list">店铺查看</a></li>
					</ul></li>
				<li><a onclick="change(this)" href="#" class="expand"><i
						class="icon-tasks"></i>用户管理<strong>1</strong></a>
					<ul style="display: none;">
						<li><a href="Member?oper=list">用户修改</a></li>
					</ul></li>

				<li><a onclick="change(this)" href="#" class="expand"><i
						class="icon-tasks"></i>公告管理<strong>1</strong></a>
					<ul style="display: none;">
						<li><a href="Announce?oper=list">公告信息管理</a></li>
					</ul></li>

				<li><a onclick="change(this);" href="#" class="expand"><i
						class="icon-sitemap"></i>管理员信息<strong>2</strong></a>
					<ul style="display: none;">
						<li><a href="Admin?oper=list">管理员信息列表</a></li>
						<li><a href="Admin?oper=update">管理员密码修改</a></li>
					</ul></li>
			</ul>
			<!-- /main navigation -->

		</div>

	</div>
</div>

<script type="text/javascript">
	function change(obj) {
		if ($(obj).next().css("display") == "none") {
			$(obj).next().css("display", "block");
		} else {
			$(obj).next().css("display", "none");
		}
	}
</script>