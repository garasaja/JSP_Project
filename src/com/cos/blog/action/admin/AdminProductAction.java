package com.cos.blog.action.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.model.Product;
import com.cos.blog.model.Users;
import com.cos.blog.repository.ProductRepository;
import com.cos.blog.repository.UsersRepository;

public class AdminProductAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductRepository productRepository = ProductRepository.getInstance();
		List<Product> productlist = productRepository.findAll();
		request.setAttribute("productlist", productlist);
		
		RequestDispatcher dis = request.getRequestDispatcher("admin/product.jsp");
		dis.forward(request, response);
	}
}
