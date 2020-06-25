package second.action.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import second.action.Action;
import second.util.Script;

public class ProductDetailAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(
				request.getParameter("id") == null || 
				request.getParameter("id").equals("")
		  ) {
			Script.back("잘못된 접근입니다.", response);
			return;
		}
		
		
		
	}
}
