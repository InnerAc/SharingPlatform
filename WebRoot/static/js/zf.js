function zf_edit(e){
	var btn = $(e);
	var tr = btn.parent().parent();
	tr.find('td').each(function (){
		if($(this).attr('edit') == "true"){
			var text = $(this).text();
			var width = $(this).width()-5;
			var name = $(this).attr('name');
			if(name == 'ZF'){
				$(this).html('<input type="text" name="'+name+'" style="width: '+width+'px" value="'+text+'"/>');
			}
		} 
		if($(this).attr('edit') == "btn"){
			$(this).html('<button onclick="zf_save(this);">保存</button>\n<button onclick="zf_reload(this);">放弃</button>');
		}
	});
}

function zf_save(e){
	var btn = $(e);
	var tr = btn.parent().parent();
	var item = {};
	tr.find('td').each(function (){
		var input = $(this).children();
		if(input.is('input')){
			var text = input.val();
			var name = input.attr('name');
			item[name] = text;
			$(this).html('<td edit="true" name="'+name+'">'+text+'</td>');
		}
		if($(this).attr('edit') == 'false'){
			var text = $(this).text();
			var name = $(this).attr('name');
			item[name] = text;
			$(this).html(text);
		}
		if(input.is('button')){
			$(this).html('<button onclick="zf_edit(this);">修改</button>')
		}
	});
	item = JSON.stringify(item);
	$.ajax({
	    type: "POST",
	    cache: false,
	    dataType:"json",
	    url: "/swyswh/commit/",
	    data:{'swys':item},
	});
}

function zf_reload(e){
	var btn = $(e);
	var tr = btn.parent().parent();
	tr.find('td').each(function (){
		var input = $(this).children();
		if(input.is('input')){
			var text = input.attr('value');
			var name = input.attr('name');
			console.log(text);
			$(this).html('<td edit="true" name="'+name+'">'+text+'</td>');
		}
		if(input.is('button')){
			$(this).html('<button onclick="zf_edit(this);">修改</button>')
		}
	});
}