package com.cos.blog.action.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.repository.ProductRepository;
import com.cos.blog.util.Script;

public class ProductBasketDeleteAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		ProductRepository productRepository = ProductRepository.getInstance();
		int result = productRepository.deleteBybasketId(id);
		
		Script.outText(result+"", response);
		
	}
}
