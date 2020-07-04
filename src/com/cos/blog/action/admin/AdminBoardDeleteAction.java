package com.cos.blog.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.repository.BoardRepository;
import com.cos.blog.util.Script;

public class AdminBoardDeleteAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("boardId"));
		BoardRepository boardRepository = BoardRepository.getInstance();
		int result = boardRepository.deleteById(id);
		Script.outText(result+"", response);
	}
}
