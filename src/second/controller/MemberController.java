package second.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import second.action.Action;
import second.action.member.MemberJoinAction;
import second.action.member.MemberJoinProcAction;
import second.action.member.MemberLoginAction;
import second.action.member.MemberLoginProcAction;
import second.action.member.MemberLogoutAction;
import second.action.member.MemberProfileUploadAction;
import second.action.member.MemberProfileUploadProcAction;
import second.action.member.MemberUpdateAction;
import second.action.member.MemberUpdateProcAction;
import second.action.member.MemberUsernameCheckAction;


// http://localhost:8000/blog/user
@WebServlet("/member")
public class MemberController extends HttpServlet {
	private final static String TAG = "MemberController : ";
	private static final long serialVersionUID = 1L;
       
    public MemberController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// http://localhost:8000/blog/user?cmd=join
		String cmd = request.getParameter("cmd");
		System.out.println(TAG+"router : "+cmd);
		Action action = router(cmd);
		action.execute(request, response);
	}
	
	public Action router(String cmd) {
		if(cmd.equals("join")) {
			// 회원가입 페이지로 이동
			return new MemberJoinAction();
		}else if(cmd.equals("joinProc")) {
			// 회원가입을 진행 한 후 -> index.jsp로 이동
			return new MemberJoinProcAction();
		}else if(cmd.equals("update")) {
			// 회원 수정 페이지로 이동 (세션에 User 오브젝트를 가지고 있을 예정)
			return new MemberUpdateAction();
		}else if(cmd.equals("updateProc")) {
			// 회원 수정을 진행 한 후 -> index.jsp로 이동
			return new MemberUpdateProcAction();
		}else if(cmd.equals("delete")) {
			// 회원 삭제를 진행 한 후 -> 로그아웃을 하고 -> index.jsp로 이동
		}else if(cmd.equals("login")) {
			// 회원 로그인 페이지로 이동
			return new MemberLoginAction();
		}else if(cmd.equals("loginProc")) {
			// 회원 로그인을 수행한 후 -> 세션에 등록을 하고 -> index.jsp로 이동
			return new MemberLoginProcAction();
		}else if(cmd.equals("logout")) {
			return new MemberLogoutAction();
		}else if(cmd.equals("usernameCheck")) {
			return new MemberUsernameCheckAction();
		}else if(cmd.equals("profileUpload")) {
			return new MemberProfileUploadAction();
		}else if(cmd.equals("profileUploadProc")) {
			return new MemberProfileUploadProcAction();
		}
		return null;
	}
	

}




