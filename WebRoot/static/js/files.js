function show(e){
	var btn = $(e);
	var id = btn.attr('id');
	$('#'+id+'_show').fadeIn(100);
}

function addClick(e){
	var btn = $(e);
	var id = btn.attr('id');
	var input = $('#'+id+'_st');
	var text =  $.trim(input.val());
	var select = $('#'+id+'_sts');
	select.append('<option>'+text+'</option>');
	$('#'+id+'_show').fadeOut(100);
}

function rmClick(e){
	var btn = $(e);
	var id = btn.attr('id');
	var select = $('#'+id+'_sts');
	var text = select.val();
	select.find('option').each(function (){
		if(text.includes($(this).text())){
			$(this).remove();
		}
	});
}