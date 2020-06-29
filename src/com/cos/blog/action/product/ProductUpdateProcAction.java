package com.cos.blog.action.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.model.Product;
import com.cos.blog.repository.ProductRepository;
import com.cos.blog.util.Script;


public class ProductUpdateProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0번 인증 확인
				HttpSession session = request.getSession();
				if(session.getAttribute("principal") == null) {
					Script.getMessage("잘못된 접근입니다.", response);
					return;
				}
				
				if
				(
						request.getParameter("pid").equals("") ||
						request.getParameter("pid") == null ||
						request.getParameter("ptitle").equals("") ||
						request.getParameter("ptitle") == null ||
						request.getParameter("pcontent").equals("") ||
						request.getParameter("pcontent") == null ||
						request.getParameter("pcategory").equals("") ||
						request.getParameter("pcategory") == null ||
						request.getParameter("pplace").equals("") ||
						request.getParameter("pplace") == null ||
						request.getParameter("pprice").equals("") ||
						request.getParameter("pprice") == null 
						
				) {
					return;
				}
				
				int pid = Integer.parseInt(request.getParameter("pid"));
				String ptitle = request.getParameter("title");
				String pcontent = request.getParameter("pcontent");
				String pcategory = request.getParameter("pcategory");
				String pplace = request.getParameter("pplace");
				int pprice = Integer.parseInt(request.getParameter("pprice"));
				
				Product product = Product.builder()
						.pid(pid)
						.ptitle(ptitle)
						.pcontent(pcontent)
						.preadCount(0)
						.pcategory(pcategory)
						.pprice(pprice)
						.pplace(pplace)
						.build();
				
				ProductRepository productRepository = ProductRepository.getInstance();
				int result = productRepository.update(product);
				
				if(result ==1) {
					Script.href("수정완료","/second/product?cmd=detail&pid="+pid, response);
				}else {
					Script.back("상품 수정 실패", response);
				}
						
	}
}
