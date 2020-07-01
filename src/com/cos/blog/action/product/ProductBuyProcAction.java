package com.cos.blog.action.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.model.Buy;
import com.cos.blog.model.Users;
import com.cos.blog.repository.ProductRepository;
import com.cos.blog.util.Script;

public class ProductBuyProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") == null) {
			Script.getMessage("잘못된 접근입니다.", response);
			return; //여기서 return이 었으면 코드를 아래를 타고 내려간다.
		}
		Users principal = (Users)session.getAttribute("principal");
		
//		if
//		(
//				request.getParameter("buyaddress") == null ||
//				request.getParameter("buyaddress").equals("") ||
//				request.getParameter("buyrequest") == null ||
//				request.getParameter("buyrequest").equals("") ||
//				request.getParameter("buypayment") == null ||
//				request.getParameter("buypayment").equals("") ||
//				request.getParameter("buyprice") == null ||
//				request.getParameter("buyprice").equals("")
//				
//		) {
//			
//			System.out.println("유효성 리턴");
//			return;
//		}
		
		String buyaddress = request.getParameter("buyaddress");
		String buyrequest = request.getParameter("buyrequest");
		String buypayment = request.getParameter("buypayment");
		int buyprice = Integer.parseInt(request.getParameter("buyprice"));		
		int productid = Integer.parseInt(request.getParameter("productid"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		Buy buy = Buy.builder()
				.buyaddress(buyaddress)
				.buyprice(buyprice)
				.buyrequest(buyrequest)
				.userid(principal.getId())
				.productid(productid)
				.buypayment(buypayment)
				.build();
		
		ProductRepository productRepository = ProductRepository.getInstance();
		int result = productRepository.save(buy,pid);
		
		if(result == 1) {
			Script.href("결제 성공하였습니다.", "/testPay.jsp", response);
		}else {
			Script.back("결제 실패하였습니다.", response);
		}
		
	}
}
