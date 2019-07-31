<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="sidebar">
	
	<div class="sidebar-tabs">
		<ul class="tabs-nav two-items">
			<li><a href="#general" title=""><i class="icon-reorder"></i></a></li>
			<li><a href="#stuff" title=""><i class="icon-cogs"></i></a></li>
		</ul>

		<div id="general">
	  		<div class="general-stats widget">
		        <ul class="head">
		        	<li><span>Users</span></li>
		        	<li><span>Orders</span></li>
		        	<li><span>Visits</span></li>
		        </ul>
		        <ul class="body">
		        	<li><strong>116k+</strong></li>
		        	<li><strong>1290</strong></li>
		        	<li><strong>554</strong></li>
		        </ul>
		    </div>
			<!-- Main navigation -->
			<ul class="navigation widget">
				<li class="active"><a href="index.html"><i
						class="icon-home"></i>导航</a></li>
				<li><a onclick="change(this)" href="#" class="expand"><i
						class="icon-reorder"></i>店铺管理<strong>4</strong></a>
					<ul style="display: none;">
						<li><a href="#">店铺审核</a></li>
						<li><a href="Store?oper=list">店铺查看</a></li>
						<li><a href="#">店铺删除</a></li>
						<li><a href="#">店铺修改</a></li>
					</ul></li>
				<li><a onclick="change(this)" href="#" class="expand"><i
						class="icon-tasks"></i>用户管理<strong>2</strong></a>
					<ul style="display: none;">
						<li><a href="components.html">用户禁用</a></li>
						<li><a href="Member?oper=list">用户管理</a></li>
					</ul></li>

				<li><a onclick="change(this)" href="#" class="expand"><i
						class="icon-indent-right"></i>公告管理<strong>3</strong></a>
					<ul style="display: none;">
						<li><a href="#">发布公告</a></li>
						<li><a href="#">修改公告</a> <li><a href="#">删除公告</a></li>
					</ul></li>
				<li><a onclick="change(this);" href="#" class="expand"><i
						class="icon-sitemap"></i>管理员信息管理<strong>1</strong></a>
					<ul style="display: none;">
						<li><a href="Admin?oper=list">管理员信息列表</a></li>
					</ul></li>
			</ul>
			<!-- /main navigation -->

		</div>

       <div id="stuff">
		<!-- Datepicker -->
     	  <div class="widget">
     		<h6 class="widget-name"><i class="icon-calendar"></i>Datepicker</h6>
             <div class="inlinepicker datepicker-liquid"></div>
         </div>
         <!-- /datepicker -->
        <!-- Social stats -->
        <div class="widget">
        	<h6 class="widget-name"><i class="icon-twitter"></i>Social statistics</h6>
        	<ul class="social-stats">
        		<li>
        			<a href="" title="" class="orange-square"><i class="icon-rss"></i></a>
        			<div>
	        			<h4>1,286</h4>
	        			<span>total feed subscribers</span>
	        		</div>
        		</li>
        		<li>
        			<a href="" title="" class="blue-square"><i class="icon-twitter"></i></a>
        			<div>
	        			<h4>12,683</h4>
	        			<span>total twitter followers</span>
	        		</div>
        		</li>
        		<li>
        			<a href="" title="" class="dark-blue-square"><i class="icon-facebook"></i></a>
        			<div>
	        			<h4>530,893</h4>
	        			<span>total facebook likes</span>
	        		</div>
        		</li>
        	</ul>
        </div>
        <!-- /social stats -->
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