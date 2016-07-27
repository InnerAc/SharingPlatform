
/**
 * 使除了资费条目外其他都处于可编辑状态。\n
 * 判断是新增的条目还是已有条目，新增条目资费默认为0.0
 * @param e	对于已有条目为按钮对象，对于新增条目为表格行对象
 */
function i_edit(e){
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
			if(name == 'RQZD1' || name == 'RQZD2'){	//判断是否为日期类型
				$(this).html('<input type="date" name="'+name+'"  value="'+text+'"/>');
			}else{
				$(this).html('<input type="text" name="'+name+'" style="width: '+width+'px" value="'+text+'"/>');
			}
		} 
		if($(this).attr('edit') == "btn"){	//判断是新增条目还是已有条目
			if(btn.is('tr')){
				$(this).html('<button onclick="i_insert(this);">插入</button>\n<button onclick="i_delete(this);">放弃</button>');
			}else{
				$(this).html('<button onclick="i_save(this);">保存</button>\n<button onclick="i_reload(this);">放弃</button>');
			}
		}
	});
}

/**
 * 将修改提交到数据库事务中，然后将可编辑框变为不可编辑状态。
 * @param e	点击的保存按钮
 */
function i_save(e){
	var btn = $(e);
	var tr = btn.parent().parent();
	var item = {};
	tr.find('td').each(function (){
		var input = $(this).children();
		if(input.is('input')){
			var text = input.val();
			var name = input.attr('name');
			item[name] = text;
			$(this).html('<td edit="true">'+text+'</td>');
		}
		if($(this).attr('name') == 'ZF'){
			var text = $(this).text();
			var name = $(this).attr('name');
			item[name] = text;
			$(this).html(text);
		}
		if(input.is('button')){
			$(this).html('<button onclick="i_edit(this);">编辑</button>\n<button onclick="i_drop(this)">删除</button>')
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

/**
 * 将新增条目插入到数据库中。然后将整行变为不可编辑状态。
 * @param e 点击的插入按钮
 */
function i_insert(e){
	var btn = $(e);
	var tr = btn.parent().parent();
	var item = {};
	tr.find('td').each(function (){
		var input = $(this).children();
		if(input.is('input')){
			var text = input.val();
			var name = input.attr('name');
			item[name] = text;
			$(this).html('<td edit="true">'+text+'</td>');
		}
		if($(this).attr('name') == 'ZF'){
			var text = $(this).text();
			var name = $(this).attr('name');
			item[name] = text;
			$(this).html(text);
		}
		if(input.is('button')){
			$(this).html('<button onclick="i_edit(this);">编辑</button>\n<button onclick="i_drop(this)">删除</button>')
		}
	});
	item = JSON.stringify(item);
	$.ajax({
	    type: "POST",
	    cache: false,
	    dataType:"json",
	    url: "/swyswh/add/",
	    data:{'swys':item},
	});
}

/**
 * 对于已有条目，放弃当前更改，使该行恢复原来状态。
 * @param e	点击的放弃按钮
 */
function i_reload(e){
	var btn = $(e);
	var tr = btn.parent().parent();
	tr.find('td').each(function (){
		var input = $(this).children();
		if(input.is('input')){
			var text = input.attr('value');
			console.log(text);
			$(this).html('<td edit="true">'+text+'</td>');
		}
		if(input.is('button')){
			$(this).html('<button onclick="i_edit(this);">编辑</button>\n<button onclick="i_drop(this)">删除</button>')
		}
	});
}

/**
 * 对于新增条目，放弃保存，同时删除该行。
 * @param e 点击的放弃按钮
 */
function i_delete(e){
	var btn = $(e);
	var tr = btn.parent().parent();
	tr.remove();
}

/**
 * 从数据库中删除该行，同时移除改行在页面中的显示。
 * @param e	点击的删除按钮
 */
function i_drop(e){
	var btn = $(e);
	var tr = btn.parent().parent();
	tr.find('td').each(function (){
		if($(this).attr('edit') == "true" & $(this).attr('name') == 'YSDM'){
			var text = $(this).text();
			$.ajax({
			    type: "POST",
			    cache: false,
			    dataType:"json",
			    url: "/swyswh/drop/",
			    data:{'swys':text},
			});
			console.log("delete "+text);
		} 
	});
	tr.remove();
}

/**
 * 增加一个空行，同时调用i_edit(e)将本行变为可编辑状态。
 */
function i_add(){
	var div = $('#new_item');
	var oldhtml = div.html();
	var newItem = '\n<tr>\n			<td edit="true" name="YSDM"></td>\n			<td edit="true" name="YSMC"></td>\n			<td edit="true" name="BM"></td>\n			<td edit="true" name="YSNR"></td>\n			<td edit="true" name="RQZD1"></td>\n			<td edit="true" name="RQZD2"></td>\n			<td edit="true" name="LX"></td>\n			<td edit="false" name="ZF">0.0</td>\n			<td edit="btn">\n	        	<button onclick="i_edit(this);">编辑</button>\n	        	<button onclick="i_drop(this)">删除</button>\n			</td>\n        </tr>';
	div.html(oldhtml+newItem);
	var div = $('#new_item');
	var tr = div.find('tr').last();
	i_edit(tr);
}