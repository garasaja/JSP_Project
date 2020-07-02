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
		
		int userid = Integer.parseInt(request.getParameter("userid"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		ProductRepository productRepository = ProductRepository.getInstance();
		Product product = new Product();
		// pid로 다시 select하고 상품!!
		product = productRepository.getById(pid);
		// 장바구니 DB에 값 넣고
		int result = productRepository.save(userid,pid);
		// 장바구니 page로 이동할 때 해당 유저의 장바구니 목록 다시 select (컬렉션) - 조인(Product)
		if(result==1) {
			List<BasketResponseDto> basketResponseDtos = productRepository.findlikeAll(userid);
			request.setAttribute("basketResponseDtos", basketResponseDtos);
			RequestDispatcher dis = request.getRequestDispatcher("/product/basket.jsp");
			dis.forward(request, response);
		}else {
			Script.outText("실패", response);
		}
		// request에 담고
				
		// Requestdispatcher 이동해
		
	}
}
