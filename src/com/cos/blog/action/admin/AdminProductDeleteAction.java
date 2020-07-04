package com.cos.blog.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.repository.BoardRepository;
import com.cos.blog.repository.ProductRepository;
import com.cos.blog.util.Script;

public class AdminProductDeleteAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("productId"));
		ProductRepository productRepository = ProductRepository.getInstance();
		int result = productRepository.deleteById(pid);
		Script.outText(result+"", response);
	}
}
