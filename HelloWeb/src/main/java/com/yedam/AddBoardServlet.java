package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.BoardDao;
import com.yedam.board.BoardVo;

@WebServlet("/boardAdd")
public class AddBoardServlet extends HttpServlet{
	//생성자>init>service>destroy
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//title , writer , content 를 받아와야함
		String title = req.getParameter("title");//<input name = "title">
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		
		BoardVo board = new BoardVo();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		BoardDao dao = new BoardDao();
		boolean result = dao.add(board); //입력 처리
		
		if(result) {
			resp.sendRedirect("board/blist.jsp"); //요청 재지정
		} else {
			resp.sendRedirect("board/add.jsp"); //아니면 다시 보드로 돌아가겠다
		}
	}
	
}
