package com.cos.blog.action.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.model.Product;
import com.cos.blog.model.Users;
import com.cos.blog.repository.ProductRepository;
import com.cos.blog.util.Script;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class ProductUpdateProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0번 인증 확인
				HttpSession session = request.getSession();
				if(session.getAttribute("principal") == null) {
					Script.getMessage("잘못된 접근입니다.", response);
					return;
				}
								
				
				String realPath = 
						request.getServletContext().getRealPath("image");
				int id;
				String fileName = null;
				String contextPath = request.getServletContext().getContextPath();
				String pprofile = null; //DB에 들어갈 변수 : 위치
				
				System.out.println("realPath : "+realPath);
				System.out.println("contextPath : "+contextPath);
			
				int pid = Integer.parseInt(request.getParameter("pid"));
				String ptitle = null;
				String pcategory = null;
				String pplace = null;
				int pprice = 0;
				String pcontent = null;
				
				try {
					MultipartRequest multi = new MultipartRequest
							(
								request, 
								realPath,
								1024*1024*2,
								"UTF-8",
								new DefaultFileRenamePolicy()
							);
					fileName = multi.getFilesystemName("pprofile");
					System.out.println("fileName : "+fileName);
					id = Integer.parseInt(multi.getParameter("id"));
					
					pprofile = contextPath+"/image/"+fileName;
					ptitle = multi.getParameter("ptitle");
					pcategory = multi.getParameter("pcategory");
					pplace = multi.getParameter("pplace");
					pprice = Integer.parseInt(multi.getParameter("pprice"));
					pcontent = multi.getParameter("pcontent");
					
				}catch (Exception e) {
					e.printStackTrace();
					Script.getMessage("오류 : "+e.getMessage(), response);
				}

				
				Product product = Product.builder()
						.pid(pid)
						.ptitle(ptitle)
						.pcontent(pcontent)
						.preadCount(0)
						.pcategory(pcategory)
						.pprice(pprice)
						.pplace(pplace)
						.pprofile(pprofile)
						.build();
				
				ProductRepository productRepository = ProductRepository.getInstance();
				int result = productRepository.update(product);
				
				if(result ==1) {
					//product = productRepository.findById(pid);
					//session.setAttribute("product", product);
					Script.href("수정완료","/blog/product?cmd=detail&pid="+pid, response);
				}else {
					Script.back("상품 수정 실패", response);
				}
						
	}
}
