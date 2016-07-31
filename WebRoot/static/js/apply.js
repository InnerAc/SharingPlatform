/**
 * 设置站点选择弹窗
 */
function stClick(){
	$("#stSelect").fadeIn(300);
	$("#applyTable").fadeOut(300);
}
/**
 * 设置日期选择弹窗
 */
function dateClick(){
	$("#dateSelect").fadeIn(300);
	$("#applyTable").fadeOut(300);
}

/**
 * 关闭弹窗
 */
function showTable(){
	$("#stSelect").fadeOut(300);
	$("#dateSelect").fadeOut(300);
	$("#applyTable").fadeIn(300);
}

/**
 * 得到申请内容中选中的tr
 * @returns {Array}
 */
function getCheckedTr(){
	var content = $('#yaosuneirong');
	var res = [];
	content.find('tr').each(function (){
		var tr = $(this);
		if(tr.find('input')[0].checked){
			res.push(tr);
		}
	});
	return res;
}

//监视要素选择的变化
$(function(){
	$('#yaosuxuanze').change(function(e){
		ysSelect();
	});
});
/**
 * 将要素添加到申请内容
 */
function ysSelect(){
	var selectText = $('#yaosuxuanze').val();
	var trs = getCheckedTr();
	if(trs.length == 0){
		alert('请选中一个或多个内容');
		return;
	}
	var n = trs.length;
	for(var i=0;i<n;i++){
		var tr = trs[i];
		var td = tr.find('td')[1];
		$(td).html(selectText);
	}
	
}