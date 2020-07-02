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
			renderReplyList(result, userid);
			$("#chat__write__form").val("");
		}
	}).fail(function(error){
		alert("채팅 작성 실패");
	});
}

function renderReplyList(chatDtos, userId){
	for(var chatDto of chatDtos){
		$("#chat__list").append(makeReplyItem(chatDtos, userId));
	}
}

function makeReplyItem(chatDto, userId){
	// reply-id 추가 시작
	var chatItem = `<li id="chat-${chatDto.reply.id}" class="media">`;
	// reply-id 추가 끝
	if(replyDto.userProfile == null){
		chatItem += `<img src="/blog/image/userProfile.png" class="img-circle">`;	
	}else{
		chatItem += `<img src="${chatDto.userProfile}" class="img-circle">`;
	}
	
	chatItem += `<div class="media-body">`;
	chatItem += `<strong class="text-primary">${chatDto.username}</strong>`;
	chatItem += `<p>${chatDto.chat.content}</p>`;
	chatItem += `</div>`;
	// 휴지통 추가 시작
	chatItem += `<div class="m-2">`;
	if(chatDto.chat.userid == userId){
		chatItem += `<i onclick="chatDelete(${chatDto.chat.id})" class="material-icons i__btn">delete</i>`;
	}
	chatItem += `</div>`;
	// 휴지통 추가 끝
	chatItem += `</li>`;
	return chatItem;
}