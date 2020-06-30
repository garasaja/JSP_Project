package com.cos.blog.action.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.model.Board;
import com.cos.blog.model.Product;
import com.cos.blog.repository.BoardRepository;
import com.cos.blog.repository.ProductRepository;
import com.cos.blog.util.HtmlParser;
import com.cos.blog.util.Script;

public class ProductSearchAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("keyword") == null ||
				request.getParameter("keyword").equals("")) {
			Script.back("검색 키워드가 없습니다.", response);
			return;
		}

		String keyword = request.getParameter("keyword");
		
		// 1. DB연결해서 Board 목록 다 불러와서
		ProductRepository productRepository = ProductRepository.getInstance();
		
		List<Product> productlist = productRepository.findAll(keyword);
			
		request.setAttribute("productlist", productlist);
		
		RequestDispatcher dis = request.getRequestDispatcher("shop.jsp");
		dis.forward(request, response);
		
	}
}
