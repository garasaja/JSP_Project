function chatWrite(pid, userid){
	console.log("test");
	if(userid === undefined){
		alert("로그인이 필요합니다.");
		return;
	}
	
	var data = {
		pid: pid,
		userid: userid,
		content: $("#chat__write__form").val()
	};
	
	$.ajax({
		type: "post",
		url: "/blog/product?cmd=chatProc",
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		dataType: "json"
	}).done(function(result){
		if(result == -1 || result == 0){
			alert("채팅 작성 실패");
		}else{
			alert("채팅 작성 성공");
			$("#chat__list").empty();
			console.log(result);
			
			for (let chatDto of result) {
				
				var string =
				"						<div class=\"row\">\r\n" + 
				"                            <div class=\"col-lg-12\">\r\n" + 
				"                                <div class=\"media\">\r\n" + 
				"                                    <a class=\"pull-left\" href=\"#\">\r\n" + 
				"                                        <img class=\"media-object img-circle img-chat\" src=\""+chatDto.userProfile+"\" alt=\"\">\r\n" + 
				"                                    </a>\r\n" + 
				"                                    <div class=\"media-body\">\r\n" + 
				"                                        <h4 class=\"media-heading\">"+chatDto.username+"\r\n" + 
				"                                            <span class=\"small pull-right\">"+chatDto.chat.createDate+"</span>\r\n" + 
				"                                        </h4>\r\n" + 
				"                                        <p>"+chatDto.chat.content+"</p>\r\n" + 
				"                                    </div>\r\n" + 
				"                                </div>\r\n" + 
				"                            </div>\r\n" + 
				"                        </div>\r\n" + 
				"                        <hr>";
				
				$("#chat__list").append(string);
				
			}
			
//			renderReplyList(result, userid);
			$("#chat__write__form").val("");
		}
	}).fail(function(error){
		alert("채팅 작성 실패");
	});
}

$(".form-control").focus();

