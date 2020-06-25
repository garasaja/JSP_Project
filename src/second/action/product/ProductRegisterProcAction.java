package second.action.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import second.action.Action;

public class ProductRegisterProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ptitle = request.getParameter("ptitle");
		String category = request.getParameter("category");
		String pplace = request.getParameter("pplace");
		String pprice = request.getParameter("pprice");
		String pcontent = request.getParameter("pcontent");
	}
}
