package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DispatcherTest2")
public class DispatcherTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherTest2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h3>Request공유정보</h3>");
		String msg = (String) request.getAttribute("request");
		out.print("<p>msg "+ msg + "</p>");//요청했던페이지정보를 ~~2로 재지정
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
