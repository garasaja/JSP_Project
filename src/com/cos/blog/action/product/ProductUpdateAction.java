package com.cos.blog.action.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.model.Product;
import com.cos.blog.repository.ProductRepository;
import com.cos.blog.util.Script;



public class ProductUpdateAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") == null) {
			Script.getMessage("잘못된 접근입니다.", response);
			return;
		}
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		System.out.println("pid : " + pid );
		ProductRepository productRepository = ProductRepository.getInstance();
		Product product = productRepository.findById(pid);

		request.setAttribute("product", product);
		
		RequestDispatcher dis = request.getRequestDispatcher("product/update.jsp");
		dis.forward(request, response);

			
		
			
			
			
			
			
			
	}
}
