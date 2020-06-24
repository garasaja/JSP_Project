package second.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import second.action.Action;



public class MemberLoginAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 아이디 남기는 로직
		
//		String myCookie = request.getHeader("Cookie");
//		System.out.println("myCookie : "+myCookie);
//		Cookie[] cookies = request.getCookies();
//		if(cookies != null) {
//			for (Cookie cookie : cookies) {
//				if(cookie.getName().equals("remember")) {
//					request.setAttribute("remember", cookie.getValue());
//				}
//			}
//		}
		
		RequestDispatcher dis = request.getRequestDispatcher("member/login.jsp");
		dis.forward(request, response);
	}
	
}
