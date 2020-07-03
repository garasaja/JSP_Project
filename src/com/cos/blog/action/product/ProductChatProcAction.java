package com.cos.blog.action.product;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.dto.ChatResponseDto;
import com.cos.blog.model.Chat;
import com.cos.blog.model.Product;
import com.cos.blog.model.Users;
import com.cos.blog.repository.ChatRepository;
import com.cos.blog.repository.ProductRepository;
import com.cos.blog.util.Script;
import com.google.gson.Gson;

public class ProductChatProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BufferedReader br = request.getReader();
		StringBuffer sb = new StringBuffer();
		String input = null;
		while((input = br.readLine()) != null) {
			sb.append(input);
		}
		System.out.println(sb.toString());
		Gson gson = new Gson();
		Chat chat = gson.fromJson(sb.toString(), Chat.class);
		
		// ReplyRepository 연결 - save(reply)
		ChatRepository chatRepository = 
				ChatRepository.getInstance();
		int result = chatRepository.save(chat);
		// save 성공하면 1, 실패하면 0, -1 Script.outText() 응답
		if(result == 1) {		
			List<ChatResponseDto> chatDtos = chatRepository.findAll(chat.getPid());
			String chatDtosJson = gson.toJson(chatDtos);
			Script.outJson(chatDtosJson, response);
		}else {
			Script.outJson(result+"", response);
		}
	}
}
