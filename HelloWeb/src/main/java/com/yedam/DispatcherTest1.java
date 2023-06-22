package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DispatcherTest1")
public class DispatcherTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherTest1() {
        super();
        
    }
//디스패처1을실행하면 디스패처2로 재지정함 디스패처2에서는 출력 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h3>Request공유</h3>");
		request.setAttribute("request", "Hello");//요청했던페이지정보를 ~~2로 재지정
		
//		RequestDispatcher rd = 
//				request.getRequestDispatcher("DispatcherTest2");//디스패처테스트2로 url요청하겠다
//		
//		rd.forward(request, response);//요청을 재지정 하겠습니다 (요청정보,응답정보)
		
		response.sendRedirect("DispatcherTest2");//이것도 재지정 해주는 다른것
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
