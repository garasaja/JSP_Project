function replyDelete(replyId){
	
	$.ajax({
		type: "post",
		url: "/blog/product?cmd=deleteProc",
		data: "replyId="+replyId,
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType: "text"
	}).done(function(result){
		if(result == "1"){
			alert("찜 삭제 성공");
			var replyItem = $("#reply-"+replyId);
			replyItem.remove();
		}else{
			alert("찜 삭제 실패");
		}
	}).fail(function(error){
		alert("찜 삭제 실패");
	});
}

function replyWrite(boardId, userId){
	if(userId === undefined){
		alert("로그인이 필요합니다.");
		return;
	}
	
	var data = {
		productId: productId,
		userId: userId,
		content: $("#basket__write__form").val()
	};
	
	$.ajax({
		type: "post",
		url: "/blog/basket?cmd=basket",
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		dataType: "json"
	}).done(function(result){
		if(result == -1 || result == 0){
			alert("찜하기 실패");
		}else{
			alert("찜하기 성공");
			$("#reply__list").empty();
			console.log(result);
			renderReplyList(result, userId);
			$("#reply__write__form").val("");
		}
	}).fail(function(error){
		alert("찜하기 실패");
	});
}