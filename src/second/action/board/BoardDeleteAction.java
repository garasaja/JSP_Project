package second.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import second.action.Action;
import second.repository.BoardRepository;
import second.util.Script;



public class BoardDeleteAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0번 인증 확인
				HttpSession session = request.getSession();
				if(session.getAttribute("principal") == null) {
					Script.getMessage("잘못된 접근입니다.", response);
					return;
				}
				
				if(request.getParameter("id").equals("") ||request.getParameter("id") == null ) {
					return;
				}
				int id = Integer.parseInt(request.getParameter("id"));
				
				BoardRepository boardRepository = BoardRepository.getInstance();
				int result = boardRepository.deleteById(id);
				Script.outText(result+"", response);
				
	}
}
