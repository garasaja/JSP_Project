package com.cos.blog.action.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.dto.BuyResponseDto;
import com.cos.blog.repository.ProductRepository;

public class ProductBuySelectAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductRepository productRepository = ProductRepository.getInstance();
		
		List<BuyResponseDto> buylist = productRepository.findBuyAll();
		request.setAttribute("buylist", buylist);
		RequestDispatcher dis = request.getRequestDispatcher("buylist.jsp");
		dis.forward(request, response);
	}
}
