package com.cos.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.action.product.ProductBasketAction;
import com.cos.blog.action.product.ProductBasketProcAction;
import com.cos.blog.action.product.ProductBuyAction;
import com.cos.blog.action.product.ProductBuyProcAction;
import com.cos.blog.action.product.ProductChatAction;
import com.cos.blog.action.product.ProductDeleteAction;
import com.cos.blog.action.product.ProductDetailAction;
import com.cos.blog.action.product.ProductRegisterAction;
import com.cos.blog.action.product.ProductRegisterProcAction;
import com.cos.blog.action.product.ProductSearchAction;
import com.cos.blog.action.product.ProductShopAction;
import com.cos.blog.action.product.ProductUpdateAction;
import com.cos.blog.action.product.ProductUpdateProcAction;




// http://localhost:8000/blog/user
@WebServlet("/product")
public class ProductController extends HttpServlet {
	private final static String TAG = "productController : ";
	private static final long serialVersionUID = 1L;
       
    public ProductController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("path", request.getContextPath());
		// http://localhost:8000/blog/user?cmd=join
		String cmd = request.getParameter("cmd");
		System.out.println(TAG+"router : "+cmd);
		Action action = router(cmd);
		action.execute(request, response);
	}
	
	public Action router(String cmd) {
		 if(cmd.equals("register")) {			
			return new ProductRegisterAction();
		}else if(cmd.equals("registerProc")) {			
			return new ProductRegisterProcAction();
		}else if(cmd.equals("update")) {			
			return new ProductUpdateAction();
		}else if(cmd.equals("updateProc")) {			
			return new ProductUpdateProcAction();
		}else if(cmd.equals("detail")) {			
			return new ProductDetailAction();
		}else if(cmd.equals("chat")) {			
			return new ProductChatAction();
		}else if(cmd.equals("shop")) {			
			return new ProductShopAction();
		}else if(cmd.equals("buy")) {			
			return new ProductBuyAction();
		}else if(cmd.equals("buyProc")) {			
			return new ProductBuyProcAction();
		}else if(cmd.equals("basket")) {			
			return new ProductBasketAction();
		}else if(cmd.equals("basketProc")) {			
			return new ProductBasketProcAction();
		}else if(cmd.equals("search")) {
			return new ProductSearchAction(); //검색하기
		}else if(cmd.equals("delete")) {
			return new ProductDeleteAction(); //검색하기
		}
		return null;
	}
	

}




