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
import com.cos.blog.model.Users;
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
		BufferedReader br = request.getReader();
		StringBuffer sb = new StringBuffer();
		String input = null;
		while((input = br.readLine()) != null) {
			sb.append(input);
		}
		Gson gson = new Gson();
		Users user = gson.fromJson(sb.toString(), Users.class);
		Basket basket = gson.fromJson(sb.toString(), Basket.class);//?
		
		ProductRepository productRepository = ProductRepository.getInstance();
		int result = productRepository.save(basket);
		if(result==1) {
			List<BasketResponseDto> basketResponseDtos = productRepository.findlikeAll(user.getId());
			String basketDtosJson = gson.toJson(basketResponseDtos);
			Script.outJson(basketDtosJson, response);
		}else {
			Script.outJson(result+"", response);
		}
		
		
		//productRepository.findlikeAll(id);
		
		
//		List<Product> productlist = productRepository.();
//		if(productlist != null) {
//			session.setAttribute("productlist", productlist);
//		}
		
		RequestDispatcher dis = request.getRequestDispatcher("/product/basket.jsp");
		dis.forward(request, response);
		
	}
}
