function deletebybasketid(id){
	$.ajax({
		type: "POST",
		url: `/blog/product?cmd=basketdelete&id=${id}`,
		dataType: "text"
	}).done(function(result){
		console.log(result);
		if(result == 1){
			alert("삭제 성공");
			var basketItem = $("#delete-"+id);
			basketItem.remove();
		}else{
			alert("삭제 실패");
		}
	}).fail(function(error){
		console.log(error);
		console.log(error.responseText);
		console.log(error.status);
		alert("서버 오류");
	});
}




