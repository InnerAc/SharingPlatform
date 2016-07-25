function getAllSwys(){
	
}

function edit(e){
	var btn = $(e);
//	console.log(btn.text());
	var tr = btn.parent().parent();
//	console.log(tr.html());
	tr.find('td').each(function (){
		if($(this).attr('edit') == "true"){
			var text = $(this).text();
			$(this).html('<input type="text" value="'+text+'"/>');
		}
		
		console.log($(this).text());
	});
}