package com.cos.blog.action.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.model.Buy;
import com.cos.blog.repository.ProductRepository;
import com.cos.blog.util.Script;

public class ProductBuyProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if
		(
				request.getParameter("buyaddress") == null ||
				request.getParameter("buyaddress").equals("") ||
				request.getParameter("buyrequest") == null ||
				request.getParameter("buyrequest").equals("") ||
				request.getParameter("buypayment") == null ||
				request.getParameter("buypayment").equals("") ||
				request.getParameter("buyprice") == null ||
				request.getParameter("buyprice").equals("")
				
		) {
			return;
		}
		
		String buyaddress = request.getParameter("buyaddress");
		String buyrequest = request.getParameter("buyrequest");
		String buypayment = request.getParameter("buypayment");
		int buyprice = Integer.parseInt(request.getParameter("buyprice"));
		int userid = Integer.parseInt(request.getParameter("userid"));
		int productid = Integer.parseInt(request.getParameter("productid"));
		
		Buy buy = Buy.builder()
				.buyaddress(buyaddress)
				.buyprice(buyprice)
				.buyrequest(buyrequest)
				.userid(userid)
				.productid(productid)
				.buypayment(buypayment)
				.build();
		
		ProductRepository productRepository = ProductRepository.getInstance();
		int result = productRepository.save(buy);
		
		if(result == 1) {
			Script.href("회원가입에 성공하였습니다.", "/shop.jsp", response);
		}else {
			Script.back("회원가입에 실패하였습니다.", response);
		}
		
	}
}
