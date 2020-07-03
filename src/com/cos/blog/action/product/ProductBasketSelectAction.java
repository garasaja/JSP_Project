package com.cos.blog.action.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.dto.BasketResponseDto;
import com.cos.blog.dto.BuyResponseDto;
import com.cos.blog.model.Users;
import com.cos.blog.repository.ProductRepository;

public class ProductBasketSelectAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductRepository productRepository = ProductRepository.getInstance();
		
		HttpSession session = request.getSession();
		Users principal = (Users)session.getAttribute("principal");
		
		List<BasketResponseDto> basketResponseDtos = productRepository.findlikeAll(principal.getId());
		request.setAttribute("basketResponseDtos", basketResponseDtos);
		RequestDispatcher dis = request.getRequestDispatcher("product/basket.jsp");
		dis.forward(request, response);
	}
}
