package second.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import second.action.Action;
import second.util.Script;


public class MemberLogoutAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		
		// session.removeAttribute("principal");
		Script.href("로그아웃 성공", "index.jsp", response);
	}
	
}
