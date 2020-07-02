package com.cos.blog.action.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

public class ProductChatAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") == null) {
			Script.getMessage("잘못된 접근입니다.", response);
			return; //여기서 return이 었으면 코드를 아래를 타고 내려간다.
		}
		ProductRepository productRepository = ProductRepository.getInstance();
		Product product = new Product();
		ChatRepository chatRepository = ChatRepository.getInstance();
				
		int pid = Integer.parseInt(request.getParameter("pid"));
//		Users user = (Users)session.getAttribute("principal");
		
		
		//product = productRepository.getById(pid);
		//Chat chat = new Chat();
		 List<ChatResponseDto> chatDtos = chatRepository.findAll(pid);
		request.setAttribute("chatDtos",chatDtos);
		//int result = chatRepository.save(chat);
		
		RequestDispatcher dis = request.getRequestDispatcher("product/chat.jsp");
		dis.forward(request, response);
		
	}
}
