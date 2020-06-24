package second.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import second.action.Action;
import second.model.Member;
import second.repository.MemberRepository;
import second.util.Script;


public class MemberLoginProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 0. 유효성 검사
		if
		(
				request.getParameter("username") == null ||
				request.getParameter("username").equals("") ||
				request.getParameter("password") == null ||
				request.getParameter("password").equals("")
				
		) {
			return;
		}
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// System.out.println("UsersLoginProcAction : "+password);
		MemberRepository memberRepository = MemberRepository.getInstance();
		Member member = memberRepository.findByUsernameAndPassword(username, password);
		
		if(member != null) {
			HttpSession session = request.getSession();
			session.setAttribute("principal", member);
			
			
			if(request.getParameter("remember") != null) {
				// key => Set-Cookie
				// value => remember=ssar 
				Cookie cookie = new Cookie("remember", member.getUsername());
				response.addCookie(cookie);
				
				//response.setHeader("Set-Cookie", "remember=ssar");
			}else {
				Cookie cookie = new Cookie("remember", "");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				
			}
			
			Script.href("로그인 성공", "/blog/index.jsp", response);
		}else {
			Script.back("로그인 실패", response);
		}
	}
	
}


