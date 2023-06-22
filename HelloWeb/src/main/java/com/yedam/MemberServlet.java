package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String msg;

    public MemberServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int number = 0 ;
		msg = request.getParameter("msg");//msg라는파라미터 갖고와서 출력
		response.setContentType("text/html;charset=UTF-8");//한글처리
		PrintWriter out = response.getWriter();
		out.println("<h3>멤버변수</h3>");
		
		while(number++<10) {
			out.print("<p>"+msg+" : " + number + "</p>");
			out.flush();
			try {
				Thread.sleep(1000);//1초씩 10번 출력 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		out.println("<h3>DONE:</h3>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
