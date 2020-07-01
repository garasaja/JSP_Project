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

public class ProductBuyAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") == null) {
			Script.getMessage("잘못된 접근입니다.", response);
			return; //여기서 return이 었으면 코드를 아래를 타고 내려간다.
		}
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		ProductRepository productRepository = ProductRepository.getInstance();
		
		Product product = productRepository.findById(pid);
		
		request.setAttribute("product", product);
		
		RequestDispatcher dis = request.getRequestDispatcher("/product/buy.jsp");
		dis.forward(request, response);
	}
}
