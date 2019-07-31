$(function() {
	$('#qingkong').click(function() {
		location.href = 'Admin?oper=list';
	});

	$("#checkall").change(function() {
		var $otherCheckList = $("input:checkbox:not('checkall')");
		var checkAllState = $("#checkall").prop("checked");
		$otherCheckList.prop("checked", checkAllState);
	})



});
