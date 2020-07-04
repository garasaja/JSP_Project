package com.cos.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.action.admin.AdminBoardAction;
import com.cos.blog.action.admin.AdminBoardDeleteAction;
import com.cos.blog.action.admin.AdminProductAction;
import com.cos.blog.action.admin.AdminProductDeleteAction;
import com.cos.blog.action.admin.AdminReplyAction;
import com.cos.blog.action.admin.AdminReplyDeleteAction;
import com.cos.blog.action.admin.AdminUserAction;
import com.cos.blog.action.admin.AdminUserDeleteAction;


// http://localhost:8000/blog/user
@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private final static String TAG = "AdminController : ";
	private static final long serialVersionUID = 1L;
       
    public AdminController() {
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
		if(cmd.equals("user")) {
			return new AdminUserAction();
			
		}else if(cmd.equals("reply")) {
			return new AdminReplyAction();
			
		}else if(cmd.equals("product")) {
			return new AdminProductAction();
			
		}else if(cmd.equals("board")) {
			return new AdminBoardAction();
		}else if(cmd.equals("boarddelete")) {
			return new AdminBoardDeleteAction();
		}else if(cmd.equals("replydelete")) {
			return new AdminReplyDeleteAction();
		}else if(cmd.equals("userdelete")) {
			return new AdminUserDeleteAction();
		}else if(cmd.equals("productdelete")) {
			return new AdminProductDeleteAction();
		}
		return null;
	}
	

}




