package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.BoardDao;
import com.yedam.board.BoardVo;


@WebServlet("/modify")
public class ModifyServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no1 = req.getParameter("no");
		int no = Integer.parseInt(no1);
		//title , writer , content 를 받아와야함
		String title = req.getParameter("title");//<input name = "title">
		String content = req.getParameter("content");
		
		BoardVo board = new BoardVo();
		board.setNumber(no);
		board.setTitle(title);
		board.setContent(content);
		
		BoardDao dao = new BoardDao();
		boolean result = dao.modify(board); //입력 처리
		
		if(result) {
			resp.sendRedirect("board/blist.jsp"); //요청 재지정
		} else {
			resp.sendRedirect("board/blist.jsp"); //아니면 다시 보드로 돌아가겠다
		}
	}
}
