package com.cos.blog.action.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.model.Board;
import com.cos.blog.model.Users;
import com.cos.blog.repository.BoardRepository;
import com.cos.blog.repository.UsersRepository;

public class AdminBoardAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardRepository boardRepository = BoardRepository.getInstance();
		List<Board> boardlist = boardRepository.findAll();
		request.setAttribute("boardlist", boardlist);
		
		RequestDispatcher dis = request.getRequestDispatcher("admin/board.jsp");
		dis.forward(request, response);
	}
}
