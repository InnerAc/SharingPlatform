function hl_edit(e){
	var btn = $(e);
	var tr = btn.parent().parent();
	if(btn.is('tr')){	//判断是新增条目还是已有条目
		tr = btn;
	}
	tr.find('td').each(function (){
		if($(this).attr('edit') == "true"){
			var text = $(this).text();
			var width = $(this).width()-5;
			var name = $(this).attr('name');
			$(this).html('<input type="text" name="'+name+'" style="width: '+width+'px" value="'+text+'"/>');
		} 
		if($(this).attr('edit') == "btn"){	//判断是新增条目还是已有条目
			if(btn.is('tr')){
				$(this).html('<button onclick="hl_insert(this);">插入</button>\n<button onclick="hl_delete(this);">放弃</button>');
			}else{
				$(this).html('<button onclick="hl_save(this);">保存</button>\n<button onclick="hl_reload(this);">放弃</button>');
			}
		}
	});
}

function hl_save(e){
	var btn = $(e);
	var tr = btn.parent().parent();
	var item = {};
	tr.find('td').each(function (){
		var input = $(this).children();
		if(input.is('input')){
			var text = input.val();
			var name = input.attr('name');
			item[name] = text;
			$(this).html(text);
		}
		if($(this).attr('edit') == 'false'){
			var text = $(this).text();
			var name = $(this).attr('name');
			item[name] = text;
		}
		if(input.is('button')){
			$(this).html('<button onclick="hl_edit(this);">编辑</button>\n<button onclick="hl_drop(this)">删除</button>')
		}
	});
	item = JSON.stringify(item);
	$.ajax({
	    type: "POST",
	    cache: false,
	    dataType:"json",
	    url: "/codewh/commitHL/",
	    data:{'hlmc':item},
	    success : function(data,stau){
	    	alert(data['res']);
	    }
	});
}
function hl_drop(e){
	var btn = $(e);
	var tr = btn.parent().parent();
	tr.find('td').each(function (){
		if($(this).attr('name') == 'BSHNCD'){
			var text = $(this).text();
			$.ajax({
			    type: "POST",
			    cache: false,
			    dataType:"json",
			    url: "/codewh/dropHL/",
			    data:{'hlmc':text},
			    success : function(data,stau){
			    	alert(data['res']);
			    }
			});
			console.log("delete "+text);
		} 
	});
	tr.remove();
}
function hl_reload(e){
	var btn = $(e);
	var tr = btn.parent().parent();
	tr.find('td').each(function (){
		var input = $(this).children();
		if(input.is('input')){
			var text = input.attr('value');
			$(this).html(text);
		}
		if(input.is('button')){
			$(this).html('<button onclick="hl_edit(this);">编辑</button>\n<button onclick="hl_drop(this)">删除</button>')
		}
	});
}


function hl_add(){
	var div = $('#new_item');
	var oldhtml = div.html();
	var newItem = '\n<tr>\n	<td edit="true" name="BSHNCD"></td>\n	<td edit="true" name="HNNM"></td>\n	<td edit="true" name="RVNM"></td>\n	<td edit="btn">\n    	<button onclick="hl_edit(this);">编辑</button>\n    	<button onclick="hl_drop(this)">删除</button>\n	</td>\n</tr>';
	div.append(newItem);
	var div = $('#new_item');
	var tr = div.find('tr').last();
	hl_edit(tr);
}
function hl_insert(e){
	var btn = $(e);
	var tr = btn.parent().parent();
	var item = {};
	tr.find('td').each(function (){
		var input = $(this).children();
		if(input.is('input')){
			var text = input.val();
			var name = input.attr('name');
			item[name] = text;
			if(input.attr('name') == 'BSHNCD'){
				$(this).html(text);
				$(this).attr('edit','false');
			}else{
				$(this).html(text);
			}
		}
		if(input.is('button')){
			$(this).html('<button onclick="hl_edit(this);">编辑</button>\n<button onclick="hl_drop(this)">删除</button>')
		}
	});
	item = JSON.stringify(item);
	$.ajax({
	    type: "POST",
	    cache: false,
	    dataType:"json",
	    url: "/codewh/addHL/",
	    data:{'hlmc':item},
	    success : function(data,stau){
	    	alert(data['res']);
	    }
	});
}
function hl_delete(e){
	var btn = $(e);
	var tr = btn.parent().parent();
	tr.remove();
}