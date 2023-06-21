package com.yedam;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
	
	public FirstServlet() {
		System.out.println("생성자 호출");
	}
	
	//init() -> req , resp 객체를 톰캣이 만들어줌 -> service() -> destroy() : 서블릿 라이프 사이클 
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("init()호출");//서버실행된후에 최초로 한번만 실행된다 
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		System.out.println("service()호출");// 서버 실행 후 요청이 있을 때 마다 실행
	}
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destroy()호출");//서버 종료되면 마지막으로 한번만 실행
	}
}
