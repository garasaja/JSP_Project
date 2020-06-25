package second.action.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.util.Script;

public class BoardWriteAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//글쓰기 버튼은 로그인을 햇을시 나타나는 버튼인데 주소창을 복사해서 비정상적인 방법으로 접근했을시 막아줌
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") == null) {//비정상적 접근   principal은 인증주체  
			Script.getMessage("잘못된 접근입니다.", response);
		} else {//로그인 했을시 
			RequestDispatcher dis = request.getRequestDispatcher("board/write.jsp");
			dis.forward(request, response);
		}
		
		
	}
}
