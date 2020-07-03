package com.cos.blog.action.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.model.Reply;
import com.cos.blog.model.Users;
import com.cos.blog.repository.ReplyRepository;
import com.cos.blog.repository.UsersRepository;

public class AdminReplyAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReplyRepository replyRepository = ReplyRepository.getInstance();
		List<Reply> replylist = replyRepository.findAll();
		request.setAttribute("replylist", replylist);
		
		RequestDispatcher dis = request.getRequestDispatcher("admin/reply.jsp");
		dis.forward(request, response);
	}
}
