package com.cos.blog.action.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.model.Product;
import com.cos.blog.repository.ProductRepository;

public class ProductBasketProcAction implements Action{
@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	RequestDispatcher dis = request.getRequestDispatcher("basket.jsp");
	dis.forward(request, response);
		
	}
}
