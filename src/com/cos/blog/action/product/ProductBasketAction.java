package com.cos.blog.action.product;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.dto.BasketResponseDto;
import com.cos.blog.model.Basket;
import com.cos.blog.model.Product;
import com.cos.blog.model.Reply;
import com.cos.blog.repository.ProductRepository;
import com.cos.blog.util.Script;
import com.google.gson.Gson;

public class ProductBasketAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") == null) {
			Script.getMessage("잘못된 접근입니다.", response);
			return; //여기서 return이 었으면 코드를 아래를 타고 내려간다.
		}
		
		//int id = Integer.parseInt(request.getParameter("id"));
		int pid =Integer.parseInt(request.getParameter("pid")); 
		int pprice = Integer.parseInt(request.getParameter("pprice"));
		String pcategory = request.getParameter("pcategory");
		String ptitle = request.getParameter("ptitle");
		String pprofile = request.getParameter("pprofile");
		
		ProductRepository productRepository = ProductRepository.getInstance();
 

		//productRepository.findlikeAll(id);
		
		
//		List<Product> productlist = productRepository.();
//		if(productlist != null) {
//			session.setAttribute("productlist", productlist);
//		}
		
		RequestDispatcher dis = request.getRequestDispatcher("/product/basket.jsp");
		dis.forward(request, response);
		
	}
}
