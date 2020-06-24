package second.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import second.action.Action;
import second.model.Member;
import second.repository.MemberRepository;
import second.util.Script;

public class MemberUsernameCheckAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		
		MemberRepository memberRepository = 
				MemberRepository.getInstance();
		Member member = memberRepository.findByUsername(username);
		if(member == null) {
			Script.outText("0", response);
		}else {
			Script.outText("1", response);
		}
		
	}
}
