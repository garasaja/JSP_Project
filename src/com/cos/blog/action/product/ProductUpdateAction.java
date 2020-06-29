package com.cos.blog.action.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.dto.ProductResponseDto;
import com.cos.blog.repository.ProductRepository;
import com.cos.blog.util.Script;



public class ProductUpdateAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(
				request.getParameter("id") == null || 
				request.getParameter("id").equals("")
		  ) {
			Script.back("잘못된 접근입니다.", response);
			return;
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		ProductRepository productRepository = ProductRepository.getInstance();
		ProductResponseDto productResponseDto = productRepository.findById(id);
		if(productResponseDto != null) {
			request.setAttribute("productResponseDto", productResponseDto);
			RequestDispatcher dis = request.getRequestDispatcher("product/update.jsp");
			dis.forward(request, response);
		}else {
			Script.back("잘못된 접근입니다.", response);
		}
		
	}
}
