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
@WebServlet("/product")
public class ProductController extends HttpServlet {
	private final static String TAG = "MemberController : ";
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
		// http://localhost:8000/blog/user?cmd=join
		String cmd = request.getParameter("cmd");
		System.out.println(TAG+"router : "+cmd);
		Action action = router(cmd);
		action.execute(request, response);
	}
	
	public Action router(String cmd) {
		if(cmd.equals("home")) {
			// 회원가입 페이지로 이동
			return new MemberJoinAction();
		}
		return null;
	}
	

}




