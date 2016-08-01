/**
 * 设置站点选择弹窗
 */
function stClick(){
	var ntrs = getCheckedTr();
	if(ntrs.length == 0){
		alert('请选中一个或多个内容');
		return;
	}
	$("#stSelect").fadeIn(300);
	$("#applyTable").fadeOut(300);
}
/**
 * 设置日期选择弹窗
 */
function dateClick(){
	var ntrs = getCheckedTr();
	if(ntrs.length == 0){
		alert('请选中一个或多个内容');
		return;
	}
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
 * 增加要素内容一个条目
 */
function addTR(){
	var table = $('#yaosuneirong');
	table.append('<tr>\n<td><input type="checkbox" /></td>\n<td name="YSDM"></td>\n<td name="STCD"></td>\n<td name="QSRQ"></td>\n<td name="ZZRQ"></td>\n</tr>');
}

/**
 * 移除选中条目
 */
function rmTR(){
	var res = getCheckedTr();
	var n = res.length;
	for(var i=0;i<n;i++){
		res[i].remove();
	}
}

function commitALL(){
	//得到提交头
	var DW = $('#DW').val();
	var XM = $('#XM').val();
	var DH = $('#DH').val();
	var ZLYT = $('#ZLYT').val();
	var RQ = (new Date().Format("yyyy-MM-dd"));
	var XH = Math.round(new Date().getTime()/100)%140000000;	//我这儿仅仅是靠UNIX时间戳来创建随机id，可以后续更改
	var sqb = {'DW':DW, 'XM':XM, 'DH':DH, 'ZLYT':ZLYT, 'RQ':RQ, 'XH':XH};
	sqb = JSON.stringify(sqb);

	//得到提交内容
	
	sqnrbs = [];
	var content = $('#yaosuneirong');
	content.find('tr').each(function (){
		var tr = $(this).find('td');
		var sqnrb = {'YSDM':$(tr[1]).text() ,  'STCD': $(tr[2]).text().split(',')[0],  'QSRQ': $(tr[3]).text(),  'ZZRQ': $(tr[4]).text()};
		sqnrbs.push(sqnrb);
	});
	console.log(sqnrbs);
	
	sqnrbs = JSON.stringify(sqnrbs);
	
	$.ajax({
	    type: "POST",
	    cache: false,
	    dataType:"json",
	    url: "/apply/commit/",
	    data:{'sqb':sqb,'sqnrbs':sqnrbs},
	    success : function(data,stau){
	    	alert(data['res']);
	    }
	});
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

/**
 * 获取选中的站点
 * @returns
 */
function getCheckedSTTr(){
	var content = $('#zhandianneirong');
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
		var td = tr.find('td')[1];	//这里的td位置是写死的，如果改html结构的话，记得改这里
		$(td).html(selectText);
	}
}

/**
 * 通过流域和行政区筛选出站点
 */
function stSelectClick(){
	var liuyuText = $('#liuyuSelect').val();
	var xzqText = $('#xzqSelect').val();
	if(liuyuText == null || xzqText == null){
		alert("请同时选择流域和行政区！！");
		return;
	}
	var postData = {'bshncd':JSON.stringify(liuyuText),'addvcd':JSON.stringify(xzqText)};
	console.log(liuyuText);
	$.ajax({
	    type: "POST",
	    cache: false,
	    dataType:"json",
	    url: "/apply/jsonST/",
	    data: postData,
	    success : function(data,stau){
	    	var n = data.length;
	    	var table = $('#zhandianneirong');
	    	table.html('');
	    	for(var i=0;i<n;i++){
	    		var st = data[i];
	    		var htmls = '<tr>\n<td><input type="checkbox" /></td>\n<td name="STCD">'+st.STCD+'</td>\n<td name="STNM">'+st.STNM+'</td>\n</tr>';
	    		table.append(htmls);
	    	}
	    },
	});
}

/**
 * 选中所有站点
 */
function selectAll(){
	$("#zhandianneirong  input:checkbox").each(function () {  
        this.checked = !this.checked;  
     });
}

/**
 * 确认选择站点
 */
function commitST(){
	var strs = getCheckedSTTr();
	if(strs == null){
		alert("请选择一个或多个站点");
	}
	//将所有选中站点的信息放到一个Array里面
	var sn = strs.length;
	var texts = [];
	for(var i=0;i<sn;i++){
		var tds = strs[i].find('td');
		var text = $(tds[1]).text()+','+$(tds[2]).text();
		texts.push(text);
	}
	//得到所有被选中的申请内容
	var ntrs = getCheckedTr();
	var nn = ntrs.length;
	for(var i=0;i<nn;i++){
		var ntr = ntrs[i];
		var temp = '<tr>'+ntr.html()+'</tr>';
		var td = ntr.find('td')[2];	//这里的td位置是写死的，如果改html结构的话，记得改这里
		$(td).html(texts[0]);
		for(var j=1;j<sn;j++){	//循环填充，如果不足则创建新的条目
			var yscontent = $('#yaosuneirong');
			var tempTR = $(temp);
			$(tempTR.find('td')[2]).html(texts[j]);
			yscontent.append(tempTR);
		}
	}
	showTable();
}

//时段选择
function commitDate(){
	var startTime = $('#startTime').val()+':00';
	var stopTime = $('#stopTime').val()+':00';
	var ntrs = getCheckedTr();
	var nn = ntrs.length;
	for(var i=0;i<nn;i++){
		var ntr = ntrs[i];
		$(ntr.find('td')[3]).html(startTime);
		$(ntr.find('td')[4]).html(startTime);
	}
	showTable();
}