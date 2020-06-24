package second.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import second.action.Action;
import second.model.Member;
import second.repository.MemberRepository;
import second.util.Script;

public class MemberUpdateProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") == null) {
			Script.getMessage("잘못된 접근입니다.", response);
			return;
		}
		
		if
		(
				request.getParameter("id") == null ||
				request.getParameter("id").equals("") ||
				request.getParameter("password") == null ||
				request.getParameter("password").equals("") ||
				request.getParameter("email") == null ||
				request.getParameter("email").equals("") ||
				request.getParameter("address") == null ||
				request.getParameter("address").equals("")		
		) {
			Script.back("입력되지 않은 필드가 있습니다.", response);
			return;
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		Member member = Member.builder()
				.id(id)
				.password(password)
				.email(email)
				.address(address)
				.build();
		
		MemberRepository memberRepository = MemberRepository.getInstance();
		int result = memberRepository.update(member);
		
		// update가 성공적으로 이루어지면 세션이 재등록한다.
		if(result == 1) {
			Member principal = memberRepository.findById(id);
			System.out.println("UsersUpdateProc : username : "+principal.getUsername());
			session.setAttribute("principal", principal);
			
			Script.href("회원수정 성공", "/blog/index.jsp", response);
		}else {
			Script.back("회원수정 실패", response);
		}
	}
	
}


