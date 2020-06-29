package com.cos.blog.action.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.model.Product;
import com.cos.blog.repository.ProductRepository;
import com.cos.blog.util.Script;

public class ProductDetailAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		ProductRepository productRepository = ProductRepository.getInstance();
		
		List<Product> productlist = productRepository.findAll(pid);
		
		request.setAttribute("productlist", productlist);
		
		RequestDispatcher dis = request.getRequestDispatcher("product/detail.jsp");
		dis.forward(request, response);
		
		
		
	}
}
