$(document).ready(function(){
	var header = $(".header-text");
	$(window).scroll(function() {
		var scroll = $(window).scrollTop();
		if ($(".index-page").length > 0) {
			if (scroll >= 270) {
				header.addClass("remove");
			} else {
				header.removeClass("remove");
			}
		}else{
			if (scroll >= 120) {
				header.addClass("remove");
			} else {
				header.removeClass("remove");
			}
		}
	});
	
	$(window).resize(function(){
		var width = (window.innerWidth > 0) ? window.innerWidth : screen.width;
		var footerHeight = $('#footer').outerHeight();
		if (width >= '768') { 
			$('#page-content').css({'marginBottom': footerHeight + 'px'});
		}else{
			$('#page-content').css({'marginBottom': '0px'});
		}
	});
	$(window).resize();
});