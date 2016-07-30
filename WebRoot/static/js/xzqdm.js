function xzq_edit(e){
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
				$(this).html('<button onclick="xzq_insert(this);">插入</button>\n<button onclick="xzq_delete(this);">退出</button>');
			}else{
				$(this).html('<button onclick="xzq_save(this);">确认</button>\n<button onclick="xzq_reload(this);">退出</button>');
			}
		}
	});
}

function xzq_save(e){
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
			$(this).html('<button onclick="xzq_edit(this);">编辑</button>\n<button onclick="xzq_drop(this)">删除</button>')
		}
	});
	item = JSON.stringify(item);
	$.ajax({
	    type: "POST",
	    cache: false,
	    dataType:"json",
	    url: "/codewh/commitXZQ/",
	    data:{'xzqdm':item},
	    success : function(data,stau){
	    	alert(data['res']);
	    }
	});
}
function xzq_drop(e){
	var btn = $(e);
	var tr = btn.parent().parent();
	tr.find('td').each(function (){
		if($(this).attr('name') == 'ADDVCD'){
			var text = $(this).text();
			$.ajax({
			    type: "POST",
			    cache: false,
			    dataType:"json",
			    url: "/codewh/dropXZQ/",
			    data:{'xzqdm':text},
			    success : function(data,stau){
			    	alert(data['res']);
			    }
			});
			console.log("delete "+text);
		} 
	});
	tr.remove();
}
function xzq_reload(e){
	var btn = $(e);
	var tr = btn.parent().parent();
	tr.find('td').each(function (){
		var input = $(this).children();
		if(input.is('input')){
			var text = input.attr('value');
			$(this).html(text);
		}
		if(input.is('button')){
			$(this).html('<button onclick="xzq_edit(this);">编辑</button>\n<button onclick="xzq_drop(this)">删除</button>')
		}
	});
}


function xzq_add(){
	var div = $('#new_item');
	var oldhtml = div.html();
	var newItem = '\n<tr>\n	<td edit="true" name="ADDVCD"></td>\n	<td edit="true" name="XZQMC"></td>\n	<td edit="btn">\n    	<button onclick="xzq_edit(this);">编辑</button>\n    	<button onclick="xzq_drop(this)">删除</button>\n	</td>\n</tr>';
	div.append(newItem);
	var div = $('#new_item');
	var tr = div.find('tr').last();
	xzq_edit(tr);
}
function xzq_insert(e){
	var btn = $(e);
	var tr = btn.parent().parent();
	var item = {};
	tr.find('td').each(function (){
		var input = $(this).children();
		if(input.is('input')){
			var text = input.val();
			var name = input.attr('name');
			item[name] = text;
			if(input.attr('name') == 'ADDVCD'){
				$(this).html(text);
				$(this).attr('edit','false');
			}else{
				$(this).html(text);
			}
		}
		if(input.is('button')){
			$(this).html('<button onclick="xzq_edit(this);">编辑</button>\n<button onclick="xzq_drop(this)">删除</button>')
		}
	});
	item = JSON.stringify(item);
	$.ajax({
	    type: "POST",
	    cache: false,
	    dataType:"json",
	    url: "/codewh/addXZQ/",
	    data:{'xzqdm':item},
	    success : function(data,stau){
	    	alert(data['res']);
	    }
	});
}
function xzq_delete(e){
	var btn = $(e);
	var tr = btn.parent().parent();
	tr.remove();
}