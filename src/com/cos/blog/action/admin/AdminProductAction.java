package com.cos.blog.action.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.model.Users;
import com.cos.blog.repository.UsersRepository;

public class AdminProductAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsersRepository usersRepository = UsersRepository.getInstance();
		List<Users> userlist = usersRepository.findAll();
		request.setAttribute("userlist", userlist);
		
		RequestDispatcher dis = request.getRequestDispatcher("admin/user.jsp");
		dis.forward(request, response);
	}
}
