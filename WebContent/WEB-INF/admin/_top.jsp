<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="top">
	<div class="fixed">
		<a href="index.html" title="" class="logo"><img
			src="${AppRootPath}/static/cpts_1078_bpt/img/logo.png" alt="" /></a>
		<ul class="top-menu">
			<li><a class="fullview"></a></li>
			<li><a class="showmenu"></a></li>
			<li><a href="#" class="messages"><i class="new-message"></i></a></li>
			<li class="dropdown"><a class="user-menu" data-toggle="dropdown"><img
					src="${AppRootPath}/static/cpts_1078_bpt/img/userpic.png" alt="" />
					<span>${FG_LOGINUSER_KEY.adminName}<b class="caret"></b>
				</span></a>
				<ul class="dropdown-menu">
					<li><a href="#"><i class="icon-user"></i>Profile</a></li>
					<li><a href="#"><i class="icon-inbox"></i>Messages<span
							class="badge badge-info">9</span></a></li>
					<li><a href="#"><i class="icon-cog"></i>Settings</a></li>
					<li><a href="Loginout"><i class="icon-remove"></i>Logout</a></li>
				</ul></li>
		</ul>
	</div>
</div>