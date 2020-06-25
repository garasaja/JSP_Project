package second.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import second.action.Action;
import second.action.member.MemberJoinAction;
import second.action.product.ProductDetailAction;
import second.action.product.ProductRegisterAction;
import second.action.product.ProductRegisterProcAction;
import second.action.product.ProductUpdateAction;
import second.action.product.ProductUpdateProcAction;


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
			return new MemberJoinAction();
		}else if(cmd.equals("register")) {			
			return new ProductRegisterAction();
		}else if(cmd.equals("registerProc")) {			
			return new ProductRegisterProcAction();
		}else if(cmd.equals("update")) {			
			return new ProductUpdateAction();
		}else if(cmd.equals("updateProc")) {			
			return new ProductUpdateProcAction();
		}else if(cmd.equals("detail")) {			
			return new ProductDetailAction();
		}
		return null;
	}
	

}




